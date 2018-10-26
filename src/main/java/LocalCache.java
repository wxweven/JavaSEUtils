import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wxweven
 * @date 2018/7/14
 */
public final class LocalCache {
    /**
     * 缓存数据容器
     */
    private static final Map<String, Data> CACHE_MAP;

    /**
     * 定时器，用于清理过期的缓存数据
     */
    private static final Timer TIMER;

    /**
     * 缓存TTL(毫秒)，默认为5分钟
     */
    private static final long DEFAULT_TTL = 5 * 60 * 1000;

    /**
     * 随机数类
     */
    private static final Random RANDOM = new Random();

    /**
     * 最大随机数
     */
    private static final int RANDOM_MAX = 100;


    static {
        TIMER = new Timer();
        CACHE_MAP = new ConcurrentHashMap<>();
    }

    private LocalCache() {

    }

    /**
     * 缓存清理定时任务
     */
    private static class Data {
        /**
         * 缓存key
         */
        private String key;

        /**
         * 缓存value
         */
        private Object value;

        /**
         * 缓存失效时间戳
         */
        private long timestamp;

        public String getKey() {
            return key;
        }

        public Data setKey(String key) {
            this.key = key;
            return this;
        }

        public Object getValue() {
            return value;
        }

        public Data setValue(Object value) {
            this.value = value;
            return this;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public Data setTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }
    }

    /**
     * 缓存清理定时任务
     */
    private static class CleanTask extends TimerTask {
        /**
         * 缓存key
         */
        private String key;

        CleanTask(String key) {
            this.key = key;
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            Data data = CACHE_MAP.get(key);

            if (data.getTimestamp() < currentTimeMillis) {
                LocalCache.remove(key);
            }
        }
    }

    /**
     * 设置缓存，TTL为默认值(5分钟)
     *
     * @param key   缓存的key
     * @param value 缓存的value
     */
    public static void set(String key, Object value) {
        set(key, value, DEFAULT_TTL);
    }


    /**
     * 设置缓存，指定TTL
     *
     * @param key   缓存的key
     * @param value 缓存的value
     * @param ttl   缓存的ttl
     */
    public static void set(String key, Object value, long ttl) {
        Data data = new Data().setKey(key)
                              .setValue(value)
                              .setTimestamp(System.currentTimeMillis() + ttl);

        CACHE_MAP.put(key, data);
        TIMER.schedule(new CleanTask(key), ttl);
    }

    /**
     * 批量设置缓存，默认过期时间(5分钟)
     *
     * @param kvMap 需要缓存的key/value map
     */
    public static void mset(Map<String, ?> kvMap) {
        mset(kvMap, DEFAULT_TTL);
    }

    /**
     * 批量设置缓存，所有的缓存同一时间过期
     *
     * @param kvMap 需要缓存的key/value map
     * @param ttl   缓存ttl
     */
    public static void mset(Map<String, ?> kvMap, long ttl) {
        mset(kvMap, ttl, false);
    }

    /**
     * 批量设置缓存，可以选择在指定的TTL上，再随机增加缓存过期时间，避免同一时间过多key同时失效
     *
     * @param kvMap        需要缓存的key/value map
     * @param ttl          缓存ttl
     * @param addRandomTTL 是否添加随机过期时间
     */
    public static void mset(Map<String, ?> kvMap, long ttl, boolean addRandomTTL) {

        kvMap.forEach((key, val) -> {
            Data data = new Data().setKey(key)
                                  .setValue(val);
            long newTTL = addRandomTTL
                    ? ttl + RANDOM.nextInt(RANDOM_MAX)
                    : ttl;
            data.setTimestamp(System.currentTimeMillis() + newTTL);

            CACHE_MAP.put(key, data);

            TIMER.schedule(new CleanTask(key), newTTL);
        });
    }

    /**
     * 获取缓存
     *
     * @param key 缓存的key
     * @return 缓存value
     */
    public static Object get(String key) {
        Data data = CACHE_MAP.get(key);

        return data == null
                ? null
                : data.getValue();
    }

    /**
     * 批量获取缓存
     *
     * @param keys 缓存的keys
     * @return 缓存value
     */
    public static Map<String, Object> mget(Set<String> keys) {
        Map<String, Object> cacheMap = new HashMap<>();

        keys.forEach(key -> {
            Data data = CACHE_MAP.get(key);
            cacheMap.put(key, data == null ? null : data.getValue());
        });

        return cacheMap;
    }

    /**
     * 查询缓存是否包含key
     *
     * @param key 缓存的key
     * @return true: 包含缓存的key；否则false
     */
    public static boolean containsKey(String key) {
        return CACHE_MAP.containsKey(key);
    }

    /**
     * 删除缓存
     *
     * @param key 缓存的key
     */
    public static void remove(String key) {
        if (CACHE_MAP.containsKey(key)) {
            CACHE_MAP.remove(key);
        }
    }

    /**
     * 返回缓存大小
     *
     * @return 缓存的大小
     */
    public static int size() {
        return CACHE_MAP.size();
    }

    /**
     * 清除所有缓存
     *
     * @return
     */
    public static void clear() {
        if (size() > 0) {
            CACHE_MAP.clear();
        }

        // 将『缓存过期的定时任务』取消
        TIMER.cancel();
    }
}

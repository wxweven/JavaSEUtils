import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author wxweven
 * @date 2018/7/14
 */
public class LocalCacheTest {

    @Test
    public void testSetGet() {
        LocalCache.set("key", "val");
        String value = (String) LocalCache.get("key");
        Assert.assertEquals(value, "val");
    }

    @Test
    public void testSetGetWithTTL() throws InterruptedException {
        LocalCache.set("key", "val", 500);
        Object value = LocalCache.get("key");
        System.out.println("缓存没过期，值为：" + value.toString());
        Assert.assertEquals(value.toString(), "val");

        LocalCache.set("key", "val", 5000);


        Thread.sleep(1000);
        value = LocalCache.get("key");
        System.out.println("缓存没过期，值为：" + value);
        Assert.assertNotNull(value);
    }


    @Test
    public void testMsetWithTTL() throws InterruptedException {
        Map<String, String> kvMap = new HashMap<>();
        IntStream.rangeClosed(1, 5)
                 .forEach(i -> kvMap.put("key" + i, "val" + i));

        LocalCache.mset(kvMap, 500);

        Map<String, Object> cacheMap = LocalCache.mget(kvMap.keySet());

        String testKey = "key1";
        Assert.assertEquals(kvMap.get(testKey), cacheMap.get(testKey));

        System.out.println("---------------缓存过期后----------");

        Thread.sleep(1000);
        cacheMap = LocalCache.mget(kvMap.keySet());
        Assert.assertNull(cacheMap.get(testKey));

    }
}

package com.algorithm.array;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wxweven
 */
public class LC380O1插入删除获取 {

    // https://www.yuque.com/wxweven/yn3rzz/wmsx82

    // 存储元素的值
    private List<Integer> nums = new ArrayList<>();

    // 记录每个元素对应在 nums 中的索引
    private Map<Integer, Integer> valToIndex = new HashMap<>();

    /**
     * 如果 val 不存在集合中，则插入并返回 true，否则直接返回 false
     */
    public boolean insert(int val) {
        // 若 val 已存在，不用再插入
        if (valToIndex.containsKey(val)) {
            return false;
        }

        // 若 val 不存在，插入到 nums 尾部，
        nums.add(val);

        // 并记录 val 对应的索引值，即数组最后一个元素的下标
        valToIndex.put(val, nums.size() - 1);

        return true;
    }

    /**
     * 如果 val 在集合中，则删除并返回 true，否则直接返回 false
     */
    public boolean remove(int val) {
        // 若 val 不存在，不用再删除
        if (!valToIndex.containsKey(val)) {
            return false;
        }

        int index = valToIndex.get(val);
        int lastIndex = nums.size() - 1;

        if (index == lastIndex) {
            // 删除的元素是最后一个元素，则直接删除
            nums.remove(lastIndex);
            return true;
        }

        // 交换最后一个元素到val所在位置，并更新valToIndex，然后删除最后一个元素以及索引
        int lastVal = nums.get(lastIndex);

        nums.add(index, lastVal);
        valToIndex.put(lastVal, index);
        nums.remove(lastIndex);
        valToIndex.remove(val);

        return true;
    }

    /**
     * 从集合中等概率地随机获得一个元素
     */
    public int getRandom() {
        // 随机获取 nums 中的一个元素
        return nums.get(RandomUtils.nextInt(0, nums.size()));
    }
}
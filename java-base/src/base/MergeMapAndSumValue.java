package base;

import java.util.HashMap;
import java.util.Map;

public class MergeMapAndSumValue {
    public static void main(String[] args) {
        // 创建两个Map<Long, Integer>
        Map<Long, Integer> map1 = new HashMap<>();
        map1.put(1L, 10);
        map1.put(2L, 5);
        map1.put(3L, 20);

        Map<Long, Integer> map2 = new HashMap<>();
        map2.put(2L, 15);
        map2.put(3L, 25);
        map2.put(4L, 30);

        // 合并两个Map并保留两个Map的key的合集，将相同key的value相加
        Map<Long, Integer> mergedMap = new HashMap<>(map1);
        map2.forEach((key, value) -> mergedMap.merge(key, value, Integer::sum));

        // 打印合并后的Map
        System.out.println("Merged Map: " + mergedMap);
    }

}

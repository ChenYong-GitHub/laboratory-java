package base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetRemoveAllDemo {

    public static void main(String[] args) {
        // 创建一个Map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);

        // 创建一个Set用于存储需要移除的key
        Set<String> keysToRemove = new HashSet<>();
        keysToRemove.add("B");
        keysToRemove.add("D");

        // 使用keySet()和removeAll()移除Set中的key
        map.keySet().removeAll(keysToRemove);

        // 打印结果
        System.out.println("Map after removal: " + map);
    }
}

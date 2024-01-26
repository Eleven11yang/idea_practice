package study.practice.demo;

import java.util.HashMap;
import java.util.Map;

public class MapToJsonExample {
    public static void main(String[] args) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", "Alice");
        dataMap.put("age", 30);
        dataMap.put("city", "London");

//        // 使用FastJSON将Map转换为JSON字符串
//        String jsonString = JSON.toJSONString(dataMap);

        // 打印JSON字符串
//        System.out.println(jsonString);
    }
}

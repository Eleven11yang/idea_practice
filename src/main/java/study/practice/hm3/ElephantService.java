package study.practice.hm3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ElephantService {
    static void saveToTxtFile(Elephant elephant) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("elephants.txt", true))) {
            // 将Elephant对象的JSON字符串表示形式附加到文件中
            writer.write(elephant.toJson().toJSONString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList getElephantsJson(String filePath) {
        Set<String> elephantSet = new HashSet<>();
        ArrayList jsonList = new ArrayList();
        // 读取文件并添加到 HashSet 中
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                JSONObject jsonObject = JSON.parseObject(line);
                String name = jsonObject.getString("name");
                if (elephantSet.contains(name) == false) {
                    elephantSet.add(name);
                    jsonList.add(jsonObject);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonList;
    }

    static void changeHashCodeWithBooleanMembers() {

    }

    static void changeHashCodeWithoutBooleanMembers() {

    }
}


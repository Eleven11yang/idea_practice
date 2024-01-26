package study.practice.hm3;

import com.alibaba.fastjson.JSONObject;

public class Elephant {
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public static Elephant fromJson(JSONObject json) {
        Elephant elephant = new Elephant();
        elephant.setName(json.getString("name"));
        elephant.setAge(json.getIntValue("age"));
        return elephant;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("age", this.age);
        return json;
    }
}

package study.practice.hm3;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

public class Elephant {
    private String name;
    private boolean isFridgeOpen;
    private boolean isElephantInside;
    private boolean isFridgeLocked;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isFridgeLocked() {
        return isFridgeLocked;
    }

    public void setFridgeLocked(boolean fridgeLocked) {
        isFridgeLocked = fridgeLocked;
    }

    public boolean isElephantInside() {
        return isElephantInside;
    }

    public void setElephantInside(boolean elephantInside) {
        isElephantInside = elephantInside;
    }

    public boolean isFridgeOpen() {
        return isFridgeOpen;
    }

    public void setFridgeOpen(boolean fridgeOpen) {
        isFridgeOpen = fridgeOpen;
    }

    public static Elephant fromJson(JSONObject json) {
        Elephant elephant = new Elephant();
        elephant.setName(json.getString("name"));
        elephant.setFridgeOpen(json.getBooleanValue("isFridgeOpen"));
        elephant.setElephantInside(json.getBooleanValue("isElephantInside"));
        elephant.setFridgeLocked(json.getBooleanValue("isFridgeLocked"));
        return elephant;
    }
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("isFridgeOpen", this.isFridgeOpen);
        json.put("isElephantInside", this.isElephantInside);
        json.put("isFridgeLocked", this.isFridgeLocked);
        return json;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

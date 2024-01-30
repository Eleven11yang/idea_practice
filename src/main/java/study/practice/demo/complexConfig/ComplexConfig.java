package study.practice.demo.complexConfig;

import java.util.List;

public class ComplexConfig {
    private String property1;
    private int property2;
    private List<NestedConfig> nestedConfigs;

    // 省略构造函数和其他方法

    // Getter和Setter方法
    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public int getProperty2() {
        return property2;
    }

    public void setProperty2(int property2) {
        this.property2 = property2;
    }

    public List<NestedConfig> getNestedConfigs() {
        return nestedConfigs;
    }

    public void setNestedConfigs(List<NestedConfig> nestedConfigs) {
        this.nestedConfigs = nestedConfigs;
    }
}




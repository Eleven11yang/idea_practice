package study.practice.demo.complexConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final ComplexConfig complexConfig;

    @Autowired
    public MyService(ComplexConfig complexConfig) {
        this.complexConfig = complexConfig;
    }

    public void doSomething() {
        System.out.println("Property1: " + complexConfig.getProperty1());
        System.out.println("Property2: " + complexConfig.getProperty2());

        for (NestedConfig nestedConfig : complexConfig.getNestedConfigs()) {
            System.out.println("Nested Property: " + nestedConfig.getNestedProperty());
        }
    }
}


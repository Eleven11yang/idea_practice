package study.practice.demo.singleConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MyService {
    private final MyConfig myConfig;
    @Autowired
    public MyService(MyConfig myConfig) {
        this.myConfig = myConfig;
    }
    public void doSomething() {
        System.out.println("Property1: " + myConfig.getProperty1());
        System.out.println("Property2: " + myConfig.getProperty2());
    }

    public static void main(String[] args) {
        AppConfig myApp = new AppConfig();
        MyConfig myConfig = myApp.myConfig();
        MyService myService = new MyService(myConfig);
        myService.doSomething();

    }
}


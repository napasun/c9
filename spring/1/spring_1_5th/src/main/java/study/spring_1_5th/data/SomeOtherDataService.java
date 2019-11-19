package study.spring_1_5th.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import study.spring_1_5th.configuration.ApplicationConfiguration;

@Component
public class SomeOtherDataService {
    @Autowired
    private ApplicationConfiguration configuration;

    public String retrieveSomeData() {
        System.out.println(configuration.getService1Timeout());
        System.out.println(configuration.getService1Url());
        System.out.println(configuration.isEnableSwitchForService1());

        return "data from service";
    }
}

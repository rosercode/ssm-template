package cool.wangshuo.st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TemplateAppApplication {

    public static ConfigurableApplicationContext ac;

    public static void main(String[] args) {
        ac = SpringApplication.run(TemplateAppApplication.class, args);
    }

}

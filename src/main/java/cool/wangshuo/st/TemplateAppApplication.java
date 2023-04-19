package cool.wangshuo.st;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EntityScan("cool.wangshuo.st.model.entity")
@MapperScan("cool.wangshuo.st.mapper")
public class TemplateAppApplication {

    public static ConfigurableApplicationContext ac;

    public static void main(String[] args) {
        ac = SpringApplication.run(TemplateAppApplication.class, args);
    }

}

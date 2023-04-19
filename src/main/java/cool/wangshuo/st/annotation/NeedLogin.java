package cool.wangshuo.st.annotation;

import java.lang.annotation.*;

/**
 * @author wangshuo
 * @date 2023/3/7 17:32
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedLogin {

}

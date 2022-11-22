package cool.wangshuo.st.utils;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author wangshuo
 * @description Spring 工具类
 * @date 2021/5/7 2022/09/15 17/34
 */
@Component
public class SpringUtils implements BeanFactoryPostProcessor {
    public static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtils.beanFactory = beanFactory;
    }

    public static <T> T getBean(Class<T> requireType) {
        return beanFactory.getBean(requireType);
    }

    public static <T> T getBean(String beanName) {
        return (T) beanFactory.getBean(beanName);
    }
}
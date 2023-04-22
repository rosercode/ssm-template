package cool.wangshuo.st.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author wangshuo
 * @description
 * @createDate 2022/10/26 12:33
 */

@Component
public class MetaHandler implements MetaObjectHandler {

    /**
     * 新增数据执行
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        boolean hasSetter = metaObject.hasSetter("createdAt");
        if (hasSetter) {
            this.setFieldValByName("createdAt", new Date(), metaObject);
            this.setFieldValByName("updatedAt", new Date(), metaObject);
        }
    }

    /**
     * 更新数据执行
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        boolean hasSetter = metaObject.hasSetter("updatedAt");
        if (hasSetter) {
            this.setFieldValByName("updatedAt", new Date(), metaObject);
        }
    }

}
package cool.wangshuo.st.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cool.wangshuo.st.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangshuo
 * @description
 * @createDate 2022/12/21 14:28
 */

@TableName(value = "t_user")

@Data
@AllArgsConstructor
public class User extends BaseEntity {

    private String username;

    private String password;

    public User() {
    }
}

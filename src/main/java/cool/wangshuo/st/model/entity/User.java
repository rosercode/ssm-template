package cool.wangshuo.st.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cool.wangshuo.st.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author wangshuo
 * @description
 * @createDate 2022/12/21 14:28
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@TableName(value = "t_user")
public class User extends BaseEntity {

    private String username;

    private String password;

}

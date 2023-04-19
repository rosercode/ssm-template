package cool.wangshuo.st.model.vo.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author wangshuo
 * @date 2023/3/3 23:16
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVo {

    @NotNull(message = "username 不能为空")
    @ApiModelProperty("username")
    private String username;

    @NotNull(message = "password 不能为空")
    @ApiModelProperty("password")
    private String password;
}

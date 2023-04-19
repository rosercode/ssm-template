package cool.wangshuo.st.model.vo.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangshuo
 * @date 2023/3/3 23:29
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterVo {

    private String username;

    private String password1;

    private String password2;

}

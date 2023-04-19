package cool.wangshuo.st.model.response.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangshuo
 * @date 2023/3/7 20:36
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMsgResp {

    private Long id;
    private String username;

}

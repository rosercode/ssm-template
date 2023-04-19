package cool.wangshuo.st.service;

import cool.wangshuo.st.model.entity.User;
import cool.wangshuo.st.model.response.GlobalResult;
import cool.wangshuo.st.model.vo.auth.UserLoginVo;
import cool.wangshuo.st.model.vo.auth.UserRegisterVo;

import java.util.List;

/**
 * @author wangshuo
 * @date 2023/4/19 21:50
 */

public interface UserService {

    public List<User> findUser(UserLoginVo vo);

    public GlobalResult<String> add(UserRegisterVo vo);
}

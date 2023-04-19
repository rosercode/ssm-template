package cool.wangshuo.st.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cool.wangshuo.st.mapper.UserMapper;
import cool.wangshuo.st.model.entity.User;
import cool.wangshuo.st.model.response.GlobalResult;
import cool.wangshuo.st.model.vo.auth.UserLoginVo;
import cool.wangshuo.st.model.vo.auth.UserRegisterVo;
import cool.wangshuo.st.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangshuo
 * @date 2023/4/19 21:51
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findUser(UserLoginVo vo) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .eq(StringUtils.isNotBlank(vo.getUsername()), "username", vo.getUsername())
                .eq(StringUtils.isNotBlank(vo.getPassword()), "password", vo.getPassword());

        List<User> userList = userMapper.selectList(queryWrapper);
        return userList;
    }

    @Override
    public GlobalResult<String> add(UserRegisterVo vo) {
        User user = new User();
        user.setUsername(vo.getUsername());
        user.setPassword(vo.getPassword1());
        int count = userMapper.insert(user);
        return count<1 ? GlobalResult.error("注册失败") : GlobalResult.success("注册成功");
    }
}

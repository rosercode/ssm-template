package cool.wangshuo.st.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cool.wangshuo.st.annotation.NeedLogin;
import cool.wangshuo.st.mapper.UserMapper;
import cool.wangshuo.st.model.entity.User;
import cool.wangshuo.st.model.response.GlobalResult;
import cool.wangshuo.st.model.response.auth.UserMsgResp;
import cool.wangshuo.st.model.vo.auth.UserLoginVo;
import cool.wangshuo.st.model.vo.auth.UserRegisterVo;
import cool.wangshuo.st.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author wangshuo
 * @date 2023/4/19 20:37
 */

@RestController
@Slf4j
@RequestMapping(value = "/auth")
@Api(value = "auth", tags = "auth")
@Validated
public class UserController {

    @Resource
    private UserService userService;


    @ApiOperation(value = "登录")
    @PostMapping(value = "/sign-in")
    public GlobalResult<String> login(@RequestBody UserLoginVo vo, HttpSession session) {

        List<User> userList = userService.findUser(vo);
        if (userList.size() < 1) {
            return GlobalResult.error("登录失败");
        }
        session.setAttribute("isLogin", true);
        User userMsg = userList.get(0);
        UserMsgResp userMsgResp = new UserMsgResp();
        BeanUtils.copyProperties(userMsg, userMsgResp);
        session.setAttribute("userMsg", userMsgResp);
        return GlobalResult.success("登录成功");
    }

    @ApiOperation(value = "登出")
    @PostMapping(value = "/sign-out")
    @NeedLogin
    public GlobalResult<String> logout(HttpSession session) {
        session.invalidate();
        return GlobalResult.success("登出");
    }

    @ApiOperation(value = "注册")
    @PostMapping(value = "/register")
    public GlobalResult<String> register(@RequestBody UserRegisterVo vo){
        return userService.add(vo);
    }

    @ApiOperation(value = "获取用户个人信息")
    @PostMapping(value = "/msg")
    @NeedLogin
    public GlobalResult<UserMsgResp> msg(HttpSession session){
        UserMsgResp userMsg = (UserMsgResp) session.getAttribute("userMsg");
        return GlobalResult.success(userMsg);
    }
}

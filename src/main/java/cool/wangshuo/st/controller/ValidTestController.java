package cool.wangshuo.st.controller;

import cool.wangshuo.st.model.response.GlobalResult;
import cool.wangshuo.st.model.vo.valid.ValidGetVo;
import cool.wangshuo.st.model.vo.valid.ValidVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

/**
 * @author wangshuo
 * @date 2023/4/19 20:31
 */

@RestController
@Slf4j
@RequestMapping(value = "/valid")
@Api(value = "Validator校验框架测试", tags = "Validator校验框架测试")
@Validated
public class ValidTestController {

    @ApiOperation(value = "RequestBody 校验")
    @PostMapping(value = "/test1")
    public GlobalResult<String> test1(@Validated @RequestBody ValidVO vo){
        log.info("validEntity is {}", vo);
        return GlobalResult.<String>success("test1 valid success");
    }

    @ApiOperation(value = "Form 校验")
    @PostMapping(value = "/test2")
    public GlobalResult<String> test2(@Validated ValidVO vo){
        log.info("validEntity is {}", vo);
        return GlobalResult.<String>success("test2 valid success");
    }

    @ApiOperation(value = "单参数校验")
    @PostMapping(value = "/test3")
    public GlobalResult<String> test3(@Email String email){
        log.info("email is {}", email);
        return GlobalResult.<String>success("email valid success");
    }

    @ApiOperation(value = "Get 接口参数校验")
    @GetMapping(value = "/test4")
    public GlobalResult<String> test4(@Valid ValidGetVo vo){
        return GlobalResult.<String>success("get valid success");
    }
}

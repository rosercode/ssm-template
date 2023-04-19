package cool.wangshuo.st.controller;

import cool.wangshuo.st.model.response.GlobalResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangshuo
 * @date 2023/4/19 20:37
 */

@RestController
@Slf4j
@RequestMapping(value = "/crud")
@Api(value = "crud", tags = "crud")
@Validated
public class CURDController {



}

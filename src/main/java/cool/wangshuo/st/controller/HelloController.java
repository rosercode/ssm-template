package cool.wangshuo.st.controller;

import com.baomidou.mybatisplus.extension.api.R;
import cool.wangshuo.st.exception.NormalException;
import cool.wangshuo.st.model.request.GoodsAddRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/goods")
@Api(value = "API")
public class HelloController {

    @GetMapping(value = "/1")
    @ApiOperation(value = "interface")
    public String hello(String id){
        if (id!=null && id.equals("1")){
            throw new NormalException("");
        }
        return "Hello";
    }

    @PostMapping(value = "/add")
    public R add(@Valid @RequestBody GoodsAddRequest goodsAddRequest){
        return R.ok("添加成功");
    }
}

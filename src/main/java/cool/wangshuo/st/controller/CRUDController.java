package cool.wangshuo.st.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cool.wangshuo.st.model.response.GlobalResult;
import cool.wangshuo.st.model.response.crud.GoodsPageResp;
import cool.wangshuo.st.model.vo.common.CommonVo1;
import cool.wangshuo.st.model.vo.curd.GoodsAddVo;
import cool.wangshuo.st.model.vo.curd.GoodsPageVo;
import cool.wangshuo.st.model.vo.curd.GoodsUpdateVo;
import cool.wangshuo.st.service.CRUDService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangshuo
 * @date 2023/4/19 20:37
 */

@RestController
@Slf4j
@RequestMapping(value = "/crud")
@Api(value = "crud 接口测试", tags = "crud 接口测试")
@Validated
public class CRUDController {

    @Resource
    private CRUDService crudService;


    @ApiOperation(value = "添加商品")
    @PostMapping(value = "/add")
    public GlobalResult<String> add(@Validated @RequestBody GoodsAddVo vo){
        return crudService.add(vo);
    }

    @ApiOperation(value = "删除商品")
    @PostMapping(value = "/delete")
    public GlobalResult<String> delete(@Validated @RequestBody CommonVo1 vo){
        return crudService.delete(vo);
    }

    @ApiOperation(value = "更新商品")
    @PostMapping(value = "/update")
    public GlobalResult<String> update(@Validated @RequestBody GoodsUpdateVo vo){
        return crudService.update(vo);
    }

    @ApiOperation(value = "分页查询商品")
    @PostMapping(value = "/page")
    public GlobalResult<IPage<GoodsPageResp>> page(@Validated @RequestBody GoodsPageVo vo){
        return crudService.page(vo);
    }
}

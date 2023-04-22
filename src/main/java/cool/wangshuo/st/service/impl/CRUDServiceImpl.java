package cool.wangshuo.st.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cool.wangshuo.st.mapper.CRUDMapper;
import cool.wangshuo.st.model.base.MyBatisPage;
import cool.wangshuo.st.model.entity.Goods;
import cool.wangshuo.st.model.response.GlobalResult;
import cool.wangshuo.st.model.response.crud.GoodsPageResp;
import cool.wangshuo.st.model.vo.common.CommonVo1;
import cool.wangshuo.st.model.vo.curd.GoodsAddVo;
import cool.wangshuo.st.model.vo.curd.GoodsPageVo;
import cool.wangshuo.st.model.vo.curd.GoodsUpdateVo;
import cool.wangshuo.st.service.CRUDService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangshuo
 * @date 2023/4/19 22:14
 */

@Service
public class CRUDServiceImpl implements CRUDService {

    @Resource
    private CRUDMapper crudMapper;

    @Override
    public GlobalResult<String> add(GoodsAddVo vo) {
        Goods entity = new Goods();
        BeanUtils.copyProperties(vo, entity);
        crudMapper.insert(entity);
        return GlobalResult.success();
    }

    @Override
    public GlobalResult<String> delete(CommonVo1 vo) {
        int count = crudMapper.deleteById(vo.getId());
        if (count == 0){
            return GlobalResult.error("删除失败");
        }
        return GlobalResult.success();
    }


    @Override
    public GlobalResult<String> update(GoodsUpdateVo vo) {
        Goods entity = crudMapper.selectById(vo.getId());
        if (entity == null){
            return GlobalResult.error("商品不存在");
        }
        BeanUtils.copyProperties(vo, entity);
        System.out.println("___________________________");
        System.out.println(entity.getName());
        System.out.println("___________________________");
        int count = crudMapper.updateById(entity);
        if (count == 0){
            return GlobalResult.error("更新失败");
        }
        return GlobalResult.success();
    }

    @Override
    public GlobalResult<IPage<GoodsPageResp>> page(GoodsPageVo vo) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<Goods>()
                .like(StringUtils.isNotBlank(vo.getName()),"name",vo.getName())
                ;
        MyBatisPage<Goods> page = crudMapper.selectPage(new MyBatisPage<>(vo.getPageNum(), vo.getPageSize()), queryWrapper);
        IPage<GoodsPageResp> response = page.convert(goods -> {
            GoodsPageResp resp = new GoodsPageResp();
            BeanUtils.copyProperties(goods, resp);
            return resp;
        });
        return GlobalResult.success(response);
    }
}

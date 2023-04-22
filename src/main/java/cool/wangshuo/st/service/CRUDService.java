package cool.wangshuo.st.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cool.wangshuo.st.model.response.GlobalResult;
import cool.wangshuo.st.model.response.crud.GoodsPageResp;
import cool.wangshuo.st.model.vo.common.CommonVo1;
import cool.wangshuo.st.model.vo.curd.GoodsAddVo;
import cool.wangshuo.st.model.vo.curd.GoodsPageVo;
import cool.wangshuo.st.model.vo.curd.GoodsUpdateVo;


/**
 * @author wangshuo
 * @date 2023/4/19 22:14
 */

public interface CRUDService {

    public GlobalResult<String> add(GoodsAddVo vo);

    public GlobalResult<String> delete(CommonVo1 vo);

    public GlobalResult<String> update(GoodsUpdateVo vo);

    public GlobalResult<IPage<GoodsPageResp>> page(GoodsPageVo vo);

}

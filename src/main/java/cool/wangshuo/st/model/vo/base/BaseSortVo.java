package cool.wangshuo.st.model.vo.base;

import cool.wangshuo.st.model.enums.SortTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wangshuo
 * @description 前端请求实体（查询）基类，对分页基类进行扩展 <br> 默认：安装创建时间进行降序
 * @createDate 2022/10/26 12:39
 */

@Data
public class BaseSortVo extends BasePageVo {

    @ApiModelProperty("字段名称 默认值: createTime")
    protected String column = "createTime";

    @ApiModelProperty("ASC(升序) DESC(降序) 默认：降序")
    protected SortTypeEnum sortType = SortTypeEnum.DESC;
}

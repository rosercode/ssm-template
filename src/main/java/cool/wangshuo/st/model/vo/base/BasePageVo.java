package cool.wangshuo.st.model.vo.base;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author wangshuo
 * @description 基础请求分页实体
 * @createDate 2022/09/15 17:58
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "请求分页实体", description = "请求分页实体")
public class BasePageVo {

    @ApiModelProperty("页数")
    private Integer pageNum = 1;

    @ApiModelProperty("每页的大小")
    private Integer pageSize = 10;

}

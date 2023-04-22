package cool.wangshuo.st.model.response.crud;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

/**
 * @author wangshuo
 * @date 2023/4/19 22:37
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsPageResp {

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品类型")
    private String goodType;

    @ApiModelProperty("商品价格")
    private Integer price;

    @ApiModelProperty("生产日期")
    private Date manufacturing;
}

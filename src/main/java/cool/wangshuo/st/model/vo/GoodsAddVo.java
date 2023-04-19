package cool.wangshuo.st.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author wangshuo
 * @description
 * @createDate 2022/10/26 13:59
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsAddVo {

    // 商品名称
    @NotNull(message = "名称不能为空")
    private String name;

    // 商品类型
    @NotNull(message = "类型不能为空")
    private String goodType;

    // 商品价格
    @NotNull(message = "价格不能为空")
    private Integer price;

}

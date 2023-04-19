package cool.wangshuo.st.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author
 * @description
 * @createDate 2022/10/26 13:59
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsAddRequest {

    // 商品名称
    private String name;

    // 商品类型
    private String goodType;

    // 商品价格
    @NotNull(message = "N不饿能为i空")
    private Integer price;

}

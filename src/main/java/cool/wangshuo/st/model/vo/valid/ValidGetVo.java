package cool.wangshuo.st.model.vo.valid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author wangshuo
 * @date 2023/4/19 20:57
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidGetVo {

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

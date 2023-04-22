package cool.wangshuo.st.model.vo.curd;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author wangshuo
 * @date 2023/4/19 22:19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsUpdateVo extends GoodsAddVo{

    @NotNull(message = "id不能为空")
    @ApiModelProperty("id")
    private Long id;
}

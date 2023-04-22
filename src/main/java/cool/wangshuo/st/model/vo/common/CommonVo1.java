package cool.wangshuo.st.model.vo.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author wangshuo
 * @date 2023/4/19 22:11
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonVo1 {

    @NotNull(message = "id不能为空")
    @ApiModelProperty("id")
    private Long id;
}

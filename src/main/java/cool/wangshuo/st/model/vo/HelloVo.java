package cool.wangshuo.st.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloVo {

    @NotEmpty(message = "姓名不能为空")
    private String username;
}

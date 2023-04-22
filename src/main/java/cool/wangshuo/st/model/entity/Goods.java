package cool.wangshuo.st.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cool.wangshuo.st.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wangshuo
 * @description
 * @createDate 2022/10/26 13:59
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@TableName("t_goods")
public class Goods extends BaseEntity {

    // 商品名称
    private String name;

    // 商品类型
    private String goodType;

    // 商品价格
    private Integer price;

    // 生产日期
    private Date manufacturing;

}

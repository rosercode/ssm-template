package cool.wangshuo.st.model.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description 数据库实体类基类，定义了数据库表共同的属性（字段），数据库表对应的实体类在此基类上进行扩展
 * @Date 2022/9/27 15:28
 * @Created by wangshuo
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    /**
     *  主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    protected Long id;


    /**
     * 列创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    protected Date createdAt;


    /**
     * 列更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Date updatedAt;

}

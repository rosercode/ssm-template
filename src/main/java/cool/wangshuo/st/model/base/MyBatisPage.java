package cool.wangshuo.st.model.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author
 * @date
 * @description
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class MyBatisPage<T> extends Page<T> {

    public MyBatisPage(long pageNum, long pageSize) {
        super(pageNum + 1, pageSize);
    }
}

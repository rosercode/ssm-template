package cool.wangshuo.st.advice;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import cool.wangshuo.st.model.response.GlobalResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author wangshuo
 * @description
 * @createDate 2022/10/26 16:52
 */

@RestControllerAdvice
public class GlobalAdvice {


    /**
     * ExceptionHandler的作用是用来捕获指定的异常
     * 这里示例 捕获 Java的validation做入参的校验 的校验失败的异常
     * 统一处理，免得返回前端
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GlobalResult handleStoreAuthException(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        StringBuilder detailMsg = new StringBuilder();
        if (CollectionUtils.isNotEmpty(allErrors)) {
            allErrors.stream().forEach(i -> detailMsg.append(i.getDefaultMessage()).append(";"));
        }
        return GlobalResult.build(GlobalResult.ERROR_CODE, detailMsg.toString());
    }


    /**
     * ExceptionHandler的作用是用来捕获指定的异常
     * 这里示例 捕获 Exception异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public GlobalResult handleStoreAuthException(Exception e) {
        return GlobalResult.build(GlobalResult.ERROR_CODE, e.getMessage());
    }
}

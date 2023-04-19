package cool.wangshuo.st.advice;


import cool.wangshuo.st.model.response.GlobalResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

/**
 * @author wangshuo
 * @description
 * @createDate 2022/10/26 16:52
 */

@Slf4j
@RestControllerAdvice
public class GlobalAdvice {

    /**
     * 拦截所有的异常信息
     * 1、打印异常信息 <br/>
     * 2、
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public GlobalResult<String> exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return GlobalResult.error(500,e.getMessage());
    }

    /**
     * 为了方便前端提示，简化 Validator 校验框架返回的错误提示
     * @param e
     * @return
     */
    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public GlobalResult<String> handleValidatedException(Exception e) {
        log.info(String.valueOf(HttpStatus.BAD_REQUEST.value()));

        if (e instanceof MethodArgumentNotValidException) {
            // BeanValidation exception
            log.info("BeanValidation exception");
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            return GlobalResult.error(ex.getBindingResult().getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("\n")));
        } else if (e instanceof ConstraintViolationException) {
            // BeanValidation GET simple param
            log.info("BeanValidation GET simple param");
            ConstraintViolationException ex = (ConstraintViolationException) e;
            return GlobalResult.error(ex.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n")));

        } else if (e instanceof BindException) {
            log.info("BeanValidation GET object param");
            // BeanValidation GET object param
            BindException ex = (BindException) e;
            return GlobalResult.error(ex.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("\n")));
        }
        return GlobalResult.error();
    }
}

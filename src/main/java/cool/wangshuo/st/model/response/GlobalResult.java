package cool.wangshuo.st.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangshuo
 * @description
 * @createDate 2022/10/26 16:53
 */

@Data
public class GlobalResult<T> implements Serializable {

    public static final Integer SUCCESS_CODE = 200;

    public static final Integer ERROR_CODE = 500;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态码描述
     */
    private String message;

    /**
     * 响应结果
     */
    private T data;

    public GlobalResult() {

    }
    private GlobalResult(Integer code, String message) {
        this(code, message, null);
    }
    private GlobalResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static <T> GlobalResult<T>  build(Integer code, String message) {
        return new GlobalResult(code, message);
    }
    public static <T> GlobalResult<T> build(Integer code, String message, T data) {
        return new GlobalResult(code, message, data);
    }

    public static <T> GlobalResult<T> success() {
        return build(SUCCESS_CODE, "处理成功");
    }

    public static <T>GlobalResult<T> success(Integer code, String message) {
        return build(code, message);
    }

    public static <T> GlobalResult<T> success(T data) {
        return build(SUCCESS_CODE, "处理成功", data);
    }
    public static <T>GlobalResult<T> error() {
        return build(ERROR_CODE, "处理失败");
    }
    public static <T>GlobalResult<T> error(String message) {
        return error(ERROR_CODE, message);
    }
    public static <T>GlobalResult<T> error(Integer code, String message) {
        return build(code, message);
    }
}
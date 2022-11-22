package cool.wangshuo.st.model.response;

import lombok.Data;

/**
 * @author
 * @description
 * @createDate 2022/10/26 16:53
 */

@Data
public class GlobalResult {

    public static final String SUCCESS_CODE = "200";

    public static final String ERROR_CODE = "500";

    /**
     * 状态码
     */
    private String code;

    /**
     * 状态码描述
     */
    private String message;

    /**
     * 响应结果
     */
    private Object data;

    private GlobalResult(String code, String message) {
        this(code, message, null);
    }

    private GlobalResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static GlobalResult build(String code, String message) {
        return new GlobalResult(code, message);
    }

    public static GlobalResult build(String code, String message, Object data) {
        return new GlobalResult(code, message, data);
    }

    public static GlobalResult success() {
        return build(SUCCESS_CODE, "处理成功");
    }

    public static GlobalResult success(String code, String message) {
        return build(code, message);
    }

    public static GlobalResult success(Object data) {
        return build(SUCCESS_CODE, "处理成功", data);
    }

    public static GlobalResult error() {
        return build(ERROR_CODE, "处理失败");
    }

    public static GlobalResult error(String message) {
        return error(ERROR_CODE, message);
    }

    public static GlobalResult error(String code, String message) {
        return build(code, message);
    }
}
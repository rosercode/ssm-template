package cool.wangshuo.st.exception;

/**
 * @author wangshuo
 * @description
 * @createDate 2022/10/26 15:55
 */

public class NormalException extends RuntimeException {

    public NormalException() {
    }

    public NormalException(String message) {
        super(message);
    }
}

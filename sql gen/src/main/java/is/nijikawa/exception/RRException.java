package is.nijikawa.exception;

/**
 * 自定义异常
 */
@Data
public class RRException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;
}

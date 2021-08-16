package is.nijikawa.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class Rexception extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Rexception() {
        put("code", 0);
    }

    public static Rexception error() {
        return error(500, "未知异常");
    }

    public static Rexception error(String msg) {
        return error(500, msg);
    }

    public static Rexception error(int code, String msg) {
        Rexception r = new Rexception();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Rexception ok(String msg) {
        Rexception r = new Rexception();
        r.put("msg", msg);
        return r;
    }

    public static Rexception ok(Map<String, Object> map) {
        Rexception r = new Rexception();
        r.putAll(map);
        return r;
    }

    public static Rexception ok() {
        return new Rexception();
    }

    public Rexception put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}

package is.nijikawa.fozubaoyo.security.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 结果封装用实体
 **/

@Data
public class Result implements Serializable {
    //响应码 TODO:响应码应当用枚举类型
    private Integer code;
    //消息
    private String message;
    //返回数据
    private Object data;

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

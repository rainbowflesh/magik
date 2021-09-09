package is.nijikawa.fozubaoyo.model.vo;

import is.nijikawa.fozubaoyo.model.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * 登录VO
 **/
@Data
public class LoginVO implements Serializable {
    private Integer id;
    private String token;
    private User user;
}

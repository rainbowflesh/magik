package is.nijikawa.fozubaoyo.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户实体类
 **/
@Data
@TableName(value = "user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String loginName;
    private String userName;
    private String password;

    public User(String loginName, String userName, String password) {
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
    }
}

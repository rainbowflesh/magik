package is.nijikawa.fozubaoyo.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Table;

/**
 * 验权用的实体类就不用jpa了罢
 */
@Data
@Table(name = "user_role")
public class Role {
    @TableId(type = IdType.AUTO)
    private int id;
    private String login_name;
    private String role;

    public Role(String login_name, String role) {
        this.login_name = login_name;
        this.role = role;
    }
}


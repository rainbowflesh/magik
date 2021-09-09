package is.nijikawa.fozubaoyo.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * jpa 实体类
 */
// 啥b jpa咩办法用Lombok一把梭, 太拉了
@Table(name = "user_info")
@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String login_name;
    @Column
    private String email;

    public Info(String login_name, String email) {
        this.login_name = login_name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Info info = (Info) o;

        return Objects.equals(id, info.id);
    }

    @Override
    public int hashCode() {
        return 1034993061;
    }
}
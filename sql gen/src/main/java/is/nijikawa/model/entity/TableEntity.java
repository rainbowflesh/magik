package is.nijikawa.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 表数据
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月20日 上午12:02:55
 */
@Data
public class TableEntity {
    //表的名称
    private String tableName;
    //表的备注
    private String comments;
    //表的主键
    private ColumnEntity pk;
    //表的列名(不包含主键)
    private List<ColumnEntity> columns;
    //类名(第一个字母大写)，如：sys_user => SysUser
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String className;
    //类名(第一个字母小写)，如：sys_user => sysUser
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String classname;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
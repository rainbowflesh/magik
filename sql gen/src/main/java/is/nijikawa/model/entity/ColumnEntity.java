package is.nijikawa.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 列的属性
 */
@Data
public class ColumnEntity {
    //列名
    private String columnName;
    //列名类型
    private String dataType;
    //列名备注
    private String comments;
    //属性名称(第一个字母大写)，如：user_name => UserName
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String attrName;
    //属性名称(第一个字母小写)，如：user_name => userName
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String attrname;
    //属性类型
    private String attrType;
    //auto_increment
    private String extra;

    public String getAttrname() {
        return attrname;
    }

    public void setAttrname(String attrname) {
        this.attrname = attrname;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
}
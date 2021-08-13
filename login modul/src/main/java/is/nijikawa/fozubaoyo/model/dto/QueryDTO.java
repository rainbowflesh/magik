package is.nijikawa.fozubaoyo.model.dto;

import lombok.Data;

/**
 * 查询业务实体
 */
@Data
public class QueryDTO {
    private Integer pageNo;    //页码
    private Integer pageSize;  //页面大小
    private String keyword;    //关键字
}

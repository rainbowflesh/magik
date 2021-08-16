package is.nijikawa.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 */
@Component
public interface mysql_SysGeneratorDao {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}

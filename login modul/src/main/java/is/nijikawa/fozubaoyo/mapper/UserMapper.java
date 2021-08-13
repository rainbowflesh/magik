package is.nijikawa.fozubaoyo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import is.nijikawa.fozubaoyo.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * myblyat自定义查询
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    IPage<User> selectUserPage(@Param("page") Page<User> page, @Param("keyword") String keyword);
}

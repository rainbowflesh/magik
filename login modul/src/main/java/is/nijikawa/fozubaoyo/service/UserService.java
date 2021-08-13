package is.nijikawa.fozubaoyo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import is.nijikawa.fozubaoyo.model.dto.QueryDTO;
import is.nijikawa.fozubaoyo.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户操作服务
 */
@Component
public interface UserService {
    /**
     * 分页查询
     *
     * @param queryDTO queryDTO
     * @return null
     */
    IPage<User> selectUserPage(QueryDTO queryDTO);

    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);

    void batchDelete(List<Integer> ids);
}

package is.nijikawa.fozubaoyo.service.imp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import is.nijikawa.fozubaoyo.mapper.UserMapper;
import is.nijikawa.fozubaoyo.model.dto.QueryDTO;
import is.nijikawa.fozubaoyo.model.entity.User;
import is.nijikawa.fozubaoyo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作用户实现
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public IPage<User> selectUserPage(QueryDTO queryDTO) {
        Page<User> page = new Page<>(queryDTO.getPageNo(), queryDTO.getPageSize());
        return userMapper.selectUserPage(page, queryDTO.getKeyword());
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        userMapper.deleteBatchIds(ids);
    }

}

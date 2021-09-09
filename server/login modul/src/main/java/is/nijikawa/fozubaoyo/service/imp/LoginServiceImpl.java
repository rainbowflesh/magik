package is.nijikawa.fozubaoyo.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import is.nijikawa.fozubaoyo.mapper.UserMapper;
import is.nijikawa.fozubaoyo.model.dto.LoginDTO;
import is.nijikawa.fozubaoyo.model.entity.User;
import is.nijikawa.fozubaoyo.model.vo.LoginVO;
import is.nijikawa.fozubaoyo.security.model.Result;
import is.nijikawa.fozubaoyo.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

/**
 * 登录实现
 **/
@Service
public class LoginServiceImpl implements LoginService {
    private final UserMapper userMapper;

    public LoginServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Result login(LoginDTO loginDTO) {
        if (ObjectUtils.isEmpty(loginDTO.getLoginName())) {
            return new Result(400, "账号不能为空", "");
        }
        if (ObjectUtils.isEmpty(loginDTO.getPassword())) {
            return new Result(400, "密码不能为空", "");
        }
        //通过登录名查询用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("login_name", loginDTO.getLoginName());
        User uer = userMapper.selectOne(wrapper);
        //比较密码
        if (uer != null && uer.getPassword().equals(loginDTO.getPassword())) {
            LoginVO loginVO = new LoginVO();
            loginVO.setId(uer.getId());
            //这里token直接用一个uuid
            //使用jwt的情况下，会生成一个jwt token,jwt token里会包含用户的信息
            //TODO: 所以接下来要使用jwt进行安全升级
            loginVO.setToken(UUID.randomUUID().toString());
            loginVO.setUser(uer);
            return new Result(200, "", loginVO);
        }
        return new Result(401, "登录失败", "");
    }
}

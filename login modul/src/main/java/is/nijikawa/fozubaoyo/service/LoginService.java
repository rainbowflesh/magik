package is.nijikawa.fozubaoyo.service;

import is.nijikawa.fozubaoyo.model.dto.LoginDTO;
import is.nijikawa.fozubaoyo.security.model.Result;
import org.springframework.stereotype.Component;

/**
 * 登陆服务
 **/
@Component
public interface LoginService {
    Result login(LoginDTO loginDTO);
}

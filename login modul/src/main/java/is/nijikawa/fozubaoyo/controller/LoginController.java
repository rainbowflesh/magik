package is.nijikawa.fozubaoyo.controller;

import is.nijikawa.fozubaoyo.model.dto.LoginDTO;
import is.nijikawa.fozubaoyo.security.model.Result;
import is.nijikawa.fozubaoyo.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录
 */
@RestController()
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/api/login")
    public Result login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

    @PostMapping(value = "/api/hello")
    public Result hello() {
        return new Result(200, "hello", "world");
    }
}

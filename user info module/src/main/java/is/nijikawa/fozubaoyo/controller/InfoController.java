package is.nijikawa.fozubaoyo.controller;

import is.nijikawa.fozubaoyo.model.entity.Info;
import is.nijikawa.fozubaoyo.service.InfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户信息
 */
@RestController
public class InfoController {
    private final InfoService infoS;

    public InfoController(InfoService infoS) {
        this.infoS = infoS;
    }

    @GetMapping("/api/user/infolist")
    public Info getUserInfo() {
        List<Info> list = infoS.findAll();
        return (Info) list;
    }

    @GetMapping("/api/user/info")
    public Info getInfoByName(String login_name) {
        List<Info> list = infoS.findByName(login_name);
        return (Info) list;
    }
}

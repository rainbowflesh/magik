package is.nijikawa.fozubaoyo.controller;

import is.nijikawa.fozubaoyo.model.dto.QueryDTO;
import is.nijikawa.fozubaoyo.model.entity.User;
import is.nijikawa.fozubaoyo.security.model.Result;
import is.nijikawa.fozubaoyo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户管理
 */
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 分页查询
     *
     * @param queryDTO queryDTO
     * @return Result
     */
    @PostMapping("/api/user/list")
    public Result userList(@RequestBody QueryDTO queryDTO) {
        return new Result(200, "", userService.selectUserPage(queryDTO));
    }

    /**
     * 添加
     *
     * @param user user
     * @return Result
     */
    @PostMapping("/api/user/add")
    public Result addUser(@RequestBody User user) {
        return new Result(200, "", userService.addUser(user));
    }

    /**
     * 更新
     *
     * @param user user
     * @return Result
     */
    @PostMapping("/api/user/update")
    public Result updateUser(@RequestBody User user) {
        return new Result(200, "", userService.updateUser(user));
    }

    /**
     * 删除
     *
     * @param id id
     * @return Result
     */
    @PostMapping("/api/user/delete")
    public Result deleteUser(Integer id) {
        return new Result(200, "", userService.deleteUser(id));
    }

    /**
     * 批量删除
     *
     * @param ids ids
     * @return Result
     */
    @PostMapping("/api/user/delete/batch")
    public Result batchDeleteUser(@RequestBody List<Integer> ids) {
        userService.batchDelete(ids);
        return new Result(200, "", "");
    }
}

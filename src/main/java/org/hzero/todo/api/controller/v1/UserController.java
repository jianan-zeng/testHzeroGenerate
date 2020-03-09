package org.hzero.todo.api.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hzero.todo.domain.entity.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;

import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.todo.app.service.UserService;
import org.hzero.todo.config.SwaggerApiConfig;
import org.hzero.todo.domain.entity.User;
import org.hzero.todo.domain.repository.UserRepository;

/**
 * 用户接口
 */
@Api(tags = SwaggerApiConfig.USER)
@RestController("userController.v1")
@RequestMapping("/v1/users")
public class UserController extends BaseController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "分页查询用户")
    @GetMapping
    public ResponseEntity<Page<User>> pageTask(User user, PageRequest pageRequest) {
        return Results.success(userRepository.pageAndSort(pageRequest, user));
    }

    @Permission(level = ResourceLevel.ORGANIZATION,permissionPublic=true)
    @ApiOperation(value = "根据用户id查询用户")
    @ApiImplicitParams({@ApiImplicitParam(value = "用户编号", paramType = "string")})
    @GetMapping("/{userId}")
    public ResponseEntity<User> selectDetail(@PathVariable Long organizationId, @PathVariable Long userId) {
        return Results.success(userRepository.selectDetailByUserId(userId));
    }

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "创建 todo 用户")
    @PostMapping
    private ResponseEntity<User> createUser(@RequestBody User user) {
        // 简单数据校验
        this.validObject(user);
        // 创建用户
        return Results.success(userService.create(user));
    }

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "删除 todo 用户")
    @DeleteMapping
    private ResponseEntity<User> deleteUser(@RequestBody User user) {
        // 数据防篡改校验
        SecurityTokenHelper.validToken(user);
        // 删除用户
        userService.delete(user.getId());
        return Results.success();
    }
}

package org.hzero.todo.infra.repository.impl;

import org.hzero.todo.domain.entity.Task;
import org.hzero.todo.infra.mapper.TaskMapper;
import org.hzero.todo.infra.mapper.UserMapper;
import org.springframework.stereotype.Component;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.todo.domain.entity.User;
import org.hzero.todo.domain.repository.UserRepository;

/**
 * 用户资源库实现
 */
@Component
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

    private final UserMapper userMapper;

    public UserRepositoryImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }



    @Override
    public User selectDetailByUserId(long userId) {
        return null;
    }
}

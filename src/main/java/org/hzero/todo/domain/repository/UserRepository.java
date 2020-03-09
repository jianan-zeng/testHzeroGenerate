package org.hzero.todo.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import org.hzero.todo.domain.entity.Task;
import org.hzero.todo.domain.entity.User;

/**
 * 用户资源库
 */
public interface UserRepository extends BaseRepository<User> {

    /**
     * 根据任务编号查询任务详细(包含员工姓名)
     *
     * @param userId 任务编号
     * @return Task
     */
    User selectDetailByUserId(long userId);
}

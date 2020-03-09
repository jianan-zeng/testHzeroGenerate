package org.hzero.todo.infra.mapper;

import java.util.List;

import io.choerodon.mybatis.common.BaseMapper;

import org.hzero.todo.domain.entity.Task;

/**
 * TaskMapper
 */
public interface TaskMapper extends BaseMapper<Task> {

    /**
     * 查询任务
     * 
     * @param params 任务查询参数
     * @return Task
     */
    List<Task> selectTask(Task params);
}

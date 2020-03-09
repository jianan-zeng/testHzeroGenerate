package org.hzero.todo.config;

import io.choerodon.core.swagger.ChoerodonRouteData;
import io.choerodon.swagger.annotation.ChoerodonExtraData;
import io.choerodon.swagger.swagger.extra.ExtraData;
import io.choerodon.swagger.swagger.extra.ExtraDataManager;

/**
 * 服务路由配置 一般不做修改
 */
@ChoerodonExtraData
public class TodoExtraDataManager implements ExtraDataManager {

    @Override
    public ExtraData getData() {
        ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
        //服务简码
        choerodonRouteData.setName("htdo");
        //服务路由
        choerodonRouteData.setPath("/todo/**");
        //服务路由对应的服务名称
        choerodonRouteData.setServiceId("hzero-todo-service");
        extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
        return extraData;
    }
}

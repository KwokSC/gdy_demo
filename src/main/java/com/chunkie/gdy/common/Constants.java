package com.chunkie.gdy.common;

/**
 * @Description:
 * @ClassName: MsgConstants
 * @Author: SichengGuo
 * @Date: 2021/12/14 17:22
 * @Version: 1.0
 */
public interface Constants {

    interface Msgs{
        String SUCCESS = "请求成功";
        String FAIL = "请求失败";
    }

    interface Code{
        Integer NORMAL = 200;
        Integer EXCEPTION = 500;
    }

}

package com.chunkie.gdy.common;

import io.netty.buffer.ByteBuf;

/**
 * @Description:
 * @ClassName: MsgConstants
 * @Author: SichengGuo
 * @Date: 2021/12/14 17:22
 * @Version: 1.0
 */
public interface Constants {

    String JWT_SECRET = "chunkie0518";

    interface Msgs{
        String SUCCESS = "请求成功";
        String FAIL = "请求失败";
    }

    interface Code{
        Integer NORMAL = 200;
        Integer EXCEPTION = 500;
    }

}

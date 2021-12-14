package com.chunkie.gdy.common;

import lombok.Data;

/**
 * @Description:
 * @ClassName: ResponseObj
 * @Author: SichengGuo
 * @Date: 2021/12/14 17:19
 * @Version: 1.0
 */

@Data
public class ResponseObj {

    private final static int NORMAL = 200;

    private final static int EXCEPTION =500;

    private Object data;

    private Integer code;

    private String msg;
}

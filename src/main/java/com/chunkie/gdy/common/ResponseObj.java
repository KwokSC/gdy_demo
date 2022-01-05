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

    private Object data;

    private int code;

    private String msg;

}

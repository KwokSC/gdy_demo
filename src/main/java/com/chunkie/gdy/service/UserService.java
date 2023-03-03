package com.chunkie.gdy.service;

import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.User;
import com.chunkie.gdy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.geom.RectangularShape;


/**
 * @Description:
 * @ClassName: UserService
 * @Author: SichengGuo
 * @Date: 2022/1/5 11:38
 * @Version: 1.0
 */

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public ResponseObj login(User user){
        ResponseObj responseObj = new ResponseObj();
        User u = findByUserName(user.getUserName());
        if (u.getPassword().equals(user.getPassword())) {
            responseObj.setMsg(Constants.Msgs.SUCCESS);
            responseObj.setCode(Constants.Code.NORMAL);
        }
        else{
            responseObj.setCode(Constants.Code.EXCEPTION);
            responseObj.setMsg(Constants.Msgs.FAIL);
        }
        return responseObj;
    }

    public User findByUserName(String userName){
        return userMapper.selectByUserName(userName);
    }
}

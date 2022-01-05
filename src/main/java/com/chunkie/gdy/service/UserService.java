package com.chunkie.gdy.service;

import com.chunkie.gdy.entity.User;
import com.chunkie.gdy.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    public User findByUserName(String userName){
        return userMapper.selectByUserName(userName);
    }
}

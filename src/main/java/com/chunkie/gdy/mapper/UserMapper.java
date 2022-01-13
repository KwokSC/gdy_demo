package com.chunkie.gdy.mapper;

import com.chunkie.gdy.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @ClassName: RoomMapper
 * @Author: SichengGuo
 * @Date: 2021/12/15 10:44
 * @Version: 1.0
 */

@Mapper
public interface UserMapper {

    User selectByUserName(String userName);

    int addUser(User user);
}

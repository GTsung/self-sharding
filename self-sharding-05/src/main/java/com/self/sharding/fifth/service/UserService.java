package com.self.sharding.fifth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.self.sharding.fifth.domain.UserDO;

import java.util.List;

public interface UserService extends IService<UserDO> {

    boolean saveUsers(List<UserDO> users);

    UserDO getUserById(Long userId);

}

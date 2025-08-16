package com.self.sharding.fourth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.self.sharding.fourth.domain.UserDO;
import com.self.sharding.fourth.mapper.UserMapper;
import com.self.sharding.fourth.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {


}

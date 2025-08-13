package com.self.sharding.first.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.self.sharding.first.domain.SelfUser;
import com.self.sharding.first.mapper.SelfUserMapper;
import com.self.sharding.first.service.SelfUserService;
import org.springframework.stereotype.Service;

@Service
public class SelfUserServiceImpl extends ServiceImpl<SelfUserMapper, SelfUser> implements SelfUserService {



}

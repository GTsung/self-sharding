package com.self.sharding.six.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.self.sharding.six.domain.PeopleDO;
import com.self.sharding.six.mapper.PeopleMapper;
import com.self.sharding.six.service.PeopleService;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, PeopleDO> implements PeopleService {

}

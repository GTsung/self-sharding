package com.self.sharding.third.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.self.sharding.third.domain.AddressDO;
import com.self.sharding.third.mapper.AddressMapper;
import com.self.sharding.third.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, AddressDO> implements AddressService {


}

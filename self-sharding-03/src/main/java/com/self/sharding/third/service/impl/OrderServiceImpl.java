package com.self.sharding.third.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.self.sharding.third.domain.OrderDO;
import com.self.sharding.third.mapper.OrderMapper;
import com.self.sharding.third.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderDO> implements OrderService {
}

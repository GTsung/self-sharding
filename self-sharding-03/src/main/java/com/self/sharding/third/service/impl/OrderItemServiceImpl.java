package com.self.sharding.third.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.self.sharding.third.domain.OrderItemDO;
import com.self.sharding.third.mapper.OrderItemMapper;
import com.self.sharding.third.service.OrderItemService;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemDO> implements OrderItemService {
}

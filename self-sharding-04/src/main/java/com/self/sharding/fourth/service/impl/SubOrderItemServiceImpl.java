package com.self.sharding.fourth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.self.sharding.fourth.domain.SubOrderItemDO;
import com.self.sharding.fourth.mapper.SubOrderItemMapper;
import com.self.sharding.fourth.service.SubOrderItemService;
import org.springframework.stereotype.Service;

@Service
public class SubOrderItemServiceImpl extends ServiceImpl<SubOrderItemMapper, SubOrderItemDO> implements SubOrderItemService {
}

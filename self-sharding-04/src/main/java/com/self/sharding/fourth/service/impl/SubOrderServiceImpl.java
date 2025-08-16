package com.self.sharding.fourth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.self.sharding.fourth.domain.SubOrderDO;
import com.self.sharding.fourth.mapper.SubOrderMapper;
import com.self.sharding.fourth.service.SubOrderService;
import org.springframework.stereotype.Service;

@Service
public class SubOrderServiceImpl extends ServiceImpl<SubOrderMapper, SubOrderDO> implements SubOrderService {
}

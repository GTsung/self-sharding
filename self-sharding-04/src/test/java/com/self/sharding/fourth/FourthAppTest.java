package com.self.sharding.fourth;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.self.sharding.fourth.domain.AddressDO;
import com.self.sharding.fourth.domain.SubOrderDO;
import com.self.sharding.fourth.domain.SubOrderItemDO;
import com.self.sharding.fourth.domain.UserDO;
import com.self.sharding.fourth.service.AddressService;
import com.self.sharding.fourth.service.SubOrderItemService;
import com.self.sharding.fourth.service.SubOrderService;
import com.self.sharding.fourth.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class FourthAppTest {

    @Resource
    private AddressService addressService;

    @Resource
    private UserService userService;

    @Resource
    private SubOrderService subOrderService;

    @Resource
    private SubOrderItemService subOrderItemService;

    @Test
    public void testInit() {
        List<UserDO> userDOS = IntStream.range(1, 11)
                .mapToObj(i -> UserDO.builder()
                        .userId(i)
                        .userName("u" + i)
                        .assistedQueryPwd("pass" + i)
                        .build())
                .collect(Collectors.toList());
        userService.saveBatch(userDOS);

        List<AddressDO> addressDOS = IntStream.range(1, 11)
                .mapToObj(i ->
                        AddressDO.builder()
                                .addressId((long) i)
                                .addressName("address" + i)
                                .build())
                .collect(Collectors.toList());
        addressService.saveBatch(addressDOS);

        for (int i = 1; i <= 10; i++) {
            SubOrderDO order = new SubOrderDO();
            order.setUserId(i);
            order.setAddressId((long) i);
            order.setStatus("INSERT_TEST");
            subOrderService.save(order);
            SubOrderItemDO item = new SubOrderItemDO();
            item.setOrderId(order.getOrderId());
            item.setUserId(i);
            item.setStatus("INSERT_TEST");
            subOrderItemService.save(item);
        }
    }

    @Test
    public void testSelect() {
        List<SubOrderDO> subOrderDOS = subOrderService.list(
                Wrappers.<SubOrderDO>lambdaQuery()
                        .in(SubOrderDO::getUserId, Lists.newArrayList(1, 2, 3))
        );
        System.out.println(subOrderDOS);
        List<Long> subOrderIds = subOrderDOS.stream()
                .map(SubOrderDO::getOrderId).collect(Collectors.toList());
        List<SubOrderItemDO> subOrderItemDOS = subOrderItemService.list(
                Wrappers.<SubOrderItemDO>lambdaQuery().in(SubOrderItemDO::getOrderId, subOrderIds)
        );
        System.out.println(subOrderItemDOS);
    }

}

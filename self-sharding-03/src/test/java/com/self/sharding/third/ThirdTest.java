package com.self.sharding.third;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.self.sharding.third.domain.AddressDO;
import com.self.sharding.third.domain.OrderDO;
import com.self.sharding.third.domain.OrderItemDO;
import com.self.sharding.third.domain.UserDO;
import com.self.sharding.third.service.AddressService;
import com.self.sharding.third.service.OrderItemService;
import com.self.sharding.third.service.OrderService;
import com.self.sharding.third.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class ThirdTest {

    @Resource
    private AddressService addressService;
    @Resource
    private UserService userService;
    @Resource
    private OrderService orderService;
    @Resource
    private OrderItemService orderItemService;

    /**
     * 这个表即使没有userId,也会在每个库里都有,而且数据一致
     */
    @Test
    public void testInitAddress() {
        List<AddressDO> addressDOList = IntStream.range(1, 11)
                .mapToObj(i -> AddressDO.builder()
                        .addressId((long) i)
                        .addressName("address_" + i)
                        .build())
                .collect(Collectors.toList());
        addressService.saveBatch(addressDOList);
    }

    /**
     * 根据userId分库
     */
    @Test
    public void testInsert() {
        List<UserDO> userDOS = IntStream.range(1, 11)
                .mapToObj(i -> UserDO.builder()
                        .userId(i)
                        .userName("test_mybatis_" + i)
                        .pwd("pwd_mybatis_" + i)
                        .build())
                .collect(Collectors.toList());
        userService.saveBatch(userDOS);
    }

    /**
     * 会根据userId分库,而且指定了两个表的关联,所以不会笛卡尔
     */
    @Test
    public void testInsertOrder() {
        for (int i = 1; i <= 10; i++) {
            OrderDO order = new OrderDO();
            order.setUserId(i);
            order.setAddressId((long) i);
            order.setStatus("INSERT_TEST");
            orderService.save(order);
            OrderItemDO item = new OrderItemDO();
            item.setOrderId(order.getOrderId());
            item.setUserId(i);
            item.setStatus("INSERT_TEST");
            orderItemService.save(item);
        }
    }

    @Test
    public void testSelect() {
        OrderDO orderDO = orderService.getOne(
                Wrappers.<OrderDO>lambdaQuery()
                        .eq(OrderDO::getUserId, 1)
        );
        System.out.println(orderDO);
        OrderItemDO orderItemDO = orderItemService.getOne(
                Wrappers.<OrderItemDO>lambdaQuery()
                        .eq(OrderItemDO::getOrderId, orderDO.getOrderId())
        );
        System.out.println(orderItemDO);
        AddressDO addressDO = addressService.getOne(
                Wrappers.<AddressDO>lambdaQuery()
                        .eq(AddressDO::getAddressId, orderDO.getAddressId())
        );
        System.out.println(addressDO);
    }


}

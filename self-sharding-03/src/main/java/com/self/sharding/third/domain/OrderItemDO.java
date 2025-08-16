package com.self.sharding.third.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_order_item")
public class OrderItemDO {

    @TableId
    private Long orderItemId;

    private Long orderId;

    private Integer userId;

    private String status;

}

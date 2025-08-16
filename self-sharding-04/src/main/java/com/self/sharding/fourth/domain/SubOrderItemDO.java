package com.self.sharding.fourth.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_sub_order_item")
public class SubOrderItemDO {

    @TableId
    private Long orderItemId;

    private Long orderId;

    private Integer userId;

    private String status;

}

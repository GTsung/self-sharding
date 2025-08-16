package com.self.sharding.third.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_order")
public class OrderDO {

    @TableId
    private Long orderId;

    private Integer userId;

    private Long addressId;

    private String status;
}

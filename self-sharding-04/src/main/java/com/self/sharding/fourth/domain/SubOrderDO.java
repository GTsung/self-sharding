package com.self.sharding.fourth.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_sub_order")
public class SubOrderDO {

    @TableId
    private Long orderId;

    private Integer userId;

    private Long addressId;

    private String status;
}

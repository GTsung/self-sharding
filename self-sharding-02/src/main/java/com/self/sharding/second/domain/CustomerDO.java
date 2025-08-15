package com.self.sharding.second.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_customer")
public class CustomerDO {

    @TableId
    private Long id;

    private String name;

    private Integer age;

    private String phone;

    private String customerNo;
}

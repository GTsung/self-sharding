package com.self.sharding.first.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_user")
public class SelfUser {

    @TableId
    private Long id;

    private String name;

    private Integer sex;

}

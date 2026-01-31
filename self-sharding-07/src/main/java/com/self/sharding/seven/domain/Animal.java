package com.self.sharding.seven.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_animal")
public class Animal {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer sex;

}

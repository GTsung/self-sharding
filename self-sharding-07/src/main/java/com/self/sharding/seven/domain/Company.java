package com.self.sharding.seven.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_company")
public class Company {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String address;

    private String phone;

    private Date createTime;

    private Date updateTime;
}

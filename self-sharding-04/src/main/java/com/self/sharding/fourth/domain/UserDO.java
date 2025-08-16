package com.self.sharding.fourth.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_user")
public class UserDO {

    @TableId
    private Integer userId;

    private String userName;

    private String userNamePlain;

    private String pwd;

    private String assistedQueryPwd;
}

package com.self.sharding.fifth.domain;

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
    private Long userId;

    private String userName;

    private String userNamePlain;

    private String pwd;

    private String assistedQueryPwd;
}

package com.self.sharding.six.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName(value = "t_people")
public class PeopleDO {

    @TableId(type = IdType.AUTO)
    private Long userId;

    private String userName;

    private String userNamePlain;

    private String pwd;

    private String assistedQueryPwd;

}

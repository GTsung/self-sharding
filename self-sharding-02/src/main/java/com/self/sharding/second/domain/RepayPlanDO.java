package com.self.sharding.second.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_repay_plan")
public class RepayPlanDO {

    @TableId
    private Long id;

    private String customerNo;

    private String loanNo;

    private Integer term;

    private String capitalCode;

    private Date dueDate;

    private Date repayDate;

    private Date graceDate;

    private BigDecimal principal;

}

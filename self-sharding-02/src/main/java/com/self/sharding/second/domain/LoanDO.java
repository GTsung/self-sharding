package com.self.sharding.second.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName(value = "t_loan")
public class LoanDO {

    @TableId
    private Long id;

    private String loanNo;

    private String customerNo;

    private Integer term;

    private BigDecimal loanAmt;

    private Date loanDate;

}

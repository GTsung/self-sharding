package com.self.sharding.second.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_repay_detail")
public class RepayDetailDO {

    @TableId
    private Long id;

    private String customerNo;

    private String repayNo;

    private String loanNo;

    private String capitalCode;

    private Integer term;

    private Integer repayType;

    private String costItem;

    private BigDecimal repayAmt;

    private Date repayDate;

}

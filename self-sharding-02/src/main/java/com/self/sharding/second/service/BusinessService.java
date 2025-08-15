package com.self.sharding.second.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.self.sharding.second.domain.CustomerDO;
import com.self.sharding.second.domain.LoanDO;
import com.self.sharding.second.domain.RepayDetailDO;
import com.self.sharding.second.domain.RepayPlanDO;
import com.self.sharding.second.mapper.CustomerMapper;
import com.self.sharding.second.mapper.LoanMapper;
import com.self.sharding.second.mapper.RepayDetailMapper;
import com.self.sharding.second.mapper.RepayPlanMapper;
import com.self.sharding.second.util.DateUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class BusinessService {

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private LoanMapper loanMapper;

    @Resource
    private RepayPlanMapper repayPlanMapper;

    @Resource
    private RepayDetailMapper repayDetailMapper;

    public void apply(CustomerDO customerDO) {
        customerMapper.insert(customerDO);
    }

    public void loan(LoanDO loanDO) {
        loanMapper.insert(loanDO);
        List<RepayPlanDO> plans = IntStream.range(1, loanDO.getTerm() + 1)
                .mapToObj(i -> {
                    Date repayDate = DateUtil.plusMonth(loanDO.getLoanDate(), 1);
                    Date graceDate = DateUtil.plusDays(repayDate, 3);
                    Date dueDate = DateUtil.plusDays(repayDate, -10);
                    return RepayPlanDO.builder()
                            .loanNo(loanDO.getLoanNo())
                            .customerNo(loanDO.getCustomerNo())
                            .capitalCode("C5001")
                            .dueDate(dueDate)
                            .repayDate(repayDate)
                            .graceDate(graceDate)
                            .term(i)
                            .principal(loanDO.getLoanAmt()
                                    .divide(new BigDecimal(String.valueOf(loanDO.getTerm())),
                                            2, RoundingMode.HALF_UP)
                            ).build();
                }).collect(Collectors.toList());
        plans.forEach(p -> repayPlanMapper.insert(p));
    }

    public void insertDetail(RepayDetailDO detailDO) {
        repayDetailMapper.insert(detailDO);
    }

    public List<RepayPlanDO> getRepayPlan(String loanNo) {
        return repayPlanMapper.selectList(Wrappers.<RepayPlanDO>lambdaQuery()
                .eq(RepayPlanDO::getLoanNo, loanNo));
    }

    public List<RepayDetailDO> listDetail(String loanNo) {
        return repayDetailMapper.selectList(Wrappers.<RepayDetailDO>lambdaQuery()
                .eq(RepayDetailDO::getLoanNo, loanNo));
    }

}

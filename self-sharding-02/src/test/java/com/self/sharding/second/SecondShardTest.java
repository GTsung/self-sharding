package com.self.sharding.second;

import com.self.sharding.second.domain.CustomerDO;
import com.self.sharding.second.domain.LoanDO;
import com.self.sharding.second.domain.RepayDetailDO;
import com.self.sharding.second.domain.RepayPlanDO;
import com.self.sharding.second.service.BusinessService;
import com.self.sharding.second.util.ChineseNameUtil;
import com.self.sharding.second.util.DateUtil;
import com.self.sharding.second.util.HintUtil;
import com.self.sharding.second.util.PhoneUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootTest
public class SecondShardTest {

    @Resource
    private BusinessService businessService;

    @Test
    public void testInsert() {
        for (int i = 0; i < 20; i++) {
            String customerNo = generateCustomerNo();
            HintUtil.setDatabase(customerNo);
            CustomerDO c1 = CustomerDO.builder()
                    .customerNo(customerNo)
                    .age(ThreadLocalRandom.current().nextInt(25, 53))
                    .phone(PhoneUtil.generateRandomPhoneNumber())
                    .name(ChineseNameUtil.generateRandomName())
                    .build();
            businessService.apply(c1);
            String loanNo = generateLoanNo();
            LoanDO loanDO = LoanDO.builder()
                    .customerNo(customerNo)
                    .loanNo(loanNo)
                    .loanAmt(new BigDecimal("600"))
                    .loanDate(new Date())
                    .term(6)
                    .build();
            businessService.loan(loanDO);

            RepayDetailDO repayDetailDO = RepayDetailDO.builder()
                    .loanNo(loanNo)
                    .customerNo(customerNo)
                    .capitalCode("C5001")
                    .repayNo(generateRepayNo())
                    .term(1)
                    .costItem("principal")
                    .repayAmt(new BigDecimal("20"))
                    .repayType(1)
                    .repayDate(DateUtil.plusMonth(loanDO.getLoanDate(), 1))
                    .build();
            businessService.insertDetail(repayDetailDO);
            HintUtil.clear();
        }
    }

    @Test
    public void testList() {
        String loanNo = "SP-78493", customerNo = "0c2a2e00980f4002977874ee739cb8bc";
        // 如果不指定切库健,则查询所有数据库->避免这种情况
        HintUtil.setDatabase(customerNo);
        List<RepayPlanDO> repayPlan = businessService.getRepayPlan(loanNo);
        System.err.println(repayPlan);
        List<RepayDetailDO> repayDetailDOS = businessService.listDetail(loanNo);
        System.err.println(repayDetailDOS);
        HintUtil.clear();
    }

    private String generateCustomerNo() {
        String customerNo = UUID.randomUUID().toString().replaceAll("-", "");
        System.err.println(customerNo);
        return customerNo;
    }

    private String generateLoanNo() {
        return String.format("SP-%05d", ThreadLocalRandom.current().nextInt(1, 100000));
    }

    private String generateRepayNo() {
        return String.format("R-%05d", ThreadLocalRandom.current().nextInt(1, 100000));
    }

}

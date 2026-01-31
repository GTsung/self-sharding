package com.self.sharding.seven.service;

import com.self.sharding.seven.config.TableNameConstant;
import com.self.sharding.seven.domain.Animal;
import com.self.sharding.seven.domain.Company;
import com.self.sharding.seven.util.HintUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestInit {

    @Resource
    private AnimalService animalService;
    @Resource
    private CompanyService companyService;

    @Test
    public void testInit() {
        Company company = Company.builder()
                .address("Beijing")
                .phone("13398117209")
                .name("万宝路公司")
                .build();
        companyService.save(company);

        for (int idx = 1; idx <= 30; idx++) {
            Animal animal = Animal.builder()
                    .id((long) idx)
                    .name("adams_" + idx)
                    .build();
            HintUtil.hintAndExecute(TableNameConstant.TABLE_ANIMAL, animal.getId(),
                    () -> animalService.save(animal));
        }
    }

}

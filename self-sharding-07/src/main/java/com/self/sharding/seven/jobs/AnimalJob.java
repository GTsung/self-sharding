package com.self.sharding.seven.jobs;

import com.self.sharding.seven.config.TableNameConstant;
import com.self.sharding.seven.domain.Animal;
import com.self.sharding.seven.domain.Company;
import com.self.sharding.seven.service.AnimalService;
import com.self.sharding.seven.service.CompanyService;
import com.self.sharding.seven.util.HintUtil;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class AnimalJob {

    @Resource
    private AnimalService animalService;
    @Resource
    private CompanyService companyService;

    @XxlJob("animalListJob")
    public void animalList() {
        int shardIndex = XxlJobHelper.getShardIndex();
        int shardTotal = XxlJobHelper.getShardTotal();
        log.info("shardIndex:{}, shardTotal:{}", shardIndex, shardTotal);
        List<Company> companies = companyService.list();
        log.info("companies:{}", companies);
        List<Animal> animalList = HintUtil.hintAndExecute(
                TableNameConstant.TABLE_ANIMAL, (long) shardIndex, () -> animalService.list());
        log.info("animalList:{}", animalList);
    }

}

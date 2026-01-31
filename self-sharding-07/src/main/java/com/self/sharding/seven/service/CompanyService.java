package com.self.sharding.seven.service;

import com.self.sharding.seven.domain.Company;
import com.self.sharding.seven.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    public void save(Company company) {
        companyMapper.insert(company);
    }

    public List<Company> list() {
        return companyMapper.selectList(null);
    }

}

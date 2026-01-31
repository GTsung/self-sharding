package com.self.sharding.seven.service;

import com.self.sharding.seven.domain.Animal;
import com.self.sharding.seven.mapper.AnimalMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnimalService {

    @Resource
    private AnimalMapper animalMapper;

    public void save(Animal animal) {
        animalMapper.insert(animal);
    }

    public List<Animal> list() {
        return animalMapper.selectList(null);
    }

}

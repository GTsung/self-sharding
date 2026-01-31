package com.self.sharding.seven.config;

import com.google.common.collect.Lists;

import java.util.List;

public interface TableNameConstant {

    String TABLE_ANIMAL = "t_animal";

    List<String> ALL_TABLE_NAME = Lists.newArrayList(TABLE_ANIMAL);
}

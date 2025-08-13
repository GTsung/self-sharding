
CREATE DATABASE `ds0`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
CREATE DATABASE `ds1`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;

-- 分别在每个库新建两张表
CREATE TABLE `t_user_0` (
    `id` bigint NOT NULL,
    `name` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
    `sex` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `t_user_1` (
    `id` bigint NOT NULL,
    `name` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
    `sex` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

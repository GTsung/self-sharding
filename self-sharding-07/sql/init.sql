CREATE TABLE `t_company` (
    `id` bigint NOT NULL auto_increment,
    `name` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
    `address` varchar(50) NOT NULL default '',
    `phone` char(11) not null default '',
    `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `t_animal_0` (
    `id` bigint NOT NULL auto_increment,
    `name` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
    `sex` tinyint(1) NOT NULL default 0,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `t_animal_1` (
    `id` bigint NOT NULL auto_increment,
    `name` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
    `sex` tinyint(1) NOT NULL default 0,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;





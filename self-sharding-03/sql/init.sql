
CREATE DATABASE `ds0`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
CREATE DATABASE `ds1`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;

-- 只分库
CREATE TABLE IF NOT EXISTS t_user (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(200),
    user_name_plain VARCHAR(200),
    pwd VARCHAR(200),
    assisted_query_pwd VARCHAR(200),
    PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS t_order (
    order_id BIGINT AUTO_INCREMENT,
    user_id INT NOT NULL,
    address_id BIGINT NOT NULL,
    status VARCHAR(50),
    PRIMARY KEY (order_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS t_order_item (
    order_item_id BIGINT AUTO_INCREMENT,
    order_id BIGINT,
    user_id INT NOT NULL,
    status VARCHAR(50) ,
    PRIMARY KEY (order_item_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 每个库的数据一致,为广播表
CREATE TABLE IF NOT EXISTS t_address (
    address_id BIGINT NOT NULL,
    address_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (address_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



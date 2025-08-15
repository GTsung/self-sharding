-- 两个库都有这些表

CREATE TABLE IF NOT EXISTS t_loan (
    id BIGINT NOT NULL,
    loan_no VARCHAR(36) NOT NULL,
    customer_no varchar(36) not null,
    term tinyint(1) not null,
    loan_amt decimal(8,2) not null,
    loan_date datetime,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS t_customer (
    id BIGINT NOT NULL,
    name VARCHAR(36) NOT NULL,
    customer_no varchar(36) not null,
    age tinyint(1) not null,
    phone VARCHAR(36) NOT NULL,
    PRIMARY KEY (id)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS t_repay_plan (
    id BIGINT NOT NULL,
    customer_no varchar(36) not null,
    loan_no varchar(36) not null,
    term tinyint(1) not null,
    capital_code varchar(32) not null,
    due_date date,
    repay_date date,
    grace_date date,
    principal decimal(12,2),
    PRIMARY KEY (id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS t_repay_detail (
    id BIGINT NOT NULL,
    customer_no varchar(36) not null,
    loan_no varchar(36) not null,
    repay_no varchar(36) not null,
    term tinyint(1) not null,
    capital_code varchar(32) not null,
    repay_type tinyint(1) not null,
    cost_item varchar(32) not null,
    repay_date datetime,
    repay_amt decimal(12,2),
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

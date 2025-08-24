
CREATE TABLE IF NOT EXISTS t_people (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(200),
    user_name_plain VARCHAR(200),
    pwd VARCHAR(200),
    assisted_query_pwd VARCHAR(200),
    PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


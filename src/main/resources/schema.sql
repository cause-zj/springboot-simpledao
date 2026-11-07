CREATE TABLE IF NOT EXISTS demo_item (
    id          BIGINT       NOT NULL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    create_time TIMESTAMP    NULL,
    create_by   BIGINT       NULL,
    update_time TIMESTAMP    NULL,
    update_by   BIGINT       NULL,
    dr          TINYINT      NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS project
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(124)            NOT NULL,
    description TEXT                    NOT NULL,
    status      VARCHAR(64)             NOT NULL,
    owner_id    BIGINT                  NOT NULL,
    privacy     BOOLEAN   DEFAULT FALSE NOT NULL,
    parent_id   BIGINT,
    created_at  TIMESTAMP DEFAULT now(),
    created_by  BIGINT                  NOT NULL,
    updated_at  TIMESTAMP,
    updated_by  BIGINT
)
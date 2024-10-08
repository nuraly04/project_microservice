CREATE TABLE IF NOT EXISTS project
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(124)            NOT NULL,
    description TEXT                    NOT NULL,
    status      VARCHAR(64)             NOT NULL,
    movement    VARCHAR(64)             NOT NULL,
    owner_id    BIGINT                  NOT NULL,
    privacy     BOOLEAN   DEFAULT FALSE NOT NULL,
    parent_id   BIGINT,
    created_at  TIMESTAMP DEFAULT now(),
    created_by  BIGINT                  NOT NULL,
    updated_at  TIMESTAMP,
    updated_by  BIGINT
);

CREATE TABLE IF NOT EXISTS internship
(
    id BIGSERIAL PRIMARY KEY,
    project_id BIGINT NOT NULL,
    mentor_id BIGINT NOT NULL,
    start_date TIMESTAMP DEFAULT NOW() NOT NULL,
    end_date TIMESTAMP NOT NULL

    CONSTRAINT fk_project_id, FOREIGN KEY (project_id) REFERENCES project (id)
);
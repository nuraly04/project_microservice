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
    id         BIGSERIAL PRIMARY KEY,
    project_id BIGINT                  NOT NULL,
    mentor_id  BIGINT                  NOT NULL,
    start_date TIMESTAMP DEFAULT NOW() NOT NULL,
    end_date   TIMESTAMP               NOT NULL,

    CONSTRAINT fk_project_id FOREIGN KEY (project_id) REFERENCES project (id)
);

CREATE TABLE IF NOT EXISTS moment
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(124) NOT NULL,
    description TEXT         NOT NULL,
    created_at  TIMESTAMP    NOT NULL
);

CREATE TABLE IF NOT EXISTS member
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS security_role
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(124)        NOT NULL,
    code VARCHAR(124) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS m2m_member_role
(
    id            BIGSERIAL PRIMARY KEY,
    member_id     BIGINT NOT NULL,
    security_role BIGINT NOT NULL,

    CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES member (id),
    CONSTRAINT fk_security_role FOREIGN KEY (security_role) REFERENCES security_role (id)
);


CREATE TABLE IF NOT EXISTS m2m_project_member
(
    id         BIGSERIAL PRIMARY KEY,
    project_id BIGINT NOT NULL,
    member_id  BIGINT NOT NULL,

    CONSTRAINT fk_project_id FOREIGN KEY (project_id) REFERENCES project (id),
    CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES member (id)
);

CREATE TABLE IF NOT EXISTS m2m_internship_member
(
    id            BIGSERIAL PRIMARY KEY,
    internship_id BIGINT NOT NULL,
    member_id     BIGINT NOT NULL,

    CONSTRAINT fk_internship_id FOREIGN KEY (internship_id) REFERENCES internship (id),
    CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES member (id)
);
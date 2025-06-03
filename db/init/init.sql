CREATE TABLE IF NOT EXISTS notification (
    id SERIAL PRIMARY KEY,
    task_id BIGINT,
    message VARCHAR(255),
    date TIMESTAMP,
    completed BOOLEAN
);

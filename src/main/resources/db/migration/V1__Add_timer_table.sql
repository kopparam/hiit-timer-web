CREATE TABLE timer (
    id UUID PRIMARY KEY,
    name TEXT,
    description TEXT,
    work_duration INT NOT NULL,
    rest_duration INT NOT NULL
)

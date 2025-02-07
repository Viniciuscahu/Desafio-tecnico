CREATE TABLE tasks (
                       id BIGINT PRIMARY KEY IDENTITY(1,1),
                       title VARCHAR(255) NOT NULL,
                       description TEXT NOT NULL,
                       created_at DATETIME NOT NULL DEFAULT GETDATE(),
                       status VARCHAR(20) NOT NULL DEFAULT 'PENDING'
);

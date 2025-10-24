CREATE TABLE IF NOT EXISTS tb_revenue(
    id UUID PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    date DATE DEFAULT CURRENT_DATE,
    user_id UUID NOT NULL,
    CONSTRAINT fk_user
    FOREIGN KEY(user_id)
    REFERENCES tb_user(id)
    ON DELETE CASCADE
    )

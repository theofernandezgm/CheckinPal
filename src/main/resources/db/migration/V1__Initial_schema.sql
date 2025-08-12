-- src/main/resources/db/migration/V1__Initial_schema.sql

-- User table for authentication
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Host account linked to a user
CREATE TABLE host_account (
    id BIGSERIAL PRIMARY KEY,
    owner_user_id BIGINT NOT NULL REFERENCES users(id),
    legal_name VARCHAR(255) NOT NULL,
    nif VARCHAR(50) NOT NULL UNIQUE
);

-- Property details
CREATE TABLE property (
    id BIGSERIAL PRIMARY KEY,
    host_id BIGINT NOT NULL REFERENCES host_account(id),
    address TEXT NOT NULL,
    hut_number VARCHAR(100) NOT NULL UNIQUE,
    capacity INT NOT NULL,
    documents_s3_key VARCHAR(255)
);

-- Audit trail for important events
CREATE TABLE audit_event (
    id BIGSERIAL PRIMARY KEY,
    actor VARCHAR(255),
    action VARCHAR(255) NOT NULL,
    entity VARCHAR(100),
    entity_id BIGINT,
    metadata_json TEXT,
    at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);
-- ==========================================
-- PARTNERS TABLE
-- ==========================================

CREATE TABLE partners (
    partner_id BIGSERIAL PRIMARY KEY,
    partner_name VARCHAR(100) NOT NULL,
    partner_code VARCHAR(50) NOT NULL UNIQUE,
    contact_email VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ==========================================
-- USERS TABLE
-- ==========================================

CREATE TABLE users (
    user_id BIGSERIAL PRIMARY KEY,
    partner_id BIGINT NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_users_partner
        FOREIGN KEY (partner_id)
        REFERENCES partners(partner_id)
);

-- ==========================================
-- TRANSFERS TABLE
-- ==========================================

CREATE TABLE transfers (
    transfer_id BIGSERIAL PRIMARY KEY,
    partner_id BIGINT NOT NULL,
    uploaded_by BIGINT NOT NULL,

    file_name VARCHAR(255) NOT NULL,
    file_type VARCHAR(50) NOT NULL,
    file_size BIGINT NOT NULL,

    status VARCHAR(50) NOT NULL,

    s3_key VARCHAR(500),

    upload_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    validation_message TEXT,

    CONSTRAINT fk_transfer_partner
        FOREIGN KEY (partner_id)
        REFERENCES partners(partner_id),

    CONSTRAINT fk_transfer_user
        FOREIGN KEY (uploaded_by)
        REFERENCES users(user_id)
);

-- ==========================================
-- PROCESSING_REPORTS TABLE
-- ==========================================

CREATE TABLE processing_reports (
    report_id BIGSERIAL PRIMARY KEY,

    transfer_id BIGINT NOT NULL,

    records_read INTEGER NOT NULL DEFAULT 0,
    records_processed INTEGER NOT NULL DEFAULT 0,
    records_failed INTEGER NOT NULL DEFAULT 0,

    processing_time BIGINT,

    status VARCHAR(50) NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_report_transfer
        FOREIGN KEY (transfer_id)
        REFERENCES transfers(transfer_id)
);

-- ==========================================
-- AUDIT_LOGS TABLE
-- ==========================================

CREATE TABLE audit_logs (
    audit_id BIGSERIAL PRIMARY KEY,

    transfer_id BIGINT,

    action VARCHAR(100) NOT NULL,

    performed_by BIGINT NOT NULL,

    event_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    remarks TEXT,

    CONSTRAINT fk_audit_transfer
        FOREIGN KEY (transfer_id)
        REFERENCES transfers(transfer_id),

    CONSTRAINT fk_audit_user
        FOREIGN KEY (performed_by)
        REFERENCES users(user_id)
);


-- =====================================================
-- DATABASE
-- =====================================================
CREATE DATABASE IF NOT EXISTS ride_hailing_db;
USE ride_hailing_db;

-- =====================================================
-- USER
-- =====================================================
CREATE TABLE users (
    user_id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name       VARCHAR(100) NOT NULL,
    email           VARCHAR(120) NOT NULL UNIQUE,
    phone           VARCHAR(15) NOT NULL UNIQUE,
    password        VARCHAR(255) NOT NULL,
    role            ENUM('RIDER', 'DRIVER') NOT NULL,
    license_number  VARCHAR(50) NULL,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================
-- VEHICLE (1:1 with Driver)
-- =====================================================
CREATE TABLE vehicles (
    vehicle_id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    driver_id       BIGINT NOT NULL UNIQUE,
    make            VARCHAR(50) NOT NULL,
    model           VARCHAR(50) NOT NULL,
    plate_number    VARCHAR(20) NOT NULL UNIQUE,
    color           VARCHAR(30),
    year            INT,

    CONSTRAINT fk_vehicle_driver
        FOREIGN KEY (driver_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
);

-- =====================================================
-- RIDE
-- =====================================================
CREATE TABLE rides (
    ride_id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    rider_id            BIGINT NOT NULL,
    driver_id           BIGINT,
    pickup_location     VARCHAR(255) NOT NULL,
    drop_location       VARCHAR(255) NOT NULL,
    status              ENUM(
                            'REQUESTED',
                            'ONGOING',
                            'COMPLETED',
                            'CANCELLED'
                        ) NOT NULL DEFAULT 'REQUESTED',
    start_time          TIMESTAMP NULL,
    end_time            TIMESTAMP NULL,
    fare                DECIMAL(10,2),

    CONSTRAINT fk_ride_rider
        FOREIGN KEY (rider_id)
        REFERENCES users(user_id),

    CONSTRAINT fk_ride_driver
        FOREIGN KEY (driver_id)
        REFERENCES users(user_id),

    INDEX idx_ride_rider (rider_id),
    INDEX idx_ride_driver (driver_id),
    INDEX idx_ride_status (status)
);

-- =====================================================
-- PAYMENT (1:1 with Ride)
-- =====================================================
CREATE TABLE payments (
    payment_id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    ride_id         BIGINT NOT NULL UNIQUE,
    amount          DECIMAL(10,2) NOT NULL,
    method          ENUM('CASH', 'CREDIT_CARD', 'WALLET', 'UPI') NOT NULL,
    status          ENUM('PENDING', 'COMPLETED', 'FAILED') NOT NULL,
    payment_date    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_payment_ride
        FOREIGN KEY (ride_id)
        REFERENCES rides(ride_id)
        ON DELETE CASCADE
);

-- =====================================================
-- RATING (User ↔ User via Ride)
-- =====================================================
CREATE TABLE ratings (
    rating_id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    ride_id         BIGINT NOT NULL UNIQUE,
    given_by        BIGINT NOT NULL,
    given_to        BIGINT NOT NULL,
    score           INT NOT NULL CHECK (score BETWEEN 1 AND 5),
    comment         VARCHAR(255),

    CONSTRAINT fk_rating_ride
        FOREIGN KEY (ride_id)
        REFERENCES rides(ride_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_rating_given_by
        FOREIGN KEY (given_by)
        REFERENCES users(user_id),

    CONSTRAINT fk_rating_given_to
        FOREIGN KEY (given_to)
        REFERENCES users(user_id)
);

-- Use the database
USE ride_hailing_db;

-- ==================== USERS ====================
INSERT INTO users (full_name, email, phone, password, role, license_number, created_at)
VALUES
('Alice Rider', 'alice.rider@example.com', '9876543210', 'hashed_password1', 'RIDER', NULL, NOW()),
('Bob Driver', 'bob.driver@example.com', '9876543211', 'hashed_password2', 'DRIVER', 'LIC12345', NOW()),
('Charlie Rider', 'charlie.rider@example.com', '9876543212', 'hashed_password3', 'RIDER', NULL, NOW()),
('David Driver', 'david.driver@example.com', '9876543213', 'hashed_password4', 'DRIVER', 'LIC67890', NOW());

-- ==================== VEHICLES ====================
INSERT INTO vehicles (driver_id, make, model, plate_number, color, year)
VALUES
(2, 'Toyota', 'Camry', 'AB12CD3456', 'Blue', 2020),
(4, 'Honda', 'City', 'XY34EF5678', 'Red', 2021);

-- ==================== RIDES ====================
INSERT INTO rides (rider_id, driver_id, pickup_location, drop_location, status, start_time, end_time, fare)
VALUES
(1, 2, 'MG Road, Patna', 'Boring Road, Patna', 'COMPLETED', '2025-12-28 10:00:00', '2025-12-28 10:45:00', 250.00),
(3, 4, 'Kankarbagh, Patna', 'Patliputra Colony, Patna', 'ONGOING', '2025-12-29 09:00:00', NULL, 0.00);

-- ==================== PAYMENTS ====================
INSERT INTO payments (ride_id, amount, method, status, payment_date)
VALUES
(1, 250.00, 'CASH', 'COMPLETED', '2025-12-28 10:45:00'),
(2, 0.00, 'WALLET', 'PENDING', '2025-12-29 09:30:00');

-- ==================== RATINGS ====================
INSERT INTO ratings (ride_id, given_by, given_to, score, comment)
VALUES
(1, 1, 2, 5, 'Excellent ride! Very polite driver.'),
(1, 2, 1, 5, 'Great passenger, punctual and friendly.');

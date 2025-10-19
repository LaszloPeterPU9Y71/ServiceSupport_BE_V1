INSERT INTO users (id, email, password_hash, full_name, phone_number, position, enabled, company_id)
VALUES (1, 'admin@example.com', '$2a$10$Ar51WbSfXjl2DSd.RynIwOAMTC2QKXpD4T6CLSfvMGPbNQLx.9B1a', 'Admin Felhasználó',
        '+36123456789', 'Rendszergazda', 1, 1),
       (2, 'manager@example.com', '$2a$10$Ar51WbSfXjl2DSd.RynIwOAMTC2QKXpD4T6CLSfvMGPbNQLx.9B1a', 'Minta Manager',
        '+36201234567', 'Üzletágvezető', 1, 1),
       (3, 'tech@example.com', '$2a$10$Ar51WbSfXjl2DSd.RynIwOAMTC2QKXpD4T6CLSfvMGPbNQLx.9B1a', 'Minta Szervizes',
        '+36301234567', 'Szervizes', 1, 1),
       (4, 'wiskeys@gmail.com', '$2a$10$JHrenr4hYMegLO9uUIbIseYMHAXLPx3tqm8OuIIza5qGG19sWk9Zy', 'László Péter',
        '+36301234567', 'Szervizes', 1, 1),
       (5, 'proba3@gmail.com', '$2a$10$Ar51WbSfXjl2DSd.RynIwOAMTC2QKXpD4T6CLSfvMGPbNQLx.9B1a', 'Minta Szervizes',
        '+36301234567', 'TEST', 1, 1) ON DUPLICATE KEY
UPDATE
    email =
VALUES (email), password_hash =
VALUES (password_hash), full_name =
VALUES (full_name), phone_number =
VALUES (phone_number), position =
VALUES (position), enabled =
VALUES (enabled), company_id =
VALUES (company_id);

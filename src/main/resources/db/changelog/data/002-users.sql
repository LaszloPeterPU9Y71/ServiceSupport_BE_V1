INSERT INTO users (id, email, password_hash, full_name, phone_number, position, enabled, company_id)
VALUES (1, 'admin@example.com', '$2a$10$JHrenr4hYMegLO9uUIbIseYMHAXLPx3tqm8OuIIza5qGG19sWk9Zy', 'Tóth Attila',
        '+36123456789', 'Rendszergazda', 1, 1),
       (2, 'manager@example.com', '$2a$10$JHrenr4hYMegLO9uUIbIseYMHAXLPx3tqm8OuIIza5qGG19sWk9Zy', 'Lép Tamás',
        '+36201234567', 'Üzletágvezető', 1, 1),
       (3, 'tech@example.com', '$2a$10$JHrenr4hYMegLO9uUIbIseYMHAXLPx3tqm8OuIIza5qGG19sWk9Zy', 'Horváth Ádám',
        '+36301234567', 'Szervizes', 1, 1),
       (4, 'admin@gmail.com', '$2a$10$JHrenr4hYMegLO9uUIbIseYMHAXLPx3tqm8OuIIza5qGG19sWk9Zy', 'László Péter',
        '+36301234567', 'Szervizes', 1, 1) ON DUPLICATE KEY
UPDATE
    email =
VALUES (email), password_hash =
VALUES (password_hash), full_name =
VALUES (full_name), phone_number =
VALUES (phone_number), position =
VALUES (position), enabled =
VALUES (enabled), company_id =
VALUES (company_id);

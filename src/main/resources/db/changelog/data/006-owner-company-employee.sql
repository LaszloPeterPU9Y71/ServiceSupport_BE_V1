INSERT INTO owner_company_employee (owner_company_employee_id, owner_company_employee_email,
                                           owner_company_employee_name,
                                           owner_company_employee_tel_num, owner_company_employee_title,
                                           owner_company_employee)
VALUES
-- 1. employee, nincs owner company
(1, 'wiskeys@gmail.com', 'László Péter', '36201234567', 'Freelancer', NULL),
(2, 'szabo.anna@yahoo.com', 'Szabó Anna', '36205551234', 'Designer', 3),
(3, 'toth.marton@outlook.com', 'Tóth Márton', '36203334444', 'Developer', 7),
(4, 'kiss.julia@gmail.com', 'Kiss Júlia', '36204445555', 'Freelancer', 9),
(5, 'nagy.david@freemail.hu', 'Nagy Dávid', '36206667777', 'Photographer', 7),
(6, 'horvath.lilla@protonmail.com', 'Horváth Lilla', '36207778888', 'Consultant', 1),
(7, 'balogh.gergo@gmail.com', 'Balogh Gergő', '36208889999', 'Translator', 5),
(8, 'farkas.eva@yahoo.com', 'Farkas Éva', '36209990000', 'Freelancer', 4);
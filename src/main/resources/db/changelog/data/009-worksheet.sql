INSERT INTO worksheet
(worksheet_id, custom_id, tool_id, created_at, status, is_warranty, has_warranty_card, has_invoice_copy, has_registration_proof, assigned_user_id, owner_description)
VALUES
    (1, '2501/1', 1, NOW(), 'BEERKEZETT', 1, 0, 0, 1, 5, 'Rossz'),
    (2, '2501/2', 2, NOW(), 'FOLYAMATBAN', 0, 0, 0, 1, 6, 'nem jó'),
    (3, '2501/3', 3, NOW(), 'BEERKEZETT', 0, 0, 0, 1, 6, 'Nem működik'),
    (4, '2501/4', 4, NOW(), 'BEERKEZETT', 0, 0, 0, 0, 3, 'nem jó'),
    (5, '2501/5', 5, NOW(), 'BEERKEZETT', 1, 0, 0, 0, 1, 'Elromlott'),
    (6, '2501/6', 6, NOW(), 'BEERKEZETT', 1, 0, 1, 0, 4, 'Zörög'),
    (7, '2501/7', 7, NOW(), 'FOLYAMATBAN', 1, 0, 1, 1, 5, 'nem jó'),
    (8, '2501/8', 8, NOW(), 'BEERKEZETT', 1, 0, 0, 0, 4, 'csörög'),
    (9, '2501/9', 9, NOW(), 'BEERKEZETT', 1, 0, 0, 0, 3, 'nem jó'),
    (10,'2501/10',  10, NOW(), 'BEERKEZETT', 0, 1, 1, 1, 2, 'jó, csak nem fúr');
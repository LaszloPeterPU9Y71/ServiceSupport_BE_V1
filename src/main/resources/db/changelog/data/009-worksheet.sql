INSERT INTO worksheet
(worksheet_id, tool_id, created_at, status, is_warranty, has_warranty_card, has_invoice_copy, has_registration_proof, assigned_user_id, owner_description)
VALUES
    (1, 1, NOW(), 'BEERKEZETT', 1, 0, 0, 1, 5, 'Rossz'),
    (2, 2, NOW(), 'FOLYAMATBAN', 0, 0, 0, 1, 6, 'nem jó'),
    (3, 3, NOW(), 'BEERKEZETT', 0, 0, 0, 1, 6, 'Nem működik'),
    (4, 4, NOW(), 'BEERKEZETT', 0, 0, 0, 0, 3, 'nem jó'),
    (5, 5, NOW(), 'BEERKEZETT', 1, 0, 0, 0, 1, 'Elromlott'),
    (6, 6, NOW(), 'BEERKEZETT', 1, 0, 1, 0, 4, 'Zörög'),
    (7, 1, NOW(), 'FOLYAMATBAN', 1, 0, 1, 1, 5, 'nem jó'),
    (8, 2, NOW(), 'BEERKEZETT', 1, 0, 0, 0, 4, 'csörög'),
    (9, 3, NOW(), 'BEERKEZETT', 1, 0, 0, 0, 3, 'nem jó'),
    (10, 4, NOW(), 'BEERKEZETT', 0, 1, 1, 1, 2, 'jó, csak nem fúr');
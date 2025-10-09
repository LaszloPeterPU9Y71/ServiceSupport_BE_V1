INSERT INTO user_roles (user_id, role_id) VALUES
                                              (1,1),
                                              (2,2),
                                              (3,3),
                                              (4,1)AS new
ON DUPLICATE KEY UPDATE role_id = new.role_id;

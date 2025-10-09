INSERT INTO roles (id, name, description) VALUES
                                              (1,'ADMIN','Rendszergazda'),
                                              (2,'MANAGER','Vezető'),
                                              (3,'TECHNICIAN','Szervizes')
    ON DUPLICATE KEY UPDATE name=VALUES(name), description=VALUES(description);

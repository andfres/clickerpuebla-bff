INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN'),('ROLE_USER');
INSERT INTO usuarios (dinero,  email , nombre, password , username) VALUES (1111,  'admin@gmail.com', 'admin' , '$2a$10$SxRZ2xUUA.SzAbxIgd7uPuIRhKguz1MFLEs0WW6QGwlfc5sr5QoKO' , 'admin');
INSERT INTO usuarios_roles (usuario_id, roles_id) VALUES (1 , 1);


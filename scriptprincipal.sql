CREATE SCHEMA db_microservicios_cliente_usuario;
CREATE USER 'root'@'localhost' IDENTIFIED BY 'Univalle';
GRANT ALL PRIVILEGES ON * . * TO 'root'@'localhost';
CREATE SCHEMA warehouse_product;
CREATE USER 'node'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON * . * TO 'root'@'localhost';
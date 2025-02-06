/*ear una tabla clientes con las siguientes columnas:
• id (INT, PRIMARY KEY, AUTO_INCREMENT)
• nombre (VARCHAR, 100)
• email (VARCHAR, 100, UNIQUE)
• telefono (VARCHAR, 20)
• fecha_registro (DATE, DEFAULT CURRENT_DATE)
• Insertar al menos 5 registros en la tabla clientes*/

-- CREATE DATABASE CRUDJAVA;
USE crudjava;

/*
CREATE TABLE IF NOT EXISTS clientes (
    `id_cliente` INT NOT NULL AUTO_INCREMENT,
    `nombre_cliente` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `telefono` VARCHAR(20) NOT NULL,
    `fecha_registro` DATE NOT NULL DEFAULT CURRENT_DATE,
    PRIMARY KEY (`id_cliente`),
    UNIQUE KEY `email` (`email`)
    );


INSERT INTO clientes (nombre_cliente, email, telefono) VALUES
('Juan david rodriguez', 'juanchurrias@miau.com', '33333333'),
('dieguis la loka', 'diega@gmai.com', '2222222'),
('Vale Marin', 'valecitalamaslinda@gmail.com', '88888888'),
('carechuspa tiven', 'tiven@gmail.com', '77777777'),
('piojo hola', 'piojo@gmail.com', '666666');




1. Consultas con JOINs en SQL
• (Rama: extra-joins-sql)
• Crear una tabla pedidos que tenga una relación con clientes (FK cliente_id).
• Obtener la lista de clientes con la cantidad de pedidos realizados.
• Encontrar los clientes que no han realizado ningún pedido.

CREATE TABLE IF NOT EXISTS pedidos (
    `id_pedido` INT NOT NULL AUTO_INCREMENT,
    `cliente_id` INT NOT NULL,
    `fecha_pedido` DATE NOT NULL DEFAULT CURRENT_DATE,
    `total` DECIMAL NOT NULL,
    PRIMARY KEY (`id_pedido`),
    FOREIGN KEY (`cliente_id`) REFERENCES clientes(`id_cliente`)
);
*/


INSERT INTO pedidos ( cliente_id , total) VALUES
(1,1500);

SELECT id_cliente , nombre_cliente ,(SELECT COUNT(*) FROM pedidos p WHERE p.cliente_id = c.id_cliente)as cantidad_pedidos FROM clientes c;


SELECT  id_cliente , nombre_cliente
FROM clientes c LEFT JOIN pedidos p ON c.id_cliente = p.cliente_id  WHERE p.cliente_id IS NULL ;
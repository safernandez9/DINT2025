-- =========================================
-- ELIMINAR TABLAS (primero las dependientes)
-- =========================================
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS pedidos;
DROP TABLE IF EXISTS clientes;


-- =================
-- TABLA: clientes
-- =================
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(100) NOT NULL,
    direccion  VARCHAR(255),
    pais       VARCHAR(50),
    descuento  INT DEFAULT 0
);


-- ===============
-- TABLA: pedidos
-- ===============
CREATE TABLE pedidos (
    id_pedido      INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente     INT NOT NULL,
    vendedor       VARCHAR(100),
    fecha_pedido   DATE,
    fecha_entrega  DATE,
    fecha_envio    DATE,
    forma_envio    VARCHAR(50),
    cargo         DECIMAL(10,2),
    CONSTRAINT fk_pedidos_clientes
        FOREIGN KEY (id_cliente)
        REFERENCES clientes(id_cliente)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


-- =================
-- TABLA: productos
-- =================
CREATE TABLE productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido   INT NOT NULL,
    nombre      VARCHAR(100) NOT NULL,
    cantidad    INT DEFAULT 1,
    precio      DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_productos_pedidos
        FOREIGN KEY (id_pedido)
        REFERENCES pedidos(id_pedido)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


-- =========================
-- INSERCIÓN DE DATOS
-- =========================

-- Cliente (Id. cliente en el informe: BONAP)
INSERT INTO clientes (id_cliente, nombre, direccion, pais, descuento)
VALUES (
    1,
    'BONAP - Bon app',
    '12, rue des Bouchers, Marseille 13008',
    'Francia',
    25
);


-- Pedido
INSERT INTO pedidos (
    id_pedido,
    id_cliente,
    vendedor,
    fecha_pedido,
    fecha_entrega,
    fecha_envio,
    forma_envio,
    cargo
)
VALUES (
    11076,
    1,
    'Margaret Peacock',
    '1998-05-06',
    '1998-06-03',
    NULL,
    'United Package',
    38.28
);


-- Productos del pedido
INSERT INTO productos (
    id_producto,
    id_pedido,
    nombre,
    cantidad,
    precio
)
VALUES
    (6,  11076, 'Mermelada de grosellas de la abuela', 20, 25.00),
    (14, 11076, 'Cuajada de judías',                  20, 23.25),
    (19, 11076, 'Pastas de té de chocolate',          10,  9.20);




SELECT
    c.nombre        AS cliente,
    c.direccion,
    c.pais,

    p.id_pedido,
    p.vendedor,
    p.fecha_pedido,
    p.fecha_entrega,
    p.fecha_envio,
    p.forma_envio,
    p.cargo,

    pr.id_producto,
    pr.nombre        AS producto,
    pr.cantidad,
    pr.precio        AS precio_unidad,

    c.descuento      AS descuento,

    (pr.precio * pr.cantidad) *
    (1 - c.descuento / 100.0) AS precio_con_descuento

FROM pedidos p
JOIN clientes c  ON c.id_cliente = p.id_cliente
JOIN productos pr ON pr.id_pedido = p.id_pedido

WHERE p.id_pedido = 11076;
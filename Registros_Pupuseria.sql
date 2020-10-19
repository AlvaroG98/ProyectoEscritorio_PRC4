/*DIRECCIONES*/
INSERT INTO pupuseria_final.direcciones (Municipio, Direccion, Punto_referen) 
VALUES 
('San salvador', '5a AV note calle #3', 'Tienda azul', '78787654');

INSERT INTO pupuseria_final.direcciones (Municipio, Direccion, Punto_referen) 
VALUES 
('Santa tecla', '8a AV note calle #4', 'Tienda roja', '76543432');

/*USUARIOS*/
INSERT INTO pupuseria_final.usuarios (Prim_nom, Seg_nom, Prim_ape, Seg_ape, Email, Contraseña, cod_direc) 
VALUES 
('Juan', 'Antonio', 'Perez', 'Hernandez', 'juanperez@gmail.com', '1234', '1');

INSERT INTO pupuseria_final.usuarios (Prim_nom, Seg_nom, Prim_ape, Seg_ape, Email, Contraseña, cod_direc) 
VALUES 
('Benjamin', 'Javier', 'Hernandez', 'Modric', 'benjamin@gmail.com', '112233', '2');


/*EMPLEADOS*/
INSERT INTO pupuseria_final.empleados (Prim_nom, Seg_nom, Prim_ape, Seg_ape, Email, Contraseña, foto) 
VALUES 
('Juan', 'Antonio', 'Perez', 'Hernandez', 'juanperez@gmail.com', '1234', 'C:\Users\lando\Downloads\communication.png');

INSERT INTO pupuseria_final.empleados (Prim_nom, Seg_nom, Prim_ape, Seg_ape, Email, Contraseña, foto) 
VALUES 
('Jorge', 'Mauricio', 'Serrano', 'Hernandez', 'mauricio@gmail.com', '1234', 'C:\Users\lando\Downloads\communication.png');

/*POSTRES*/
INSERT INTO pupuseria_final.postres (tipo_postre) 
VALUES 
('Tres leches');

INSERT INTO pupuseria_final.postres (tipo_postre) 
VALUES 
('Budin');

/*INGREDIENTES*/
INSERT INTO pupuseria_final.ingredientes (ingredientes, costo_Indiv) 
VALUES 
('Frijol', '0.50');

INSERT INTO pupuseria_final.ingredientes (ingredientes, costo_Indiv) 
VALUES 
('Queso', '0.50');

INSERT INTO pupuseria_final.ingredientes (ingredientes, costo_Indiv) 
VALUES 
('Chicharron', '0.75');

INSERT INTO pupuseria_final.ingredientes (ingredientes, costo_Indiv) 
VALUES 
('Loroco', '0.75');

INSERT INTO pupuseria_final.ingredientes (ingredientes, costo_Indiv) 
VALUES 
('Ayote', '0.75');

INSERT INTO pupuseria_final.ingredientes (ingredientes, costo_Indiv) 
VALUES 
('Ajo', '0.75');

INSERT INTO pupuseria_final.ingredientes (ingredientes, costo_Indiv) 
VALUES 
('Pollo', '1.50');

INSERT INTO pupuseria_final.ingredientes (ingredientes, costo_Indiv) 
VALUES 
('Camaron', '2');

INSERT INTO pupuseria_final.ingredientes (ingredientes, costo_Indiv) 
VALUES 
('Jalapeño', '0.80');


/*PUPUSAS*/
INSERT INTO pupuseria_final.pupusas (Harina, Cod_Ingre) 
VALUES 
('Tradiciona', '1');

INSERT INTO pupuseria_final.pupusas (Harina, Cod_Ingre) 
VALUES 
('Especial', '2');
/*BEBIDAS*/
INSERT INTO pupuseria_final.bebidas (Tipo_bebida) 
VALUES 
('Coca cola');

INSERT INTO pupuseria_final.bebidas (Tipo_bebida) 
VALUES 
('Pepsi');

INSERT INTO pupuseria_final.bebidas (Tipo_bebida) 
VALUES 
('Horchata');

/*PRODUCTOS*/
INSERT INTO pupuseria_final.productos (Cod_Pupusa, Cod_Postre, Cod_Bebida, PrecioProducto, Descripcion, Foto) 
VALUES 
('1', '1', '1', '1.25', 'Pupusa de frijol y coca cola', 'C:\Users\lando\Downloads\communication.png');

INSERT INTO pupuseria_final.productos (Status, Cod_Usuario, CreadaEl) 
VALUES 
('Disponible', '1', '2020-10-17');

/*ORDENES*/
ALTER TABLE ordenes
CHANGE Status Statuss varchar(25);

INSERT INTO ordenes (Statuss, Cod_Usuario, CreadaEl) 
VALUES 
('Disponible', '5', '2020-10-17');

/*DETALLE ORDENES (tener en cuenta que el código de orden puede variar)*/
INSERT INTO detalle_ordenes (Cod_Orden, Cod_Producto, Cantidad, Descuento) 
VALUES 
('8','1', '10', '0.25');



CREATE DATABASE homeblinds;
USE homeblinds;

#Crear estructura
CREATE TABLE `Proveedor` (
	`idproveedor` INTEGER NOT NULL COMMENT 'Clave del proveedor' AUTO_INCREMENT,
	`nombreproveedor` VARCHAR(50) NOT NULL COMMENT 'Nombre o razón del proveedor',
	`ciudad` VARCHAR(45) NULL COMMENT 'Ciudad en donde radica el proveedor',
	`telefono` VARCHAR(15) NULL COMMENT 'Teléfono del proveedor',
	`email` VARCHAR(35) NULL COMMENT 'Correo electrónico del proveedor',
	`estado` VARCHAR(15) NULL COMMENT 'Estado',
	PRIMARY KEY(`idproveedor`)
) ENGINE=INNODB;
CREATE TABLE `Telas` (
	`idtela` INTEGER NOT NULL COMMENT 'Clave del material' AUTO_INCREMENT,
	`nombretela` VARCHAR(45) NOT NULL COMMENT 'Nombre del material',
	`descripcion` VARCHAR(50) NULL COMMENT 'Descripción del material',
	`precioalmacen` DOUBLE NOT NULL COMMENT 'Precio de almacen del producto',
	`preciopublico` DOUBLE NOT NULL COMMENT 'Precio a publico del producto',
	`tipopersiana` VARCHAR(50) NOT NULL COMMENT 'Tipo de Persiana',
	`color` VARCHAR(10) NULL COMMENT 'Color del Material',
	`ubicacion` VARCHAR(45) NULL,
	`stock` INTEGER NOT NULL,
	`fechacompra` DATE NULL,
	`proveedor_idproveedor` INTEGER NULL COMMENT 'Clave del proveedor',
    `muestrario_idmuestrario` INTEGER NULL,
	KEY(`proveedor_idproveedor`),
    KEY(`muestrario_idmuestrario`),
	PRIMARY KEY(`idtela`)
) ENGINE=INNODB;
CREATE TABLE `Muestrario`(
    `idmuestrario` INTEGER NOT NULL AUTO_INCREMENT,
    `nombremuestrario` VARCHAR(50) NOT NULL,
    `tipodepersianas` VARCHAR(50) NOT NULL,
    `precio` DOUBLE NOT NULL,
    `proveedor_idproveedor` INTEGER NOT NULL,
    KEY(`proveedor_idproveedor`),
    PRIMARY KEY(`idmuestrario`)
)ENGINE=INNODB;
CREATE TABLE `Cliente` (
	`idcliente` INTEGER NOT NULL COMMENT 'Clave del cliente' AUTO_INCREMENT,
	`nombre` VARCHAR(50) NOT NULL COMMENT 'Nombre del cliente',
	`calle` VARCHAR(50) NOT NULL COMMENT 'Direccion donde vive el cliente',
	`colonia` VARCHAR(50) NOT NULL COMMENT 'Direccion donde vive el cliente',
	`cp` VARCHAR(50) NOT NULL COMMENT 'Direccion donde vive el cliente',
	`telefono` VARCHAR(15) NULL COMMENT 'Telefono del cliente',
    `email` VARCHAR(50) NULL COMMENT 'E-mail del cliente',
	`ciudad` VARCHAR(30) NULL COMMENT 'Ciudad donde radica el cliente',
	`rfc` VARCHAR(30) NULL,
	`estado` VARCHAR(50) NULL,
	PRIMARY KEY(`idcliente`)
) ENGINE=INNODB;
CREATE TABLE `Pedido` (
	`numpedido` INTEGER NOT NULL COMMENT 'Numero de pedido' AUTO_INCREMENT,
	`fechapedido` DATE NOT NULL COMMENT 'Fecha en la que se realizo el pedido',
	`ivapedido` DECIMAL NOT NULL COMMENT 'Porcentaje del iva aplicado al pedido',
	`subtotal` DOUBLE NOT NULL COMMENT 'Subtotal del pedido',
	`totalneto` DOUBLE NOT NULL COMMENT 'Total neto del pedido',
	`anticipo` DOUBLE NOT NULL COMMENT 'Anticipo del pedido',
    `pdf` BLOB NULL,
	`cliente_idcliente` INTEGER NOT NULL COMMENT 'Clave del cliente',
	KEY(`cliente_idcliente`),
	PRIMARY KEY(`numpedido`)
) ENGINE=INNODB;
CREATE TABLE `Lineas` (
	`numlinea` INTEGER NOT NULL COMMENT 'Numero de linea en el pedido' AUTO_INCREMENT,
	`cantidad` INTEGER NOT NULL COMMENT 'Cantidad pedida',
	`ancho` DOUBLE NOT NULL,
	`alto` DOUBLE NOT NULL,
	`m2` DOUBLE NOT NULL COMMENT 'Metros cuadrados',
	`linea` VARCHAR(45) NOT NULL,
	`modelo` VARCHAR(45) NOT NULL,
	`color` VARCHAR(45) NOT NULL,
	`sistema` VARCHAR(45) NOT NULL,
	`galeria` VARCHAR(4) NOT NULL,
	`cadena` VARCHAR(4) NOT NULL,
	`barra` VARCHAR(6) NOT NULL,
	`instalacion` VARCHAR(50) NOT NULL,
	`control` VARCHAR(30) NOT NULL,
	`preciounitario` DOUBLE NOT NULL,
	`totallinea` DOUBLE NOT NULL,
	`pedido_numpedido` INTEGER NOT NULL COMMENT 'Numero de pedido',
	KEY(`pedido_numpedido`),
    KEY(`numlinea`),
    PRIMARY KEY(`pedido_numpedido`,`numlinea`)
) ENGINE=INNODB;
CREATE TABLE `Cajeros` (
	`id_cajero` INTEGER NOT NULL AUTO_INCREMENT,
	`empleado_id_empleado` INTEGER NOT NULL,
	KEY(`empleado_id_empleado`),
	PRIMARY KEY(`id_cajero`)
) ENGINE=INNODB;
CREATE TABLE `Ventas` (
	`pedido_numpedido` INTEGER NOT NULL COMMENT 'Numero de pedido',
	KEY(`pedido_numpedido`),
	`sucursales_id_sucursal` INTEGER NOT NULL,
	KEY(`sucursales_id_sucursal`),
	`cajeros_id_cajero` INTEGER NOT NULL,
	KEY(`cajeros_id_cajero`),
	`id_venta` INTEGER NOT NULL AUTO_INCREMENT,
    KEY(`id_venta`),
	`fecha` DATE NOT NULL,
	PRIMARY KEY(`pedido_numpedido`,`sucursales_id_sucursal`,`cajeros_id_cajero`,`id_venta`)
) ENGINE=INNODB;
CREATE TABLE `Sucursales` (
	`id_sucursal` INTEGER NOT NULL AUTO_INCREMENT,
	`direccion` VARCHAR(50) NOT NULL,
	`telefono` VARCHAR(15) NOT NULL,
	PRIMARY KEY(`id_sucursal`)
) ENGINE=INNODB;
CREATE TABLE `Empleado` (
	`id_empleado` INTEGER NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(45) NOT NULL,
	`edad` SMALLINT NOT NULL,
	`rfc` VARCHAR(20) NOT NULL,
	`domicilio` VARCHAR(45) NOT NULL,
	`telefono` VARCHAR(15) NOT NULL,
	`sueldo_x_hora` DOUBLE NOT NULL,
	`puesto` VARCHAR(25) NOT NULL,
	`usuariosistema` VARCHAR(50) NOT NULL,
	`contrasenasistema` VARCHAR(50) NOT NULL,
	PRIMARY KEY(`id_empleado`)
) ENGINE=INNODB;
CREATE TABLE `Checador` (
	`id_checador` INTEGER NOT NULL AUTO_INCREMENT,
	`fecha` DATE NOT NULL,
	`hora_entrada` TIME NOT NULL,
	`hora_salida` TIME NULL,
	`empleado_id_empleado` INTEGER NOT NULL,
	KEY(`empleado_id_empleado`),
	PRIMARY KEY(`id_checador`)
) ENGINE=INNODB;
CREATE TABLE `Facturas` (
	`folio` VARCHAR(45) NOT NULL COMMENT 'Folio de la factura emitida',
	`formadepago` VARCHAR(45) NOT NULL,
	`metododepago` VARCHAR(45) NOT NULL,
	`sello` VARCHAR(100) NOT NULL,
	`ventas_pedido_numpedido` INTEGER NOT NULL COMMENT 'Numero de pedido',
	KEY(`ventas_pedido_numpedido`),
	`ventas_sucursales_id_sucursal` INTEGER NOT NULL,
	KEY(`ventas_sucursales_id_sucursal`),
	`ventas_cajeros_id_cajero` INTEGER NOT NULL,
	KEY(`ventas_cajeros_id_cajero`),
	`ventas_id_venta` INTEGER NOT NULL,
	KEY(`ventas_id_venta`),
	PRIMARY KEY(`folio`)
) ENGINE=INNODB;
CREATE TABLE `Configuracion` (
	`idconfiguracion` INTEGER NOT NULL,
	`nombreempresa` VARCHAR(50) NOT NULL,
	`logoempresa` LONGBLOB NOT NULL,
	PRIMARY KEY(`idconfiguracion`)
) ENGINE=INNODB;

# GENERATING RELATIONSHIPS
ALTER TABLE `Telas` ADD CONSTRAINT `telas_proveedor_proveedor_idproveedor` FOREIGN KEY (`proveedor_idproveedor`) REFERENCES `Proveedor`(`idproveedor`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `Telas` ADD CONSTRAINT `material_muestrario_muestrario_idmuestrario` FOREIGN KEY (`muestrario_idmuestrario`) REFERENCES `Muestrario`(`idmuestrario`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `Muestrario` ADD CONSTRAINT `muestrario_proveedor_proveedor_idproveedor` FOREIGN KEY (`proveedor_idproveedor`) REFERENCES `Proveedor`(`idproveedor`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `Pedido` ADD CONSTRAINT `pedido_cliente_cliente_idcliente` FOREIGN KEY (`cliente_idcliente`) REFERENCES `Cliente`(`idcliente`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `Lineas` ADD CONSTRAINT `lineas_pedido_pedido_numpedido` FOREIGN KEY (`pedido_numpedido`) REFERENCES `Pedido`(`numpedido`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `Cajeros` ADD CONSTRAINT `cajeros_empleado_empleado_id_empleado` FOREIGN KEY (`empleado_id_empleado`) REFERENCES `Empleado`(`id_empleado`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `Ventas` ADD CONSTRAINT `ventas_pedido_pedido_numpedido` FOREIGN KEY (`pedido_numpedido`) REFERENCES `Pedido`(`numpedido`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `Ventas` ADD CONSTRAINT `ventas_sucursales_sucursales_id_sucursal` FOREIGN KEY (`sucursales_id_sucursal`) REFERENCES `Sucursales`(`id_sucursal`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `Ventas` ADD CONSTRAINT `ventas_cajeros_cajeros_id_cajero` FOREIGN KEY (`cajeros_id_cajero`) REFERENCES `Cajeros`(`id_cajero`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `Checador` ADD CONSTRAINT `checador_empleado_empleado_id_empleado` FOREIGN KEY (`empleado_id_empleado`) REFERENCES `Empleado`(`id_empleado`) ON DELETE NO ACTION ON UPDATE CASCADE;

# Insertar datos
INSERT INTO `Proveedor` (`idproveedor`, `nombreproveedor`, `ciudad`, `estado`, `telefono`, `email`) VALUES
(1, 'Gabín SA. DE CV.', 'DF', 'DF', '551234321', 'distribuidores@gabin.com.mx'),
(2, 'Vertilux SA. DE CV.', 'TOLUCA', 'Estado De México', '546754523', 'contacto@vertilux.mx'),
(3, 'Juan Manuel Castro', 'Durango', 'Durango', '6181235423', 'castro_666@hotmail.com'),
(4, 'Alejandro Hernandez', 'Torreon', 'Coahuila', '3451234356', 'alex_123@gmail.com');
INSERT INTO `homeblinds`.`muestrario` (`idmuestrario`, `nombremuestrario`,`tipodepersianas`, `precio`,`proveedor_idproveedor`) VALUES ('1', 'Vertilux 2014','VERTICAL TELA', '1200','2'), ('2', 'Gabin Enrollables 2014','ENROLLABLE','2000','1');
INSERT INTO `Telas` (`idtela`, `nombretela`, `descripcion`,  `precioalmacen`, `preciopublico`, `tipopersiana`,`color`, `ubicacion`,`stock`,`fechacompra`,`proveedor_idproveedor`, `muestrario_idmuestrario`) VALUES
(1, 'Blackout', 'Tela que no permite el paso de la luz', 250, 345, 'ENROLLABLE','WHITE','MESA 1', 35, '2014-05-04', 1,2),
(2,'PVC','Vertical de pvc',500,600,'VERTICAL PVC','Cream',NULL,0,NULL,NULL,NULL);
INSERT INTO `Empleado` (`id_empleado`, `nombre`, `edad`, `rfc`, `domicilio`, `telefono`, `sueldo_x_hora`, `puesto`,`usuariosistema`, `contrasenasistema`) VALUES
(1, 'Manuel Alejandro Ceniceros Mercado', 20, 'MACM3245ASR', 'Calle la penca 234 Colonia el cerro', '6181234254', 200, 'Instalador','manuel','12345'),
(2, 'Luis Fernando Alvarez Alvarez', 20, 'CHIKI1445DDF', 'Felipe Pescador 243 Fracc. Chikistrikis', '4532452345', 200, 'Instalador','fernandito','chachagrey'),
(3, 'Mauricio Alejandro Martinez Pacheco ', 20, 'MAMP34FDE4', 'Diente de leon 3124 Fracc. Jardines de Durang', '6187653423', 500, 'CEO','mauricio','54321'),
(4, 'María Cruz Valle', 25, 'MCVPM234', 'Prof. Vazques 234 Colonia del Maestro', '6187654587', 150, 'Cajera','maria','maria'),
(5, 'Margarita Rodríguez', 26, 'MR423DF', 'Diente de León 23 Fracc. Jardines de Durango ', '6183764323', 150, 'Cajera','margarita','margarita'),
(6, 'Juan Luis Olguin Diaz', 19, 'PLOS1234MASD01', 'Abasolo 23 Fracc. Max Rodeo', '812324', 120, 'Inventario', 'juan', 'juan');
INSERT INTO `Cajeros` (`id_cajero`,`empleado_id_empleado`) VALUES
(1,4),(2,5),(3,3);
INSERT INTO `Cliente` (`idcliente`, `nombre`, `calle`,`colonia`,`cp`, `telefono`, `ciudad`, `estado`) VALUES
(1, 'María Hernández Barrera', 'Avenida 20 de Noviembre SN.','Zona centro','3400', '6181234553', 'Durango', 'Durango'),
(2, 'Alejandro Cazares Hoyos', 'Calle Laurel 304','Fracc. Floral','34534', '6181673849', 'Durango', 'Durango'),
(3, 'Consuelo Martinez Rodríguez', 'Calle Adelfa 400',' Fracc. Jardines De Durango','34200', '6182345323', 'Durango', 'Durango'),
(4, 'Francisco Torres Perez', 'Calle De Las Azucenas 304',' Colonia Vencedores','34543', '6181342345', 'Durango', 'Durango');
INSERT INTO `Pedido` (`numpedido`, `fechapedido`, `ivapedido`, `subtotal`, `totalneto`, `anticipo`, `cliente_idcliente`) VALUES
(1, '2014-03-04', '320', 2000, 2320, 232, 1),
(2, '2014-04-03', '2400', 15000, 17400, 1740, 2),
(3, '2014-05-01', '1920', 12000, 13920, 1392, 4),
(4, '2014-03-02', '880', 5500, 6380, 638, 3);
INSERT INTO `Lineas` (`pedido_numpedido`, `numlinea`, `cantidad`, `ancho`, `alto`, `m2`, `linea`, `modelo`, `color`, `sistema`, `galeria`, `cadena`, `barra`, `instalacion`, `control`, `preciounitario`, `totallinea`) VALUES
(1, 1, 3, 2.2, 1.2, 5, 'PANEL JAPONES', 'RT56', 'WHITE', 'PREDETERMINADO', 'NO', 'NO', 'NO', 'A TEC', 'NORMAL', 666, 2000),
(2, 1, 1, 1, 2, 2, 'VERTICAL TELA', '23', 'GRAY', 'PREDETERMINADO', 'NO', 'NO', 'NO', 'A PAR', 'NORMAL', 5000, 5000),
(2, 2, 2, 3, 2, 6, 'ENROLLABLE', 'SCREEN 3', 'BEIGE', 'CONTROL INVERTIDO', 'NO', 'NO', 'NO', 'A TEC', 'NORMAL', 5000, 10000),
(3, 1, 1, 5, 3, 15, 'PVC', 'PVC PLASTICO', 'CHOCOLATE', 'PREDETERMINADO', 'SI', 'NO', 'NO', 'A TEC', 'INVERTIDO', 12000, 12000),
(4, 1, 1, 3, 3, 9, 'HORIZONTAL ', 'MADERA ', 'MADERA', 'PREDETERMINADO', 'NO', 'SI', 'SI', 'A PAR', 'NORMAL', 5500, 5500);
INSERT INTO `Sucursales` (`id_sucursal`, `direccion`, `telefono`) VALUES
(1, 'Blvd. Durango 203 CP:3453', 32767),
(2, 'Blvd. Francisco Villa 1233 CP:34200', 32767);
INSERT INTO `Checador` (`id_checador`, `fecha`, `hora_entrada`, `hora_salida`, `empleado_id_empleado`) VALUES
(1, '2014-03-04', '08:02:00', '20:12:00', 1),
(2, '2014-03-04', '16:05:00', '20:15:00', 2),
(3, '2014-04-03', '18:00:00', '20:10:00', 3);

CREATE VIEW pedidos(numpedido,cliente,fechapedido)
    AS select `pedido`.`numpedido` AS `numpedido`,(select `cliente`.`nombre` from `cliente` where (`cliente`.`idcliente` = `pedido`.`cliente_idcliente`)) AS `cliente`,`pedido`.`fechapedido` AS `fechapedido` from `pedido`;

#Procedimientos almacenados
delimiter $$
CREATE PROCEDURE descontarStock(linea varchar(45),modelo varchar(45),col varchar(45))
BEGIN
START TRANSACTION;
UPDATE Telas SET stock=stock-1 WHERE nombretela=modelo AND tipopersiana=linea AND color=col;
COMMIT;
END$$

CREATE PROCEDURE generarPedido(fecha date, iva decimal(10,0),sub DOUBLE,neto DOUBLE, anticip DOUBLE, cliente int(11),lineas int(11))
BEGIN
DECLARE id int;
DECLARE i int;
INSERT INTO Pedido (fechapedido,ivapedido,subtotal,totalneto,anticipo,cliente_idcliente) VALUES (fecha,iva,sub,neto,anticip,cliente);

SELECT numpedido INTO id FROM Pedido WHERE fechapedido=fecha AND ivapedido=iva AND subtotal=sub AND totalneto=neto AND anticipo=anticip AND cliente_idcliente=cliente;
SET i=0;
REPEAT
	INSERT INTO Lineas (cantidad,ancho,alto,m2,linea,modelo,color,sistema,galeria,cadena,barra,instalacion,control,preciounitario,totallinea,pedido_numpedido) VALUES(NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,id);
    UNTIL i<=lineas
END REPEAT;
END$$

#Triggers
delimiter ;
CREATE TABLE numeroventa_insert(
    idnumventa INTEGER NOT NULL AUTO_INCREMENT,
    cajeros_idcajero INTEGER NOT NULL,
    ventas_idventa INTEGER NOT NULL,
    KEY(cajeros_idcajero),
    KEY(ventas_idventa),
    PRIMARY KEY(idnumventa)
)ENGINE=InnoDB;
ALTER TABLE `numeroventa_insert` ADD CONSTRAINT `cajeros_numeroventa_cajeros_idcajero` FOREIGN KEY (`cajeros_idcajero`) REFERENCES `Cajeros`(`id_cajero`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `numeroventa_insert` ADD CONSTRAINT `ventas_numeroventa_ventas_idventa` FOREIGN KEY (`ventas_idventa`) REFERENCES `Ventas`(`id_venta`) ON DELETE NO ACTION ON UPDATE CASCADE;
delimiter $$
CREATE TRIGGER numero_ventas_insert AFTER INSERT ON Ventas FOR EACH ROW
BEGIN
INSERT INTO numeroventa_insert(cajeros_idcajero,ventas_idventa) VALUES(NEW.cajeros_id_cajero,NEW.id_venta);
END$$
delimiter ;
CREATE TABLE numeroventa_update(
    idnumventa INTEGER NOT NULL AUTO_INCREMENT,
    cajeros_idcajero INTEGER NOT NULL,
    ventas_idventa INTEGER NOT NULL,
    fecha DATETIME NOT NULL,
    KEY(cajeros_idcajero),
    KEY(ventas_idventa),
    PRIMARY KEY(idnumventa)
)ENGINE=InnoDB;
ALTER TABLE `numeroventa_update` ADD CONSTRAINT `cajeros_numeroventaupdate_cajeros_idcajero` FOREIGN KEY (`cajeros_idcajero`) REFERENCES `Cajeros`(`id_cajero`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `numeroventa_update` ADD CONSTRAINT `ventas_numeroventaupdate_ventas_idventa` FOREIGN KEY (`ventas_idventa`) REFERENCES `Ventas`(`id_venta`) ON DELETE NO ACTION ON UPDATE CASCADE;
delimiter $$
CREATE TRIGGER numero_ventas_update AFTER UPDATE ON Ventas FOR EACH ROW
BEGIN
INSERT INTO numeroventa_update(cajeros_idcajero,ventas_idventa,fecha) VALUES(OLD.cajeros_id_cajero,OLD.id_venta,NOW());
END$$

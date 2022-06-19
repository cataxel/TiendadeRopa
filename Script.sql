create database tiendaRopaP;
drop database tiendaRopaP;

use tiendaRopaP;
create table tipo_usuarios(
	idtipo_usuarios int auto_increment,
    nombre varchar(30) not null,
    primary key (idtipo_usuarios)
);

insert into tipo_usuarios(nombre)values('Administrador');
insert into tipo_usuarios(nombre)values('Usuario');

select * from tipo_usuarios;

create table usuarios(
	idusuario int auto_increment,
    usuario varchar(50) not null,
    contra varchar(50) not null,
    nombre varchar(50) not null,
    correo varchar(50) not null,
    last_session datetime,
    id_tipo int(11),
    primary key (idusuario),
    FOREIGN KEY (id_tipo) REFERENCES tipo_usuarios(idtipo_usuarios)
);

SELECT * FROM usuarios WHERE id_tipo = '1';	

select * from usuarios;
drop table usuarios;
UPDATE usuarios SET usuario = 'admin', contra = 'admin', nombre = 'admin',id_tipo = '1' WHERE idusuario = '1';
DELETE from usuarios WHERE idusuario = '1';
create table ClasePrenda(
	idClasePrenda int auto_increment,
    nombre varchar(50) not null,
	primary key (idClasePrenda)
);

insert into ClasePrenda (nombre) value('Superior');
insert into ClasePrenda (nombre) value('Inferior');
insert into ClasePrenda (nombre) value('Calzado');

select * from ClasePrenda;

create table TipoPrenda(
	-- idTipCamiseta de ajuste holgado para hombre, tela de alto gramaje, de manga corta con bolsillooPrenda int auto_increment,
    nombre varchar(50) not null,
    idclaseprenda int not null,
	primary key (idTipoPrenda),
	FOREIGN KEY (idclaseprenda) REFERENCES ClasePrenda(idClasePrenda)
);
insert into TipoPrenda(nombre,idclaseprenda)values('Camiseta',1);
insert into TipoPrenda(nombre,idclaseprenda)values('Camisa',1);
insert into TipoPrenda(nombre,idclaseprenda)values('Sudadera',1);
insert into TipoPrenda(nombre,idclaseprenda)values('Chaqueta',1);
insert into TipoPrenda(nombre,idclaseprenda)values('Sueter',1);
insert into TipoPrenda(nombre,idclaseprenda)values('Abrigo',1);

insert into TipoPrenda(nombre,idclaseprenda)values('Pantalon de Vestir',2);
insert into TipoPrenda(nombre,idclaseprenda)values('Pantalon Deportivo',2);
insert into TipoPrenda(nombre,idclaseprenda)values('Shorts',2);
insert into TipoPrenda(nombre,idclaseprenda)values('Bermudas',2);

insert into TipoPrenda(nombre,idclaseprenda)values('Casual',3);
insert into TipoPrenda(nombre,idclaseprenda)values('Deportivo',3);
insert into TipoPrenda(nombre,idclaseprenda)values('Formal',3);
insert into TipoPrenda(nombre,idclaseprenda)values('Sandalias',3);

select * from TipoPrenda;

drop table Tallas;

create table Tallas(
	idtalla int auto_increment,
    nombre varchar(50) not null,
    idclasePrenda int not null,
	primary key (idtalla),
	FOREIGN KEY (idclasePrenda) REFERENCES ClasePrenda(idClasePrenda)
);

insert into Tallas (nombre,idclasePrenda) value('CH',1);
insert into Tallas (nombre,idclasePrenda) value('M',1);
insert into Tallas (nombre,idclasePrenda) value('GR',1);
insert into Tallas (nombre,idclasePrenda) value('XG',1);

insert into Tallas (nombre,idclasePrenda) value('32',2);
insert into Tallas (nombre,idclasePrenda) value('34',2);
insert into Tallas (nombre,idclasePrenda) value('36',2);
insert into Tallas (nombre,idclasePrenda) value('38',2);


insert into Tallas (nombre,idclasePrenda) value('3',3);
insert into Tallas (nombre,idclasePrenda) value('4',3);
insert into Tallas (nombre,idclasePrenda) value('5',3);
insert into Tallas (nombre,idclasePrenda) value('6',3);
SELECT * from Tallas;


SELECT * FROM tropa.usuarios;
SELECT * FROM tiendaropa.tipo_usuarios;

create table ropa(
	IdRopa int auto_increment,
    nombre varchar(50) not null,
    descripcion varchar(300) not null,
    precio_costo double not null,
    precio_venta double not null,
    ganancia double not null,
    genero varchar(9) not null,
    marca varchar(30) not null,
    idtipoprenda int not null,
    existencias int not null
    primary key(IdRopa),
    FOREIGN KEY (idtipoprenda) REFERENCES TipoPrenda(idTipoPrenda)
);
select * from ropa;
alter table ropa add column existencias int not null;
drop table ropa;
create table ropa_talla(
	idRopaTalla int auto_increment,
	idropa int not null,
	idtalla int not null,
	existencias int not null default 0,
    primary key(idRopaTalla),
	FOREIGN KEY (idropa) REFERENCES ropa(idropa),
	FOREIGN KEY (idtalla) REFERENCES Tallas(idtalla)
);

drop table ropa_talla;
 
 select * from TipoPrenda;
 insert into ropa(nombre,descripcion,precio,genero,marca,idtipoprenda) values ('Nike Drifit Pro','Casisa fabricada en Indonesia',899.00,'Masculino','Nike',2);
 insert into ropa(nombre,descripcion,precio,genero,marca,idtipoprenda) values ('Nike SportSwaer Fit','Pantalon Deposrtivo fabricada en Indonesia',1299.00,'Masculino','Nike',8);

select * from ropa;
select * from Tallas;

insert into ropa_talla(idropa,idtalla,existencias)values(1,1,10);
insert into ropa_talla(idropa,idtalla,existencias)values(1,3,5);
insert into ropa_talla(idropa,idtalla,existencias)values(1,4,2);
 select * from ropa_talla;
 select * from ropa;

select distinct r.idropa, r.nombre, r.descripcion, r.precio, GROUP_CONCAT('Talla: ',t.nombre,' Existencias: ',rp.existencias SEPARATOR ', ') As Tallas, r.genero, r.marca, cp.nombre, tp.nombre
from ropa r inner join ropa_talla rp on r.idropa = rp.idropa inner join Tallas t on rp.idtalla=t.idtalla 
    inner join ClasePrenda cp on t.idclasePrenda=cp.idClasePrenda
    INNER JOIN TipoPrenda tp ON cp.idClasePrenda = tp.idclaseprenda
where r.idropa=11;

select distinct r.idropa, r.nombre, r.descripcion, r.genero, r.marca, cp.nombre, tp.nombre 
from ropa r inner join ropa_talla rp on r.idropa = rp.idropa inner join Tallas t on rp.idtalla=t.idtalla 
    inner join ClasePrenda cp on t.idclasePrenda=cp.idClasePrenda
    INNER JOIN TipoPrenda tp ON r.idtipoprenda = tp.idTipoPrenda;


SELECT DISTINCT r.idropa, r.nombre, r.descripcion, r.genero, r.marca, cp.nombre, tp.nombre FROM ropa r INNER JOIN ropa_talla rp ON r.idropa = rp.idropa INNER JOIN Tallas t ON rp.idtalla=t.idtalla INNER JOIN ClasePrenda cp ON t.idclasePrenda=cp.idClasePrenda INNER JOIN TipoPrenda tp ON r.idtipoprenda = tp.idTipoPrenda;

select * from ropa_talla;

select * from ropa;

drop table ropa;

select * from TipoPrenda;

Select MAX(idropa) from ropa;


SELECT t.nombre, rt.existencias FROM Tallas t INNER JOIN ropa_talla rt ON t.idtalla = rt.idtalla INNER JOIN ropa r ON rt.idropa = r.idropa WHERE r.idropa=10;
create table Opiniones(
CveOpiniones int auto_increment not null,
CalidadOpiniones varchar(300) not null,
ExperienciaOpiniones varchar(300) not null,
SugerenciasOpiniones varchar(300) not null,
primary key(CveOpiniones)
);
insert into Opiniones(CalidadOpiniones, ExperienciaOpiniones, SugerenciasOpiniones) values ('Muy buena', 'Muy buena, e interfaz fácil', 'Favor de poner colores claros en la interfaz');
select*From Opiniones;

create table Proveedor(
CveProveedor int auto_increment not null,
NombreProveedor varchar(50) not null,
Telefonoproveedor varchar(12) not null,
DireccionProveedor varchar(100) not null,
NombreEmpresaProveedor varchar(50) not null,
ActivoProveedor boolean not null,
primary key(CveProveedor)
);
select CveProveedor, NombreProveedor, NombreEmpresaProveedor,ActivoProveedor from Proveedor;
select CveProveedor ,NombreProveedor ,ActivoProveedor from Proveedor;
insert into Proveedor(NombreProveedor, TelefonoProveedor, DireccionProveedor, NombreEmpresaProveedor) values('Verónica Barragán', '3539631801', 'Guadalupe Victoria #927 Sahuayo Michoacán', 'RopaSahuayo');
UPDATE Proveedor SET NombreProveedor='Ángel David', Telefonoproveedor='3531020411',DireccionProveedor='Niños Héroes #280 Sahuayo',NombreEmpresaProveedor='Nike' WHERE CveProveedor = 1;
SELECT COUNT(*) FROM Proveedor;
SELECT * FROM Proveedor WHERE NombreProveedor = 1;
select*from Proveedor;
CREATE table Ventas(
	idVenta int auto_increment,
	idRopa int not null,
	folioVenta VARCHAR(10) unique not null,
	Fecha date not null,
	Total double(11,2) not null,
	Descuento double(11,2) not null,
	IVA double(11,2) not null,
	Estado boolean not null,
	existencias int not null,
	Primary key (idVenta),
	foreign key (idRopa) references ropa(IdRopa)
);
alter table Ventas add column existencias int not null;
INSERT INTO Ventas(idRopa,folioVenta,Fecha,Total,Descuento,IVA,Estado) VALUES('1','nose','2021-01-10','1000.0','2.0','10.0',true);
SELECT * from Ventas;
SELECT existencias from ropa where idropa = 1;
DELETE from Ventas WHERE idVenta = 8;

create table Compra(
	IdCompra int not null auto_increment,
	IdProveedor int,
	fechaCompra varchar(10) not null,
	MontoCompra varchar(6) not null,
	DescripcionCompra varchar(50),
	idropa int,
	cantidad int,
	primary key (IdCompra),
	FOREIgn KEY (IdProveedor) references Proveedor(CveProveedor)
	foreign key (idropa) references ropa(idropa);
);
alter table Compra add column cantidad int;
insert into Compra(IdCompra,IdProveedor,FechaCompra, MontoCompra, DescripcionCompra) values(1,1,'2022-05-28','1000','idk');
SELECT * from Compra;
DELETE from Compra WHERE IdCompra = 4;
SELECT IdCompra, IdProveedor, FechaCompra, MontoCompra, DescripcionCompra from Compra WHERE IdCompra ='1';

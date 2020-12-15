create database QuickDeliveryBD;
use QuickDeliveryBD;

Create Table Usuarios
(
idUsuario int primary key auto_increment not null,
nombreU varchar(50) not null,
apellidoU varchar(50) not null,
correoU Varchar(50) not null,
contraU Varchar(50),
telefonoU Varchar(10) not null,
direccionU Varchar(500) not null
);

Create Table Productos
(
idProducto int primary key auto_increment not null,
nombreP varchar (50) not null,
precioP decimal not null
);

Create Table Vendedores 
(
idVendedor int primary key auto_increment not null,
idUsuario int not null,
foreign key (idUsuario) references Usuarios(idUsuario)
);

Create Table Ventas 
(
idVenta int primary key auto_increment not null,
idVendedor int not null,
idProducto int not null,
totalV decimal,
comisionEnvio decimal,
fechaVenta Date not null,
foreign key (idVendedor) references Vendedores(idVendedor),
foreign key (idProducto) references Productos(idProducto)
);
Create Table Clientes 
(
idCliente int primary key auto_increment not null,
idUsuario int not null,
idCompra int not null,
foreign key (idUsuario) references Usuarios (idUsuario)

);
Create Table Compras 
(
idCompra int not null primary key auto_increment,
idVenta int not null,
idCliente int not null,
foreign key (idCliente) references Clientes (idCliente),
foreign key (idVenta) references Ventas (idVenta)
);

Create Table Envios 
(
idEnvio int primary key not null auto_increment,
idVenta int not null,
idCliente int not null,
foreign key (idVenta) references Ventas (idVenta),
foreign key (idCliente) references Clientes (idCliente)
);
-- si sale un error, descomentar lo siguiente y ejecutarlo
-- alter table Clientes Add foreign key (idCompra) references Compras (idCompra)


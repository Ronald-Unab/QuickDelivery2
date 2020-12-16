CREATE PROCEDURE `sp_crearUsuario` (
CidUsuario int,
CnombreUsuario varchar(50),
CapellidoUsuario varchar(50),
CcorreoUsuario varchar(50),
CcontraUsuario varchar(600),
CtelefonoUsuario varchar(10),
CdireccionUsuario varchar (500)
 )
BEGIN
INSERT INTO Usuarios ( idUsuario, nombreU, apellidoU, correoU , contraU, telefonoU, direccionU)
Values (CidUsuario, CnombreUsuario, CapellidoUsuario, CcorreoUsuario, sha2(CcontraUsuario,512), 
CtelefonoUsuario, CdireccionUsuario);
END

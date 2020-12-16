CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarUsuario`(
UidUsuario int,
UnombreUsuario varchar (50),
UapellidoUsuario varchar(50),
UcorreoUsuario varchar (50),
UcontraUsuario varchar (600),
UtelefonoUsuario varchar (10),
UdireccionUsuario varchar (500)
)
BEGIN
update Usuarios set idUsuario = UidUsuario, nombreU = UnombreUsuario, apellidoU = UapellidoUsuario,
correoU = UcorreoUsuario, contraU = UcontraUsuario, telefonoU = UtelefonoUsuario, 
direccionU = UdireccionUsuario 
where idUsuario = UidUsuario;
END
CREATE PROCEDURE `sp_borrarUsuario` (DidUsuario int)
BEGIN
delete from Usuarios where idUsuario=DidUsuario;
END; 
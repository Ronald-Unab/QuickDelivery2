CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarUsuario`()
BEGIN
select * from quickdeliverybd.Usuarios;
END
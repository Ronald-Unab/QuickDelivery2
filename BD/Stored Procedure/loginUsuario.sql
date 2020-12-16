CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_loguin`(LcorreoUsuario varchar(50), LcontraUsuario varchar(600))
BEGIN
select * from Usuarios where correoU = LcorreoUsuario and contraU = sha2(LcontraUsuario,512);
END
CREATE PROCEDURE `sp_cripPass` (cripContra varchar(600))
BEGIN
select sha2(cripContra, 512) as crip;
END

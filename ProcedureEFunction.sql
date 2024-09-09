-- PROCEDURE: public.inserir_usuario(character varying, character varying, character varying, character varying)

-- DROP PROCEDURE IF EXISTS public.inserir_usuario(character varying, character varying, character varying, character varying);

CREATE OR REPLACE PROCEDURE public.inserir_usuario(
	IN p_usuario_nome character varying,
	IN p_usuario_email character varying,
	IN p_usuario_senha character varying,
	IN p_usuario_tipo character varying)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN
    INSERT INTO usuarios (usuario_nome, usuario_email, usuario_senha, usuario_tipo)
    VALUES (p_usuario_nome, p_usuario_email, p_usuario_senha, p_usuario_tipo);
END;
$BODY$;
ALTER PROCEDURE public.inserir_usuario(character varying, character varying, character varying, character varying)
    OWNER TO postgres;



-- PROCEDURE: public.inserir_habilidade(integer, character varying, character varying)

-- DROP PROCEDURE IF EXISTS public.inserir_habilidade(integer, character varying, character varying);

CREATE OR REPLACE PROCEDURE public.inserir_habilidade(
	IN p_idusuario integer,
	IN p_categoria character varying,
	IN p_habilidade character varying)
LANGUAGE 'plpgsql'
AS $BODY$

BEGIN
	INSERT INTO habilidades(usuario_id,habilidade_categoria, habilidade_habilidade)
	VALUES (p_idUsuario,p_categoria,p_habilidade);
END;
$BODY$;
ALTER PROCEDURE public.inserir_habilidade(integer, character varying, character varying)
    OWNER TO postgres;



-- PROCEDURE: public.inserir_candidato_vaga(character varying, character varying)

-- DROP PROCEDURE IF EXISTS public.inserir_candidato_vaga(character varying, character varying);

CREATE OR REPLACE PROCEDURE public.inserir_candidato_vaga(
	IN p_email character varying,
	IN p_vaga_numero character varying)
LANGUAGE 'plpgsql'
AS $BODY$
declare 
v_candidato_id int;
BEGIN 
select usuario_id into v_candidato_id
from usuarios
where usuario_email = p_email;

UPDATE vagas SET candidato_id = v_candidato_id where vaga_numero = p_vaga_numero;
END;
$BODY$;
ALTER PROCEDURE public.inserir_candidato_vaga(character varying, character varying)
    OWNER TO postgres;



-- FUNCTION: public.login_usuario(character varying, character varying)

-- DROP FUNCTION IF EXISTS public.login_usuario(character varying, character varying);

CREATE OR REPLACE FUNCTION public.login_usuario(
	p_usuario_email character varying,
	p_usuario_senha character varying)
    RETURNS SETOF integer 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
RETURN QUERY SELECT usuario_id 
FROM usuarios 
WHERE usuario_email = p_usuario_email AND usuario_senha = p_usuario_senha;
END;
$BODY$;

ALTER FUNCTION public.login_usuario(character varying, character varying)
    OWNER TO postgres;



-- FUNCTION: public.listar_vagas()

-- DROP FUNCTION IF EXISTS public.listar_vagas();

CREATE OR REPLACE FUNCTION public.listar_vagas(
	)
    RETURNS TABLE(vaga_data date, vaga_descricao character varying, vaga_numero character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
 
BEGIN
RETURN QUERY 
SELECT v.vaga_data,v.vaga_descricao,v.vaga_numero
FROM vagas v;
END;
$BODY$;

ALTER FUNCTION public.listar_vagas()
    OWNER TO postgres;




-- FUNCTION: public.busca_habilidades_por_email(integer, character varying)

-- DROP FUNCTION IF EXISTS public.busca_habilidades_por_email(integer, character varying);

CREATE OR REPLACE FUNCTION public.busca_habilidades_por_email(
	p_id_usuario integer,
	p_email character varying)
    RETURNS TABLE(habilidade_categoria character varying, habilidade_habilidade character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    RETURN QUERY 
    SELECT h.habilidade_categoria, h.habilidade_habilidade
    FROM habilidades h 
    INNER JOIN usuarios u ON h.usuario_id = u.usuario_id
    WHERE u.usuario_email = p_email AND u.usuario_id = p_id_usuario;
END;
$BODY$;

ALTER FUNCTION public.busca_habilidades_por_email(integer, character varying)
    OWNER TO postgres;
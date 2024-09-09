-- Table: public.usuarios

-- DROP TABLE IF EXISTS public.usuarios;

CREATE TABLE IF NOT EXISTS public.usuarios
(
    usuario_id integer NOT NULL DEFAULT nextval('usuarios_usuario_id_seq'::regclass),
    usuario_nome character varying(255) COLLATE pg_catalog."default",
    usuario_email character varying(255) COLLATE pg_catalog."default",
    usuario_senha character varying(255) COLLATE pg_catalog."default",
    usuario_tipo character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT usuarios_pkey PRIMARY KEY (usuario_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuarios
    OWNER to postgres;



-- Table: public.habilidades

-- DROP TABLE IF EXISTS public.habilidades;

CREATE TABLE IF NOT EXISTS public.habilidades
(
    habilidade_id integer NOT NULL DEFAULT nextval('habilidades_habilidade_id_seq'::regclass),
    habilidade_categoria character varying(255) COLLATE pg_catalog."default",
    habilidade_habilidade character varying(255) COLLATE pg_catalog."default",
    usuario_id integer,
    CONSTRAINT habilidades_pkey PRIMARY KEY (habilidade_id),
    CONSTRAINT habilidades_usuario_id_fkey FOREIGN KEY (usuario_id)
        REFERENCES public.usuarios (usuario_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.habilidades
    OWNER to postgres;



-- Table: public.vagas

-- DROP TABLE IF EXISTS public.vagas;

CREATE TABLE IF NOT EXISTS public.vagas
(
    vaga_id integer NOT NULL DEFAULT nextval('vagas_vaga_id_seq'::regclass),
    vaga_data date,
    candidato_id integer,
    vaga_descricao character varying(255) COLLATE pg_catalog."default",
    vaga_numero character varying(5) COLLATE pg_catalog."default",
    CONSTRAINT vaga_pkey PRIMARY KEY (vaga_id),
    CONSTRAINT vagas_candidato_id_fkey FOREIGN KEY (candidato_id)
        REFERENCES public.usuarios (usuario_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vagas
    OWNER to postgres;
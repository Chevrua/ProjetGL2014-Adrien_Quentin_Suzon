--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.3
-- Dumped by pg_dump version 9.3.3
-- Started on 2014-05-06 10:05:18

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2008 (class 1262 OID 16394)
-- Name: ProjetGL; Type: DATABASE; Schema: -; Owner: admin
--

CREATE DATABASE "ProjetGL2" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';


ALTER DATABASE "ProjetGL2" OWNER TO admin;

\connect "ProjetGL2"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 185 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2011 (class 0 OID 0)
-- Dependencies: 185
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 24578)
-- Name: Classe; Type: TABLE; Schema: public; Owner: admin; Tablespace: 
--

CREATE TABLE "Classe" (
    id_classe integer NOT NULL,
    id_profprcipal integer NOT NULL,
    nom character(20)
);


ALTER TABLE public."Classe" OWNER TO admin;

--
-- TOC entry 170 (class 1259 OID 24576)
-- Name: Classe_id_classe_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE "Classe_id_classe_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9223
    CACHE 1;


ALTER TABLE public."Classe_id_classe_seq" OWNER TO admin;

--
-- TOC entry 2012 (class 0 OID 0)
-- Dependencies: 170
-- Name: Classe_id_classe_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE "Classe_id_classe_seq" OWNED BY "Classe".id_classe;


SET default_with_oids = true;

--
-- TOC entry 173 (class 1259 OID 24589)
-- Name: Eleves; Type: TABLE; Schema: public; Owner: admin; Tablespace: 
--

CREATE TABLE "Eleves" (
    id_eleves integer NOT NULL,
    mdp character(8) NOT NULL,
    nom character(20) NOT NULL,
    prenom character(20) NOT NULL,
    "dateNaiss" date NOT NULL,
    adresse character(100) NOT NULL,
    id_parent integer NOT NULL,
    id_classe integer NOT NULL
);


ALTER TABLE public."Eleves" OWNER TO admin;

--
-- TOC entry 172 (class 1259 OID 24587)
-- Name: Eleves_id_eleves_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE "Eleves_id_eleves_seq"
    START WITH 100000000
    INCREMENT BY 1
    MINVALUE 100000000
    MAXVALUE 600000000
    CACHE 100000000;


ALTER TABLE public."Eleves_id_eleves_seq" OWNER TO admin;

--
-- TOC entry 2013 (class 0 OID 0)
-- Dependencies: 172
-- Name: Eleves_id_eleves_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE "Eleves_id_eleves_seq" OWNED BY "Eleves".id_eleves;


--
-- TOC entry 181 (class 1259 OID 24626)
-- Name: Matiere; Type: TABLE; Schema: public; Owner: admin; Tablespace: 
--

CREATE TABLE "Matiere" (
    id_mat integer NOT NULL,
    "nomMatiere" character(20) NOT NULL
);


ALTER TABLE public."Matiere" OWNER TO admin;

--
-- TOC entry 180 (class 1259 OID 24624)
-- Name: Matiere_id_mat_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE "Matiere_id_mat_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Matiere_id_mat_seq" OWNER TO admin;

--
-- TOC entry 2014 (class 0 OID 0)
-- Dependencies: 180
-- Name: Matiere_id_mat_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE "Matiere_id_mat_seq" OWNED BY "Matiere".id_mat;


--
-- TOC entry 177 (class 1259 OID 24607)
-- Name: Notes; Type: TABLE; Schema: public; Owner: admin; Tablespace: 
--

CREATE TABLE "Notes" (
    id_notes integer NOT NULL,
    id_eleve integer NOT NULL,
    id_matiere integer NOT NULL,
    note numeric NOT NULL
);


ALTER TABLE public."Notes" OWNER TO admin;

--
-- TOC entry 176 (class 1259 OID 24605)
-- Name: Notes_id_notes_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE "Notes_id_notes_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Notes_id_notes_seq" OWNER TO admin;

--
-- TOC entry 2015 (class 0 OID 0)
-- Dependencies: 176
-- Name: Notes_id_notes_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE "Notes_id_notes_seq" OWNED BY "Notes".id_notes;


--
-- TOC entry 175 (class 1259 OID 24599)
-- Name: Parent; Type: TABLE; Schema: public; Owner: admin; Tablespace: 
--

CREATE TABLE "Parent" (
    id_parent integer NOT NULL,
    mdp integer NOT NULL,
    nom character(20) NOT NULL,
    prenom character(20) NOT NULL
);


ALTER TABLE public."Parent" OWNER TO admin;

--
-- TOC entry 174 (class 1259 OID 24597)
-- Name: Parent_id_parent_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE "Parent_id_parent_seq"
    START WITH 600000000
    INCREMENT BY 1
    MINVALUE 600000000
    MAXVALUE 999999999
    CACHE 1
    CYCLE;


ALTER TABLE public."Parent_id_parent_seq" OWNER TO admin;

--
-- TOC entry 2016 (class 0 OID 0)
-- Dependencies: 174
-- Name: Parent_id_parent_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE "Parent_id_parent_seq" OWNED BY "Parent".id_parent;


--
-- TOC entry 179 (class 1259 OID 24618)
-- Name: Professeur; Type: TABLE; Schema: public; Owner: admin; Tablespace: 
--

CREATE TABLE "Professeur" (
    id_prof integer NOT NULL,
    mdp integer NOT NULL,
    nom character(20) NOT NULL,
    prenom character(20) NOT NULL
);


ALTER TABLE public."Professeur" OWNER TO admin;

--
-- TOC entry 178 (class 1259 OID 24616)
-- Name: Professeur_id_prof_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE "Professeur_id_prof_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000000
    CACHE 1;


ALTER TABLE public."Professeur_id_prof_seq" OWNER TO admin;

--
-- TOC entry 2017 (class 0 OID 0)
-- Dependencies: 178
-- Name: Professeur_id_prof_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE "Professeur_id_prof_seq" OWNED BY "Professeur".id_prof;


SET default_with_oids = false;

--
-- TOC entry 184 (class 1259 OID 24640)
-- Name: Relation_Classe_Prof_Mat; Type: TABLE; Schema: public; Owner: admin; Tablespace: 
--

CREATE TABLE "Relation_Classe_Prof_Mat" (
    id_r_c_p_m integer NOT NULL,
    id_r_p_m integer NOT NULL,
    id_classe integer NOT NULL
);


ALTER TABLE public."Relation_Classe_Prof_Mat" OWNER TO admin;

--
-- TOC entry 183 (class 1259 OID 24634)
-- Name: Relation_Prof_Mat; Type: TABLE; Schema: public; Owner: admin; Tablespace: 
--

CREATE TABLE "Relation_Prof_Mat" (
    id_r_p_m integer NOT NULL,
    id_prof integer NOT NULL,
    id_mat integer NOT NULL
);


ALTER TABLE public."Relation_Prof_Mat" OWNER TO admin;

--
-- TOC entry 182 (class 1259 OID 24632)
-- Name: Relation_Prof_Mat_id_r_p_m_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE "Relation_Prof_Mat_id_r_p_m_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Relation_Prof_Mat_id_r_p_m_seq" OWNER TO admin;

--
-- TOC entry 2018 (class 0 OID 0)
-- Dependencies: 182
-- Name: Relation_Prof_Mat_id_r_p_m_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE "Relation_Prof_Mat_id_r_p_m_seq" OWNED BY "Relation_Prof_Mat".id_r_p_m;


--
-- TOC entry 1865 (class 2604 OID 24581)
-- Name: id_classe; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Classe" ALTER COLUMN id_classe SET DEFAULT nextval('"Classe_id_classe_seq"'::regclass);


--
-- TOC entry 1866 (class 2604 OID 24592)
-- Name: id_eleves; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Eleves" ALTER COLUMN id_eleves SET DEFAULT nextval('"Eleves_id_eleves_seq"'::regclass);


--
-- TOC entry 1870 (class 2604 OID 24629)
-- Name: id_mat; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Matiere" ALTER COLUMN id_mat SET DEFAULT nextval('"Matiere_id_mat_seq"'::regclass);


--
-- TOC entry 1868 (class 2604 OID 24610)
-- Name: id_notes; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Notes" ALTER COLUMN id_notes SET DEFAULT nextval('"Notes_id_notes_seq"'::regclass);


--
-- TOC entry 1867 (class 2604 OID 24602)
-- Name: id_parent; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Parent" ALTER COLUMN id_parent SET DEFAULT nextval('"Parent_id_parent_seq"'::regclass);


--
-- TOC entry 1869 (class 2604 OID 24621)
-- Name: id_prof; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Professeur" ALTER COLUMN id_prof SET DEFAULT nextval('"Professeur_id_prof_seq"'::regclass);


--
-- TOC entry 1871 (class 2604 OID 24637)
-- Name: id_r_p_m; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Relation_Prof_Mat" ALTER COLUMN id_r_p_m SET DEFAULT nextval('"Relation_Prof_Mat_id_r_p_m_seq"'::regclass);


--
-- TOC entry 1885 (class 2606 OID 24639)
-- Name: pk_R_prof_mat; Type: CONSTRAINT; Schema: public; Owner: admin; Tablespace: 
--

ALTER TABLE ONLY "Relation_Prof_Mat"
    ADD CONSTRAINT "pk_R_prof_mat" PRIMARY KEY (id_r_p_m);


--
-- TOC entry 1873 (class 2606 OID 24586)
-- Name: pk_classe; Type: CONSTRAINT; Schema: public; Owner: admin; Tablespace: 
--

ALTER TABLE ONLY "Classe"
    ADD CONSTRAINT pk_classe PRIMARY KEY (id_classe);


--
-- TOC entry 1875 (class 2606 OID 24594)
-- Name: pk_eleve; Type: CONSTRAINT; Schema: public; Owner: admin; Tablespace: 
--

ALTER TABLE ONLY "Eleves"
    ADD CONSTRAINT pk_eleve PRIMARY KEY (id_eleves);


--
-- TOC entry 1883 (class 2606 OID 24631)
-- Name: pk_mat; Type: CONSTRAINT; Schema: public; Owner: admin; Tablespace: 
--

ALTER TABLE ONLY "Matiere"
    ADD CONSTRAINT pk_mat PRIMARY KEY (id_mat);


--
-- TOC entry 1879 (class 2606 OID 24615)
-- Name: pk_note; Type: CONSTRAINT; Schema: public; Owner: admin; Tablespace: 
--

ALTER TABLE ONLY "Notes"
    ADD CONSTRAINT pk_note PRIMARY KEY (id_notes);


--
-- TOC entry 1877 (class 2606 OID 24604)
-- Name: pk_parent; Type: CONSTRAINT; Schema: public; Owner: admin; Tablespace: 
--

ALTER TABLE ONLY "Parent"
    ADD CONSTRAINT pk_parent PRIMARY KEY (id_parent);


--
-- TOC entry 1881 (class 2606 OID 24623)
-- Name: pk_prof; Type: CONSTRAINT; Schema: public; Owner: admin; Tablespace: 
--

ALTER TABLE ONLY "Professeur"
    ADD CONSTRAINT pk_prof PRIMARY KEY (id_prof);


--
-- TOC entry 1887 (class 2606 OID 24644)
-- Name: pk_r_c_p_m; Type: CONSTRAINT; Schema: public; Owner: admin; Tablespace: 
--

ALTER TABLE ONLY "Relation_Classe_Prof_Mat"
    ADD CONSTRAINT pk_r_c_p_m PRIMARY KEY (id_r_c_p_m);


--
-- TOC entry 1890 (class 2606 OID 24655)
-- Name: fk_classe; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Eleves"
    ADD CONSTRAINT fk_classe FOREIGN KEY (id_classe) REFERENCES "Classe"(id_classe);


--
-- TOC entry 1896 (class 2606 OID 24675)
-- Name: fk_classe; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Relation_Classe_Prof_Mat"
    ADD CONSTRAINT fk_classe FOREIGN KEY (id_classe) REFERENCES "Classe"(id_classe);


--
-- TOC entry 1891 (class 2606 OID 24660)
-- Name: fk_eleve; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Notes"
    ADD CONSTRAINT fk_eleve FOREIGN KEY (id_eleve) REFERENCES "Eleves"(id_eleves);


--
-- TOC entry 1892 (class 2606 OID 24665)
-- Name: fk_mat; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Notes"
    ADD CONSTRAINT fk_mat FOREIGN KEY (id_matiere) REFERENCES "Matiere"(id_mat);


--
-- TOC entry 1894 (class 2606 OID 24685)
-- Name: fk_matiere; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Relation_Prof_Mat"
    ADD CONSTRAINT fk_matiere FOREIGN KEY (id_mat) REFERENCES "Matiere"(id_mat);


--
-- TOC entry 1889 (class 2606 OID 24650)
-- Name: fk_parent; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Eleves"
    ADD CONSTRAINT fk_parent FOREIGN KEY (id_parent) REFERENCES "Parent"(id_parent);


--
-- TOC entry 1893 (class 2606 OID 24680)
-- Name: fk_prof; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Relation_Prof_Mat"
    ADD CONSTRAINT fk_prof FOREIGN KEY (id_prof) REFERENCES "Professeur"(id_prof);


--
-- TOC entry 1888 (class 2606 OID 24645)
-- Name: fk_profprcipal; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Classe"
    ADD CONSTRAINT fk_profprcipal FOREIGN KEY (id_profprcipal) REFERENCES "Professeur"(id_prof);


--
-- TOC entry 1895 (class 2606 OID 24670)
-- Name: fk_r_p_m; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY "Relation_Classe_Prof_Mat"
    ADD CONSTRAINT fk_r_p_m FOREIGN KEY (id_r_p_m) REFERENCES "Relation_Prof_Mat"(id_r_p_m);


--
-- TOC entry 2010 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-05-06 10:05:18

--
-- PostgreSQL database dump complete
--


--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.3
-- Dumped by pg_dump version 9.3.3
-- Started on 2014-05-06 11:25:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 185 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2026 (class 0 OID 0)
-- Dependencies: 185
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 24578)
-- Name: Classe; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Classe" (
    id_classe integer NOT NULL,
    id_profprcipal integer NOT NULL,
    nom character(20)
);


--
-- TOC entry 170 (class 1259 OID 24576)
-- Name: Classe_id_classe_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "Classe_id_classe_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9223
    CACHE 1;


--
-- TOC entry 2027 (class 0 OID 0)
-- Dependencies: 170
-- Name: Classe_id_classe_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "Classe_id_classe_seq" OWNED BY "Classe".id_classe;


SET default_with_oids = true;

--
-- TOC entry 173 (class 1259 OID 24589)
-- Name: Eleves; Type: TABLE; Schema: public; Owner: -; Tablespace: 
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


--
-- TOC entry 172 (class 1259 OID 24587)
-- Name: Eleves_id_eleves_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "Eleves_id_eleves_seq"
    START WITH 100000000
    INCREMENT BY 1
    MINVALUE 100000000
    MAXVALUE 600000000
    CACHE 100000000;


--
-- TOC entry 2028 (class 0 OID 0)
-- Dependencies: 172
-- Name: Eleves_id_eleves_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "Eleves_id_eleves_seq" OWNED BY "Eleves".id_eleves;


--
-- TOC entry 181 (class 1259 OID 24626)
-- Name: Matiere; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Matiere" (
    id_mat integer NOT NULL,
    "nomMatiere" character(20) NOT NULL
);


--
-- TOC entry 180 (class 1259 OID 24624)
-- Name: Matiere_id_mat_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "Matiere_id_mat_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2029 (class 0 OID 0)
-- Dependencies: 180
-- Name: Matiere_id_mat_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "Matiere_id_mat_seq" OWNED BY "Matiere".id_mat;


--
-- TOC entry 177 (class 1259 OID 24607)
-- Name: Notes; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Notes" (
    id_notes integer NOT NULL,
    id_eleve integer NOT NULL,
    id_matiere integer NOT NULL,
    note numeric NOT NULL
);


--
-- TOC entry 176 (class 1259 OID 24605)
-- Name: Notes_id_notes_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "Notes_id_notes_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2030 (class 0 OID 0)
-- Dependencies: 176
-- Name: Notes_id_notes_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "Notes_id_notes_seq" OWNED BY "Notes".id_notes;


--
-- TOC entry 175 (class 1259 OID 24599)
-- Name: Parent; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Parent" (
    id_parent integer NOT NULL,
    mdp integer NOT NULL,
    nom character(20) NOT NULL,
    prenom character(20) NOT NULL
);


--
-- TOC entry 174 (class 1259 OID 24597)
-- Name: Parent_id_parent_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "Parent_id_parent_seq"
    START WITH 600000000
    INCREMENT BY 1
    MINVALUE 600000000
    MAXVALUE 999999999
    CACHE 1
    CYCLE;


--
-- TOC entry 2031 (class 0 OID 0)
-- Dependencies: 174
-- Name: Parent_id_parent_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "Parent_id_parent_seq" OWNED BY "Parent".id_parent;


--
-- TOC entry 179 (class 1259 OID 24618)
-- Name: Professeur; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Professeur" (
    id_prof integer NOT NULL,
    mdp integer NOT NULL,
    nom character(20) NOT NULL,
    prenom character(20) NOT NULL
);


--
-- TOC entry 178 (class 1259 OID 24616)
-- Name: Professeur_id_prof_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "Professeur_id_prof_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000000
    CACHE 1;


--
-- TOC entry 2032 (class 0 OID 0)
-- Dependencies: 178
-- Name: Professeur_id_prof_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "Professeur_id_prof_seq" OWNED BY "Professeur".id_prof;


SET default_with_oids = false;

--
-- TOC entry 184 (class 1259 OID 24640)
-- Name: Relation_Classe_Prof_Mat; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Relation_Classe_Prof_Mat" (
    id_r_c_p_m integer NOT NULL,
    id_r_p_m integer NOT NULL,
    id_classe integer NOT NULL
);


--
-- TOC entry 183 (class 1259 OID 24634)
-- Name: Relation_Prof_Mat; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Relation_Prof_Mat" (
    id_r_p_m integer NOT NULL,
    id_prof integer NOT NULL,
    id_mat integer NOT NULL
);


--
-- TOC entry 182 (class 1259 OID 24632)
-- Name: Relation_Prof_Mat_id_r_p_m_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "Relation_Prof_Mat_id_r_p_m_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2033 (class 0 OID 0)
-- Dependencies: 182
-- Name: Relation_Prof_Mat_id_r_p_m_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "Relation_Prof_Mat_id_r_p_m_seq" OWNED BY "Relation_Prof_Mat".id_r_p_m;


--
-- TOC entry 1865 (class 2604 OID 24581)
-- Name: id_classe; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Classe" ALTER COLUMN id_classe SET DEFAULT nextval('"Classe_id_classe_seq"'::regclass);


--
-- TOC entry 1866 (class 2604 OID 24592)
-- Name: id_eleves; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Eleves" ALTER COLUMN id_eleves SET DEFAULT nextval('"Eleves_id_eleves_seq"'::regclass);


--
-- TOC entry 1870 (class 2604 OID 24629)
-- Name: id_mat; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Matiere" ALTER COLUMN id_mat SET DEFAULT nextval('"Matiere_id_mat_seq"'::regclass);


--
-- TOC entry 1868 (class 2604 OID 24610)
-- Name: id_notes; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Notes" ALTER COLUMN id_notes SET DEFAULT nextval('"Notes_id_notes_seq"'::regclass);


--
-- TOC entry 1867 (class 2604 OID 24602)
-- Name: id_parent; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Parent" ALTER COLUMN id_parent SET DEFAULT nextval('"Parent_id_parent_seq"'::regclass);


--
-- TOC entry 1869 (class 2604 OID 24621)
-- Name: id_prof; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Professeur" ALTER COLUMN id_prof SET DEFAULT nextval('"Professeur_id_prof_seq"'::regclass);


--
-- TOC entry 1871 (class 2604 OID 24637)
-- Name: id_r_p_m; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Relation_Prof_Mat" ALTER COLUMN id_r_p_m SET DEFAULT nextval('"Relation_Prof_Mat_id_r_p_m_seq"'::regclass);


--
-- TOC entry 2005 (class 0 OID 24578)
-- Dependencies: 171
-- Data for Name: Classe; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "Classe" VALUES (1, 5, '4e Jaune            ');


--
-- TOC entry 2034 (class 0 OID 0)
-- Dependencies: 170
-- Name: Classe_id_classe_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"Classe_id_classe_seq"', 3, true);


--
-- TOC entry 2007 (class 0 OID 24589)
-- Dependencies: 173
-- Data for Name: Eleves; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "Eleves" VALUES (300000003, '12345678', 'BOZE                ', 'Adèle               ', '2000-04-25', '5 rue des Champs
30000 NIMES                                                                       ', 600000001, 1);


--
-- TOC entry 2035 (class 0 OID 0)
-- Dependencies: 172
-- Name: Eleves_id_eleves_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"Eleves_id_eleves_seq"', 400000000, true);


--
-- TOC entry 2015 (class 0 OID 24626)
-- Dependencies: 181
-- Data for Name: Matiere; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "Matiere" VALUES (1, 'Mathématiques       ');
INSERT INTO "Matiere" VALUES (2, 'Français            ');
INSERT INTO "Matiere" VALUES (3, 'Histoire-Géographie ');
INSERT INTO "Matiere" VALUES (4, 'EPS                 ');
INSERT INTO "Matiere" VALUES (5, 'Anglais             ');
INSERT INTO "Matiere" VALUES (6, 'Espagnol            ');
INSERT INTO "Matiere" VALUES (7, 'Allemand            ');
INSERT INTO "Matiere" VALUES (8, 'SVT                 ');
INSERT INTO "Matiere" VALUES (9, 'Sciences Physiques  ');
INSERT INTO "Matiere" VALUES (10, 'Arts plastiques     ');
INSERT INTO "Matiere" VALUES (11, 'Education Musicale  ');


--
-- TOC entry 2036 (class 0 OID 0)
-- Dependencies: 180
-- Name: Matiere_id_mat_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"Matiere_id_mat_seq"', 11, true);


--
-- TOC entry 2011 (class 0 OID 24607)
-- Dependencies: 177
-- Data for Name: Notes; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 2037 (class 0 OID 0)
-- Dependencies: 176
-- Name: Notes_id_notes_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"Notes_id_notes_seq"', 1, false);


--
-- TOC entry 2009 (class 0 OID 24599)
-- Dependencies: 175
-- Data for Name: Parent; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "Parent" VALUES (600000001, 12345678, 'BOZE                ', 'Jean                ');
INSERT INTO "Parent" VALUES (600000002, 12345678, 'CHAT                ', 'Paul                ');
INSERT INTO "Parent" VALUES (600000003, 12345678, 'CLAT                ', 'Sandrine            ');
INSERT INTO "Parent" VALUES (600000004, 12345678, 'DEI                 ', 'Mandy               ');
INSERT INTO "Parent" VALUES (600000005, 12345678, 'DHAT                ', 'François            ');
INSERT INTO "Parent" VALUES (600000006, 12345678, 'FACANCES            ', 'Antoine             ');


--
-- TOC entry 2038 (class 0 OID 0)
-- Dependencies: 174
-- Name: Parent_id_parent_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"Parent_id_parent_seq"', 600000006, true);


--
-- TOC entry 2013 (class 0 OID 24618)
-- Dependencies: 179
-- Data for Name: Professeur; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "Professeur" VALUES (2, 12345678, 'JUD                 ', 'Pomme               ');
INSERT INTO "Professeur" VALUES (3, 12345678, 'Mois                ', 'Avril               ');
INSERT INTO "Professeur" VALUES (5, 12345678, 'NATEUR              ', 'Jordy               ');


--
-- TOC entry 2039 (class 0 OID 0)
-- Dependencies: 178
-- Name: Professeur_id_prof_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"Professeur_id_prof_seq"', 5, true);


--
-- TOC entry 2018 (class 0 OID 24640)
-- Dependencies: 184
-- Data for Name: Relation_Classe_Prof_Mat; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 2017 (class 0 OID 24634)
-- Dependencies: 183
-- Data for Name: Relation_Prof_Mat; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "Relation_Prof_Mat" VALUES (1, 2, 9);
INSERT INTO "Relation_Prof_Mat" VALUES (2, 2, 8);
INSERT INTO "Relation_Prof_Mat" VALUES (3, 3, 4);
INSERT INTO "Relation_Prof_Mat" VALUES (4, 5, 5);


--
-- TOC entry 2040 (class 0 OID 0)
-- Dependencies: 182
-- Name: Relation_Prof_Mat_id_r_p_m_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"Relation_Prof_Mat_id_r_p_m_seq"', 4, true);


--
-- TOC entry 1885 (class 2606 OID 24639)
-- Name: pk_R_prof_mat; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Relation_Prof_Mat"
    ADD CONSTRAINT "pk_R_prof_mat" PRIMARY KEY (id_r_p_m);


--
-- TOC entry 1873 (class 2606 OID 24586)
-- Name: pk_classe; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Classe"
    ADD CONSTRAINT pk_classe PRIMARY KEY (id_classe);


--
-- TOC entry 1875 (class 2606 OID 24594)
-- Name: pk_eleve; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Eleves"
    ADD CONSTRAINT pk_eleve PRIMARY KEY (id_eleves);


--
-- TOC entry 1883 (class 2606 OID 24631)
-- Name: pk_mat; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Matiere"
    ADD CONSTRAINT pk_mat PRIMARY KEY (id_mat);


--
-- TOC entry 1879 (class 2606 OID 24615)
-- Name: pk_note; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Notes"
    ADD CONSTRAINT pk_note PRIMARY KEY (id_notes);


--
-- TOC entry 1877 (class 2606 OID 24604)
-- Name: pk_parent; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Parent"
    ADD CONSTRAINT pk_parent PRIMARY KEY (id_parent);


--
-- TOC entry 1881 (class 2606 OID 24623)
-- Name: pk_prof; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Professeur"
    ADD CONSTRAINT pk_prof PRIMARY KEY (id_prof);


--
-- TOC entry 1887 (class 2606 OID 24644)
-- Name: pk_r_c_p_m; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Relation_Classe_Prof_Mat"
    ADD CONSTRAINT pk_r_c_p_m PRIMARY KEY (id_r_c_p_m);


--
-- TOC entry 1890 (class 2606 OID 24655)
-- Name: fk_classe; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Eleves"
    ADD CONSTRAINT fk_classe FOREIGN KEY (id_classe) REFERENCES "Classe"(id_classe);


--
-- TOC entry 1896 (class 2606 OID 24675)
-- Name: fk_classe; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Relation_Classe_Prof_Mat"
    ADD CONSTRAINT fk_classe FOREIGN KEY (id_classe) REFERENCES "Classe"(id_classe);


--
-- TOC entry 1891 (class 2606 OID 24660)
-- Name: fk_eleve; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Notes"
    ADD CONSTRAINT fk_eleve FOREIGN KEY (id_eleve) REFERENCES "Eleves"(id_eleves);


--
-- TOC entry 1892 (class 2606 OID 24665)
-- Name: fk_mat; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Notes"
    ADD CONSTRAINT fk_mat FOREIGN KEY (id_matiere) REFERENCES "Matiere"(id_mat);


--
-- TOC entry 1894 (class 2606 OID 24685)
-- Name: fk_matiere; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Relation_Prof_Mat"
    ADD CONSTRAINT fk_matiere FOREIGN KEY (id_mat) REFERENCES "Matiere"(id_mat);


--
-- TOC entry 1889 (class 2606 OID 24650)
-- Name: fk_parent; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Eleves"
    ADD CONSTRAINT fk_parent FOREIGN KEY (id_parent) REFERENCES "Parent"(id_parent);


--
-- TOC entry 1893 (class 2606 OID 24680)
-- Name: fk_prof; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Relation_Prof_Mat"
    ADD CONSTRAINT fk_prof FOREIGN KEY (id_prof) REFERENCES "Professeur"(id_prof);


--
-- TOC entry 1888 (class 2606 OID 24645)
-- Name: fk_profprcipal; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Classe"
    ADD CONSTRAINT fk_profprcipal FOREIGN KEY (id_profprcipal) REFERENCES "Professeur"(id_prof);


--
-- TOC entry 1895 (class 2606 OID 24670)
-- Name: fk_r_p_m; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Relation_Classe_Prof_Mat"
    ADD CONSTRAINT fk_r_p_m FOREIGN KEY (id_r_p_m) REFERENCES "Relation_Prof_Mat"(id_r_p_m);


--
-- TOC entry 2025 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: -
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-05-06 11:25:46

--
-- PostgreSQL database dump complete
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.3
-- Dumped by pg_dump version 9.3.3
-- Started on 2014-05-09 10:17:11

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 178 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1996 (class 0 OID 0)
-- Dependencies: 178
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 49515)
-- Name: classe; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE classe (
    id_classe integer NOT NULL,
    id_profprcipal character(40) NOT NULL,
    nom character(20)
);


ALTER TABLE public.classe OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 49518)
-- Name: eleves; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE eleves (
    login character(40) NOT NULL,
    mdp character(8) NOT NULL,
    nom character(20) NOT NULL,
    prenom character(20) NOT NULL,
    datenaiss date,
    adresse character(100),
    id_parent character(40) NOT NULL,
    id_classe integer NOT NULL
);


ALTER TABLE public.eleves OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 49521)
-- Name: matiere; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE matiere (
    id_mat integer NOT NULL,
    nommatiere character(20) NOT NULL
);


ALTER TABLE public.matiere OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 49524)
-- Name: notes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE notes (
    id_notes integer NOT NULL,
    id_eleve character(40) NOT NULL,
    id_matiere integer NOT NULL,
    note numeric NOT NULL
);


ALTER TABLE public.notes OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 49530)
-- Name: parent; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE parent (
    login character(40) NOT NULL,
    mdp integer NOT NULL,
    nom character(20) NOT NULL,
    prenom character(20) NOT NULL,
    email character(60)
);


ALTER TABLE public.parent OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 49533)
-- Name: professeur; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE professeur (
    login character(40) NOT NULL,
    mdp integer NOT NULL,
    nom character(20) NOT NULL,
    prenom character(20) NOT NULL,
    email character(60)
);


ALTER TABLE public.professeur OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 49536)
-- Name: relation_classe_prof_mat; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE relation_classe_prof_mat (
    id_r_c_p_m integer NOT NULL,
    id_r_p_m integer NOT NULL,
    id_classe integer NOT NULL
);


ALTER TABLE public.relation_classe_prof_mat OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 49539)
-- Name: relation_prof_mat; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE relation_prof_mat (
    id_r_p_m integer NOT NULL,
    id_prof character(40) NOT NULL,
    id_mat integer NOT NULL
);


ALTER TABLE public.relation_prof_mat OWNER TO postgres;

--
-- TOC entry 1981 (class 0 OID 49515)
-- Dependencies: 170
-- Data for Name: classe; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO classe (id_classe, id_profprcipal, nom) VALUES (1, 'christel.achin                          ', '6e A                ');
INSERT INTO classe (id_classe, id_profprcipal, nom) VALUES (2, 'jeremie.amiach                          ', '6e B                ');


--
-- TOC entry 1982 (class 0 OID 49518)
-- Dependencies: 171
-- Data for Name: eleves; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('lea.catala                              ', '12345678', 'CATALA              ', 'Léa                 ', '2001-05-20', NULL, 'fanny.catala                            ', 1);
INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('karine.conta                            ', '12345678', 'CONTA               ', 'Karine              ', '2001-03-21', NULL, 'joann.conta                             ', 1);
INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('francois.cavailles                      ', '12345678', 'CAVAILLES           ', 'François            ', '2001-11-10', NULL, 'sylvain.cavailles                       ', 2);
INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('pierre.catala                           ', '12345678', 'CATALA              ', 'Pierre              ', '2000-04-01', NULL, 'fanny.catala                            ', 2);
INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('lola.guiness                            ', '12345678', 'GUINESS             ', 'Lola                ', '2001-12-14', NULL, 'penelope.guiness                        ', 1);
INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('paul.wahlberg                           ', '12345678', 'WAHLBERG            ', 'Paul                ', '2001-05-03', NULL, 'nick.wahlberg                           ', 2);
INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('nate.chase                              ', '12345678', 'CHASE               ', 'Nate                ', '2001-01-21', NULL, 'ed.chase                                ', 1);
INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('cindy.davis                             ', '12345678', 'DAVIS               ', 'Cindy               ', '2001-10-16', NULL, 'jennifer.davis                          ', 2);
INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('leonie.gida                             ', '12345678', 'GIDA                ', 'Léonie              ', '2001-02-20', NULL, 'johnny.gida                             ', 1);
INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('paul.nicholson                          ', '12345678', 'NICHOLSON           ', 'Paul                ', '2001-07-18', NULL, 'beth.nicholson                          ', 2);
INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('julien.johansson                        ', '12345678', 'JOHANSSON           ', 'Julien              ', '1999-04-28', NULL, 'mathieu.johansson                       ', 1);
INSERT INTO eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) VALUES ('sarah.nicholson                         ', '12345678', 'NICHOLSON           ', 'Sarah               ', '2000-12-24', NULL, 'beth.nicholson                          ', 2);


--
-- TOC entry 1983 (class 0 OID 49521)
-- Dependencies: 172
-- Data for Name: matiere; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO matiere (id_mat, nommatiere) VALUES (1, 'Mathématiques       ');
INSERT INTO matiere (id_mat, nommatiere) VALUES (2, 'Français            ');
INSERT INTO matiere (id_mat, nommatiere) VALUES (3, 'Histoire-Géographie ');
INSERT INTO matiere (id_mat, nommatiere) VALUES (4, 'EPS                 ');
INSERT INTO matiere (id_mat, nommatiere) VALUES (5, 'Anglais             ');
INSERT INTO matiere (id_mat, nommatiere) VALUES (6, 'Espagnol            ');
INSERT INTO matiere (id_mat, nommatiere) VALUES (7, 'Allemand            ');
INSERT INTO matiere (id_mat, nommatiere) VALUES (8, 'SVT                 ');
INSERT INTO matiere (id_mat, nommatiere) VALUES (9, 'Sciences Physiques  ');
INSERT INTO matiere (id_mat, nommatiere) VALUES (10, 'Arts plastiques     ');
INSERT INTO matiere (id_mat, nommatiere) VALUES (11, 'Education Musicale  ');


--
-- TOC entry 1984 (class 0 OID 49524)
-- Dependencies: 173
-- Data for Name: notes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (1, 'cindy.davis                             ', 1, 15);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (2, 'francois.cavailles                      ', 1, 12);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (3, 'julien.johansson                        ', 1, 9);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (4, 'karine.conta                            ', 1, 10);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (5, 'lea.catala                              ', 1, 18);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (6, 'leonie.gida                             ', 1, 16);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (7, 'lola.guiness                            ', 1, 6);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (8, 'nate.chase                              ', 1, 13.5);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (9, 'paul.nicholson                          ', 1, 19);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (10, 'paul.wahlberg                           ', 1, 14);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (11, 'pierre.catala                           ', 1, 8);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (12, 'sarah.nicholson                         ', 1, 5);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (13, 'cindy.davis                             ', 2, 16);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (14, 'francois.cavailles                      ', 2, 13);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (15, 'julien.johansson                        ', 2, 12);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (16, 'karine.conta                            ', 2, 10);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (17, 'lea.catala                              ', 2, 8);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (18, 'leonie.gida                             ', 2, 9);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (19, 'lola.guiness                            ', 2, 11);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (20, 'nate.chase                              ', 2, 14);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (21, 'paul.nicholson                          ', 2, 8);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (22, 'paul.wahlberg                           ', 2, 10);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (23, 'pierre.catala                           ', 2, 11);
INSERT INTO notes (id_notes, id_eleve, id_matiere, note) VALUES (24, 'sarah.nicholson                         ', 2, 12);


--
-- TOC entry 1985 (class 0 OID 49530)
-- Dependencies: 174
-- Data for Name: parent; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO parent (login, mdp, nom, prenom, email) VALUES ('fanny.catala                            ', 12345678, 'CATALA              ', 'Fanny               ', 'fanny.catala@mail.com                                       ');
INSERT INTO parent (login, mdp, nom, prenom, email) VALUES ('sylvain.cavailles                       ', 12345678, 'CAVAILLES           ', 'Sylvain             ', 'sylvain.cavailles@mail.com                                  ');
INSERT INTO parent (login, mdp, nom, prenom, email) VALUES ('joann.conta                             ', 12345678, 'CONTA               ', 'Joann               ', 'joann.conta@mail.com                                        ');
INSERT INTO parent (login, mdp, nom, prenom, email) VALUES ('penelope.guiness                        ', 12345678, 'GUINESS             ', 'Penelope            ', 'penelope.guiness@mail.com                                   ');
INSERT INTO parent (login, mdp, nom, prenom, email) VALUES ('nick.wahlberg                           ', 12345678, 'WAHLBERG            ', 'Nick                ', 'nwahlberg@mail.com                                          ');
INSERT INTO parent (login, mdp, nom, prenom, email) VALUES ('ed.chase                                ', 12345678, 'CHASE               ', 'Ed                  ', 'ed.chase@mail.com                                           ');
INSERT INTO parent (login, mdp, nom, prenom, email) VALUES ('jennifer.davis                          ', 12345678, 'DAVIS               ', 'Jennifer            ', 'jennifer.davis@mail.com                                     ');
INSERT INTO parent (login, mdp, nom, prenom, email) VALUES ('johnny.gida                             ', 12345678, 'GIDA                ', 'Johnny              ', 'j.gida@mail.com                                             ');
INSERT INTO parent (login, mdp, nom, prenom, email) VALUES ('beth.nicholson                          ', 12345678, 'NICHOLSON           ', 'Beth                ', 'bnicholson@mail.com                                         ');
INSERT INTO parent (login, mdp, nom, prenom, email) VALUES ('mathieu.johansson                       ', 12345678, 'JOHANSSON           ', 'Mathieu             ', 'mat.johansson@mail.com                                      ');


--
-- TOC entry 1986 (class 0 OID 49533)
-- Dependencies: 175
-- Data for Name: professeur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO professeur (login, mdp, nom, prenom, email) VALUES ('christel.achin                          ', 12345678, 'ACHIN               ', 'Christel            ', 'christel.achin@mail.com                                     ');
INSERT INTO professeur (login, mdp, nom, prenom, email) VALUES ('joelle.adler                            ', 12345678, 'ADLER               ', 'Joelle              ', 'joadler@mail.com                                            ');
INSERT INTO professeur (login, mdp, nom, prenom, email) VALUES ('jeremie.amiach                          ', 12345678, 'AMIACH              ', 'Jeremie             ', 'jeremieamiach@mail.com                                      ');
INSERT INTO professeur (login, mdp, nom, prenom, email) VALUES ('stephane.audouly                        ', 12345678, 'AUDOULY             ', 'Stephane            ', 'stephaudouly@mail.com                                       ');
INSERT INTO professeur (login, mdp, nom, prenom, email) VALUES ('jean-claude.azieau                      ', 12345678, 'AZIEAU              ', 'Jean-Claude         ', 'jcazieau@mail.com                                           ');
INSERT INTO professeur (login, mdp, nom, prenom, email) VALUES ('enying.ateba                            ', 12345678, 'ATEBA               ', 'Enying              ', 'enying.ateba@mail.com                                       ');


--
-- TOC entry 1987 (class 0 OID 49536)
-- Dependencies: 176
-- Data for Name: relation_classe_prof_mat; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO relation_classe_prof_mat (id_r_c_p_m, id_r_p_m, id_classe) VALUES (1, 1, 1);
INSERT INTO relation_classe_prof_mat (id_r_c_p_m, id_r_p_m, id_classe) VALUES (2, 3, 1);
INSERT INTO relation_classe_prof_mat (id_r_c_p_m, id_r_p_m, id_classe) VALUES (3, 2, 2);
INSERT INTO relation_classe_prof_mat (id_r_c_p_m, id_r_p_m, id_classe) VALUES (4, 4, 2);
INSERT INTO relation_classe_prof_mat (id_r_c_p_m, id_r_p_m, id_classe) VALUES (5, 1, 2);


--
-- TOC entry 1988 (class 0 OID 49539)
-- Dependencies: 177
-- Data for Name: relation_prof_mat; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO relation_prof_mat (id_r_p_m, id_prof, id_mat) VALUES (1, 'christel.achin                          ', 2);
INSERT INTO relation_prof_mat (id_r_p_m, id_prof, id_mat) VALUES (2, 'christel.achin                          ', 5);
INSERT INTO relation_prof_mat (id_r_p_m, id_prof, id_mat) VALUES (3, 'jean-claude.azieau                      ', 3);
INSERT INTO relation_prof_mat (id_r_p_m, id_prof, id_mat) VALUES (4, 'stephane.audouly                        ', 1);


--
-- TOC entry 1865 (class 2606 OID 49543)
-- Name: pk_R_prof_mat; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY relation_prof_mat
    ADD CONSTRAINT "pk_R_prof_mat" PRIMARY KEY (id_r_p_m);


--
-- TOC entry 1851 (class 2606 OID 49545)
-- Name: pk_classe; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY classe
    ADD CONSTRAINT pk_classe PRIMARY KEY (id_classe);


--
-- TOC entry 1853 (class 2606 OID 49547)
-- Name: pk_eleve; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY eleves
    ADD CONSTRAINT pk_eleve PRIMARY KEY (login);


--
-- TOC entry 1855 (class 2606 OID 49549)
-- Name: pk_mat; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY matiere
    ADD CONSTRAINT pk_mat PRIMARY KEY (id_mat);


--
-- TOC entry 1857 (class 2606 OID 57489)
-- Name: pk_note; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY notes
    ADD CONSTRAINT pk_note PRIMARY KEY (id_notes);


--
-- TOC entry 1859 (class 2606 OID 49553)
-- Name: pk_parent; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parent
    ADD CONSTRAINT pk_parent PRIMARY KEY (login);


--
-- TOC entry 1861 (class 2606 OID 49555)
-- Name: pk_prof; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY professeur
    ADD CONSTRAINT pk_prof PRIMARY KEY (login);


--
-- TOC entry 1863 (class 2606 OID 49557)
-- Name: pk_r_c_p_m; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY relation_classe_prof_mat
    ADD CONSTRAINT pk_r_c_p_m PRIMARY KEY (id_r_c_p_m);


--
-- TOC entry 1867 (class 2606 OID 49558)
-- Name: fk_classe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY eleves
    ADD CONSTRAINT fk_classe FOREIGN KEY (id_classe) REFERENCES classe(id_classe);


--
-- TOC entry 1870 (class 2606 OID 49563)
-- Name: fk_classe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relation_classe_prof_mat
    ADD CONSTRAINT fk_classe FOREIGN KEY (id_classe) REFERENCES classe(id_classe);


--
-- TOC entry 1869 (class 2606 OID 49568)
-- Name: fk_mat; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY notes
    ADD CONSTRAINT fk_mat FOREIGN KEY (id_matiere) REFERENCES matiere(id_mat);


--
-- TOC entry 1872 (class 2606 OID 49573)
-- Name: fk_matiere; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relation_prof_mat
    ADD CONSTRAINT fk_matiere FOREIGN KEY (id_mat) REFERENCES matiere(id_mat);


--
-- TOC entry 1868 (class 2606 OID 49578)
-- Name: fk_parent; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY eleves
    ADD CONSTRAINT fk_parent FOREIGN KEY (id_parent) REFERENCES parent(login);


--
-- TOC entry 1873 (class 2606 OID 49583)
-- Name: fk_prof; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relation_prof_mat
    ADD CONSTRAINT fk_prof FOREIGN KEY (id_prof) REFERENCES professeur(login);


--
-- TOC entry 1866 (class 2606 OID 49588)
-- Name: fk_profprincipal; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY classe
    ADD CONSTRAINT fk_profprincipal FOREIGN KEY (id_profprcipal) REFERENCES professeur(login);


--
-- TOC entry 1871 (class 2606 OID 49593)
-- Name: fk_r_p_m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relation_classe_prof_mat
    ADD CONSTRAINT fk_r_p_m FOREIGN KEY (id_r_p_m) REFERENCES relation_prof_mat(id_r_p_m);


--
-- TOC entry 1995 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-05-09 10:17:12

--
-- PostgreSQL database dump complete
--


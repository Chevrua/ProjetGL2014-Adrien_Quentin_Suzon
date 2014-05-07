--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.3
-- Dumped by pg_dump version 9.3.3
-- Started on 2014-05-07 15:53:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
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

COPY classe (id_classe, id_profprcipal, nom) FROM stdin;
\.


--
-- TOC entry 1982 (class 0 OID 49518)
-- Dependencies: 171
-- Data for Name: eleves; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY eleves (login, mdp, nom, prenom, datenaiss, adresse, id_parent, id_classe) FROM stdin;
\.


--
-- TOC entry 1983 (class 0 OID 49521)
-- Dependencies: 172
-- Data for Name: matiere; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY matiere (id_mat, nommatiere) FROM stdin;
\.


--
-- TOC entry 1984 (class 0 OID 49524)
-- Dependencies: 173
-- Data for Name: notes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY notes (id_notes, id_eleve, id_matiere, note) FROM stdin;
\.


--
-- TOC entry 1985 (class 0 OID 49530)
-- Dependencies: 174
-- Data for Name: parent; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY parent (login, mdp, nom, prenom, email) FROM stdin;
fanny.catala                            	12345678	CATALA              	Fanny               	fanny.catala@mail.com                                       
sylvain.cavailles                       	12345678	CAVAILLES           	Sylvain             	sylvain.cavailles@mail.com                                  
joann.conta                             	12345678	CONTA               	Joann               	joann.conta@mail.com                                        
\.


--
-- TOC entry 1986 (class 0 OID 49533)
-- Dependencies: 175
-- Data for Name: professeur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY professeur (login, mdp, nom, prenom, email) FROM stdin;
christel.achin                          	12345678	ACHIN               	Christel            	christel.achin@mail.com                                     
joelle.adler                            	12345678	ADLER               	Joelle              	joadler@mail.com                                            
jeremie.amiach                          	12345678	AMIACH              	Jeremie             	jeremieamiach@mail.com                                      
stephane.audouly                        	12345678	AUDOULY             	Stephane            	stephaudouly@mail.com                                       
jean-claude.azieau                      	12345678	AZIEAU              	Jean-Claude         	jcazieau@mail.com                                           
enying.ateba                            	12345678	ATEBA               	Enying              	enying.ateba@mail.com                                       
\.


--
-- TOC entry 1987 (class 0 OID 49536)
-- Dependencies: 176
-- Data for Name: relation_classe_prof_mat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY relation_classe_prof_mat (id_r_c_p_m, id_r_p_m, id_classe) FROM stdin;
\.


--
-- TOC entry 1988 (class 0 OID 49539)
-- Dependencies: 177
-- Data for Name: relation_prof_mat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY relation_prof_mat (id_r_p_m, id_prof, id_mat) FROM stdin;
\.


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
-- TOC entry 1857 (class 2606 OID 49551)
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


-- Completed on 2014-05-07 15:53:03

--
-- PostgreSQL database dump complete
--


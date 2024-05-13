insert  into Category values (1, 'Front-End'), (2, 'Back-end'), (3, 'Banco de Dados'),(4, 'Gestão de Projetos'), (5, 'Programação');

insert into Category values(7,'Java');
insert into Category values(8,'Web');
insert into Category values(11,'Angular');
insert into Category values(9,'Spring Boot');
insert into Category values(10,'Spring Security');

 insert into videos (videoid, videotitle, categoryid, videothumb) values ('c34zylllg3Y',	'Phyton para iniciantes', 1, '../../../assets/img/python.jpg');
 insert into videos (videoid, videotitle, categoryid, videothumb) values ('c3szylllg3Y',	'Phyton para iniciantes', 1, '../../../assets/img/python.jpg');
 insert into videos (videoid, videotitle, categoryid, videothumb) values ('cbszylllg3Y', 'Phyton para iniciantes', 2, '../../../assets/img/python.jpg');
 insert into videos (videoid, videotitle, categoryid, videothumb) values ('K2py5U8aseU', 'Introdução ao SQL', 1, '../../../assets/img/sql.jpg');
 insert into videos (videoid, videotitle, categoryid, videothumb) values ('K24y5U8aseU', 'Introdução ao SQL', 1, '../../../assets/img/sql.jpg');
 insert into videos (videoid, videotitle, categoryid, videothumb) values ('q537MQk3B7Q', 'Fundamentos do HTML5', 1, '../../../assets/img/html.jpg');
 insert into videos (videoid, videotitle, categoryid, videothumb) values ('q5f7MQk3B7Q', 'Fundamentos do HTML5', 1, '../../../assets/img/html.jpg');
 insert into videos (videoid, videotitle, categoryid, videothumb) values ('KOpy5U8aseU', 'Introdução ao SQL', 3, '../../../assets/img/sql.jpg');
 insert into videos (videoid, videotitle, categoryid, videothumb) values ('q4f7MQk3B7Q', 'Fundamentos do HTML5', 1, '../../../assets/img/html.jpg');
 insert into videos (videoid, videotitle, categoryid, videothumb) values ('q2f7MQk3B7Q', 'Fundamentos do HTML5', 1 , '../../../assets/img/html.jpg');
 insert into videos (videoid, videotitle, categoryid, videothumb) values ('q9f7MQk3B7Q', 'Fundamentos do HTML5', 1, '../../../assets/img/html.jpg');

 insert into roles (roleid, rolename) values ('CO1','USER'), ('CO2','Company');


INSERT INTO tests (testid, testtitle, testdescriptionlong, testdescriptionshort) VALUES ('J01', 'Java Básico', 'Este teste avalia conhecimentos básicos de programação em Java.', 'Conhecimentos básicos de Java');
INSERT INTO tests (testid, testtitle, testdescriptionlong, testdescriptionshort) VALUES ('J02', 'Java POO', 'Este teste avalia conhecimentos de Programação Orientada a Objetos em Java.', 'POO em Java');
INSERT INTO tests (testid, testtitle, testdescriptionlong, testdescriptionshort) VALUES ('J03', 'Java Collections', 'Este teste avalia conhecimentos sobre estruturas de dados e coleções em Java.', 'Coleções em Java');
INSERT INTO tests (testid, testtitle, testdescriptionlong, testdescriptionshort) VALUES ('W01', 'Fundamentos Web', 'Este teste avalia conhecimentos básicos sobre desenvolvimento web.', 'Fundamentos do desenvolvimento web');
INSERT INTO tests (testid, testtitle, testdescriptionlong, testdescriptionshort) VALUES ('W02', 'HTML & CSS', 'Este teste avalia conhecimentos sobre HTML e CSS para desenvolvimento web.', 'HTML e CSS para web');
INSERT INTO tests (testid, testtitle, testdescriptionlong, testdescriptionshort) VALUES ('SB01', 'Introdução ao Spring Boot', 'Este teste avalia conhecimentos introdutórios sobre o framework Spring Boot.', 'Introdução ao Spring Boot');
INSERT INTO tests (testid, testtitle, testdescriptionlong, testdescriptionshort) VALUES ('SB02', 'Spring Boot Avançado', 'Este teste avalia conhecimentos avançados sobre o framework Spring Boot.', 'Conhecimentos avançados sobre Spring Boot');
INSERT INTO tests (testid, testtitle, testdescriptionlong, testdescriptionshort) VALUES ('SS01', 'Introdução ao Spring Security', 'Este teste avalia conhecimentos introdutórios sobre o framework Spring Security.', 'Introdução ao Spring Security');
INSERT INTO tests (testid, testtitle, testdescriptionlong, testdescriptionshort) VALUES ('SS02', 'Autenticação com Spring Security', 'Este teste avalia conhecimentos sobre autenticação com Spring Security.', 'Autenticação com Spring Security');
INSERT INTO tests (testid, testtitle, testdescriptionlong, testdescriptionshort) VALUES ('A01', 'Introdução ao Angular', 'Este teste avalia conhecimentos introdutórios sobre o framework Angular.', 'Introdução ao Angular');
INSERT INTO tests (testid, testtitle, testdescriptionlong, testdescriptionshort) VALUES ('A02', 'Componentes Angular', 'Este teste avalia conhecimentos sobre componentes no framework Angular.', 'Componentes no Angular');


INSERT INTO testscategory (categoryid, testid) VALUES (7, 'J01');
INSERT INTO testscategory (categoryid, testid) VALUES (7, 'J02');
INSERT INTO testscategory (categoryid, testid) VALUES (7, 'J03');
INSERT INTO testscategory (categoryid, testid) VALUES (8, 'W01');
INSERT INTO testscategory (categoryid, testid) VALUES (8, 'W02');
INSERT INTO testscategory (categoryid, testid) VALUES (9, 'SB01');
INSERT INTO testscategory (categoryid, testid) VALUES (9, 'SB02');
INSERT INTO testscategory (categoryid, testid) VALUES (10, 'SS01');
INSERT INTO testscategory (categoryid, testid) VALUES (10, 'SS02');
INSERT INTO testscategory (categoryid, testid) VALUES (11, 'A01');
INSERT INTO testscategory (categoryid, testid) VALUES (11, 'A02');

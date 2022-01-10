# ProyectoDesafio
Este es un proyecto que se enfoca en resolver unas preguntas, si son respondidas correctamente obtienes dinero virtual. Hace parte de Sofka University 
El proyecto está creado usando las tecnologias: 



* En el backend: Java (Spring boot)

* En el FrontEnd: JavaScript (HTML, Boostrap CDN y Javascript)

* Base de datos: MYSQL

* Persistencia: JPA y ORM Hibernate 
* Maven para la gestion de dependencias

* Server Apache tomcat.
* Puerto en el que corre : 8080

Proyecto basado en API REST. 

SQL: 

create database dbdesafio; 
use dbdesafio; 

create table categoria(id_categoria int not null primary key auto_increment,
 nombre_categoria varchar(70),
 complejidad int(10)); 
 
 
create table premio (id_premio int not null primary key auto_increment,
 nombre_premio varchar(70), 
 valor decimal(20,0)); 
 
 

create table ronda(id_ronda int not null primary key auto_increment, 
nombre_ronda varchar(70),
 categoria int not null,
 foreign key (categoria) references categoria(id_categoria),
 premio int not null, 
 foreign key (premio) references premio(id_premio)); 
 
 
 create table pregunta(id_pregunta int not null primary key auto_increment,
 descripcion text, 
 ronda int not null, 
 foreign key (ronda) references ronda(id_ronda)); 
 
 
 create table opcion(id_opcion int not null primary key auto_increment, 
 descripcion text,
 tipo_opcion tinyint,
 pregunta int not null, 
 foreign key (pregunta) references pregunta(id_pregunta)); 
 
 
 create table jugador(id_jugador int not null primary key auto_increment, 
 nombre varchar(70), 
 apellido varchar(70), 
 genero varchar(30)); 
 
 
 create table historial(id_historial int not null primary key auto_increment, 
 jugador int not null, 
 foreign key (jugador) references jugador(id_jugador), 
 ronda int not null,
 foreign key (ronda) references ronda(id_ronda),
 fecha datetime, 
 ganador tinyint ); 
 


-- insertamos las categorias 

insert into categoria values (1,"muy facil",10); 
insert into categoria values (2,"facil",20); 
insert into categoria values (3,"normal",30); 
insert into categoria values (4,"dificil",40);
insert into categoria values (5,"muy dificil",50);


-- insertamos los premios 
insert into premio values(1,"bono minimo",5000);
insert into premio values(2,"bono regular", 10000); 
insert into premio values(3, "bono magico", 20000); 
insert into premio values(4,"bono especial", 50000); 
insert into premio values(5, "bono campeon", 80000); 

-- insertamos las rondas 
insert into ronda values (1,"conocimiento basico", 1,1); 
insert into ronda values (2, "conocimiento regular", 2, 2); 
insert into ronda values (3, "conocimiento esencial", 3, 3); 
insert into ronda values (4, "conocimiento trascendental", 4,4); 
insert into ronda values (5, "master del conocimiento", 5, 5); 


* Modelado (MER): 

![Sin título-2022-01-10-0114](https://user-images.githubusercontent.com/37675138/148727197-2ac6f062-1f84-494c-b9e8-bff3ba33eed0.png)

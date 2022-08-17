drop table if exists reservas;
drop table if exists investigadores;
drop table if exists equipos;
drop table if exists facultades;

create table facultades(
	codigo int auto_increment,
    nombre varchar(100),
    primary key(codigo)
);

create table equipos(
	num_serie char(4),
    nombre varchar(100),
    codigo_facultad int not null,
    primary key(num_serie),
    constraint fk_facultades_equipos foreign key (codigo_facultad)
    references facultades(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

create table investigadores(
	dni varchar(8),
    nom_apels varchar(255),
    codigo_facultad int not null,
    primary key(dni),
	constraint fk_facultades_investigadores foreign key (codigo_facultad)
    references facultades(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

create table reservas(
	id int auto_increment,
	codigo_equipos char(4) not null,
	codigo_investigadores varchar(8) not null,
    primary key(id),
    constraint fk_equipos_reservas foreign key (codigo_equipos)
    references equipos(num_serie) ON DELETE CASCADE ON UPDATE CASCADE,
    constraint fk_investigadores_reservas foreign key (codigo_investigadores)
    references investigadores(dni) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into facultades(nombre)values ('facultad1'),('facultad2'),('facultad3'),('facultad4'),('facultad5');
insert into investigadores(dni,nom_apels,codigo_facultad)values ('12345678','investigador1',1),('23456781','investigador2',1),('34567812','investigador3',2),('45678123','investigador4',3),('56781234','investigador5',5);
insert into equipos(num_serie,nombre,codigo_facultad)values ('EQ01','equipo1',1),('EQ02','equipo2',2),('EQ03','equipo3',3),('EQ04','equipo4',3),('EQ05','equipo5',5);
insert into reservas(codigo_investigadores,codigo_equipos)values ('12345678','EQ01'),('45678123','EQ03'),('23456781','EQ04'),('34567812','EQ05'),('56781234','EQ02');
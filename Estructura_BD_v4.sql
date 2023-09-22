CREATE SCHEMA dbtpint ;

USE dbtpint ;

create table Generos (
ID int primary key not null auto_increment unique,
Sexo varchar(50) not null
) ENGINE=INNODB;

create table Nacionalidades (
ID int primary key not null auto_increment unique,
Nacionalidad varchar(50) not null
) ENGINE=INNODB;

create table Provincias (
ID bigint primary key not null auto_increment unique,
Provincia varchar(50) not null
) ENGINE=INNODB;

create table Localidades (
	ID bigint primary key not null auto_increment unique,
	Id_provincia bigint not null,
	Localidad varchar(50) not null,
	foreign key (Id_provincia) references Provincias(ID)
) ENGINE=INNODB;

create table Estado_turno (
	ID bigint primary key not null auto_increment unique,
	Estado varchar(50) not null
) ENGINE=INNODB;

create table Especialidades (
	ID bigint primary key not null auto_increment unique,
	Especialidad varchar(50) not null
) ENGINE=INNODB;

create table Tipo_persona (
	ID bigint primary key not null auto_increment unique,
	Tipo varchar(50) not null
) ENGINE=INNODB;

create table Personas (
DNI bigint primary key not null unique,
Nombre varchar(50) not null,
Apellido varchar(50) not null,
FechaNacimiento date not null,
Direccion nvarchar (100) not null,
Email nvarchar (100)not null,
Telefono bigint not null,
Id_genero int not null,
Id_nacionalidad int not null,
Id_localidad bigint not null,
Id_tipo_persona bigint not null,
Id_especialidad bigint not null,
Estado bit not null,
foreign key (Id_especialidad) references Especialidades(ID),
foreign key (Id_localidad) references Localidades(ID),
foreign key (Id_genero) references Generos(ID),
foreign key (Id_tipo_persona) references Tipo_persona(ID),
foreign key (Id_nacionalidad) references Nacionalidades(ID)
) ENGINE=INNODB;

create table Usuario (
	DNI bigint primary key not null unique,
    nombre_usuario varchar(50) not null unique,
	Contrasenia nvarchar(100) not null,
	Estado bit not null,
    foreign key (DNI) references Personas(DNI)
) ENGINE=INNODB;

create table Turnos (
ID bigint primary key not null auto_increment unique,
Id_estado bigint not null,
DNI_medico bigint not null,
DNI_paciente bigint not null,
Horario float not null,
Observaciones nvarchar (100) not null,
Fecha date not null,
foreign key (Id_estado) references Estado_turno(ID),
foreign key (DNI_medico) references Personas(DNI),
foreign key (DNI_paciente) references Personas(DNI)
) ENGINE=INNODB;

create table Dias (
	ID bigint primary key not null auto_increment unique,
	Dia varchar(50) not null
) ENGINE=INNODB;

create table Disponibilidad (
ID bigint primary key not null auto_increment unique,
Id_dia bigint not null,
DNI_medico bigint not null,
Horario_entrada float not null,
Horario_salida float not null,
foreign key (Id_dia) references Dias(ID),
foreign key (DNI_medico) references Personas(DNI)
) ENGINE=INNODB;
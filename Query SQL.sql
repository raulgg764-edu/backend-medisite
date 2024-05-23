CREATE DATABASE medisite;
USE medisite;

CREATE TABLE medico(id INT IDENTITY PRIMARY KEY,
cedulaProfesional VARCHAR(8) NOT NULL,
nombres VARCHAR(50) NOT NULL,
apellidoP VARCHAR(30) NOT NULL,
apellidoM VARCHAR(30),
fechaNacimiento date NOT NULL,
telefono VARCHAR(20),
id_especialidad INT NOT NULL
);

DROP TABLE paciente;

CREATE TABLE paciente(id INT IDENTITY PRIMARY KEY,
nombres VARCHAR(50) NOT NULL,
apellidoP VARCHAR(30) NOT NULL,
apellidoM VARCHAR(30),
fechaNacimiento date NOT NULL,
telefono VARCHAR(20),
emailPersonal VARCHAR(80),
id_usuario INT NOT NULL,
FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

ALTER TABLE paciente ADD id_usuario int,
 FOREIGN KEY (id_usuario) REFERENCES usuario(id)

CREATE TABLE citas(id INT IDENTITY PRIMARY KEY,
fecha date NOT NULL,
horaInicio time NOT NULL,
horaFin time NOT NULL,
id_paciente INT NOT NULL,
id_medico INT NOT NULL,
estado VARCHAR(20)
);

CREATE TABLE especialidades(id INT IDENTITY PRIMARY KEY,
nombreEspecialidad VARCHAR(60) NOT NULL
);

CREATE TABLE ciudad(id INT IDENTITY PRIMARY KEY,
nombreCiudad VARCHAR(40));

CREATE TABLE consultorioMedico(id INT IDENTITY PRIMARY KEY,
calle VARCHAR(40) NOT NULL,
numExterior VARCHAR(6) NOT NULL,
numInterior VARCHAR(6),
colonia VARCHAR(40) NOT NULL,
id_ciudad INT NOT NULL,
estado VARCHAR(40) NOT NULL,
pais VARCHAR(40) NOT NULL,
cp VARCHAR(5) NOT NULL,
id_medico INT NOT NULL,
FOREIGN KEY (id_medico) REFERENCES medico(id),
FOREIGN KEY (id_ciudad) REFERENCES ciudad(id)
);

CREATE TABLE turnoMedico(id INT IDENTITY PRIMARY KEY,
id_medico INT NOT NULL,
diasTurno VARCHAR(7) NOT NULL,
inicioTurno time NOT NULL,
finTurno time NOT NULL
);

CREATE TABLE usuario(id INT IDENTITY PRIMARY KEY,
email VARCHAR(100) NOT NULL,
contrasena VARCHAR(100) NOT NULL,
rol VARCHAR(10) NOT NULL
);



INSERT INTO ciudad(nombreCiudad) VALUES ('Monterrey');
INSERT INTO ciudad(nombreCiudad) VALUES ('Mazatlan');
INSERT INTO ciudad(nombreCiudad) VALUES ('Cancún');
INSERT INTO ciudad(nombreCiudad) VALUES ('Tijuana');
INSERT INTO ciudad(nombreCiudad) VALUES ('Saltillo');


SELECT * from medico;

insert into consultorioMedico (calle, numexterior, numinterior, colonia, id_ciudad, estado, pais, cp, id_medico) values ('Dunning', '9', '8968', 'Armistice', 1, 'Nuevo León', 'México', '90189', 1);
insert into consultorioMedico (calle, numexterior, numinterior, colonia, id_ciudad, estado, pais, cp, id_medico) values ('Northfield', '43', '92497', 'Banding', 2, 'Sinaloa', 'México', '85010', 2);
insert into consultorioMedico (calle, numexterior, numinterior, colonia, id_ciudad, estado, pais, cp, id_medico) values ('Oakridge', '47199', '6549', 'Coolidge', 3, 'Quintana Roo', 'México', '80951', 3);
insert into consultorioMedico (calle, numexterior, numinterior, colonia, id_ciudad, estado, pais, cp, id_medico) values ('Forest Run', '0221', '13972', 'Bunting', 4, 'Baja California', 'México', '32919', 4);
insert into consultorioMedico (calle, numexterior, numinterior, colonia, id_ciudad, estado, pais, cp, id_medico) values ('Hagan', '9753', '8255', 'Golf Course', 5, 'Durango', 'México', '80223', 5);


SELECT * from consultorioMedico;

INSERT INTO turnoMedico(id_medico,diasTurno, inicioTurno, finTurno) VALUES (1,'1111110','07:00','20:00');
INSERT INTO turnoMedico(id_medico,diasTurno, inicioTurno, finTurno) VALUES (2,'1111100','13:00','13:00');
INSERT INTO turnoMedico(id_medico,diasTurno, inicioTurno, finTurno) VALUES (3,'0000010','07:00','09:00');


SELECT * from turnoMedico WHERE '06:00' < finTurno AND '20:00' > inicioTurno;

SELECT m.* FROM Medico m WHERE m.id_especialidad IS NULL OR m.id_especialidad= 1

insert into paciente (nombres, apellidop, apellidom, fechanacimiento, telefono, emailpersonal) values ('Janifer', 'Redsull', 'Dumphry', '1951-01-17', '3627519209', 'jdumphry0@shutterfly.com');
insert into paciente (nombres, apellidop, apellidom, fechanacimiento, telefono, emailpersonal) values ('Julie', 'Stow', 'Friary', '1947-09-27', '8786569799', 'jfriary1@hp.com');
insert into paciente (nombres, apellidop, apellidom, fechanacimiento, telefono, emailpersonal) values ('Esmaria', 'Moyle', 'Fills', '1940-06-28', '2449199265', 'efills2@unblog.fr');
insert into paciente (nombres, apellidop, apellidom, fechanacimiento, telefono, emailpersonal) values ('Valeria', 'Habble', 'Charlin', '1965-07-25', '1122120029', 'vcharlin3@mayoclinic.com');
insert into paciente (nombres, apellidop, apellidom, fechanacimiento, telefono, emailpersonal) values ('Reggie', 'Dohrmann', 'Lowth', '2016-07-31', '2076692686', 'rlowth4@dyndns.org');
insert into paciente (nombres, apellidop, apellidom, fechanacimiento, telefono, emailpersonal) values ('Glynn', 'Rotter', 'Diss', '1999-06-03', '2315154690', 'gdiss5@mapy.cz');
insert into paciente (nombres, apellidop, apellidom, fechanacimiento, telefono, emailpersonal) values ('Tymothy', 'Ascough', 'Vasiljevic', '1979-05-15', '4896866682', 'tvasiljevic6@vimeo.com');
insert into paciente (nombres, apellidop, apellidom, fechanacimiento, telefono, emailpersonal) values ('Bud', 'Newvill', 'Danels', '1953-04-20', '2211345439', 'bdanels7@cam.ac.uk');
insert into paciente (nombres, apellidop, apellidom, fechanacimiento, telefono, emailpersonal) values ('Elmer', 'Riggoll', 'De Filippis', '1995-06-16', '1868048724', 'edefilippis8@vinaora.com');
insert into paciente (nombres, apellidop, apellidom, fechanacimiento, telefono, emailpersonal) values ('Erminia', 'Stapforth', 'Simkovich', '1941-01-24', '4242189605', 'esimkovich9@census.gov');


SELECT * FROM citas;

SELECT * FROM paciente;
SELECT * FROM usuario;
SELECT * FROM turnoMedico;
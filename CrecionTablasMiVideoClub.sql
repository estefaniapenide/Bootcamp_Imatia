
CREATE TABLE PELICULAS(
ID_PELICULA INTEGER IDENTITY NOT NULL PRIMARY KEY,
PELICULA_TITULO VARCHAR(250),
PELICULA_PRECIO DECIMAL(4,2),
PELICULA_DISPONIBILIDAD BIT
);

CREATE TABLE ACTORES(
ID_ACTOR INTEGER IDENTITY NOT NULL PRIMARY KEY,
ACTOR_NOMBRE VARCHAR(50),
ACTOR_APELLIDOS VARCHAR(50)
);

CREATE TABLE PELICULAS_ACTORES(
ID_PELICULA INTEGER NOT NULL,
ID_ACTOR INTEGER NOT NULL,
PRIMARY KEY(ID_PELICULA,ID_ACTOR),
FOREIGN KEY (ID_PELICULA) REFERENCES PUBLIC.PELICULAS(ID_PELICULA),
FOREIGN KEY (ID_ACTOR) REFERENCES PUBLIC.ACTORES(ID_ACTOR)
);

CREATE TABLE DIRECTORES(
ID_DIRECTOR INTEGER IDENTITY NOT NULL PRIMARY KEY,
DIRECTOR_NOMBRE VARCHAR(50),
DIRECTOR_APELLIDOS VARCHAR(50)
);

CREATE TABLE PELICULAS_DIRECTORES(
ID_PELICULA INTEGER NOT NULL,
ID_DIRECTOR INTEGER NOT NULL,
PRIMARY KEY(ID_PELICULA,ID_DIRECTOR),
FOREIGN KEY (ID_PELICULA) REFERENCES PUBLIC.PELICULAS(ID_PELICULA),
FOREIGN KEY (ID_DIRECTOR) REFERENCES PUBLIC.DIRECTORES(ID_DIRECTOR)
);

CREATE TABLE NACIONALIDADES(
ID_NACIONALIDAD INTEGER IDENTITY NOT NULL PRIMARY KEY,
NACIONALIDAD VARCHAR(50)
);

CREATE TABLE PELICULAS_NACIONALIDADES(
ID_PELICULA INTEGER NOT NULL,
ID_NACIONALIDAD INTEGER NOT NULL,
PRIMARY KEY(ID_PELICULA,ID_NACIONALIDAD),
FOREIGN KEY (ID_PELICULA) REFERENCES PUBLIC.PELICULAS(ID_PELICULA),
FOREIGN KEY (ID_NACIONALIDAD) REFERENCES PUBLIC.NACIONALIDADES(ID_NACIONALIDAD)
);

CREATE TABLE GENEROS(
ID_GENERO INTEGER IDENTITY NOT NULL PRIMARY KEY,
GENERO VARCHAR(50)
);

CREATE TABLE PELICULAS_GENEROS(
ID_PELICULA INTEGER NOT NULL,
ID_GENERO INTEGER NOT NULL,
PRIMARY KEY(ID_PELICULA,ID_GENERO),
FOREIGN KEY (ID_PELICULA) REFERENCES PUBLIC.PELICULAS(ID_PELICULA),
FOREIGN KEY (ID_GENERO) REFERENCES PUBLIC.GENEROS(ID_GENERO)
);

CREATE TABLE ESTUDIOS(
ID_ESTUDIO INTEGER IDENTITY NOT NULL PRIMARY KEY,
ESTUDIO_NOMBRE VARCHAR(50)
);

CREATE TABLE PELICULAS_ESTUDIOS(
ID_PELICULA INTEGER NOT NULL,
ID_ESTUDIO INTEGER NOT NULL,
PRIMARY KEY(ID_PELICULA,ID_ESTUDIO),
FOREIGN KEY (ID_PELICULA) REFERENCES PUBLIC.PELICULAS(ID_PELICULA),
FOREIGN KEY (ID_ESTUDIO) REFERENCES PUBLIC.ESTUDIOS(ID_ESTUDIO)
);

CREATE TABLE PREMIOS(
ID_PREMIO INTEGER IDENTITY NOT NULL PRIMARY KEY,
ID_GANADOR INTEGER,
PREMIO_NOMBRE VARCHAR(50),
PREMIO_CATEGORIA VARCHAR(50),
PREMIO_YEAR INTEGER,
FOREIGN KEY (ID_GANADOR) REFERENCES PUBLIC.PELICULAS(ID_PELICULA)
);

CREATE TABLE NOMINADOS(
ID_PELICULA INTEGER NOT NULL,
ID_PREMIO INTEGER NOT NULL,
PRIMARY KEY(ID_PELICULA,ID_PREMIO),
FOREIGN KEY (ID_PELICULA) REFERENCES PUBLIC.PELICULAS(ID_PELICULA),
FOREIGN KEY (ID_PREMIO) REFERENCES PUBLIC.PREMIOS(ID_PREMIO)
);

CREATE TABLE SOCIOS(
ID_SOCIO INTEGER IDENTITY NOT NULL PRIMARY KEY,
DNI VARCHAR(50) UNIQUE NOT NULL,
SOCIO_NOMBRE VARCHAR(50),
SOCIO_APELLIDOS VARCHAR(50),
SOCIO_DIRECCION VARCHAR(50),
SOCIO_MULTA DECIMAL(4,2)
);

CREATE TABLE ALQUILERES(
ID_PELICULA INTEGER NOT NULL,
ID_SOCIO INTEGER NOT NULL,
FECHA_PRESTAMO_DESDE DATE NOT NULL,
FECHA_PRESTAMO_HASTA DATE,
FECHA_DEVOLUCION DATE,
PRIMARY KEY(ID_PELICULA,ID_SOCIO, FECHA_PRESTAMO_DESDE),
FOREIGN KEY (ID_PELICULA) REFERENCES PUBLIC.PELICULAS(ID_PELICULA),
FOREIGN KEY (ID_SOCIO) REFERENCES PUBLIC.SOCIOS(ID_SOCIO)
);




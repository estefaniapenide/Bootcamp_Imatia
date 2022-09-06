INSERT INTO PUBLIC.PELICULAS (ID_PELICULA, PELICULA_TITULO, PELICULA_PRECIO, PELICULA_DISPONIBILIDAD) VALUES (1,'El laberinto del Fauno',2.5,1);
INSERT INTO PUBLIC.PELICULAS (ID_PELICULA, PELICULA_TITULO, PELICULA_PRECIO, PELICULA_DISPONIBILIDAD) VALUES (2,'EX-MACHINA',2.5,0);

INSERT INTO PUBLIC.PELICULAS (PELICULA_TITULO, PELICULA_PRECIO, PELICULA_DISPONIBILIDAD) VALUES ('El rey le�n',2.5,1);

INSERT INTO PUBLIC.SOCIOS (ID_SOCIO, DNI ,SOCIO_NOMBRE, SOCIO_APELLIDOS) VALUES (1,'00644051M','Juan','P�rez L�pez');
INSERT INTO PUBLIC.SOCIOS (ID_SOCIO, DNI ,SOCIO_NOMBRE, SOCIO_APELLIDOS) VALUES (2,'19393426X','Paula','Rodriguez Pena');

INSERT INTO PUBLIC.ACTORES (ID_ACTOR, ACTOR_NOMBRE, ACTOR_APELLIDOS) VALUES (1,'Maribel','Verd�');
INSERT INTO PUBLIC.ACTORES (ID_ACTOR, ACTOR_NOMBRE, ACTOR_APELLIDOS) VALUES (2,'Oscar','Isaac');
INSERT INTO PUBLIC.ACTORES (ID_ACTOR, ACTOR_NOMBRE, ACTOR_APELLIDOS) VALUES (3,'Alicia','Vikander');

INSERT INTO PUBLIC.DIRECTORES (ID_DIRECTOR, DIRECTOR_NOMBRE, DIRECTOR_APELLIDOS) VALUES (1,'Guillermo','del Toro');
INSERT INTO PUBLIC.DIRECTORES (ID_DIRECTOR, DIRECTOR_NOMBRE, DIRECTOR_APELLIDOS) VALUES (2,'Alex','Garland');

INSERT INTO PUBLIC.ALQUILERES (ID_PELICULA, ID_SOCIO, FECHA_PRESTAMO_DESDE, FECHA_PRESTAMO_HASTA) VALUES (1,2, DATE '2022-05-19',DATE '2022-05-20');


INSERT INTO PUBLIC.PELICULAS_ACTORES (ID_PELICULA, ID_ACTOR) VALUES (1,1);
INSERT INTO PUBLIC.PELICULAS_ACTORES (ID_PELICULA, ID_ACTOR) VALUES (2,2);
INSERT INTO PUBLIC.PELICULAS_ACTORES (ID_PELICULA, ID_ACTOR) VALUES (2,3);

INSERT INTO PUBLIC.PELICULAS_DIRECTORES (ID_PELICULA, ID_DIRECTOR) VALUES (1,1);
INSERT INTO PUBLIC.PELICULAS_DIRECTORES (ID_PELICULA, ID_DIRECTOR) VALUES (2,2);

INSERT INTO PUBLIC.PREMIOS (ID_GANADOR,PREMIO_NOMBRE,PREMIO_CATEGORIA,PREMIO_YEAR) VALUES (1,'Oscar','Mejor maquillaje',2006);
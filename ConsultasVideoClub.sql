--Devuelve todas las pel�culas
SELECT * FROM MOVIES;

--Devuelve todos los g�neros de las pel�culas
SELECT * FROM GENRE;

--Devuelve el nombre de todas las pel�culas y el nombre del estudio que las ha realizado
SELECT M.MOVIE_NAME, S.STUDIO_NAME 
FROM MOVIES M LEFT OUTER JOIN STUDIO S USING (STUDIO_ID);

--Devuelve el nombre y la edad de todos los directores menores o iguales de 50 a�os
SELECT DIRECTOR_NAME, DATEDIFF(year, DIRECTOR_BIRTH_DATE, now()) AS DIRECTOR_AGE
FROM DIRECTORS WHERE DATEDIFF(year, DIRECTOR_BIRTH_DATE, now()) <= 50 AND DIRECTOR_DEAD_DATE IS NULL;

--Devuelve el nombre y la edad de todos los actores menores de 50 a�os que hayan fallecido
SELECT ACTOR_NAME, DATEDIFF(year, ACTOR_BIRTH_DATE, ACTOR_DEAD_DATE) AS ACTOR_AGE
FROM ACTORS 
WHERE DATEDIFF(year, ACTOR_BIRTH_DATE, ACTOR_DEAD_DATE) < 50 AND ACTOR_DEAD_DATE IS NOT NULL;

--Devuelve el nombre de todos los directores menores o iguales de 40 a�os que est�n vivos
SELECT DIRECTOR_NAME  
FROM DIRECTORS 
WHERE DATEDIFF(year, DIRECTOR_BIRTH_DATE, now()) < 40 AND DIRECTOR_DEAD_DATE IS NULL;

--Devuelve la lista de todos los estudios de grabaci�n que est�n activos
SELECT * FROM STUDIO 
WHERE STUDIO_ACTIVE = 1;

--Devuelve el nombre y el a�o de todas las pel�culas que han sido producidas por un estudio que actualmente no est� activo
SELECT M.MOVIE_NAME , YEAR(M.MOVIE_LAUNCH_DATE) AS MOVIE_LAUNCH_YEAR 
FROM MOVIES M LEFT JOIN STUDIO S USING (STUDIO_ID) 
WHERE S.STUDIO_ACTIVE = 0 ORDER BY M.MOVIE_LAUNCH_DATE; 

--Devuelve una lista de los 20 �ltimos miembros en anotarse al videoclub
SELECT * 
FROM MEMBERS 
ORDER BY MEMBER_ID DESC LIMIT 20;

--Devuelve una lista de las �ltimas 10 pel�culas que se han alquilado
SELECT MOVIE_ID, M.* 
FROM MEMBERS_MOVIE_RENTAL R LEFT JOIN MOVIES M USING(MOVIE_ID) 
ORDER BY MEMBER_RENTAL_DATE DESC LIMIT 10;

--Indica cual es el nombre del director del que m�s pel�culas se han alquilado
SELECT DIRECTOR_NAME, COUNT(R.MOVIE_ID) AS TIMES_RENTED
FROM DIRECTORS D JOIN MOVIES M USING(DIRECTOR_ID) JOIN MEMBERS_MOVIE_RENTAL R USING(MOVIE_ID)
GROUP BY DIRECTOR_NAME
ORDER BY COUNT(R.MOVIE_ID) DESC 
LIMIT 1;


SELECT MAX(TOTAL_NUM) AS TIMES_RENTED
FROM 
	(SELECT DIRECTOR_ID, SUM(NUM) AS TOTAL_NUM
		FROM
		(SELECT MOVIE_ID, DIRECTOR_ID 
			FROM MOVIES) 
	JOIN 
		(SELECT MOVIE_ID, COUNT(MEMBER_MOVIE_RENTAL_ID) AS NUM 
			FROM MEMBERS_MOVIE_RENTAL 
			GROUP BY MOVIE_ID) 
	USING(MOVIE_ID) 
	GROUP BY DIRECTOR_ID); --Veces que m�s se han alquilado sus peliculas en total

/*SELECT COUNT(MOVIE_ID) FROM MEMBERS_MOVIE_RENTAL LEFT JOIN MOVIES USING(MOVIE_ID);

SELECT MOVIE_ID, DIRECTOR_ID FROM MOVIES;
SELECT DIRECTOR_ID , COUNT(MOVIE_ID) AS NUM_PEL FROM MOVIES GROUP BY DIRECTOR_ID;
SELECT MOVIE_ID, COUNT(MEMBER_MOVIE_RENTAL_ID) AS NUM FROM MEMBERS_MOVIE_RENTAL GROUP BY MOVIE_ID;


SELECT DIRECTOR_ID, SUM(NUM) AS TOTAL_NUM
FROM
	(SELECT MOVIE_ID, DIRECTOR_ID 
		FROM MOVIES) 
JOIN 
	(SELECT MOVIE_ID, COUNT(MEMBER_MOVIE_RENTAL_ID) AS NUM 
		FROM MEMBERS_MOVIE_RENTAL 
		GROUP BY MOVIE_ID) 
USING(MOVIE_ID) 
GROUP BY DIRECTOR_ID;*/

--Indica cuantos premios han ganado cada uno de los estudios con las pel�culas que han creado
SELECT STUDIO_ID, SUM(AWARDS) AS TOTAL_AWARDS FROM (
		SELECT MOVIE_ID, SUM(AWARD_WIN) AS AWARDS , M.STUDIO_ID  
		FROM AWARDS LEFT JOIN MOVIES M USING (MOVIE_ID) 
		GROUP BY MOVIE_ID, STUDIO_ID
) GROUP BY STUDIO_ID;


--Indica cu�ntas pel�culas ha realizado cada director antes de cumplir 41 a�os
SELECT DIRECTOR_ID, DIRECTOR_NAME ,COUNT(MOVIE_ID) AS MOVIES_NUM
FROM (SELECT MOVIE_ID, MOVIE_LAUNCH_DATE, DIRECTOR_ID, DIRECTOR_NAME,DIRECTOR_BIRTH_DATE 
	FROM MOVIES LEFT JOIN DIRECTORS USING(DIRECTOR_ID) 
	WHERE DATEDIFF(year, DIRECTOR_BIRTH_DATE, MOVIE_LAUNCH_DATE) < 41)
GROUP BY DIRECTOR_ID, DIRECTOR_NAME;

/*SELECT MOVIE_ID, MOVIE_LAUNCH_DATE, DIRECTOR_ID, DIRECTOR_BIRTH_DATE 
FROM MOVIES LEFT JOIN DIRECTORS USING(DIRECTOR_ID) 
WHERE DATEDIFF(year, DIRECTOR_BIRTH_DATE, MOVIE_LAUNCH_DATE) < 41;*/

/*SELECT DIRECTOR_ID, COUNT(MOVIE_ID)
FROM MOVIES LEFT JOIN DIRECTORS USING (DIRECTOR_ID) 
GROUP BY DIRECTOR_ID
HAVING DATEDIFF(year, DIRECTOR_BIRTH_DATE, MOVIE_LAUNCH_DATE) < 41;*/


--Indica la edad media de los directores vivos
SELECT AVG(DATEDIFF(year, DIRECTOR_BIRTH_DATE, now())) AS AVG_AGE_ALIVE_DIRECTORS 
FROM DIRECTORS 
GROUP BY DIRECTOR_DEAD_DATE --Agrupo por este ya que s� que todos los vivos tienen en com�n que NO est�n muertos
HAVING DIRECTOR_DEAD_DATE IS NULL;

--Indica la edad media de los actores que han fallecido
SELECT AVG(AGE_DEAD_ACTORS) AS AVG_AGE_DEAD_ACTORS FROM(
	SELECT DATEDIFF(year, ACTOR_BIRTH_DATE, ACTOR_DEAD_DATE) AS AGE_DEAD_ACTORS 
	FROM ACTORS 
	WHERE ACTOR_DEAD_DATE IS NOT NULL);


--Indica cu�l es el g�nero favorito de cada uno de los directores cuando dirigen una pel�cula
SELECT DIRECTOR_NAME, GROUP_CONCAT(GENRE_NAME) AS FAVOURITE_GENRE 
FROM 
	(SELECT DIRECTOR_ID, GENRE_ID 
		FROM (SELECT MAX(COUNT_GENRE) AS MAX_TIMES, DIRECTOR_ID  
				FROM (SELECT DIRECTOR_ID, GENRE_ID, count(GENRE_ID) AS COUNT_GENRE 
						FROM MOVIES 
						GROUP BY DIRECTOR_ID, GENRE_ID 
						ORDER BY DIRECTOR_ID)
				GROUP BY DIRECTOR_ID) 
		LEFT JOIN (SELECT DIRECTOR_ID, GENRE_ID, COUNT(GENRE_ID) AS COUNT_GENRE 
					FROM MOVIES 
					GROUP BY DIRECTOR_ID, GENRE_ID 
					ORDER BY DIRECTOR_ID)
		USING(DIRECTOR_ID)
		WHERE MAX_TIMES = COUNT_GENRE) 
LEFT JOIN DIRECTORS USING(DIRECTOR_ID) 
LEFT JOIN GENRE USING(GENRE_ID)
GROUP BY DIRECTOR_NAME;


/*SELECT DIRECTOR_ID, GENRE_ID, COUNT(GENRE_ID) AS COUNT_GENRE 
					FROM MOVIES 
					GROUP BY DIRECTOR_ID, GENRE_ID 
					ORDER BY DIRECTOR_ID;

SELECT MAX(COUNT_GENRE) AS MAX_TIMES,DIRECTOR_ID  
				FROM (SELECT DIRECTOR_ID, GENRE_ID, count(GENRE_ID) AS COUNT_GENRE 
						FROM MOVIES 
						GROUP BY DIRECTOR_ID, GENRE_ID 
						ORDER BY DIRECTOR_ID;

SELECT * 
		FROM (SELECT MAX(COUNT_GENRE) AS MAX_TIMES,DIRECTOR_ID  
				FROM (SELECT DIRECTOR_ID, GENRE_ID, count(GENRE_ID) AS COUNT_GENRE 
						FROM MOVIES 
						GROUP BY DIRECTOR_ID, GENRE_ID 
						ORDER BY DIRECTOR_ID)
				GROUP BY DIRECTOR_ID) 
		LEFT JOIN (SELECT DIRECTOR_ID, GENRE_ID, COUNT(GENRE_ID) AS COUNT_GENRE 
					FROM MOVIES 
					GROUP BY DIRECTOR_ID, GENRE_ID 
					ORDER BY DIRECTOR_ID)
		USING(DIRECTOR_ID)
		WHERE MAX_TIMES = COUNT_GENRE;

SELECT DIRECTOR_ID, GENRE_ID 
		FROM (SELECT MAX(COUNT_GENRE) AS MAX_TIMES,DIRECTOR_ID  
				FROM (SELECT DIRECTOR_ID, GENRE_ID, count(GENRE_ID) AS COUNT_GENRE 
						FROM MOVIES 
						GROUP BY DIRECTOR_ID, GENRE_ID 
						ORDER BY DIRECTOR_ID)
				GROUP BY DIRECTOR_ID) 
		LEFT JOIN (SELECT DIRECTOR_ID, GENRE_ID, COUNT(GENRE_ID) AS COUNT_GENRE 
					FROM MOVIES 
					GROUP BY DIRECTOR_ID, GENRE_ID 
					ORDER BY DIRECTOR_ID)
		USING(DIRECTOR_ID)
		WHERE MAX_TIMES = COUNT_GENRE;*/

--Indica cu�l es la nacionalidad favorita de cada uno de los estudios en la producci�n de las pel�culas 

SELECT STUDIO_NAME, GROUP_CONCAT(NACIONALITY_NAME) AS FAVOURITE_NACIONALITY 
FROM 
	(SELECT STUDIO_ID, NACIONALITY_ID 
		FROM (SELECT MAX(COUNT_NACIONALITY) AS MAX_TIMES,STUDIO_ID  
				FROM (SELECT STUDIO_ID, NACIONALITY_ID, count(NACIONALITY_ID) AS COUNT_NACIONALITY
						FROM MOVIES 
						GROUP BY STUDIO_ID, NACIONALITY_ID 
						ORDER BY STUDIO_ID)
				GROUP BY STUDIO_ID) 
		LEFT JOIN (SELECT STUDIO_ID, NACIONALITY_ID, COUNT(NACIONALITY_ID) AS COUNT_NACIONALITY 
					FROM MOVIES 
					GROUP BY STUDIO_ID, NACIONALITY_ID 
					ORDER BY STUDIO_ID)
		USING(STUDIO_ID)
		WHERE MAX_TIMES = COUNT_NACIONALITY) 
LEFT JOIN STUDIO USING(STUDIO_ID) 
LEFT JOIN NACIONALITY USING(NACIONALITY_ID)
GROUP BY STUDIO_NAME;

/*SELECT STUDIO_ID, NACIONALITY_ID, count(NACIONALITY_ID) AS COUNT_NACIONALITY
						FROM MOVIES 
						GROUP BY STUDIO_ID, NACIONALITY_ID 
						ORDER BY STUDIO_ID;

SELECT MAX(COUNT_NACIONALITY) AS MAX_TIMES, STUDIO_ID  
				FROM (SELECT STUDIO_ID, NACIONALITY_ID, count(NACIONALITY_ID) AS COUNT_NACIONALITY
						FROM MOVIES 
						GROUP BY STUDIO_ID, NACIONALITY_ID 
						ORDER BY STUDIO_ID)
				GROUP BY STUDIO_ID;

SELECT *
		FROM (SELECT MAX(COUNT_NACIONALITY) AS MAX_TIMES,STUDIO_ID  
				FROM (SELECT STUDIO_ID, NACIONALITY_ID, count(NACIONALITY_ID) AS COUNT_NACIONALITY
						FROM MOVIES 
						GROUP BY STUDIO_ID, NACIONALITY_ID 
						ORDER BY STUDIO_ID)
				GROUP BY STUDIO_ID) 
		LEFT JOIN (SELECT STUDIO_ID, NACIONALITY_ID, COUNT(NACIONALITY_ID) AS COUNT_NACIONALITY 
					FROM MOVIES 
					GROUP BY STUDIO_ID, NACIONALITY_ID 
					ORDER BY STUDIO_ID)
		USING(STUDIO_ID)
		WHERE MAX_TIMES = COUNT_NACIONALITY;

SELECT STUDIO_ID, NACIONALITY_ID 
		FROM (SELECT MAX(COUNT_NACIONALITY) AS MAX_TIMES,STUDIO_ID  
				FROM (SELECT STUDIO_ID, NACIONALITY_ID, count(NACIONALITY_ID) AS COUNT_NACIONALITY
						FROM MOVIES 
						GROUP BY STUDIO_ID, NACIONALITY_ID 
						ORDER BY STUDIO_ID)
				GROUP BY STUDIO_ID) 
		LEFT JOIN (SELECT STUDIO_ID, NACIONALITY_ID, COUNT(NACIONALITY_ID) AS COUNT_NACIONALITY 
					FROM MOVIES 
					GROUP BY STUDIO_ID, NACIONALITY_ID 
					ORDER BY STUDIO_ID)
		USING(STUDIO_ID)
		WHERE MAX_TIMES = COUNT_NACIONALITY;*/


--Indica cu�l es la media de duraci�n de las pel�culas de cada director

SELECT DIRECTOR_ID, DIRECTOR_NAME, AVG(MOVIE_DURATION) AS AVG_MOVIE_DURATION 
FROM MOVIES LEFT JOIN DIRECTORS USING(DIRECTOR_ID) 
GROUP BY DIRECTOR_ID, DIRECTOR_NAME;

--Indica cu�l es la el nombre y la duraci�n m�nima de las pel�culas que han sido alquiladas en los �ltimos 2 a�os por los miembros del videoclub
SELECT MOVIE_NAME, MOVIE_DURATION,MEMBER_RENTAL_DATE
FROM MEMBERS_MOVIE_RENTAL LEFT JOIN MOVIES USING(MOVIE_ID) 
WHERE DATEDIFF(day,MEMBER_RENTAL_DATE, now())<=2*365 --NO devuelve nada porque la fechas de alquiler son muy antiguas
ORDER BY MEMBER_RENTAL_DATE DESC;

/*DATEADD(YEAR,-2,TODAY()) < MEMBER_RENTAL_DATE*/--Usarlo tambi�n para las edades

--Indica cu�l fue la primera pel�cula que alquilaron los miembros del videoclub cuyos tel�fonos tengan como �ltimo d�gito el ID de alguna nacionalidad

SELECT MEMBER_ID, MEMBER_NAME, MEMBER_PHONE, MOVIE_NAME, MEMBER_RENTAL_DATE, FIRST_TIME_RENTAL
FROM MEMBERS JOIN MEMBERS_MOVIE_RENTAL R USING(MEMBER_ID) JOIN MOVIES USING (MOVIE_ID)
JOIN (SELECT MEMBER_ID, MIN(MEMBER_RENTAL_DATE) AS FIRST_TIME_RENTAL
							FROM MEMBERS_MOVIE_RENTAL
							GROUP BY MEMBER_ID) AS A ON FIRST_TIME_RENTAL = MEMBER_RENTAL_DATE AND A.MEMBER_ID=R.MEMBER_ID 
WHERE MEMBER_PHONE IN (SELECT MEMBER_PHONE 
						FROM MEMBERS 
						WHERE SUBSTRING("MEMBER_PHONE", LENGTH (MEMBER_PHONE), 1) IN (SELECT CAST(NACIONALITY_ID as varchar(10)) 
																		FROM NACIONALITY));

/*SELECT MEMBER_ID, MIN(MEMBER_RENTAL_DATE) AS FIRST_TIME_RENTAL 
FROM MEMBERS_MOVIE_RENTAL INNER JOIN MOVIES USING(MOVIE_ID)
GROUP BY MEMBER_ID
ORDER BY MEMBER_ID;

SELECT MEMBER_ID, MIN(MEMBER_RENTAL_DATE) AS FIRST_TIME_RENTAL
FROM MEMBERS_MOVIE_RENTAL 
GROUP BY MEMBER_ID
ORDER BY MEMBER_ID;


SELECT  MEMBER_NAME, MEMBER_PHONE, MOVIE_NAME, MIN(MEMBER_RENTAL_DATE) AS FIRST_TIME_RENTAL
FROM  MEMBERS  LEFT JOIN MEMBERS_MOVIE_RENTAL USING (MEMBER_ID) JOIN MOVIES USING(MOVIE_ID)
GROUP BY  MEMBER_NAME, MEMBER_PHONE, MOVIE_NAME
HAVING MEMBER_PHONE IN (SELECT MEMBER_PHONE 
						FROM MEMBERS 
						WHERE SUBSTRING("MEMBER_PHONE", 12, 1) IN (SELECT CAST(NACIONALITY_ID as varchar(10)) 
																		FROM NACIONALITY));*/

/*SELECT MEMBER_PHONE, SUBSTRING("MEMBER_PHONE", 12, 1) AS END FROM MEMBERS;
SELECT CAST(NACIONALITY_ID as varchar(10)) FROM NACIONALITY;

SELECT MEMBER_PHONE FROM MEMBERS WHERE SUBSTRING("MEMBER_PHONE", 12, 1) IN (SELECT CAST(NACIONALITY_ID as varchar(10)) FROM NACIONALITY);*/


--Indica el n�mero de premios a los que estuvo nominado un actor, pero que no ha conseguido (Si una pel�cula est� nominada a un premio, su actor tambi�n lo est�)
SELECT ACTOR_ID, SUM(LOST_AWARDS) AS ACTORS_LOST_AWARDS
FROM 
	(SELECT MOVIE_ID,SUM(AWARD_ALMOST_WIN) AS LOST_AWARDS 
			FROM AWARDS 
			GROUP BY MOVIE_ID) 
JOIN 
	(SELECT MOVIE_ID, ACTOR_ID 
		FROM MOVIES JOIN MOVIES_ACTORS USING(MOVIE_ID) 
		ORDER BY MOVIE_ID) 
USING(MOVIE_ID) 
GROUP BY ACTOR_ID
ORDER BY ACTOR_ID;


/*SELECT MOVIE_ID, ACTOR_ID FROM MOVIES LEFT JOIN MOVIES_ACTORS USING(MOVIE_ID) ORDER BY MOVIE_ID;
SELECT MOVIE_ID,SUM(AWARD_ALMOST_WIN) AS LOST_AWARDS FROM AWARDS GROUP BY MOVIE_ID;*/


--Indica cuantos actores y directores hicieron pel�culas para los estudios no activos

SELECT COUNT(DISTINCT DIRECTOR_ID) AS DIRECTORS, COUNT(DISTINCT ACTOR_ID) AS ACTORS 
FROM STUDIO LEFT JOIN MOVIES USING(STUDIO_ID) JOIN MOVIES_ACTORS USING(MOVIE_ID) 
WHERE STUDIO_ACTIVE=0;


/*SELECT COUNT(DISTINCT DIRECTOR_ID) AS DIRECTORS 
 FROM STUDIO LEFT JOIN MOVIES USING(STUDIO_ID) 
 WHERE STUDIO_ACTIVE=0;
  
SELECT COUNT(DISTINCT ACTOR_ID) AS ACTORS 
FROM STUDIO LEFT JOIN MOVIES USING(STUDIO_ID) JOIN MOVIES_ACTORS USING(MOVIE_ID) 
WHERE STUDIO_ACTIVE=0;*/

--Indica el nombre, ciudad, y tel�fono de todos los miembros del videoclub que hayan alquilado pel�culas que hayan sido nominadas a m�s de 150 premios y ganaran menos de 50

SELECT MEMBER_NAME, MEMBER_TOWN, MEMBER_PHONE 
FROM MEMBERS_MOVIE_RENTAL LEFT JOIN MEMBERS USING(MEMBER_ID) JOIN MOVIES USING(MOVIE_ID) 
WHERE MOVIE_ID IN (SELECT MOVIE_ID 
					FROM AWARDS 
					GROUP BY MOVIE_ID 
					HAVING SUM(AWARD_NOMINATION)>150 AND SUM(AWARD_WIN)<50);

/*SELECT MOVIE_ID,SUM(AWARD_NOMINATION) AS NOMINATIONS, SUM(AWARD_WIN) AS WINS 
 * FROM AWARDS 
 * GROUP BY MOVIE_ID 
 * HAVING SUM(AWARD_NOMINATION)>150 AND SUM(AWARD_WIN)<50;*/

--Indica el n�mero de pel�culas que hayan hecho los directores durante las d�cadas de los 60, 70 y 80 que contengan la palabra "The" en cualquier parte del t�tulo
SELECT  DIRECTOR_NAME, COUNT(MOVIE_ID) AS MOVIES 
FROM MOVIES JOIN DIRECTORS USING(DIRECTOR_ID)
WHERE YEAR(MOVIE_LAUNCH_DATE) BETWEEN 1960 AND 1989 AND upper(MOVIE_NAME) LIKE upper('%The%')
GROUP BY DIRECTOR_NAME;

/*SELECT * FROM movies WHERE upper(movie_name) LIKE upper('%The%');*/


--Indica si hay alguna coincidencia de nacimiento de ciudad (y si las hay, indicarlas) entre los miembros del videoclub y los directores.
SELECT DIRECTOR_BIRTH_PLACE, MEMBER_TOWN 
FROM MOVIES LEFT JOIN DIRECTORS USING(DIRECTOR_ID) LEFT JOIN MEMBERS_MOVIE_RENTAL USING(MOVIE_ID) LEFT JOIN MEMBERS USING(MEMBER_ID) 
WHERE upper(MEMBER_TOWN) = upper(DIRECTOR_BIRTH_PLACE);

--Comprueba si hay errores en la BD entre las pel�culas y directores (un director muerto en el 76 no puede dirigir una pel�cula en el 88)

SELECT DIRECTOR_ID, DIRECTOR_NAME, DIRECTOR_DEAD_DATE, MOVIE_LAUNCH_DATE
FROM MOVIES JOIN DIRECTORS USING(DIRECTOR_ID) 
WHERE DIRECTOR_DEAD_DATE < MOVIE_LAUNCH_DATE;


/*SELECT DISTINCT (DIRECTOR_ID) FROM MOVIES JOIN DIRECTORS USING(DIRECTOR_ID) WHERE DIRECTOR_DEAD_DATE < MOVIE_LAUNCH_DATE OR DIRECTOR_BIRTH_DATE > MOVIE_LAUNCH_DATE*/;

--Usando como condici�n la sentencia anterior, modifica la fecha de defunci�n a un a�o m�s tarde del estreno de la pel�cula (mediante sentencia SQL)

/*SELECT DIRECTOR_ID, MAX(MOVIE_LAUNCH_DATE)
FROM MOVIES JOIN DIRECTORS USING(DIRECTOR_ID) 
WHERE DIRECTOR_DEAD_DATE < MOVIE_LAUNCH_DATE
GROUP BY DIRECTOR_ID;*/

/*UPDATE DIRECTORS SET DIRECTOR_DEAD_DATE = (SELECT DATEADD(YEAR,1,MAX(MOVIE_LAUNCH_DATE))
									FROM MOVIES JOIN DIRECTORS USING(DIRECTOR_ID) 
									WHERE DIRECTOR_DEAD_DATE < MOVIE_LAUNCH_DATE
									GROUP BY DIRECTOR_ID) 
WHERE DIRECTOR_ID IN
					(SELECT DIRECTOR_ID, MAX(MOVIE_LAUNCH_DATE)
						FROM MOVIES JOIN DIRECTORS USING(DIRECTOR_ID) 
						WHERE DIRECTOR_DEAD_DATE < MOVIE_LAUNCH_DATE
						GROUP BY DIRECTOR_ID);*/
					
UPDATE DIRECTORS d2
	SET d2.DIRECTOR_DEAD_DATE = (SELECT DATEADD(YEAR, 1, m.MOVIE_LAUNCH_DATE)
									FROM MOVIES m 
										INNER JOIN DIRECTORS d ON d.DIRECTOR_ID  = m.DIRECTOR_ID 
										AND d.DIRECTOR_DEAD_DATE < m.MOVIE_LAUNCH_DATE
									WHERE d.DIRECTOR_ID = d2.DIRECTOR_ID
									LIMIT 1)	
	WHERE d2.DIRECTOR_ID IN (SELECT d.DIRECTOR_ID
								FROM MOVIES m 
								INNER JOIN DIRECTORS d ON d.DIRECTOR_ID  = m.DIRECTOR_ID 
								AND d.DIRECTOR_DEAD_DATE < m.MOVIE_LAUNCH_DATE);
							
/*MERGE INTO
      PUBLIC.DIRECTORS D
          USING (
      SELECT
          D.DIRECTOR_ID,
          MAX(DATEADD(YEAR, 1, M.MOVIE_LAUNCH_DATE)) AS DIRECTOR_DEAD_DATE
      FROM
          PUBLIC.MOVIES M
      INNER JOIN PUBLIC.DIRECTORS D ON
          M.DIRECTOR_ID = D.DIRECTOR_ID
      WHERE
          D.DIRECTOR_DEAD_DATE IS NOT NULL
          AND D.DIRECTOR_DEAD_DATE < M.MOVIE_LAUNCH_DATE
      GROUP BY
          D.DIRECTOR_ID) AS L(DIRECTOR_ID,
      DIRECTOR_DEAD_DATE) ON
      D.DIRECTOR_ID = L.DIRECTOR_ID
      WHEN MATCHED THEN UPDATE
      SET
          D.DIRECTOR_DEAD_DATE = L.DIRECTOR_DEAD_DATE*/

/* UPDATE DIRECTORS SET  DIRECTOR_DEAD_DATE = (SELECT  MAX(M.MOVIE_LAUNCH_DATE) AS LAUNCH_DATE FROM MOVIES M 
 WHERE M.DIRECTOR_ID = DIRECTOR_ID 
 GROUP BY DIRECTOR_ID ORDER BY DIRECTOR_ID LIMIT 1)
 WHERE DIRECTOR_ID IN ( SELECT DISTINCT DIRECTOR_ID
  FROM
          MOVIES M
      INNER JOIN DIRECTORS D ON
          M.DIRECTOR_ID = D.DIRECTOR_ID
       WHERE         D.DIRECTOR_DEAD_DATE IS NOT NULL
          AND D.DIRECTOR_DEAD_DATE < M.MOVIE_LAUNCH_DATE)*/












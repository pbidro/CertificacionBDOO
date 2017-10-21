/*
Proyecto para optar a la certificación de desarrollo de bases de datos orienta-
das a objetos del Instituto Profesional Santo Tomás Talca.

Autor: Pablo Iván Bustamante Idro.
Profesor: Claudio Diaz Pacheco.

Título del proyecto: Sistema de registro de viaje de camiones.

*/

--------------------------------------------------------------------------------
-----------------------------USUARIO PROYECTO-----------------------------------

CREATE USER PROYECTO IDENTIFIED BY 12345;
GRANT CONNECT TO PROYECTO;
GRANT RESOURCE TO PROYECTO;
GRANT CREATE ANY TYPE TO PROYECTO;
GRANT UNDER ANY TYPE TO PROYECTO;
GRANT EXECUTE ANY TYPE TO PROYECTO;

--------------------------------------------------------------------------------

-----------------------------CREACION DE OBJETOS--------------------------------

CREATE OR REPLACE TYPE T_LOG AS OBJECT(
CODIGO NUMBER,
TABLA VARCHAR(15),
ACCION VARCHAR(15),
FECHASISTEMA DATE,
ESTADO NUMBER(1));
/

CREATE OR REPLACE TYPE T_PERSONA AS OBJECT(
RUT VARCHAR(15),
NOMBRE VARCHAR(15),
APELLIDO VARCHAR(15),
ESTADO NUMBER(1)) NOT FINAL;
/


CREATE OR REPLACE TYPE T_CHOFER UNDER T_PERSONA(
FECHA_INGRESO DATE,
MEMBER FUNCTION FULLNAME RETURN VARCHAR,
MEMBER FUNCTION CATEGORIA RETURN VARCHAR,
MEMBER FUNCTION TOTALVIAJES RETURN NUMBER);
/

CREATE OR REPLACE TYPE T_CAMION AS OBJECT(
PATENTE VARCHAR(15),
ANO NUMBER,
DESCRIPCION VARCHAR(25),
MARCA VARCHAR(25),
ESTADO NUMBER(1),
MEMBER FUNCTION TOTALVIAJES RETURN NUMBER );
/

CREATE OR REPLACE TYPE T_UBICACION AS OBJECT(
CODIGO NUMBER,
DESCRIPCION VARCHAR(25),
ESTADO NUMBER(1));
/

CREATE OR REPLACE TYPE T_VIAJE AS OBJECT(
CODIGO NUMBER,
FECHA_INICIO DATE,
FECHA_LLEGADA DATE,
CARGA VARCHAR(100),
ORIGEN REF T_UBICACION,
DESTINO REF T_UBICACION,
CHOFER REF T_CHOFER,
CAMION REF T_CAMION,
ESTADO NUMBER(1));
/

--------------------------------------------------------------------------------
----------------------------CREACION DE TABLAS----------------------------------



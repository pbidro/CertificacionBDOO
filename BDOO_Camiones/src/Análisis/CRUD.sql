
--------------------------------------------------------------------------------
--------------------------------CRUD CHOFER-------------------------------------

CREATE OR REPLACE PROCEDURE CRUD_CHOFER(OPT NUMBER, PRUT VARCHAR, PNOMBRE VARCHAR,
	PAPELLIDO VARCHAR, PFECHA_INGRESO DATE) AS
BEGIN
	
	IF (OPT = 1) THEN
	INSERT INTO CHOFER VALUES(PRUT,PNOMBRE,PAPELLIDO,1,PFECHA_INGRESO);

	ELSIF (OPT = 2) THEN
	UPDATE CHOFER SET NOMBRE = PNOMBRE, APELLIDO = PAPELLIDO, 
	FECHA_INGRESO = PFECHA_INGRESO
	WHERE RUT = PRUT;

	ELSIF (OPT = 3) THEN
	UPDATE CHOFER SET ESTADO = 0 WHERE RUT = PRUT;

	ELSE 
	UPDATE CHOFER SET ESTADO = 1 WHERE RUT = PRUT;

	END IF;

END;
/


--------------------------------------------------------------------------------
--------------------------------CRUD CAMION-------------------------------------


CREATE OR REPLACE PROCEDURE CRUD_CAMION(OPT NUMBER, PPATENTE VARCHAR, PANO NUMBER, 
	PDESCRIPCION VARCHAR, PMARCA VARCHAR, PEJES NUMBER) AS

BEGIN
	
	IF (OPT = 1) THEN
	INSERT INTO CAMION VALUES(PPATENTE,PANO,PDESCRIPCION,PMARCA,1,PEJES);

	ELSIF (OPT = 2) THEN
	UPDATE CAMION SET ANO = PANO, DESCRIPCION = PDESCRIPCION, MARCA = PMARCA, 
	EJES = PEJES
	WHERE PATENTE = PPATENTE;

	ELSIF (OPT = 3) THEN
	UPDATE CAMION SET ESTADO = 0 WHERE PATENTE = PPATENTE;

	ELSE 
	UPDATE CAMION SET ESTADO = 1 WHERE PATENTE = PPATENTE;

	END IF;

END;
/

--------------------------------------------------------------------------------
--------------------------------CRUD UBICACION----------------------------------

CREATE OR REPLACE PROCEDURE CRUD_UBICACION(OPT NUMBER, PCODIGO NUMBER, 
	PDESCRIPCION VARCHAR) AS

BEGIN
	
	IF (OPT = 1) THEN
	INSERT INTO UBICACION VALUES(PCODIGO,PDESCRIPCION,1);

	ELSIF (OPT = 2) THEN
	UPDATE UBICACION SET DESCRIPCION = PDESCRIPCION
	WHERE CODIGO = PCODIGO;

	ELSIF (OPT = 3) THEN
	UPDATE UBICACION SET ESTADO = 0 WHERE CODIGO = PCODIGO;

	ELSE 
	UPDATE UBICACION SET ESTADO = 1 WHERE CODIGO = PCODIGO;

	END IF;

END;
/

--------------------------------------------------------------------------------
--------------------------------CRUD VIAJE--------------------------------------

CREATE OR REPLACE PROCEDURE VIAJE_CRUD(OPCION NUMBER, PCODIGO VARCHAR, 
	PFECHA_INICIO DATE, PFECHA_LLEGADA DATE, PCARGA VARCHAR, PORIGEN NUMBER, 
	PDESTINO NUMBER, PCHOFER VARCHAR, PCAMION VARCHAR) AS
BEGIN
	IF OPCION=1 THEN
		INSERT INTO VIAJE SELECT PCODIGO,PFECHA_INICIO,PFECHA_LLEGADA,
		PCARGA,REF(ORI),REF(DEST),REF(CHO),REF(CAM),1 
		FROM UBICACION ORI, UBICACION DEST, CHOFER CHO, CAMION CAM WHERE 
		ORI.CODIGO=PORIGEN AND DEST.CODIGO=PDESTINO AND CHO.RUT=PCHOFER 
		AND CAM.PATENTE=PCAMION;	
	ELSIF OPCION=2 THEN
		UPDATE VIAJE SET FECHA_INICIO=PFECHA_INICIO,FECHA_LLEGADA=PFECHA_LLEGADA, 
		CARGA=PCARGA, 
		ESTADO=1, 
		ORIGEN = (SELECT REF(ORI) FROM UBICACION ORI WHERE ORI.CODIGO=PORIGEN),
		DESTINO = (SELECT REF(DEST) FROM UBICACION DEST WHERE DEST.CODIGO=PDESTINO),
		CHOFER = (SELECT REF(CHO) FROM CHOFER CHO WHERE CHO.RUT=PCHOFER),
		CAMION = (SELECT REF(CAM) FROM CAMION CAM WHERE CAM.PATENTE=PCAMION)
		WHERE CODIGO=PCODIGO;
	ELSIF OPCION=3 THEN
		UPDATE VIAJE SET ESTADO=0 WHERE CODIGO=PCODIGO;
	ELSIF OPCION=4 THEN
		UPDATE VIAJE SET ESTADO=1 WHERE CODIGO=PCODIGO;
	END IF;
END;
/




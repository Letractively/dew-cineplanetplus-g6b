-- Proyecto: Cineplanetplus  
-- Sistema : Cineplanetplus
-- Autor   : Alex
-- Fecha   : 13/04/2011
-- Objetivo: Creación de tablas
--   
CREATE TABLE Pelicula (
  idPelicula VARCHAR(20) NOT NULL,
  titulo VARCHAR(100) NULL,
  genero VARCHAR(45) NULL,
  synopsis VARCHAR(2000) NULL,
  site VARCHAR(60) NULL,
  imagen VARCHAR(60) NULL,
  director VARCHAR(60) NULL,
  reparto VARCHAR(1000) NULL,
  duracion INT NULL,
  pais VARCHAR(20) NULL,
  estado INTEGER UNSIGNED NULL,
  publico VARCHAR(40),
  subtitulos VARCHAR(20) NULL,
  PRIMARY KEY(idPelicula)
);

CREATE TABLE Opcion (
  id VARCHAR(20) NOT NULL,
  descripcion VARCHAR(45) NULL,
  estado VARCHAR(20) NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TipoEmision (
  idTipoEmision VARCHAR(20),
  descripcion VARCHAR(20) NULL,
  PRIMARY KEY(idTipoEmision)
);

CREATE TABLE Perfil (
  id VARCHAR(20) NOT NULL,
  nombre VARCHAR(45) NULL,
  estado VARCHAR(20) NULL,
  vigencia DATE NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Noticia (
  id INT NOT NULL,
  titular VARCHAR(200) NULL,
  descripcion VARCHAR(1000) NULL,
  fecha DATE NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Cine (
  idCine VARCHAR(20) NOT NULL,
  nombre VARCHAR(20) NULL,
  direccion VARCHAR(65) NULL,
  telefono VARCHAR(20) NULL,
  PRIMARY KEY(idCine)
);

CREATE TABLE Horario (
  id INT NOT NULL AUTO_INCREMENT,
  horaInicio TIME NULL,
  horaFin TIME NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Sala (
  idSala VARCHAR(20) NOT NULL,
  idCine VARCHAR(20) NOT NULL,
  descripcion VARCHAR(20) NULL,
  aforo INT NULL,
  PRIMARY KEY(idSala),
  INDEX Sala_FKIndex1(idCine),
  FOREIGN KEY(idCine)
    REFERENCES Cine(idCine)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Usuario (
  idUsuario VARCHAR(20) NOT NULL,
  idPerfil VARCHAR(20) NULL,
  nombre VARCHAR(20) NULL,
  apePaterno VARCHAR(20) NULL,
  apeMaterno VARCHAR(20) NULL,
  username VARCHAR(20) NOT NULL,
  passw VARCHAR(20) NULL,
  direccion VARCHAR(85) NULL,
  estado VARCHAR(1) NULL,
  PRIMARY KEY(idUsuario),
  INDEX Usuario_FKIndex1(idPerfil),
  FOREIGN KEY(idPerfil)
    REFERENCES Perfil(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE FilaAsiento (
  idFilaAsiento INT NOT NULL AUTO_INCREMENT,
  idSala VARCHAR(20) NOT NULL,
  cantAsientos INT NULL,
  -- PRIMARY KEY(idFilaAsiento, idSala),
  PRIMARY KEY(idFilaAsiento),
  INDEX Fila_Asiento_FKIndex1(idSala),
  FOREIGN KEY(idSala)
    REFERENCES Sala(idSala)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE TipoEmisionPelicula (
  idPelicula VARCHAR(20) NOT NULL,
  idTipoEmision VARCHAR(20) NOT NULL,
  PRIMARY KEY(idPelicula, idTipoEmision),
  INDEX TipoEmision_has_Pelicula_FKIndex1(idTipoEmision),
  INDEX TipoEmision_has_Pelicula_FKIndex2(idPelicula),
  FOREIGN KEY(idTipoEmision)
    REFERENCES TipoEmision(idTipoEmision)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(idPelicula)
    REFERENCES Pelicula(idPelicula)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Comentario (
  id INT NOT NULL,
  idUsuario VARCHAR(20) NOT NULL,
  idPelicula VARCHAR(20) NOT NULL,
  fechaCreacion DATETIME NULL,
  comentario VARCHAR(2000) NULL,
  PRIMARY KEY(id),
  INDEX Comentario_FKIndex1(idPelicula),
  INDEX Comentario_FKIndex2(idUsuario),
  FOREIGN KEY(idPelicula)
    REFERENCES Pelicula(idPelicula)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(idUsuario)
    REFERENCES Usuario(idUsuario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE OpcionPerfil (
  idPerfil VARCHAR(20) NOT NULL,
  idOpcion VARCHAR(20) NOT NULL,
  PRIMARY KEY(idPerfil, idOpcion),
  INDEX Opcion_has_Perfil_FKIndex1(idOpcion),
  INDEX Opcion_has_Perfil_FKIndex2(idPerfil),
  FOREIGN KEY(idOpcion)
    REFERENCES Opcion(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(idPerfil)
    REFERENCES Perfil(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE ProgramacionPelicula (
  id VARCHAR(20) NOT NULL,
  idSala VARCHAR(20) NOT NULL,
  idPelicula VARCHAR(20) NOT NULL,
  idHorario INT NOT NULL,
  fechaInicio DATE NULL,
  fechaFin DATE NULL,
  PRIMARY KEY(id),
  INDEX Programacion_Pelicula_FKIndex1(idPelicula),
  INDEX Programacion_Pelicula_FKIndex2(idSala),
  INDEX ProgramacionPelicula_FKIndex3(idHorario),
  FOREIGN KEY(idSala)
    REFERENCES Sala(idSala)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(idPelicula)
    REFERENCES Pelicula(idPelicula)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(idHorario)
    REFERENCES Horario(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Reservacion (
  idReservacion VARCHAR(20) NOT NULL,
  idUsuario VARCHAR(20) NOT NULL,
  idProgramacionPelicula VARCHAR(20) NOT NULL,
  fechaReservada DATE NULL,
  fechaReservacion DATE NULL,
  cantAsientosReservados INT NULL,
  PRIMARY KEY(idReservacion),
  INDEX Reservacion_FKIndex1(idUsuario),
  INDEX Reservacion_FKIndex2(idProgramacionPelicula),
  FOREIGN KEY(idUsuario)
    REFERENCES Usuario(idUsuario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(idProgramacionPelicula)
    REFERENCES ProgramacionPelicula(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE ReservacionFilaAsiento (
  idReservacionFilaAsiento  VARCHAR(25) NOT NULL,   
  idReservacion VARCHAR(20) NOT NULL,
  idFilaAsiento INT NOT NULL,
  numeroAsiento INT NOT NULL,
  fechaReservada DATE NULL,
  PRIMARY KEY(idReservacionFilaAsiento),
  INDEX ReservacionFilaAsiento_FKIndex1(idFilaAsiento),
  INDEX ReservacionFilaAsiento_FKIndex2(idReservacion),
  FOREIGN KEY(idFilaAsiento)
    REFERENCES FilaAsiento(idFilaAsiento)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(idReservacion)
    REFERENCES Reservacion(idReservacion)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);



DROP SCHEMA IF EXISTS gomu;

CREATE SCHEMA gomu;

USE gomu;

CREATE TABLE IF NOT EXISTS categorias(
    id_categoria INT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR (100) NOT NULL,
    CONSTRAINT PK_CATEGORIA PRIMARY KEY(id_categoria)  
);

CREATE TABLE IF NOT EXISTS libros(
    ISBN VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    costo DECIMAL(9,2) NOT NULL,
    id_categoria INT NOT NULL,
    autor VARCHAR(50) NOT NULL,
    CONSTRAINT PK_LIBRO PRIMARY KEY(ISBN),
    CONSTRAINT FK_TO_CATEGORIA FOREIGN KEY(id_categoria) REFERENCES categorias(id_categoria) ON UPDATE CASCADE

);

CREATE TABLE IF NOT EXISTS bibliotecas(
    id_biblioteca INT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    CONSTRAINT PK_BIBLIOTECA PRIMARY KEY(id_biblioteca)
);

CREATE TABLE IF NOT EXISTS libreria (
    ISBN VARCHAR(50) NOT NULL,
    id_biblioteca INT NOT NULL,
    existencia INT NOT NULL,
    CONSTRAINT PK_LIBRERIA PRIMARY KEY (ISBN, id_biblioteca)
);

CREATE TABLE IF NOT EXISTS usuario(
    id_usuario INT NOT NULL,
    nombre VARCHAR (50) NOT NULL,
    username VARCHAR (50) NOT NULL,
    estado TINYINT NOT NULL,
    tipo ENUM ('administrador', 'recepcionista','transportista','usuarioFinal') NOT NULL,
    contrasenia VARCHAR (8) NOT NULL,
    email VARCHAR (50) NOT NULL,
    CONSTRAINT PK_USUARIO PRIMARY KEY (id_usuario)
);

CREATE TABLE IF NOT EXISTS administrador (
    id_administrador VARCHAR(50) NOT NULL,
    id_usuario INT NOT NULL,
    CONSTRAINT PK_ADMIN PRIMARY KEY (id_administrador),
    CONSTRAINT FK_USUARIO FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario) ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS recepcionista(
    id_recepcionista INT NOT NULL,
    id_biblioteca INT NOT NULL,
    id_usuario INT NOT NULL,
    CONSTRAINT PK_RECEPCIONISTA PRIMARY KEY(id_recepcionista),
    CONSTRAINT FK_USUARIO_RECEPCIONISTA FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) ON UPDATE CASCADE,
    CONSTRAINT FK_BIBLIOTECA_RECEPCIONISTA FOREIGN KEY(id_biblioteca) REFERENCES bibliotecas(id_biblioteca) ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS transportista(
    id_transportista INT NOT NULL,
    id_biblioteca INT NOT NULL,
    id_usuario INT NOT NULL,
    CONSTRAINT PK_TRANSPORTISTA PRIMARY KEY(id_transportista),
    CONSTRAINT FK_USUARIO_TRANSPORTISTA FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) on UPDATE CASCADE,
    CONSTRAINT FK_BIBLIOTECA_TRANSPORTISTA FOREIGN KEY(id_biblioteca) REFERENCES bibliotecas(id_biblioteca) ON UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS usuario_final(
    id_usuarioFinal  INT NOT NULL,
    saldoInicial DECIMAL(9,2),
    id_usuario INT NOT NULL,
    CONSTRAINT PK_USUARIO_FINAL PRIMARY KEY(id_usuarioFinal),
    CONSTRAINT FK_USUARIO_USUARIOFINAL FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) on UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS solicitudes_de_prestamos(
    id_solicitud INT NOT NULL,
    id_biblioteca INT NOT NULL,
    id_usuarioFinal INT NOT NULL,
    id_transportista INT NOT NULL,
    id_recepcionista INT NOT NULL,
    tipoEntrega enum ('DOMICILIO' , 'PRESENCIAL') NOT NULL,
    estado BOOLEAN NOT NULL,
    fecha DATE NOT NULL,
    ISBN VARCHAR(50) NOT NULL,
    CONSTRAINT PK_SOLICITUD_DE_PRESTAMO PRIMARY KEY(id_solicitud),
    CONSTRAINT FK_BIBLIOTECA_SOLICITUD_PRESTAMOS FOREIGN KEY(id_biblioteca) REFERENCES bibliotecas(id_biblioteca) ON UPDATE CASCADE,
    CONSTRAINT FK_RECEPCIONISTA_SOLICITUD_PRESTAMOS FOREIGN KEY(id_recepcionista) REFERENCES recepcionista(id_recepcionista) ON UPDATE CASCADE,
    CONSTRAINT FK_USUARIO_FINAL_SOLICITUD_PRESTAMOS FOREIGN KEY(id_usuarioFinal) REFERENCES usuario_final(id_usuarioFinal) ON UPDATE CASCADE,
    CONSTRAINT FK_LIBRO_SOLICITUD_PRESTAMOS FOREIGN KEY(ISBN) REFERENCES libros(ISBN) ON UPDATE CASCADE,
    CONSTRAINT FK_TRANSPORTISTA_SOLICITUD_PRESTAMOS FOREIGN KEY(id_transportista) REFERENCES transportista(id_transportista) ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS prestamos (
    id_prestamos INT NOT NULL,
    id_biblioteca INT NOT NULL,
    id_recepcionista INT NOT NULL,
    id_usuarioFinal INT NOT NULL,
    ISBN VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    estado BOOLEAN NOT NULL,
    multa DECIMAL(9,2) NOT NULL,
    CONSTRAINT PK_PRESTAMO PRIMARY KEY(id_prestamos),
    CONSTRAINT FK_BIBLIOTECA_PRESTAMO FOREIGN KEY(id_biblioteca) REFERENCES bibliotecas(id_biblioteca) ON UPDATE CASCADE,
    CONSTRAINT FK_RECEPCIONISTA_PRESTAMO FOREIGN KEY(id_recepcionista) REFERENCES recepcionista(id_recepcionista) on UPDATE CASCADE,
    CONSTRAINT FK_USUARIO_FINAL_PRESTAMO FOREIGN KEY(id_usuarioFinal) REFERENCES usuario_final(id_usuarioFinal) ON UPDATE CASCADE,
    CONSTRAINT FK_LIBRO_PRESTAMO FOREIGN KEY(ISBN) REFERENCES libros(ISBN) ON UPDATE CASCADE
);

 CREATE TABLE IF NOT EXISTS transporte_entre_bibliotecas(
    id_tb INT NOT NULL,
    id_biblioteca_origen INT NOT NULL,
    id_biblioteca_destino INT NOT NULL,
    id_recepcionista INT NOT NULL,
    id_transportista INT NOT NULL,
    fecha DATE NOT NULL,
    estado BOOLEAN NOT NULL,
    CONSTRAINT PK_BIBLIOTECA_TRANSPORTE PRIMARY KEY (id_tb),
    CONSTRAINT FK_BIBLIOTECA_TB_ORIGEN FOREIGN KEY (id_biblioteca_origen) REFERENCES bibliotecas(id_biblioteca) ON UPDATE CASCADE,
    CONSTRAINT FK_BIBLIOTECA_TB_DESTINO FOREIGN KEY (id_biblioteca_destino) REFERENCES bibliotecas(id_biblioteca) ON UPDATE CASCADE,
    CONSTRAINT FK_RECEPCIONISTA_TB FOREIGN KEY (id_recepcionista) REFERENCES recepcionista(id_recepcionista) ON UPDATE CASCADE,
    CONSTRAINT FK_TRANSPORTISTA_TB FOREIGN KEY (id_transportista) REFERENCES transportista(id_transportista) ON UPDATE CASCADE
 );

CREATE TABLE IF NOT EXISTS detalles_libros(
    ISBN VARCHAR(50) NOT NULL,
    id_tb INT NOT NULL,
    unidades INT NOT NULL,
    CONSTRAINT PK_DETALLES_LIBROS PRIMARY KEY(ISBN, id_tb )
);



CREATE TABLE IF NOT EXISTS transporte_a_usuarios (
    id_trasporteUsuarios INT NOT NULL,
    id_biblioteca INT NOT NULL,
    id_usuarioFinal INT NOT NULL,
    ISBN VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    estado BOOLEAN NOT NULL,
    multa DECIMAL(9,2) NOT NULL,
    CONSTRAINT PK_TRANSPORTE_A_USUARIOS PRIMARY KEY(id_trasporteUsuarios),
    CONSTRAINT FK_BIBLIOTECA_TRANSPORTEUSUARIOS FOREIGN KEY(id_biblioteca) REFERENCES bibliotecas(id_biblioteca) ON UPDATE CASCADE,
    CONSTRAINT FK_USUARIO_FINAL_TRANSPORTEUSUARIOS  FOREIGN KEY(id_usuarioFinal) REFERENCES usuario_final(id_usuarioFinal) ON UPDATE CASCADE,
    CONSTRAINT FK_LIBRO_TRANSPORTEUSUARIOS  FOREIGN KEY(ISBN) REFERENCES libros(ISBN) ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS incidencias (
    id_incidencias INT NOT NULL,
    id_prestamos INT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    cantidadPagada DECIMAL(9,2) NOT NULL,
    CONSTRAINT PK_INCIDENCIA PRIMARY KEY(id_incidencias),
    CONSTRAINT FK_PRESTAMO_INCIDENCIAS FOREIGN KEY(id_prestamos) REFERENCES prestamos(id_prestamos) ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS solicitudes_revocacion (
    id_solicitudRevocacion INT NOT NULL,
    id_usuarioFinal INT NOT NULL,
    estado VARCHAR(50) NOT NULL,
    detalle TEXT NOT NULL,
    CONSTRAINT PK_SOLICITUD_REVOCACION PRIMARY KEY(id_solicitudRevocacion),
    CONSTRAINT FK_USUARIO_SOLICITUD_REVOCACION FOREIGN KEY(id_usuarioFinal) REFERENCES usuario_final(id_usuarioFinal) ON UPDATE CASCADE
);

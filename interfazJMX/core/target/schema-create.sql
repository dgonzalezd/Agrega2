
    drop table if exists PROPIEDAD;

    create table PROPIEDAD (
        NOMBRE VARCHAR(255) BINARY not null,
        VALOR VARCHAR(255) BINARY not null,
        DESCRIPCION VARCHAR(255) BINARY not null,
        EJEMPLO VARCHAR(255) BINARY not null,
        primary key (NOMBRE)
    );

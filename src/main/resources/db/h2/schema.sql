DROP TABLE veterinario_especialidad IF EXISTS;
DROP TABLE veterinario IF EXISTS;
DROP TABLE especialidad IF EXISTS;
DROP TABLE visita IF EXISTS;
DROP TABLE mascota IF EXISTS;
DROP TABLE tipo IF EXISTS;
DROP TABLE propietario IF EXISTS;


CREATE TABLE veterinario (
  id INTEGER IDENTITY PRIMARY KEY,
  nif VARCHAR(9) NOT NULL UNIQUE,
  nombre VARCHAR(30) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  direccion VARCHAR(80) NOT NULL,
  cp VARCHAR(5) NOT NULL,
  municipio VARCHAR(30) NOT NULL,
  provincia VARCHAR(30) NOT NULL,
  telefono VARCHAR(12),
  email VARCHAR(30)
);
CREATE INDEX veterinario_apellidos ON veterinario (apellidos);

CREATE TABLE especialidad (
  id INTEGER IDENTITY PRIMARY KEY,
  nombre VARCHAR(80)
);
CREATE INDEX especialidad_nombre ON especialidad (nombre);

CREATE TABLE veterinario_especialidad (
  veterinario_id INTEGER NOT NULL,
  especialidad_id INTEGER NOT NULL
);
ALTER TABLE veterinario_especialidad ADD CONSTRAINT fk_veterinario_especialidad_veterinario FOREIGN KEY (veterinario_id) REFERENCES veterinario (id);
ALTER TABLE veterinario_especialidad ADD CONSTRAINT fk_veterinario_especialidad_especialidad FOREIGN KEY (especialidad_id) REFERENCES especialidad (id);

CREATE TABLE tipo (
  id INTEGER IDENTITY PRIMARY KEY,
  nombre VARCHAR(80)
);
CREATE INDEX tipo_nombre ON tipo (nombre);

CREATE TABLE propietario (
  id INTEGER IDENTITY PRIMARY KEY,
  nif VARCHAR(9) NOT NULL UNIQUE,
  nombre VARCHAR(30) NOT NULL,
  apellidos VARCHAR_IGNORECASE(30),
  direccion VARCHAR(80) NOT NULL,
  cp VARCHAR(5) NOT NULL,
  municipio VARCHAR(30) NOT NULL,
  provincia VARCHAR(30) NOT NULL,
  telefono VARCHAR(12),
  email VARCHAR(30)
);
CREATE INDEX propietario_apellidos ON propietario (apellidos);

CREATE TABLE mascota (
  id INTEGER IDENTITY PRIMARY KEY,
  nombre VARCHAR(30) NOT NULL,
  fecha_nacimiento DATE,
  tipo_id INTEGER NOT NULL,
  propietario_id INTEGER NOT NULL
);
ALTER TABLE mascota ADD CONSTRAINT fk_mascota_propietario FOREIGN KEY (propietario_id) REFERENCES propietario (id);
ALTER TABLE mascota ADD CONSTRAINT fk_mascota_tipo FOREIGN KEY (tipo_id) REFERENCES tipo (id);
CREATE INDEX mascota_nombre ON mascota (nombre);

CREATE TABLE visita (
  id INTEGER IDENTITY PRIMARY KEY,
  mascota_id INTEGER NOT NULL,
  fecha_visita DATE,
  descripcion VARCHAR(255)
);
ALTER TABLE visita ADD CONSTRAINT fk_visita_mascota FOREIGN KEY (mascota_id) REFERENCES mascota (id);
CREATE INDEX visita_mascota_id ON visita (mascota_id);


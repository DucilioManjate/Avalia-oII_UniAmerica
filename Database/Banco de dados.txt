USE prova;
CREATE TABLE usuario(
id INTEGER NOT NULL AUTO_INCREMENT,
email VARCHAR(50) NOT NULL UNIQUE,
senha VARCHAR(20) NOT NULL,
PRIMARY KEY(id));

CREATE TABLE filme(
id INTEGER NOT NULL AUTO_INCREMENT,
nome VARCHAR(40) NOT NULL,
duracao INT NOT NULL,
PRIMARY KEY(id));

CREATE TABLE genero(
id INTEGER NOT NULL AUTO_INCREMENT,
nome VARCHAR(40) NOT NULL,
PRIMARY KEY(id));

CREATE TABLE rel_usuario_filme( 
id_usuario INTEGER NOT NULL, 
id_filme INTEGER NOT NULL, 
PRIMARY KEY(id_usuario, id_filme), 
CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id), 
CONSTRAINT fk_filme FOREIGN KEY (id_filme) REFERENCES filme(id));

CREATE TABLE rel_filme_genero(
id_filme INTEGER NOT NULL,
id_genero INTEGER NOT NULL,
PRIMARY KEY(id_filme, id_genero),
CONSTRAINT fk_genero FOREIGN KEY (id_genero) REFERENCES genero(id),
CONSTRAINT fk_filme FOREIGN KEY (id_filme) REFERENCES filme(id));
CREATE DATABASE dbos2025;
USE dbos2025;

CREATE TABLE tbusuarios(
	iduser INT PRIMARY KEY,
    usuario VARCHAR(15) NOT NULL,
    fone VARCHAR(15),
    login VARCHAR(15) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL,
    perfil VARCHAR(20) NOT NULL
);

SELECT * FROM tbusuarios;

DESCRIBE tbusuarios;

INSERT INTO tbusuarios(iduser, usuario, fone, login, senha, perfil) 
VALUES (1,"Pedro", "(66) 996131680", "pedro.usuario","pedro123","Sim");

CREATE TABLE tbclientes(
	idcli INT PRIMARY KEY AUTO_INCREMENT,
    nomecli VARCHAR(50) NOT NULL,
    endcli VARCHAR(100),
    fonecli VARCHAR(15) NOT NULL,
    emailcli VARCHAR(50) UNIQUE
);

DESCRIBE tbclientes;

SELECT * FROM tbclientes;
INSERT INTO tbclientes (nomecli, endcli, fonecli, emailcli)
VALUES ("Lewis","2021 roubado","(66) 9920184451","lewis.willsmith");

CREATE TABLE tbos(
	os INT PRIMARY KEY AUTO_INCREMENT,
    data_os TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo VARCHAR(15) NOT NULL,
    situacao VARCHAR(20) NOT NULL,
    equipamento VARCHAR(150) NOT NULL,
    defeito VARCHAR(150),
    servico VARCHAR(150),
    tecnico VARCHAR(30),
    valor DECIMAL(10,2),
    idcli INT NOT NULL,
    FOREIGN KEY(idcli) REFERENCES tbclientes(idcli)
);	
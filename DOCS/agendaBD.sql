CREATE TABLE contatos(
id SERIAL PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
endereco VARCHAR(80),
email VARCHAR(30)
);

drop table contatos cascade;
CREATE TABLE telefones(
id SERIAL PRIMARY KEY,
residencial VARCHAR(10),
celular VARCHAR(10),
id_contatos INTEGER REFERENCES contatos (id)
);

drop table telefones cascade;
INSERT INTO contatos (nome,endereco,email) values
('Renato Borba','Rua Pepino nº 315','renato@gmail.com');
INSERT INTO contatos (nome,endereco,email) values
('Claudia Leite','Rua Vaca nº 33','claudia@gmail.com');
INSERT INTO contatos (nome,endereco,email) values
('Rodrigo Bosta','Rua Mumu nº 99','rodrigo@gmail.com');


select * from  contatos;

INSERT INTO telefones(residencial,celular,id_contatos) VALUES
('33445155','99449933',1);
INSERT INTO telefones(residencial,celular,id_contatos) VALUES
('34536776','91234345',2);
INSERT INTO telefones(residencial,celular,id_contatos) VALUES
('22436889','84167878',3);

select * from telefones;


select * from contatos c join telefones t on c.id=t.id_contatos;
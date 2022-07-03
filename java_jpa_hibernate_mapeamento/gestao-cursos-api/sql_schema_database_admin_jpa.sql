-- TABLE
CREATE TABLE Aluno (id bigint not null, email varchar(255), matricula varchar(255), nascimento date, nomeCompleto varchar(255), curso_id bigint, primary key (id));
CREATE TABLE Aluno_Endereco (Aluno_id bigint not null, enderecos_id bigint not null, unique (enderecos_id));
CREATE TABLE Aluno_Telefone (Aluno_id bigint not null, telefones_id bigint not null, unique (telefones_id));
CREATE TABLE Curso (id bigint not null, nome varchar(255), sigla varchar(255), material_id bigint, professor_id bigint, primary key (id));
CREATE TABLE Endereco (id bigint not null, bairro varchar(255), cep integer, cidade varchar(255), endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), primary key (id));
CREATE TABLE hibernate_sequence (next_val bigint);
CREATE TABLE MaterialCurso (id bigint not null, url varchar(255), primary key (id));
CREATE TABLE Professor (id bigint not null, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (id));
CREATE TABLE Telefone (id bigint not null, DDD varchar(255), numero varchar(255), primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 

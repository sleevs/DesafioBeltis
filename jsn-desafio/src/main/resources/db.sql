usuario
projeto
tarefa



CREATE TABLE usuario (
  usuario_id SERIAL PRIMARY KEY, 
  usuario_nome VARCHAR (50), 
  usuario_email VARCHAR (20) 
);

CREATE TABLE projeto (
  projeto_id SERIAL PRIMARY KEY, 
  projeto_titulo VARCHAR (50), 
  projeto_descricao VARCHAR (200), 
  projeto_data TIMESTAMP,
  usuario_id INT  );

CREATE TABLE projeto_1 (
  projeto_id SERIAL PRIMARY KEY, 
  projeto_titulo VARCHAR (50), 
  projeto_descricao VARCHAR (200), 
  projeto_data TIMESTAMP,
  usuario_id INT  );


CREATE TABLE tarefa (
  tarefa_id SERIAL PRIMARY KEY, 
  tarefa_titulo VARCHAR (50), 
  tarefa_descricao VARCHAR (200), 
  tarefa_prioridade VARCHAR (20),
  tarefa_estimativa VARCHAR (20),
  projeto_id INT
);

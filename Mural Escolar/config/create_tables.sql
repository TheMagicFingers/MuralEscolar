CREATE TABLE aluno(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                  nome TEXT NOT NULL,
                  email TEXT NOT NULL,
                  senha TEXT NOT NULL,
                  matricula TEXT NOT NULL,
                  curso TEXT NOT NULL);

CREATE TABLE professor(id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL,
                  nome TEXT NOT NULL,
                  email TEXT NOT NULL,
                  senha TEXT NOT NULL,
                  cpf TEXT NOT NULL,
                  siape TEXT NOT NULL);

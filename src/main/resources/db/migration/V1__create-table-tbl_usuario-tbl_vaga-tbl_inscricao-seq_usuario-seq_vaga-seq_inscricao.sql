-- TABELA CANDIDATO
CREATE TABLE candidato (
    id NUMBER PRIMARY KEY,
    nome VARCHAR2(100),
    email VARCHAR2(100) UNIQUE,
    marcador_diversidade CHAR(1) CHECK (marcador_diversidade IN ('S', 'N'))
);

CREATE SEQUENCE seq_candidato START WITH 1 INCREMENT BY 1;

-- TABELA VAGA
CREATE TABLE vaga (
    id NUMBER PRIMARY KEY,
    titulo VARCHAR2(100),
    descricao CLOB
);

CREATE SEQUENCE seq_vaga START WITH 1 INCREMENT BY 1;

-- TABELA INSCRICAO
CREATE TABLE inscricao (
    id NUMBER PRIMARY KEY,
    candidato_id NUMBER,
    vaga_id NUMBER,
    FOREIGN KEY (candidato_id) REFERENCES candidato(id),
    FOREIGN KEY (vaga_id) REFERENCES vaga(id)
);

CREATE SEQUENCE seq_inscricao START WITH 1 INCREMENT BY 1;

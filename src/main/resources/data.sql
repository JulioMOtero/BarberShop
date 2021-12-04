
-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;
DROP TABLE IF  exists  Produto_Venda;
DROP TABLE IF  exists  Produtos;
DROP table IF  exists  Categoria;
DROP TABLE IF  exists  Venda;
DROP TABLE IF  exists  Agendamento;
DROP TABLE IF  exists  Barbeiro;


DROP TABLE IF  exists  Funcionario;





DROP TABLE IF  exists  Cliente;




-- ************************************** Categoria

CREATE TABLE Categoria
(
 id_categoria integer NOT NULL,
 nome         varchar(50) NOT NULL,
 CONSTRAINT PK_143 PRIMARY KEY ( id_categoria )
);


-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;





-- ************************************** Produtos

CREATE TABLE Produtos
(
 nome         varchar(50) NOT NULL,
 id_categoria integer NOT NULL,
 valor        integer NOT NULL,
 id_produto   integer NOT NULL,
 CONSTRAINT PK_95 PRIMARY KEY ( id_produto ),
 CONSTRAINT FK_145 FOREIGN KEY ( id_categoria ) REFERENCES Categoria ( id_categoria )
);

CREATE INDEX FK_147 ON Produtos
(
 id_categoria
);

-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;





-- ************************************** Funcionario

CREATE TABLE Funcionario
(
 id_funcionario integer NOT NULL,
 nome           varchar(50) NOT NULL,
 cargo          varchar(50) NOT NULL,
 CONSTRAINT PK_64 PRIMARY KEY ( id_funcionario )
);

-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;





-- ************************************** Barbeiro

CREATE TABLE Barbeiro
(
 id_funcionario integer NOT NULL,
 id_barbeiro    integer NOT NULL,
 CONSTRAINT PK_87 PRIMARY KEY ( id_barbeiro ),
 CONSTRAINT FK_118 FOREIGN KEY ( id_funcionario ) REFERENCES Funcionario ( id_funcionario )
);

CREATE INDEX fkIdx_61 ON Barbeiro
(
 id_funcionario
);

-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;



-- ************************************** Cliente

CREATE TABLE Cliente
(
 id_cliente integer NOT NULL,
 email      varchar(50) NOT NULL,
 qtd_cortes integer NOT NULL,
 CONSTRAINT PK_70 PRIMARY KEY ( id_cliente )
);

-- Warning: You can generate script only for one table/view at a time in your Free plan
--
-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;




-- ************************************** Agendamento

CREATE TABLE Agendamento
(
 horario        date NOT NULL,
 id_cliente     integer NOT NULL,
 servico        varchar(50) NOT NULL,
 id_barbeiro    integer NOT NULL,
 id_agendamento integer NOT NULL,
 CONSTRAINT PK_109 PRIMARY KEY ( id_agendamento ),
 CONSTRAINT FK_998 FOREIGN KEY ( id_cliente ) REFERENCES Cliente ( id_cliente ),
 CONSTRAINT FK_124 FOREIGN KEY ( id_barbeiro ) REFERENCES Barbeiro ( id_barbeiro )
);

CREATE INDEX FK_120 ON Agendamento
(
 id_cliente
);

CREATE INDEX FK_126 ON Agendamento
(
 id_barbeiro
);

-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;





-- ************************************** Venda

CREATE TABLE Venda
(
 id_agendamento integer NULL,
 id_funcionario integer NOT NULL,
 id_cliente     integer NOT NULL,
 valor_total    integer NOT NULL,
 pago           boolean NOT NULL,
 id_venda       integer NOT NULL,
 CONSTRAINT PK_106 PRIMARY KEY ( id_venda ),
 CONSTRAINT FK_127 FOREIGN KEY ( id_agendamento ) REFERENCES Agendamento ( id_agendamento ),
 CONSTRAINT FK_138 FOREIGN KEY ( id_funcionario ) REFERENCES Funcionario ( id_funcionario ),
 CONSTRAINT FK_999 FOREIGN KEY ( id_cliente ) REFERENCES Cliente ( id_cliente )
);

CREATE INDEX FK_129 ON Venda
(
 id_agendamento
);

CREATE INDEX FK_140 ON Venda
(
 id_funcionario
);

CREATE INDEX fkIdx_71 ON Venda
(
 id_cliente
);

-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;





-- ************************************** Produto_Venda

CREATE TABLE Produto_Venda
(
 qtd_produtos integer NOT NULL,
 id_produto   integer NOT NULL,
 id_venda     integer NOT NULL,
 CONSTRAINT PK_111 PRIMARY KEY ( id_produto, id_venda ),
 CONSTRAINT FK_102 FOREIGN KEY ( id_venda ) REFERENCES Venda ( id_venda ),
 CONSTRAINT FK_96 FOREIGN KEY ( id_produto ) REFERENCES Produtos ( id_produto )
);

CREATE INDEX fkIdx_104 ON Produto_Venda
(
 id_venda
);

CREATE INDEX fkIdx_98 ON Produto_Venda
(
 id_produto
);

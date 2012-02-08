---
layout: post
title: "Scripts Flyway"
author: "Hellen Escarate"
user: "hescarate"
published: true
tags:
- flyway migration 
- procedimento
- script flyway 
- mysql
---


## Scripts Flyway 

No diretório src/main/resources crie o diretório: db/migration/

Importante:
NUNCA usar um arquivo existente, sempre criar um arquivo novo. 
NUNCA editar um script antigo, ainda que esteja errado.


```
drop table if exists BASE.TABELA;

create table BASE.TABELA
(ID integer not null auto_increment,
NOME varchar(60),
CODIGO varchar(20),
DATA date not null,
DATA_HORA datetime not null,
ENTIDADE_RELACIONADA_ID integer not null,
IDADE tinyint,
VERDADE_FALSO tinyint,

primary key (ID),
UNIQUE (CODIGO)
) ENGINE=InnoDB;
```


Algo importante é pensar na especificação quando se cria uma tabela, é interessante saber se os campos podem ser nulos, 
se algum campo deve ser único, mas no geral os deve ser seguido o padrão acima.

ID: Por ser chave primária o ID não pode ser nulo. 
NOME: por padrão pode ser usado o tamanho 60.
CODIGO: por padrão pode ser usado o tamanho 20.
DATA: o tipo data armazena uma data comum. (ano, mês e dia)
DATA_HORA: o tipo date time armazenada data e hora (ano, mês, dia hora, min, seg)
ENTIDADE_RELATIONADA_ID: esse campo em questão é uma chave estrangeira e deve ser idêntico a chave primária da entidade. 
IDADE: pode ser usado nesse campo o tipo tinyint, é o menor valor que podemos armazenar (de -128 à 127, ou de 0 à 255). 1 byte
VERDADE_FALSO também podemos usar o tipo acima. 0 = false, e 1 = true. 

**Conclusão 

**Referências









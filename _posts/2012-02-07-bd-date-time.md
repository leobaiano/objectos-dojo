---
layout: post
title: "Representando datas no banco de dados"
author: "Hellen Escarate"
user: "hescarate"
published: true
tags:
- banco de dados
- datetime
- mysql
- procedimento
---

## Como representar data no banco de dados: 

*No script Flyway* 

```
create table BASE.TABELA
(ID integer not null auto_increment,
DATA date not null,
DATA_HORA datetime not null,

primary key (ID)) ENGINE=InnoDB;
```

*No Teste:*

```
int id = 1;
LocalDate data = new LocalDate(2012, 1, 1);
DateTime  dataHora = new DateTime(2012, 1, 1, 18, 0, 0);

Proposta res = buscarProposta.porId(id);

assertThat(res.getId(), equalTo(id));
assertThat(res.getData(), equalTo(data));
assertThat(res.getDataDeCriacao(), equalTo(dataCriacao));
```

*No mini-arquivo arquivo:* 

```
<BASE.TABELA 
ID="1"
DATA="2012-01-01"
DATA_HORA="2012-01-01 10:00:00" />
```


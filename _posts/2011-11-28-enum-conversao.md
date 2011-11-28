---
layout: post-alpha
title: "Enum :: Conversão de Enum"
autor: "Afonso Jardim Filgueiras"
published: true 
tags:
- dojo
- aprendizes
- enum
---

## Conversão de Enum

Antes de convertermos uma Enum, é preciso saber o tipo definido no JPA, ORDINAL ou STRING.

Caso o tipo da Enum esteja definido como ORDINAL, utilizamos o seguinte código para conversão: 

    public Nome getNome() {
      int value = rs.getInt("TABELA.NOME");
      Nome[] values = Nome.values();
      return values[value];
    }


Caso o tipo da Enum esteja definido como STRING, utilizamos o seguinte código para conversão:

    public Nome getNome() {
      String val = rs.getString("TABELA.NOME");
      Nome res = Nome.valueOf(val);
      return res;
    }


E os asserts ficarão dessa forma:

    List<ConsultaDaClasse> res = consulta.list();
    List<Nome> nomes = transform(res, new ToNome());
   
    assertThat(nomes.size(), equalTo(3));
    assertThat(nomes.get(0), equalTo(Nome.AFONSO));
    assertThat(nomes.get(1), equalTo(Nome.HELEN));
    assertThat(nomes.get(2), equalTo(Nome.MARCOS));

    private class ToNome implements Function<ConsultaDaClasse, Nome> {
      @Override
      public Nome apply(ConsultaDaClasse input) {
     	return input.Nome;
      }
    }


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

    public String getNome() {
      int value = rs.getInt("TABELA.NOME");
      Nome[] values = Nome.values();
      return values[value].toString();
    }


E os asserts ficarão dessa forma:

    List<String> nomes = transform(res, new ToNome());
    assertThat(nomes.size(), equalTo(3));
    assertThat(nomes.get(0), equalTo("AFONSO"));
    assertThat(nomes.get(1), equalTo("HELEN"));
    assertThat(nomes.get(2), equalTo("MARCOS"));


Caso o tipo da Enum esteja definido como STRING, utilizamos o seguinte código para conversão:

    public CotaAberturaFechamento getCotaDeAbertura() {
      String val = rs.getString("TABELA.NOME");
      CotaAberturaFechamento res = CotaAberturaFechamento.valueOf(val);
    return res;
    }



E os asserts ficarão dessa forma:

    List<Nome> nomes = transform(res, new ToNome());
    assertThat(nomes.size(), equalTo(3));
    assertThat(nomes.get(0), equalTo(Nome.AFONSO));
    assertThat(nomes.get(1), equalTo(Nome.HELEN));
    assertThat(nomes.get(2), equalTo(Nome.MARCOS));

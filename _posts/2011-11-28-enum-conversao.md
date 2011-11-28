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

Dada a seguinte Enum:

        public enum Estagiario{
                AFONSO,
                HELLEN,
                MARCOS
        }

O teste de enum será parecido com isso:

    List<ListaDeEstagiario> res = consulta.list();
    List<Nome> nomes = transform(res, new ToNome());

    assertThat(nomes.size(), equalTo(3));
    assertThat(nomes.get(0), equalTo(Estagiario.AFONSO));
    assertThat(nomes.get(1), equalTo(Estagiario.HELLEN));
    assertThat(nomes.get(2), equalTo(Estagiario.MARCOS));

    private class ToNome implements Function<ListaDeEstagiarios, Estagiario> {
        @Override
        public Estagiario apply(ListaDeEstagiarios input) {
          return input.Estagiario;
        }
    }

O tipo dessa Enum pode estar definida de duas maneiras no JPA. ORDINAL ou STRING.

No caso de uma Enum do tipo ORDINAL, ela estará gravada da seguinte maneira no banco de dados:

    +-----------+------------+
    | MATRICULA | ESTAGIARIO |
    +-----------+------------+
    |  31256    |     0      |
    |  51476    |     1      |
    |  32569    |     2      |
    +-----------+------------+

Nesse caso, 0 = AFONSO, 1 = HELLEN e 2 = MARCOS. Seguindo a ordem que as propriedades são definidas no código.

No caso de uma Enum do tipo STRING, ela estará gravada da seguinte maneira do banco de dados

    +-----------+------------+
    | MATRICULA | ESTAGIARIO |
    +-----------+------------+
    |  31256    |   AFONSO   |
    |  51476    |   HELLEN   |
    |  32569    |   MARCOS   |
    +-----------+------------+

Observe que nesse caso de uma Enum do tipo String, as propriedades gravadas no banco de dados são idênticas as do código.

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

---
layout: post
title: "Teste de Form Create"
author: "Hellen Escarate"
user: "hescarate"
published: true
tags: 
- procedimento
---

## Entendendo TesteDeFormCreate

1) Entender o problema do mundo real, de fato o que deve ser feito.

ex: Cadastrar alunos para uma determinada instituição de ensino.  
Partindo do ponto em que o cliente já vai estar na página que lista as instituições de ensino, e deve cadastrar alunos
para uma determinada instituição. 
pensar na url: "api/crud/instituicao/1/alunos"

2) Pensar em quais dados o cliente precisará cadastrar, por exemplo:
nome e cpf; 

3) No método form_deve_gravar_no_bd:
a) deve ser simulado os dados que o cliente vai entrar, ex:
int cpf = 999.999.999-99
String nome = AlunoA; 

Pensando nesses dados, o que seria importante para gravar esse cadastro no banco de dados?
- pode ser cadastrado um cpf que já existe?
- qual a condição para cadastrar um novo cpf (aluno)?



1 - Inserir a anotação @Test

2 - extends TesteDeFormAbstratoCreate.
Caso não exista, é necessário criá-lo. 

3 - depois do item anterior pode ser observado erro de compilação, portanto use CRTL+1 p/ adicionar os métodos não
implementados.

4 - Caso necessário chame o buscador.

5 - No método que foi implementado depois de usar o CTRL+1, insira a URL: ]

```
  @Override
    String URL() {
        return "api/crud/plano/1/politica_investimento";
    }
```


6 - Se agora for rodado o teste, certamente no console aparecerá o erro 404, pois a URL não foi encontrada, então o
próximo passo é adicionar a URL no Módulo. 

..... procedimento....... 

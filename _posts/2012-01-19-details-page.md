---
layout: post
title: "Details Page"
author: "Marcio Endo"
user: "mendo"
published: true 
tags:
- padrão objectos
- procedimento
- sitebricks
- web
---

## Details Page

Implementando página de detalhes nos padrões objectos.

Assume conhecimento em:

* Java
* SiteBricks 
* HTML
* CSS

### Erros comuns

Listados abaixo alguns erros comuns:

#### Para cada variável declarada no HTML existe um getter em sua classe Java?

Para que o código abaixo funcione:

	<dl>
	  <dt>Tipo</dt>
	  <dd>${minhaEntidade.nome}</dd>
	</dl>
	
Sua classe Java deve possuir um getter para a propriedade `minhaEntidade`

	public class DetailsPage {
	  private Entidade minhaEntidade;
	  
	  public Entidade getMinhaEntidade() {
	    return minhaEntidade;
	  }
	}
	
Além disso o objeto retornado deve possuir um getter para a propriedade `nome`

	public class Entidade {
	   private String nome;
	   
	   public String getNome() {
	     return nome;
	   }
	}
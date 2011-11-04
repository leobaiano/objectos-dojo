/*
 * StringFormat.java criado em 04/11/2011
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.dificuldades;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

/**
 * @author hellen.escarate@objectos.com.br (Hellen Escarate)
 */
@Test
public class StringFormat {

  public void quando_precisar_retornar_um_string_format_consulte_aqui() {
    String nome = "Hellen";
    String sobrenome = "Escarate";

    String res = String.format("%s - %s", nome, sobrenome);

    assertThat(res, equalTo("Hellen - Escarate"));
  }

}

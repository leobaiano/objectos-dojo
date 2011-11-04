/*
 * DojoEnum.java criado em 04/11/2011
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
public class DojoEnum {

  public enum Tamanho {
    PEQUENO,
    MEDIO,
    GRANDE
  }

  public static class Cafe {

    public Tamanho getPequeno() {
      return Tamanho.PEQUENO;
    }

    public Tamanho getMedio() {
      return Tamanho.MEDIO;
    }

    public Tamanho getGrande() {
      return Tamanho.GRANDE;
    }

  }

  public void para_asserts_de_enum_faca_assim() {
    Cafe cafe = new Cafe();

    assertThat(cafe.getPequeno(), equalTo(Tamanho.PEQUENO));
    assertThat(cafe.getMedio(), equalTo(Tamanho.MEDIO));
    assertThat(cafe.getGrande(), equalTo(Tamanho.GRANDE));
  }
}

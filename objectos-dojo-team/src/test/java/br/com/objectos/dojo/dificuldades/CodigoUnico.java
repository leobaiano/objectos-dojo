/*
 * CodigoUnico.java criado em 28/10/2011
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.dificuldades;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

/**
 * @author hellen.escarate@objectos.com.br (Hellen Escarate)
 */
@Test
public class CodigoUnico {

  public void numeros_maiores_que_cinco_devem_retornar_true() {
    int numero = 7;

    assertTrue(maiorquecinco(numero));
  }

  public void numeros_menores_que_cinco_devem_retornar_false() {
    int numero = 0;

    assertFalse(maiorquecinco(numero));
  }

  public void numeros_iguais_a_cinco_devem_retornar_false() {
    int numero = 5;

    assertFalse(maiorquecinco(numero));
  }

  private boolean maiorquecinco(int i) {
    return i > 5;
  }

}

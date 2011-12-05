/*
 * EnumJdbc.java criado em 26/10/2011
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.dificuldades;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class EnumJdbc {

  public enum Estagiarios {
    MARCOS,
    HELEN,
    AFONSO
  }

  public void enum_deve_funcionar() {
    int val = 0;

    Estagiarios local = converter(val);

    assertEquals(local, Estagiarios.MARCOS);

    System.out.println(local);
  }

  public void enum_deve_falhar() {
    try {
      String val = "0";
      Estagiarios local = Estagiarios.valueOf(val);
      assertEquals(local, Estagiarios.MARCOS);
    } catch (IllegalArgumentException e) {

      e.printStackTrace();

    }

  }

  private Estagiarios converter(int val) {
    Estagiarios[] values = Estagiarios.values();
    return values[val];
  }

}

/*
 * TesteDeConversaoDeDateTime.java criado em 28/10/2011
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.dificuldades;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class ConversaoDeDateTime {

  public void para_criar_um_local_date_faca_assim() {
    LocalDate data = new LocalDate(2011, 10, 28);

    assertEquals(data.toString(), "2011-10-28");
  }

  public void quando_for_converter_localdate_para_datetime_NAO_faca_assim() {
    try {

      LocalDate data = new LocalDate(2011, 10, 28);
      DateTime dateTime = new DateTime(data);

      assertEquals(dateTime.toString(), "2011-10-28");

    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  public void FACA_ASSIM() {
    LocalDate data = new LocalDate(2011, 10, 28);
    DateTime res = data.toDateTimeAtStartOfDay();

    assertTrue(res.toString().startsWith("2011-10-28"));
  }

}
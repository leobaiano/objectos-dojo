/*
 * LocalDate.java criado em 01/11/2011
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.dificuldades;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

/**
 * @author afonso.filgueiras@objectos.com.br (Afonso J. Filgueiras)
 */
@Test
public class CompararLocalDate {

  public void para_comparar_datas_faca_assim() {
    int ano = 2011;
    int mes = 11;
    int dia = 1;

    LocalDate data = new LocalDate(ano, mes, dia);

    EntidadeQuePossuiData res = new EntidadeQuePossuiData(data);

    assertThat(res.getData(), equalTo(new LocalDate(ano, mes, dia)));
  }

  public void NAO_cometa_este_erro_comum() {
    int ano = 2011;
    int mes = 11;
    int dia = 1;

    LocalDate data = new LocalDate(ano, mes, dia);

    EntidadeQuePossuiData res = new EntidadeQuePossuiData(data);

    // NÃO!!! REPITO, NÃO FAÇA ASSIM
    // //--->
    // || ISTO ESTÁ ERRADO
    // || assertThat(res.getData(), equalTo("2011-11-01"))); ISTO NÃO COMPILA
    // || ISTO NÃO COMPILA
    // \\--->
    // NÃO!!! REPITO, NÃO FAÇA ASSIM

    // FAÇA ASSIM!!!!!!!
    assertThat(res.getData(), equalTo(new LocalDate(ano, mes, dia)));
  }

  public void uma_alternativa_seria() {
    int ano = 2011;
    int mes = 11;
    int dia = 1;

    LocalDate data = new LocalDate(ano, mes, dia);

    EntidadeQuePossuiData res = new EntidadeQuePossuiData(data);

    assertThat(res.getData(), equalTo(new LocalDate("2011-11-01")));
  }

  public void SEM_PARAMETROS_local_date_igual_a_hoje() {
    LocalDate hoje = new LocalDate();

    Date hojeJavaUtil = new Date();
    EntidadeQuePossuiData res = new EntidadeQuePossuiData(hoje);

    assertThat(res.getData(), equalTo(new LocalDate(hojeJavaUtil)));
  }

  private class EntidadeQuePossuiData {

    private final LocalDate data;

    public EntidadeQuePossuiData(LocalDate data) {
      this.data = data;
    }

    public LocalDate getData() {
      return data;
    }

  }

}
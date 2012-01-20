/*
* Copyright 2011 Objectos, Fábrica de Software LTDA.
*
* Licensed under the Apache License, Version 2.0 (the "License"); you may not
* use this file except in compliance with the License. You may obtain a copy of
* the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations under
* the License.
*/
package br.com.objectos.dojo.laboratorio;

import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

/**
 * @author afonso.filgueiras@objectos.com.br (Afonso J. Filgueiras)
 */
@Test
public class TesteDeConversaoTxt {

  private Conversor conversor;

  @BeforeClass
  public void carregaConversor() {
    conversor = new ConversorTxt();
  }

  public void lista_deve_conter_elementos_do_arquivo() throws IOException {
    InputStream arquivo = obterStream("Campeao.txt");

    List<Campeao> res = conversor.retornaCampeoes(arquivo);

    assertThat(res.size(), equalTo(3));

    List<Integer> anos = transform(res, new ToAno());
    assertThat(anos.get(0), equalTo(2011));
    assertThat(anos.get(1), equalTo(2010));
    assertThat(anos.get(2), equalTo(2009));

    List<String> times = transform(res, new ToTime());
    assertThat(times.get(0), equalTo("Corinthians"));
    assertThat(times.get(1), equalTo("Fluminense"));
    assertThat(times.get(2), equalTo("Flamengo"));
  }

  public void arquivo_nao_deve_existir() throws IOException {
    FileInputStream arquivo;
    try {
      arquivo = new FileInputStream("ArquivoNaoExistente.txt");
      List<Campeao> campeoes = conversor.retornaCampeoes(arquivo);
    } catch (FileNotFoundException e) {
      System.out.println();
      System.out.println("\n----- 404 ARQUIVO NÃO ENCONTRADO 404 -----");
      System.out.println();
    }
  }

  private InputStream obterStream(String nome) {
    ClassLoader classLoader = getClass().getClassLoader();

    return classLoader.getResourceAsStream("txt/" + nome);
  }

  private class ToAno implements Function<Campeao, Integer> {
    @Override
    public Integer apply(Campeao input) {
      return input.getAno();
    }
  }

  private class ToTime implements Function<Campeao, String> {
    @Override
    public String apply(Campeao input) {
      return input.getTime();
    }
  }

}

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

import static com.google.common.collect.Lists.newArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author afonso.filgueiras@objectos.com.br (Afonso J. Filgueiras)
 */
public class ConversorV2 implements Conversor {

  public List<String> arquivo(InputStream stream) throws IOException {
    List<String> texto = newArrayList();

    InputStreamReader arquivo = new InputStreamReader(stream);
    BufferedReader reader = new BufferedReader(arquivo);
    String linha = reader.readLine();

    while (linha != null) {
      texto.add(linha);
      linha = reader.readLine();
    }

    arquivo.close();

    return texto;
  }

  @Override
  public List<Campeao> retornaCampeoes(InputStream stream) throws IOException {
    List<String> lista = arquivo(stream);
    List<Campeao> listaDeCampeoes = newArrayList();

    for (String string : lista) {
      String[] colunas = string.split(";");

      Campeao campeao = new Construtor(colunas).novaInstancia();
      listaDeCampeoes.add(campeao);
    }

    return listaDeCampeoes;
  }

  private class Construtor implements Campeao.Construtor {

    private final String[] arrayDeCampeoes;

    public Construtor(String[] arrayDeCampeos) {
      this.arrayDeCampeoes = arrayDeCampeos;
    }

    @Override
    public Campeao novaInstancia() {
      return new Campeoes(this);
    }

    @Override
    public Integer getAno() {
      return stringToInt(arrayDeCampeoes[0]);
    }

    @Override
    public String getTime() {
      return arrayDeCampeoes[1];
    }

    @Override
    public int getSaldo() {
      return stringToInt(arrayDeCampeoes[2]);
    }

    @Override
    public int getPontos() {
      return stringToInt(arrayDeCampeoes[3]);
    }

    private int stringToInt(String val) {
      return Integer.parseInt(val);
    }

  }

}

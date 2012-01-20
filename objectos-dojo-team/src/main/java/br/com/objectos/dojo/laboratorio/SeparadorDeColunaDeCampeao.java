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

import java.util.List;

/**
 * @author afonso.filgueiras@objectos.com.br (Afonso J. Filgueiras)
 */
public class SeparadorDeColunaDeCampeao {

  public List<Campeao> separaColuna(List<String> lista) {
    List<Campeao> listaDeCampeoes = newArrayList();

    for (String linha : lista) {

      Campeao campeao = new Construtor(linha).get();

      listaDeCampeoes.add(campeao);

    }

    return listaDeCampeoes;
  }

  private class Construtor implements Campeao.Construtor {

    private final String[] separador;

    public Construtor(String linha) {
      separador = linha.split(";");
    }

    @Override
    public Campeao get() {
      return new Campeoes(this);
    }

    @Override
    public Integer getAno() {
      String col0 = separador[0];
      return Integer.valueOf(col0);
    }

    @Override
    public String getTime() {
      String col1 = separador[1];
      return col1;
    }

    @Override
    public String getTreinador() {
      String col2 = separador[2];
      return col2;
    }

  }

}

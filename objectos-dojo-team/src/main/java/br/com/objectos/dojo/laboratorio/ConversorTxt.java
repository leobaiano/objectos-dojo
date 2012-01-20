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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author afonso.filgueiras@objectos.com.br (Afonso J. Filgueiras)
 */
public class ConversorTxt implements Conversor {

  @Override
  public List<Campeao> retornaCampeoes(InputStream arquivo) throws IOException {

    ConverteTxtEmLista conversor = new ConverteTxtEmLista();
    List<String> lista = conversor.converteEmLista(arquivo);

    SeparadorDeColunaDeCampeao separar = new SeparadorDeColunaDeCampeao();
    return separar.separaColuna(lista);
  }

}

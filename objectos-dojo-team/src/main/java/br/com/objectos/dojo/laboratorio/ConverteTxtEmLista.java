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
public class ConverteTxtEmLista {

  public List<String> converteEmLista(InputStream texto) throws IOException {
    List<String> lista = newArrayList();

    InputStreamReader arquivo = new InputStreamReader(texto);
    BufferedReader reader = new BufferedReader(arquivo);
    String linha;
    linha = reader.readLine();

    while (linha != null) {
      lista.add(linha);
      linha = reader.readLine();
    }

    arquivo.close();

    return lista;
  }

}

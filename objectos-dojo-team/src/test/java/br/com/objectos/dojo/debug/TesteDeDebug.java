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
package br.com.objectos.dojo.debug;

import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.google.common.base.Function;

/**
 * @author afonso.filgueiras@objectos.com.br (Afonso J. Filgueiras)
 */
@Test
public class TesteDeDebug {

  public void debug_de_array_list() {
    List<String> listaDeNomes = new ArrayList<String>();

    listaDeNomes.add("AFONSO");
    listaDeNomes.add("HELLEN");
    listaDeNomes.add("MARCOS");

    List<String> res = transform(listaDeNomes, new ToNomes());

    assertThat(res.get(0), equalTo("afonso"));
    assertThat(res.get(1), equalTo("hellen"));
    assertThat(res.get(2), equalTo("marcos"));
  }

  private class ToNomes implements Function<String, String> {
    @Override
    public String apply(String input) {
      return input.toLowerCase();
    }
  }

}

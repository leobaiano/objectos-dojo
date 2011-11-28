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
package br.com.objectos.dojo.afilgueiras.enum_jdbc;

import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import com.google.common.base.Function;

/**
 * @author afonso.filgueiras@objectos.com.br (Afonso J. Filgueiras)
 */
@Test
public class ArtigoDeEnumJdbc {

  private final ConsultaDeFuncionario consulta = new ConsultaDeFuncionario();

  public void listar_departamento() {
    List<Funcionario> res = consulta.list();
    List<Departamento> deps = transform(res, new ToDepartamento());

    assertThat(deps.size(), equalTo(3));
    assertThat(deps.get(0), equalTo(Departamento.ENGENHARIA));
    assertThat(deps.get(1), equalTo(Departamento.FINANCEIRO));
    assertThat(deps.get(2), equalTo(Departamento.CONTABILIDADE));
  }

  private class ToDepartamento implements Function<Funcionario, Departamento> {
    @Override
    public Departamento apply(Funcionario input) {
      return input.getDepartamento();
    }
  }

}

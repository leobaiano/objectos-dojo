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

/**
 * @author afonso.filgueiras@objectos.com.br (Afonso J. Filgueiras)
 */
public class ConstrutorDeCampeoesFalso implements Campeao.Construtor {

  private Integer ano;
  private String time;
  private int saldo;
  private int pontos;

  @Override
  public Campeao novaInstancia() {
    return new Campeoes(this);
  }

  public ConstrutorDeCampeoesFalso ano(Integer ano) {
    this.ano = ano;
    return this;
  }

  public ConstrutorDeCampeoesFalso time(String time) {
    this.time = time;
    return this;
  }

  public ConstrutorDeCampeoesFalso saldo(int saldo) {
    this.saldo = saldo;
    return this;
  }

  public ConstrutorDeCampeoesFalso pontos(int pontos) {
    this.pontos = pontos;
    return this;
  }

  @Override
  public Integer getAno() {
    return ano;
  }

  @Override
  public String getTime() {
    return time;
  }

  @Override
  public int getSaldo() {
    return saldo;
  }

  @Override
  public int getPontos() {
    return pontos;
  }

}

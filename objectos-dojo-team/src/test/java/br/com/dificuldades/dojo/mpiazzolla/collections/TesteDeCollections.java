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
package br.com.dificuldades.dojo.mpiazzolla.collections;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;

@Test
public class TesteDeCollections {

  public void ordenacao_de_HASH_SET_deve_ser_de_acordo_com_o_hash_code() {
    Camisa c1 = new Camisa("Azul", "123");
    Camisa c2 = new Camisa("Azul", "456");
    Camisa c3 = new Camisa("Preto", "123");
    Camisa c4 = new Camisa("Preto", "123");

    Set<Camisa> hashSetDeCamisas = new HashSet<Camisa>();
    hashSetDeCamisas.add(c1);
    hashSetDeCamisas.add(c2);
    hashSetDeCamisas.add(c3);
    hashSetDeCamisas.add(c4);

    assertThat(hashSetDeCamisas.size(), equalTo(3));
    assertThat(hashSetDeCamisas.contains(c1), equalTo(true));
    assertThat(hashSetDeCamisas.contains(c2), equalTo(true));
    assertThat(hashSetDeCamisas.contains(c3), equalTo(true));
    assertThat(hashSetDeCamisas.contains(c4), equalTo(true));
  }

  public void teste_de_HASH_SET() {
    CamisaComEqualsCorreta c1 = new CamisaComEqualsCorreta("Azul");
    CamisaComEqualsCorreta c2 = new CamisaComEqualsCorreta("Azul");
    CamisaComEqualsCorreta c3 = new CamisaComEqualsCorreta("Preto");
    CamisaComEqualsCorreta c4 = new CamisaComEqualsCorreta("Preto");

    Set<CamisaComEqualsCorreta> camisas = new HashSet<CamisaComEqualsCorreta>();
    camisas.add(c1);
    camisas.add(c2);
    camisas.add(c3);
    camisas.add(c4);

    assertThat(camisas.size(), equalTo(2));
    assertThat(camisas.contains(c1), equalTo(true));
    assertThat(camisas.contains(c2), equalTo(true));
    assertThat(camisas.contains(c3), equalTo(true));
    assertThat(camisas.contains(c4), equalTo(true));
  }

  public void teste_de_HASH() {
    CamisaHash c1 = new CamisaHash("Amarelo", 1);
    CamisaHash c2 = new CamisaHash("Azul", 2);
    CamisaHash c3 = new CamisaHash("Roxo", 1);
    CamisaHash c4 = new CamisaHash("Preto", 2);

    Set<CamisaComEqualsCorreta> camisas = new HashSet<CamisaComEqualsCorreta>();
    camisas.add(c1);
    camisas.add(c2);
    camisas.add(c3);
    camisas.add(c4);

    assertThat(camisas.size(), equalTo(4));
    assertThat(camisas.contains(c1), equalTo(true));
    assertThat(camisas.contains(c2), equalTo(true));
    assertThat(camisas.contains(c3), equalTo(true));
    assertThat(camisas.contains(c4), equalTo(true));

  }

  public void ordenacao_de_LINKED_HASH_SET_deve_ser_de_acordo_com_a_insercao_dos_elementos() {
    Camisa c1 = new Camisa("Azul", "123");
    Camisa c2 = new Camisa("Azul", "456");
    Camisa c3 = new Camisa("Preto", "123");
    Camisa c4 = new Camisa("Preto", "123");

    Set<Camisa> linkedHashSetDeCamisa = new LinkedHashSet<Camisa>();
    linkedHashSetDeCamisa.add(c3);
    linkedHashSetDeCamisa.add(c1);
    linkedHashSetDeCamisa.add(c4);
    linkedHashSetDeCamisa.add(c2);

    ArrayList<Camisa> listaDeCamisas = newArrayList(linkedHashSetDeCamisa);

    assertThat(listaDeCamisas.size(), equalTo(3));
    assertThat(listaDeCamisas.get(0), equalTo(c3));
    assertThat(listaDeCamisas.get(1), equalTo(c1));
    assertThat(listaDeCamisas.get(2), equalTo(c2));
  }

  public void ordenacao_de_TREE_SET_deve_ser_de_acordo_com_a_implementacao_de_Comparable() {
    Camisa c1 = new Camisa("Azul", "456");
    Camisa c2 = new Camisa("Azul", "123");
    Camisa c3 = new Camisa("Preto", "123");
    Camisa c4 = new Camisa("Preto", "123");

    Set<Camisa> treeSetDeCamisa = new TreeSet<Camisa>();
    treeSetDeCamisa.add(c1);
    treeSetDeCamisa.add(c2);
    treeSetDeCamisa.add(c3);
    treeSetDeCamisa.add(c4);

    List<Camisa> listaDeCamisas = new ArrayList<Camisa>(treeSetDeCamisa);
    assertThat(listaDeCamisas.size(), equalTo(3));

    assertThat(listaDeCamisas.get(0), equalTo(c2));
    assertThat(listaDeCamisas.get(1), equalTo(c1));
    assertThat(listaDeCamisas.get(2), equalTo(c3));
  }

  public void ordenacao_de_ARRAY_LIST_deve_ser_pelo_indice() {
    Camisa c1 = new Camisa("Rosa", "123");
    Camisa c2 = new Camisa("Azul", "456");
    Camisa c3 = new Camisa("Preto", "123");
    Camisa c4 = new Camisa("Preto", "123");

    List<Camisa> listaDeCamisas = new ArrayList<Camisa>();

    listaDeCamisas.add(c1);
    listaDeCamisas.add(c2);
    listaDeCamisas.add(c3);
    listaDeCamisas.add(c4);

    assertThat(listaDeCamisas.size(), equalTo(4));
    assertThat(listaDeCamisas.get(0), equalTo(c1));
    assertThat(listaDeCamisas.get(1), equalTo(c2));
    assertThat(listaDeCamisas.get(2), equalTo(c3));
    assertThat(listaDeCamisas.get(3), equalTo(c4));
  }

  public void ordenacao_de_LINK_LIST_varia_de_acordo_com_insercao_dos_elementos() {
    Camisa c1 = new Camisa("Rosa", "123");
    Camisa c2 = new Camisa("Azul", "456");
    Camisa c3 = new Camisa("Preto", "123");
    Camisa c4 = new Camisa("Preto", "123");

    LinkedList<Camisa> listaLigadaDeCamisasInsereNoInicio = new LinkedList<Camisa>();
    listaLigadaDeCamisasInsereNoInicio.addFirst(c1);
    listaLigadaDeCamisasInsereNoInicio.addFirst(c2);
    listaLigadaDeCamisasInsereNoInicio.addFirst(c3);
    listaLigadaDeCamisasInsereNoInicio.addFirst(c4);

    assertThat(listaLigadaDeCamisasInsereNoInicio.get(0), equalTo(c4));
    assertThat(listaLigadaDeCamisasInsereNoInicio.get(1), equalTo(c3));
    assertThat(listaLigadaDeCamisasInsereNoInicio.get(2), equalTo(c2));
    assertThat(listaLigadaDeCamisasInsereNoInicio.get(3), equalTo(c1));

    LinkedList<Camisa> novaListaLigadaDeCamisasInsereNoFinal = new LinkedList<Camisa>();
    novaListaLigadaDeCamisasInsereNoFinal.addLast(c1);
    novaListaLigadaDeCamisasInsereNoFinal.addLast(c2);
    novaListaLigadaDeCamisasInsereNoFinal.addLast(c3);
    novaListaLigadaDeCamisasInsereNoFinal.addLast(c4);

    assertThat(novaListaLigadaDeCamisasInsereNoFinal.get(0), equalTo(c1));
    assertThat(novaListaLigadaDeCamisasInsereNoFinal.get(1), equalTo(c2));
    assertThat(novaListaLigadaDeCamisasInsereNoFinal.get(2), equalTo(c3));
    assertThat(novaListaLigadaDeCamisasInsereNoFinal.get(3), equalTo(c4));
  }

  public void ordenacao_de_IMMUTABLE_LIST_deve_ser_de_acordo_com_a_insercao_dos_elementos_na_criacao() {
    Camisa c1 = new Camisa("Rosa", "123");
    Camisa c2 = new Camisa("Azul", "456");
    Camisa c3 = new Camisa("Preto", "123");
    Camisa c4 = new Camisa("Preto", "123");

    ImmutableList<Camisa> listaImutavelDeCamisas = ImmutableList.of(c1, c2,
        c3, c4);

    assertThat(listaImutavelDeCamisas.size(), equalTo(4));
    assertThat(listaImutavelDeCamisas.get(0), equalTo(c1));
    assertThat(listaImutavelDeCamisas.get(1), equalTo(c2));
    assertThat(listaImutavelDeCamisas.get(2), equalTo(c3));
    assertThat(listaImutavelDeCamisas.get(3), equalTo(c4));
  }

  private static class Camisa implements Comparable<Camisa> {

    private final String cor;
    private final String codigoDeBarra;

    public Camisa(String cor, String codigoDeBarra) {
      this.cor = cor;
      this.codigoDeBarra = codigoDeBarra;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((codigoDeBarra == null) ? 0 : codigoDeBarra.hashCode());
      result = prime * result + ((cor == null) ? 0 : cor.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof Camisa)) {
        return false;
      }
      Camisa other = (Camisa) obj;
      if (codigoDeBarra == null) {
        if (other.codigoDeBarra != null) {
          return false;
        }
      } else if (!codigoDeBarra.equals(other.codigoDeBarra)) {
        return false;
      }
      if (cor == null) {
        if (other.cor != null) {
          return false;
        }
      } else if (!cor.equals(other.cor)) {
        return false;
      }
      return true;
    }

    @Override
    public int compareTo(Camisa o) {
      return ComparisonChain.start()
          .compare(this.cor, o.cor)
          .compare(this.codigoDeBarra, o.codigoDeBarra)
          .result();
    }

  }

  private static class CamisaComEqualsCorreta {

    private final String cor;

    public CamisaComEqualsCorreta(String cor) {
      this.cor = cor;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((cor == null) ? 0 : cor.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof CamisaComEqualsCorreta)) {
        return false;
      }
      CamisaComEqualsCorreta other = (CamisaComEqualsCorreta) obj;
      if (cor == null) {
        if (other.cor != null) {
          return false;
        }
      } else if (!cor.equals(other.cor)) {
        return false;
      }
      return true;
    }

    @Override
    public String toString() {
      return cor;
    }

  }

  private static class CamisaHash extends CamisaComEqualsCorreta {
    private final int hash;

    public CamisaHash(String cor, int hash) {
      super(cor);
      this.hash = hash;
    }

    @Override
    public int hashCode() {
      return hash;
    }
  }

}

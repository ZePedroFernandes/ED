/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formula1;

import exceptions.EmptyException;
import java.util.Iterator;
import lists.unorderedLists.DoubleLinkedUnorderedList;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Piloto{

    private DoubleLinkedUnorderedList<Prova> provas;

    private final int idPiloto;

    private final int idade;

    private final String nome;

    public Piloto(int idPiloto, int idade, String nome) {
        this.provas = new DoubleLinkedUnorderedList<>();
        this.idPiloto = idPiloto;
        this.idade = idade;
        this.nome = nome;
    }

    public void addProva(Prova prova) {
        prova.setPiloto(this);
        provas.addToRear(prova);
    }

    public void removeProva(String id) throws ProvaNaoEncontrada {

        Prova removeProva = this.findProva(id);

        try {
            provas.remove(removeProva);
        } catch (EmptyException ex) {
        }
    }

    public Prova findProva(String id) throws ProvaNaoEncontrada {
        Iterator<Prova> provasIterator = this.provas.iterator();
        Prova current;

        boolean found = false;
        while (provasIterator.hasNext() && !found) {
            current = provasIterator.next();
            if (current != null && current.getId().equals(id)) {
                return current;
            }
        }
        throw new ProvaNaoEncontrada("Prova não encontrada");
    }

    public DoubleLinkedUnorderedList<Prova> getProvas() {
        return provas;
    }

    public int getIdPiloto() {
        return idPiloto;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

//    @Override
//    public int compareTo(Piloto o) {
//        if(this.pontos < o.pontos){
//            return -1;
//        }
//        if(this.pontos > o.pontos){
//            return 1;
//        }
//        return 0;
//    }
    @Override
    public String toString() {
        return "Nome: " + this.nome;
    }
}

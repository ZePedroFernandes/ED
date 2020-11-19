/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formula1;

import exceptions.EmptyException;
import exceptions.InvalidElementException;
import java.util.Iterator;
import lists.OrderedLists.DoubleLinkedOrderedList;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class PolePosition {

    private DoubleLinkedOrderedList<Prova> provas;

    private final String idProva;

    public PolePosition(String idProva) {
        this.provas = new DoubleLinkedOrderedList<>();
        this.idProva = idProva;
    }

    public void addPiloto(Piloto piloto) throws InvalidElementException {
        try {
            provas.add(piloto.findProva(idProva));
        } catch (ProvaNaoEncontrada ex) {
        }
    }

    public void removerPiloto(Piloto piloto) {
        try {
            try {
                provas.remove(piloto.findProva(idProva));
            } catch (ProvaNaoEncontrada ex) {
            }
        } catch (EmptyException ex) {
        }
    }

    public Iterator<Prova> getProvas(){
        return this.provas.iterator();
    }
}

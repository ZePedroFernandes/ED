/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp5;

import Formula1.Piloto;
import Formula1.PolePosition;
import Formula1.Prova;
import Formula1.ProvaNaoEncontrada;
import exceptions.InvalidElementException;
import java.util.Iterator;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class FP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Piloto piloto1 = new Piloto(0, 30, "Juliana");
        Piloto piloto2 = new Piloto(0, 30, "Tobias");
        Piloto piloto3 = new Piloto(0, 30, "Tobês");

        Prova prova = new Prova("12/11/2020", "1a", 10);
        Prova prova2 = new Prova("12/11/2020", "1a", 9);
        Prova prova3 = new Prova("12/11/2020", "1a", 12);
        
        piloto1.addProva(prova);
        piloto2.addProva(prova2);
        piloto3.addProva(prova3);
        
        
        PolePosition pole = new PolePosition("1a");
        
        try {
            pole.addPiloto(piloto3);
            pole.addPiloto(piloto2);
            pole.addPiloto(piloto1);
        } catch (InvalidElementException e) {
            System.out.println(e.getMessage());
        }
        
        Iterator<Prova> itr = pole.getProvas();
        
        while(itr.hasNext()){
            Prova p = itr.next();
            System.out.println(p.getPiloto().toString() + "\nPontos" + p.getPontos());
        }
    }

}

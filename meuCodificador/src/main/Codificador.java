/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import encoder.Encoder;
import exceptions.EmptyException;
import exceptions.InvalidKeyFormat;
import exceptions.InvalidMessageException;
import exceptions.InvalidElementException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;
import queues.LinkedQueue;
import queueMerger.QueueMerger;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Codificador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String key = "3 1 7 4 2 5";
        String m = "";
        Encoder encoder = new Encoder();

        try {
 //           m = encoder.encode("Novanjghl Mu Urxlv", key);
        m = encoder.encode("","-1 -1 -1 -1 -1 -1 1");
        } catch (Exception ex) {
            System.out.println("There has been an error with the following message:\n" + ex.getMessage());
        }

        System.out.println(m);

        System.out.println("".compareTo(""));

    }

}

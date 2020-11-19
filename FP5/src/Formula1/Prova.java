/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formula1;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Prova implements Comparable<Prova> {

    private Piloto piloto;

    private final String data;

    private final String id;

    private final int pontos;

    public Prova(String data, String id, int pontos) {
        this.data = data;
        this.id = id;
        this.pontos = pontos;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    protected void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public String getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    public int getPontos() {
        return pontos;
    }

    @Override
    public String toString() {
        return ("Piloto: " + this.piloto + "\nData: " + this.data + "\nId: " + this.id + "\nPontos: " + this.pontos);
    }

    @Override
    public int compareTo(Prova prova) {
        if (this.pontos < prova.getPontos()) {
            return -1;
        } else {
            if (this.pontos > prova.getPontos()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

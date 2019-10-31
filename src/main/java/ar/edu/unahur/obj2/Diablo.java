package ar.edu.unahur.obj2;

import java.util.List;

public class Diablo {

    private List<Demonio> demonios;
    private boolean contento;

    public Diablo(List<Demonio> demonios) {
        this.demonios = demonios;
        this.contento = false;
    }

    public void enviarACazar(Demonio demonio, Lugar lugar) {
        demonio.cazar(lugar);
    }

    public Demonio batalla(Demonio dem1, Demonio dem2) {
        if(dem1.poder() > dem2.poder()) {
            return dem1;
        } else if (dem2.poder() > dem1.poder()) {
            return dem2;
        }

        return null;
    }

    public void setContento(boolean contento) {
        this.contento = contento;
    }

    public boolean isContento() {
        return contento;
    }

    public void premiarYCastigar(Demonio dem1, Demonio dem2) {
        if(isContento()) {
            dem1.aumentarMaldad(10);
            dem2.quitarAlma();
            dem2.quitarAlma();
        } else {
            dem1.aumentarMaldad(1);
            dem2.quitarAlmas();
        }
    }
}

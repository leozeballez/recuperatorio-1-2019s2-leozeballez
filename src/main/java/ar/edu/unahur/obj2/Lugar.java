package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

public class Lugar implements EsconderAlmas {

    private int cantEscondites;
    private List<Alma> almas;
    private List<Alma> escondidas;

    public Lugar(int cantEscondites, List<Alma> almas) {
        this.cantEscondites = cantEscondites;
        this.almas = almas;
        this.escondidas = new ArrayList<>();
    }

    public List<Alma> getAlmas() {
        return almas;
    }

    public List<Alma> getEscondidas() { return escondidas; }

    public void esconderAlma(Alma alma) {
        if(almas.contains(alma)) {
            escondidas.add(alma);
            almas.remove(alma);
        }
    }

    public void quitarAlma(Alma alma) {
        almas.remove(alma);
    }

    @Override
    public void esconderAlmas() {
    }

    public boolean hayLugar() {
        return escondidas.size() != cantEscondites;
    }

    public void almasSalenDeEscondite(){
        for(int i = 0; i <= escondidas.size(); i++) {
            almas.add(escondidas.get(i));
        }
        escondidas.clear();
    }
}

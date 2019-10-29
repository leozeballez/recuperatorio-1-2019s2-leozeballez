package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

public abstract class Demonio {

    private Arma arma;
    private int maldad;
    private List<Alma> almasCazadas = new ArrayList<>();

    public Demonio(int maldad, Arma arma) {
        this.maldad = maldad;
        this.arma = arma;
    }

    public void aumentarMaldad(int maldad) {
        this.maldad += maldad;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void cazar(Lugar lugar) {
        // para evitar el error de concurrent modification
        List<Alma> copiaDeAlmas = new ArrayList<>(lugar.getAlmas());
        copiaDeAlmas.stream().forEach(alma -> cazarOAtormentar(lugar, alma));
        lugar.esconderAlmas();
        lugar.almasSalenDeEscondite();
    }

    protected void cazarOAtormentar(Lugar lugar, Alma alma) {
        int almasAtormentadas=0;
        int almasCazadas=0;

        if (alma.getValor() < this.maldad && puedoCazarlo(alma)) {
            almasCazadas++;
            cazar(lugar, alma);
        } else {
            almasAtormentadas++;
            atormentarAlma(alma);
        }
        incrementarNivelMaldad(almasCazadas, almasAtormentadas);
    }

    private void incrementarNivelMaldad(int almasCazadas, int almasAtormentadas) {
        maldad+=almasAtormentadas + 2*almasCazadas;
    }

    protected void cazar(Lugar lugar, Alma alma) {
        lugar.quitarAlma(alma);
        almasCazadas.add(alma);
    }
    protected void atormentarAlma(Alma alma) {
        alma.setValor(alma.getValor()-5);
        atormentar(alma);
    }

    protected abstract void atormentar(Alma a);
    protected abstract boolean puedoCazarlo(Alma a);

    public int poder(){
        return arma.getPoder() * maldad * almasCazadas.size();
    }

    public void quiarAlma() {
        almasCazadas.remove(0);
    }

    public void quitarAlmas() {
        almasCazadas.clear();
    }
}

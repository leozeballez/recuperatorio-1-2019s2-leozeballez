package ar.edu.unahur.obj2;

public class DemonioFuego extends Demonio {

    public DemonioFuego(int maldad, Arma arma) {
        super(maldad, arma);
    }

    @Override
    protected void atormentar(Alma alma) {
        alma.setFriolenta(false);
    }

    @Override
    protected boolean puedoCazarlo(Alma a) {
        return !a.isFriolenta();
    }
}

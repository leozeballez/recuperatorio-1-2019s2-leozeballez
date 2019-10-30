package ar.edu.unahur.obj2;

public class DemonioSombra extends Demonio {

    public DemonioSombra(int maldad, Arma arma) {
        super(maldad, arma);
    }

    @Override
    protected void atormentar(Alma alma) {
        alma.setValor(alma.getValor()/2);
    }

    @Override
    protected boolean puedoCazarlo(Alma a) {
        return a.getValor() < 50;
    }
}

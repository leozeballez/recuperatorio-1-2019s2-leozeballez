package ar.edu.unahur.obj2;

import java.util.List;

public class Infierno extends Lugar {

    public Infierno(List<Alma> almas) {
        super(2, almas);
    }

    @Override
    public void esconderAlmas() {
        while(hayLugar()){
            getAlmas().stream().forEach( alma -> {
                if(!alma.isFriolenta() && alma.getBondad() == alma.getValor()) {
                    esconderAlma(alma);
                    alma.setFriolenta(true);
                }
            });
        }

    }
}

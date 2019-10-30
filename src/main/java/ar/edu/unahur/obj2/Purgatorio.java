package ar.edu.unahur.obj2;

import java.util.List;

public class Purgatorio extends Lugar {

    public Purgatorio(List<Alma> almas) {
        super(5, almas);
    }

    @Override
    public void esconderAlmas() {
        while(hayLugar()){
            getAlmas().stream().forEach( alma -> {
                if(alma.getBondad() > 10 && alma.getValor() > 5) {
                    esconderAlma(alma);
                    alma.setBondad(alma.getBondad() -5);
                    alma.setValor(alma.getValor() -1);
                    //aca no esta aclarado en el enunciado pero supongo que hay que descontarle 1 al valor.
                }
            });
        }

    }

}

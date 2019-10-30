package ar.edu.unahur.obj2;

import java.util.List;

public class Paraiso extends Lugar {

    public Paraiso(List<Alma> almas) {
        super(10, almas);
    }

    @Override
   public void esconderAlmas() {
       while(hayLugar()){
           getAlmas().stream().forEach( alma -> {
               if(alma.getBondad() > 0) {
                   esconderAlma(alma);
                   alma.setBondad(alma.getBondad() -1);
               }
           });
       }

   }
}

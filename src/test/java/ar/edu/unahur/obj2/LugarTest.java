package ar.edu.unahur.obj2;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class LugarTest {

    @Test
    public void testEsconderAlma() {
        List<Alma> almas = new ArrayList<>();
        Alma alma = new AlmaSimple(50, 100, true);
        Alma alma2 = new AlmaSimple(1, 1, false);
        almas.add(alma);
        almas.add(alma2);
        Lugar infierno = new Infierno(almas);
        infierno.esconderAlmas();

        assertEquals(alma2.isFriolenta(), true);
    }
}
package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.Repka.Person.*;
import test.Repka.RepMashin;

/**
 * Created by Юра on 14.04.2017.
 */

public class TestRepka {

    @Test
    public void testRepMashiPrint(){
        Vnychka vnychka=new Vnychka();
        RepMashin.addPerson(new Mouse(),new Kiska(),vnychka,new Babka(),new Ded(),new Repka());
       String rez=vnychka.print();
        String expected="Vnychka";
        Assert.assertEquals("не верный ввывод vnychka.print()",expected,rez);
    }
    @Test
    public void testRepMashin(){
        RepMashin.addPerson(new Mouse(),new Kiska(),new Vnychka(),new Babka(),new Ded(),new Repka());
        String rez=RepMashin.repkaToString();
        String expected="Mouse za Kiska za Vnychka za Babka za Ded za Repka za ";
        Assert.assertEquals("not werk RepMashin",expected,rez);
    }
}

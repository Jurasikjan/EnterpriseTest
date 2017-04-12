package test;

import test.Repka.Mass;
import test.Repka.Person.*;
import test.Repka.RepMashin;

/**
 * Created by Юра on 12.04.2017.
 */
public class Start {
    public Start() {
    }
    public String started(){
        Mass m=Mass.getInstans();
        m.setMas(new Mouse(),new Vnychka(),new Babka(),new Ded(),new Repka());
        return  RepMashin.repkaToString();
    }
}

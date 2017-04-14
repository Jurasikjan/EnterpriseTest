package test;

import test.Repka.*;
import test.Repka.Person.*;


/**
 * Created by Юра on 10.04.2017.
 */
public class App {
    public static void main(String[] args) {
        /*Задания REPKA с ООП */

        Vnychka vnychka=new Vnychka();
        RepMashin.addPerson(new Mouse(),new Kiska(),vnychka,new Babka(),new Ded(),new Repka());
        System.out.println(RepMashin.repkaToString());
        System.out.println(vnychka.print());

    }


}

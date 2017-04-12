package test;

import test.Repka.Person.*;
import test.Repka.RepMashin;

/**
 * Created by Юра on 10.04.2017.
 */
public class App {
    public static void main(String[] args) {
        /*Задания REPKA с ООП */

        RepMashin.addPerson(new Mouse(),new Kiska(),new Vnychka(),new Babka(),new Ded(),new Repka());
        System.out.println(RepMashin.repkaToString());
    }


}

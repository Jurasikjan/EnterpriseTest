package test;

import test.Repka.Person.Babka;
import test.Repka.Person.Ded;
import test.Repka.Person.Mouse;
import test.Repka.Person.Vnychka;
import test.Repka.RepMashin;

/**
 * Created by Юра on 10.04.2017.
 */
public class App {
    public static void main(String[] args) {
        /*Задания REPKA с ООП */

        RepMashin repMashin=(Babka)RepMashin.addPerson(new Mouse());
        RepMashin.addPerson(new Vnychka());
       RepMashin.addPerson(new Babka());
       RepMashin.addPerson(new Ded());

        repMashin.repkaToString();
    }
}

package test;

import test.Repka.Mass;
import test.Repka.Person.*;
import test.Repka.RepMashin;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Юра on 10.04.2017.
 */
public class App {
    public static void main(String[] args) {
        /*Задания REPKA с ООП */

        Mass m=Mass.getInstans();
        m.setMas(new Mouse(),new Vnychka(),new Babka(),new Ded(),new Repka());
        RepMashin.repkaToString();
    }
}

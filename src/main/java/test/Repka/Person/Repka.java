package test.Repka.Person;

import test.Repka.RepMashin;

/**
 * Created by Юра on 12.04.2017.
 */
public class Repka extends RepMashin {
    @Override
    protected String PrintPerson() {

        return this.getClass().getSimpleName();
    }
}

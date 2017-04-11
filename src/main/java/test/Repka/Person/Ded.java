package test.Repka.Person;

import test.Repka.RepMashin;

/**
 * Created by Юра on 11.04.2017.
 */
public class Ded extends RepMashin {
    @Override
    protected String PrintPerson() {
        return this.getClass().getSimpleName();
    }
}

package test.Repka;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юра on 11.04.2017.
 */
public abstract class RepMashin implements Work {


    private List<Object> mas;


    public void print() {
        System.out.println("Repky");
        System.out.println(PrintPerson());
    }
    private RepMashin(){
       if (mas==null)
           mas=new ArrayList<Object>();
    }

    private void addPerson(Object o) {

        if (o instanceof RepMashin)
        {
            System.out.println(((RepMashin) o).PrintPerson());
        }
    }

    protected abstract String PrintPerson();
}

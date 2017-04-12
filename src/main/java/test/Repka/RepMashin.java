package test.Repka;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юра on 11.04.2017.
 */
public abstract class RepMashin implements Work {



private RepMashin repMashin;

    public void print() {
       repkaToString();
    }

    public RepMashin() {
    }

    public void repkaToString()
    {
        for (Object ma : mas) {
            if (ma instanceof RepMashin)
            {
                System.out.println(((RepMashin) ma).PrintPerson()+" za ");
            }
        }
    }
    public static Object addPerson(Object o) {

        if (mas==null)
            mas=new ArrayList<Object>();

       if (o instanceof RepMashin)
       {
           mas.add(o);
       }
       return o;
    }

    protected abstract String PrintPerson();

    private static class Mas
    {
        private static List<Object> mas;

        public Mas() {
            mas=new ArrayList<Object>();
        }

        public static List<Object> getMas() {
            return mas;
        }

        public static void setMas(List<Object> mas) {
            Mas.mas = mas;
        }


    }
}

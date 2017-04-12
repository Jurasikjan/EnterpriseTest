package test.Repka;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юра on 11.04.2017.
 */
public abstract class RepMashin implements Work {

    private static Mass mas;


    public void print() {
       repkaToString();
    }

    public static String repkaToString()
    {
        StringBuffer str=new StringBuffer();
        for (Object ma : mas.getMas()) {
            if (ma instanceof RepMashin)
            {
                str.append(((RepMashin) ma).PrintPerson()+" za ");
            }
        }
        return str.toString();
    }
    public static Object addPerson(Object o) {

       if (o instanceof RepMashin)
       {
           mas.getMas().add((RepMashin)o);
       }
       return o;
    }

    protected abstract String PrintPerson();
}

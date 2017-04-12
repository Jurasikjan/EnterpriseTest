package test.Repka;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юра on 12.04.2017.
 */
public class Mass {
    private static List<RepMashin> mas;
    private static Mass massClass;


    private Mass() {
       mas=new ArrayList<RepMashin>();
    }

    public static Mass getInstans()
    {
        if (massClass==null)
            massClass=new Mass();

        return massClass;
    }

    public static List<RepMashin> getMas() {
        return mas;
    }

    public void setMas(Object... o) {
        for (Object o1 : o) {
            if (o1 instanceof RepMashin)
                massClass.getMas().add((RepMashin) o1);
        }


    }

}

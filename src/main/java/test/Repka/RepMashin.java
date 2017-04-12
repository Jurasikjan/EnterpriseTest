package test.Repka;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юра on 11.04.2017.
 */
public abstract class RepMashin implements Work {

    private static List<RepMashin> mas;

    public static List<RepMashin> getMas() {
        return mas;
    }

    public static void setMas(List<RepMashin> mas) {
        RepMashin.mas = mas;
    }

    static {
        mas = new ArrayList<RepMashin>();
    }

    public String print() {
        return "RepMashin: "+PrintPerson();
    }

    public static String repkaToString() {
        StringBuffer str = new StringBuffer();
        for (RepMashin ma : mas) {
                str.append(ma.PrintPerson() + " za ");
        }
        return str.toString();
    }

    public static List<RepMashin> addPerson(RepMashin... o) {

        for (RepMashin o1 : o) {

                mas.add(o1);

        }
        return mas;
    }

    protected abstract String PrintPerson();
}

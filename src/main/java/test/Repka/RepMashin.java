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
        return PrintPerson();
    }

    public static String repkaToString() {
        StringBuffer str = new StringBuffer();
        for (Object ma : mas) {
                str.append(((RepMashin) ma).PrintPerson() + " za ");
        }
        return str.toString();
    }

    public static Object addPerson(Object... o) {

        for (Object o1 : o) {
            if (o1 instanceof RepMashin) {
                mas.add((RepMashin) o1);
            }
        }
        return o;
    }

    protected abstract String PrintPerson();
}

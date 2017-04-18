package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Юра on 18.04.2017.
 */
public class Rent {


    public static void main(String[] args) {
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("E:/inSSIDer/docs/inssider.chm");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            p.waitFor();
            System.out.println(p.getOutputStream().toString());
            System.out.println("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

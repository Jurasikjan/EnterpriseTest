package Connect;

import Connect.Moddel.Genre;
import Connect.Moddel.Movie;
import Connect.Repka.RepMashin;
import Connect.datasource.DataSource;
import Connect.helper.PropertyHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


/**
 * Created by Юра on 18.04.2017.
 */
public class App {

    public static void main(String[] args) {

      DataSource dataSource= DataSource.getInstance();
        DataSource.addPerson(dataSource);


        for (RepMashin repMashin : DataSource.getMas()) {
            System.out.println(Arrays.toString(repMashin.instans().toArray()));
        }



    }

}

package Connect.Repka;

import Connect.Moddel.Klient;
import Connect.Moddel.Movie;
import Connect.datasource.DataSource;
import lombok.Data;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юра on 11.04.2017.
 */
@Data
public abstract class RepMashin implements Work {

    static {
        masObject = new ArrayList<RepMashin>();
    }

    private static List<RepMashin> masObject;
   private static DataSource dataSource;
    private ResultSet resultSet;


    public static DataSource startData() {

        return dataSource= DataSource.getInstance();
    }

public Connection getConnect(){
    return dataSource.getConnection();
}
    public static void addObject(RepMashin... repMashin) {
        for (RepMashin mashin : repMashin) {
            masObject.add(mashin);
        }

    }

    public static List getList(String name) {
        List<Movie> movilist=new ArrayList<>();

        for (RepMashin mashin : masObject) {
            if (mashin.getClass().getSimpleName().equals(name))
            {
               movilist= mashin.getList();
            }
        }

        return movilist;
    }
}

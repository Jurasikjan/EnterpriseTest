package Connect.Repka;


import Connect.Moddel.Movie;
import Connect.datasource.DataSource;
import lombok.Data;


import java.sql.Connection;
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
        masObject = new ArrayList<>();
    }

    private static List<RepMashin> masObject;
    private static DataSource dataSource;
    private static List movilist;

    public static DataSource startData() {

        return dataSource = DataSource.getInstance();
    }

    public Connection getConnect() {
        return dataSource.getConnection();
    }

    public static void addObject(RepMashin... repMashin) {
        for (RepMashin mashin : repMashin) {
            masObject.add(mashin);
        }

    }

    public static List getList(String name) {
        movilist = new ArrayList<>();

        for (RepMashin mashin : masObject) {
            if (mashin.getClass().getSimpleName().equals(name)) {
                movilist = mashin.getList();
            }
        }

        return movilist;
    }

    public abstract List getAll(ResultSet resultSet) throws SQLException;
}

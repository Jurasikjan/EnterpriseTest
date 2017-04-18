package Connect.Repka;

import Connect.Moddel.Movie;
import Connect.datasource.DataSource;

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
public abstract class RepMashin implements Work {

    static {
        mas = new ArrayList<RepMashin>();
    }

    private static List<RepMashin> mas;
    public static final String SELECT_ALL = "Select * from movie";
   private static DataSource dataSource;
    private ResultSet resultSet;

public List instans(){
    dataSource=this.StartDataSource();

    String sql = String.format(SELECT_ALL);

    List result = null;
    try (Connection connection = dataSource.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         ResultSet resultSet = preparedStatement.executeQuery()){
        result = getAll(resultSet);
    } catch (SQLException e) {
        e.printStackTrace();
    }
return result;
}

    public abstract  List<Movie> getAll() throws SQLException;


    public static List<RepMashin> addPerson(RepMashin... o) {

        for (RepMashin o1 : o) {

                mas.add(o1);

        }
        return mas;
    }
    public static List<RepMashin> getMas() {
        return mas;
    }
    public static void setMas(List<RepMashin> mas) {
        RepMashin.mas = mas;
    }
    protected abstract DataSource StartDataSource();
}

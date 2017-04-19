package Connect.Repka;

import Connect.Moddel.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Юра on 11.04.2017.
 */
public interface Work {
    List<Movie> getList();
}

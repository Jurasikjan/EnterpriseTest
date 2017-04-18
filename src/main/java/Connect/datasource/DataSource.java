package Connect.datasource;


import Connect.Moddel.Genre;
import Connect.Moddel.Movie;
import Connect.Repka.RepMashin;
import Connect.helper.PropertyHolder;
import com.mchange.v2.c3p0.ComboPooledDataSource;


import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public final class DataSource extends RepMashin {

    private static ComboPooledDataSource poolConnections;
    private static DataSource dataSource;

    private DataSource() {
        initPollConnections();
    }

    public static synchronized DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = poolConnections.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static void initPollConnections() {
        poolConnections = new ComboPooledDataSource();
        PropertyHolder propertyHolder = PropertyHolder.getInstance();
        try {
            poolConnections.setDriverClass(propertyHolder.getDbDriver()); //loads the jdbc driver

            poolConnections.setJdbcUrl(propertyHolder.getJdbcUrl());
            poolConnections.setUser(propertyHolder.getDbUserLogin());
            poolConnections.setPassword(propertyHolder.getDbUserPassword());

            poolConnections.setMinPoolSize(5);
            poolConnections.setAcquireIncrement(1);
            poolConnections.setMaxPoolSize(100);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }


    public List<Movie> getAll(ResultSet resultSet) throws SQLException {
        List<Movie> result = new ArrayList<Movie>();
        Movie movie = null;
        while (resultSet.next()) {
            movie = new Movie();
            movie.setId(resultSet.getInt("id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setDescription(resultSet.getString("description"));
            movie.setDuration(Long.valueOf(resultSet.getString("duration")));
            movie.setRating(Double.valueOf(resultSet.getString("rating")));

            String s = resultSet.getString("genre");
            if (s.equals("BLOCKBUSTER")) {
                movie.setGenre(Genre.BLOCKBUSTER);

            } else if (s.equals("MYLTIK")) {
                movie.setGenre(Genre.MYLTIK);

            }

            movie.setStart(resultSet.getDate("start"));

            result.add(movie);
        }
        return result;
    }

    @Override
    public List<Movie> getAll() throws SQLException {
        return null;
    }

    @Override
    protected DataSource StartDataSource() {
        getInstance();
        return dataSource;
    }
}

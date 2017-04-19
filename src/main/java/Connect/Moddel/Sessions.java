package Connect.Moddel;

import Connect.Repka.RepMashin;
import lombok.Data;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Юра on 10.03.2017.
 */
@Data
public class Sessions extends RepMashin{
    public static final String SELECT_ALL = "Select * from Session";
    private int id;
    private Movie movie;
    private Date sessionData;
    private Hall hall;
    private Mesta mesta;
    private double price;

    public Sessions() {
    }

    public Sessions(Movie movie, Date sessionData, Hall hall, double price) {
        this.movie = movie;
        this.sessionData = sessionData;
        this.hall = hall;
        this.price = price;
        mesta=new Mesta(hall.getColumnCount(),hall.getRowCount());

    }

    @Override
    public String toString() {
        return "Session{" +
                "movie=" + movie +
                ", sessionData=" + sessionData +
                ", hall=" + hall +
                ", price=" + price +
                '}';
    }
    public int getSessionId(){
        return getId();
    }
    public void setSessionId(int id){
        setId(id);
    }

    @Override
    public List<Movie> getList() {

        String sql = String.format(SELECT_ALL);
        List result = null;
        try (Connection connection = getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            result = getAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public RepMashin getPoID(int id) {
        return null;
    }

    @Override
    public List getAll(ResultSet resultSet) throws SQLException {

        List<Sessions> result = new LinkedList<>();
        Sessions session = null;


        while (resultSet.next()) {
            session = new Sessions();
//Movie, sessionData,hall,price
            session.setId(resultSet.getInt("id"));
            session.setMovie((Movie)getPoID(resultSet.getInt("Movie")));
            session.setSessionData(resultSet.getDate("sessionData"));
            //session.setHall(hallDao.getById(resultSet.getInt("hall")));
            session.setPrice(Double.valueOf(resultSet.getString("price")));
           // session.setMesta(mestaDao.getById(resultSet.getInt("mesta")));

/////

            result.add(session);
        }
        return result;
    }
}

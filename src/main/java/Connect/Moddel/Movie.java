package Connect.Moddel;


import Connect.Repka.RepMashin;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Data
public class Movie extends RepMashin{
    public static final String SELECT_ALL = "Select * from Movie";

private int id;
    private String title;
    private String description;
    private long duration;
    private double rating;
   private Genre genre;
    private Date start;
    public Movie() {
    }

    public Movie(String title, String description, long durationMs, double rating, Genre genre, Date start) {
        this.title = title;
        this.description = description;
        this.duration = durationMs;
        this.rating = rating;
        this.genre = genre;
        this.start = start;
    }
    public int getMovieId(){
        return getId();
    }
    public void setMovieId(int id){
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
}

package Connect.Moddel;


import lombok.Data;

import java.sql.Date;


@Data
public class Movie extends Entity<Integer>{

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

}

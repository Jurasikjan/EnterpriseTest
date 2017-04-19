package Connect.Moddel;

import lombok.Data;

import java.sql.Date;

/**
 * Created by Юра on 10.03.2017.
 */
@Data
public class Sessions extends Entity<Integer>{
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

}

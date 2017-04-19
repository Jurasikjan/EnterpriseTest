package Connect;

import Connect.Moddel.Klient;
import Connect.Moddel.Movie;
import Connect.Moddel.Sessions;
import Connect.Repka.RepMashin;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Юра on 19.04.2017.
 */
public class TestConnect {
    @Test
    public void testGetTableMysql() throws Exception {
        RepMashin.startData();
        Movie movie=new Movie();
        Klient klient=new Klient();
        Sessions sessions=new Sessions();
        RepMashin.addObject(movie,klient,sessions);


        List<Movie> movieList= RepMashin.getList("Movie");

if(movieList==null)
        throw new Exception("not List<Moovie>");
else System.out.println(Arrays.toString(movieList.toArray()));
    }
}

package Connect;

import Connect.Moddel.Genre;
import Connect.Moddel.Klient;
import Connect.Moddel.Movie;
import Connect.Moddel.Sessions;
import Connect.Repka.RepMashin;
import Connect.datasource.DataSource;
import Connect.helper.PropertyHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


/**
 * Created by Юра on 18.04.2017.
 */
public class App {

    public static void main(String[] args) {


        RepMashin.startData();

        Movie movie=new Movie();
        Klient klient=new Klient();
        Sessions sessions=new Sessions();
        RepMashin.addObject(movie,klient,sessions);

       List<Movie> movieList= RepMashin.getList("Movie");
       List<Klient> klients= RepMashin.getList("Klient");

        System.out.println(Arrays.toString(movieList.toArray()));
        System.out.println(Arrays.toString(klients.toArray()));


        System.out.println(movie.getPoID(1));
        System.out.println(klient.getPoID(1));
    }

}

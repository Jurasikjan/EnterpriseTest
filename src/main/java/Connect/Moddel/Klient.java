package Connect.Moddel;

/**
 * Created by Юра on 14.03.2017.
 */

import Connect.Repka.RepMashin;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ToString
@Setter
@Getter
public class Klient extends RepMashin {
    public static final String SELECT_ALL = "Select * from Klient";
    private int id;
    private String fname;
    private String Lname;
    private String login;
    private String pswd;
    private Date Birthday;
    private String role;
    private String email;
    private Sex sex;
    private List<Ticket> tickets;

    public Klient() {

    }

    public Klient(String fname, String lname, String login, String pswd, Date birthday, String role, String email, Sex sex) {
        this.fname = fname;
        Lname = lname;
        this.login = login;
        this.pswd = pswd;
        Birthday = birthday;
        this.role = role;
        this.email = email;
        this.sex = sex;
    }

    public int getKlientId() {
        return getId();
    }

    public void setKlientId(int id) {
        setId(id);
    }

    public boolean ticketBool() {
        if (tickets == null) return false;
        else return true;
    }

    public void  newTicket(Ticket t) {
        t.setKlientId(getId());




        if (ticketBool()) {
            tickets.add(t);
        } else {
            tickets = new ArrayList<>();
            tickets.add(t);
        }

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
    public List<Klient> getAll(ResultSet resultSet) throws SQLException {
        List<Klient> result = new LinkedList<>();
        Klient user = null;

        while (resultSet.next()) {
            user = new Klient();
            //fname,lname,login,pswd,birthday,role,email,sex,tickets
            user.setId(resultSet.getInt("id"));
            user.setFname(resultSet.getString("fname"));
            user.setLname(resultSet.getString("lname"));
            user.setLogin(resultSet.getString("login"));
            user.setPswd(resultSet.getString("pswd"));
            user.setBirthday(resultSet.getDate("birthday"));
            user.setRole(resultSet.getString("role"));
            user.setEmail(resultSet.getString("email"));
///////////
            Sex sex = null;
            switch (resultSet.getString("sex")) {
                case "MEN":
                    user.setSex(sex.MEN);
                    break;
                case "WOMEN":
                    user.setSex(sex.WOMEN);
                    break;
            }

/////////
            String str=resultSet.getString("tickets");
            /*
            List<Ticket> tlist=new ArrayList<>();
            String[] mas=str.split("[,]+");
            for (int i = 0; i < mas.length; i++) {
                if (mas[i].toCharArray().length>0){

                    tlist.add(ticketDao.getById(Integer.valueOf(mas[i])));
                }
            }*/
            user.setTickets(null);
            result.add(user);

        }
        return result;
    }
}



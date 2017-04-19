package Connect.Moddel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Юра on 10.03.2017.
 */
@Getter
@Setter
@ToString
public class Ticket extends Entity<Integer> {
    private int row;
    private int column;
    private int klientId;
    private Sessions session;

    public Ticket() {
    }

    public Ticket(int column, int row, Sessions session) throws Exception {
        if (session.getMesta().insertMesto(column,row)) {
            this.row = row;
            this.column = column;
            this.session = session;
        }else throw new Exception("Mesto zanyto");

    }
    public int getTicketId(){
        return getId();
    }
    public void setTicketId(int id){
        setId(id);
    }

}

package Connect.Moddel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Юра on 10.03.2017.
 */
@Setter
@Getter
@ToString
public class Hall extends Entity<Integer>{
    private String  nameH;
    private int rowCount;
    private int columnCount;


    public Hall() {
    }

    public Hall(String name, int rowCount, int columnCount) {
        this.nameH = name;
        this.rowCount = rowCount;
        this.columnCount = columnCount;

    }
    public int getHallId(){
        return getId();
    }
    public void setHallId(int id){
        setId(id);
    }

}

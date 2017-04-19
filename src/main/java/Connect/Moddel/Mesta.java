package Connect.Moddel;

import lombok.Data;


/**
 * Created by Юра on 23.03.2017.
 */
@Data
public class Mesta extends Entity<Integer> {
    private String mesto;
    private int colum;
    private int row;


    public Mesta() {
    }

    public Mesta(int columnCount, int rowCount) {
        colum=columnCount;
        row=rowCount;
        mesto="";
        for (int i = 0; i < colum; i++) {
            for (int j = 0; j < row; j++) {
                mesto+="true,";
            }
        }
    }
    public boolean proverkaMesta(int colum, int row)
    {
       boolean[][] pr=izStrVmas();
      return pr[colum][row];
    }
    public boolean insertMesto(int colum,int row)
    {
        if (proverkaMesta(colum-1,row-1))
        {
           boolean[][]pr=izStrVmas();
            pr[colum-1][row-1]=false;
            mesto=izMasVstr(pr);
            return true;
        }else {
          return  false;
        }
    }
    public boolean[][] izStrVmas()
    {
        boolean [][]ret=new boolean[colum][row];
        String[] par=mesto.split("[,]+");
        int y=0;
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[i].length; j++) {
                ret[i][j]=Boolean.valueOf(par[y++]);
            }
        }
        return ret;
    }
    public String izMasVstr(boolean [][]mas)
    {
        String ret="";

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                ret+=Boolean.valueOf(mas[i][j])+",";
            }
        }

        return ret;
    }
    public void reset(){
        mesto="";
        for (int i = 0; i < colum; i++) {
            for (int j = 0; j < row; j++) {
                mesto+="true,";
            }
        }
    }
    public int getHallId(){
        return getId();
    }
    public void setHallId(int id){
        setId(id);
    }
}

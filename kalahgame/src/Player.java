import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Player  {
    private final String name;
    private final int numplayer;

   public Player(String name, int numplayer){
        this.name= name;
        this.numplayer = numplayer;
    }




    public String getName(){
        if(name != null)
            return name;
        else return "PC";
    }

    public int getNumplayer(){

        return this.numplayer;
    }

    public int selectMove (Kalahtable table) throws
            IOException{
        if(name != null)
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\n"+"Introdu numarul gaurii din care vrei sa muti:  "+"\n");
            System.out.flush();
            int  numballs  =  Integer.parseInt(br.readLine());
            return  numballs;
        }
        int  bestMove  =  -1;
        int  repeatMove  =  -1;
        int  maxNewBalls  =  -1;

        //possible movements
        for(int numhollows=1;numhollows<=table.playinghollows;numhollows++)
        {
            if(table.ballshollow(numplayer,numhollows)!=0)
            {
                Kalahtable testTable = table.makecopy();
                boolean doAgain = testTable.domove(numplayer,numhollows);
                if(doAgain)
                    repeatMove =numhollows;
                int newBalls = testTable.ballsingame(numplayer)-testTable.ballsingame(numplayer);
                maxNewBalls=newBalls;
                bestMove=numhollows;
            }
        }
        //choose the best option
        if (maxNewBalls>1)
            return bestMove;
        else if (repeatMove!=-1)
            return repeatMove;
        else
           return bestMove;


    }

}




import java.io.IOException;
import java.util.Scanner;

public class Kalahgame {
    Kalahtable table = new Kalahtable();
    Hollow hollow = new Hollow();
    Player [] jucator;
    public int jucatorcurent = 0;

    public Kalahgame(String  jucator1, String  jucator2) {
        table.setupforplay();
        jucator = new Player[2];
        jucator[0] = new Player(jucator1, 0);
        jucator[1] = new Player(jucator2, 1);
        }



    public void afisareTabla(){
        String LineFiller  =  "";
        System.out.println("-----------------------"); //despartire randuri
        System.out.print("      ");
        for  (int  i=1;  i<=table.playinghollows;  i++)
        {
            System.out.print(table.ballshollow(1,  i)  +"    ");
            LineFiller  +=  "     ";

        }
        afisarejucator(1);
        System.out.print(table.ballsingame(1)  + "    ");
        System.out.print(LineFiller);
        System.out.println(table.ballsingame(0));
        System.out.print("      ");
        for  (int  i=table.playinghollows;i>=1;  i--)
            System.out.print(table.ballshollow(1,  i)  + "    ");
        afisarejucator(0);
        System.out.println("-----------------------");
    }

    private  void  afisarejucator(int  numplayer)  {

        if  (jucatorcurent  ==  numplayer)
            System.out.print("            -->");
        else
            System.out.print("                  ");
        System.out.println("Jucator  "  +  (numplayer+1)  + " ("  + jucator[numplayer].getName()  +  ")");
    }

    public void joaca() throws IOException{
        afisareTabla();
        while (!table.jocterminat()) {
            int numhollows = jucator[jucatorcurent].selectMove(table);
            boolean doAgain = table.domove(jucatorcurent, numhollows);
            System.out.print("Jucatorul " + (jucatorcurent+1) + " muta de la gaura " + numhollows +"\n");
            afisareTabla();
            if (!doAgain)
                if (jucatorcurent == 0)
                    jucatorcurent = 1;
                else jucatorcurent = 0;
            else System.out.print("Jucatorul " + (jucatorcurent+1) + " alege iar ");
        }
        table.emptyballs();
        afisareTabla();
        if(table.ballsingame(0)>table.ballsingame(1))
            System.out.print(jucator[0].getName()+" a castigat!");
        else if(table.ballsingame(0)<table.ballsingame(1))
            System.out.print(jucator[1].getName()+" a castigat!");
        else System.out.print("Egalitate");
    }

    public  static  void  main(String  []  args)  throws
            IOException {

        Kalahgame  game  =  new Kalahgame("George",  "Andrei");
        game.joaca();
    }
}
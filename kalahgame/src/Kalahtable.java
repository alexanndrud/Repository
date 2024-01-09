public class Kalahtable   {
    Hollow[] hollows;
    int numhollows;
    static final int playinghollows=6,totalhollows = 2*(playinghollows+1);
    public Kalahtable()  {
        hollows  =  new Hollow[totalhollows];
        for  (int  numhollows  =  0;  numhollows  <  totalhollows;
              numhollows++)
            hollows[numhollows]  =  new Hollow();
    }
         public void setupforplay(){
            for(numhollows=0;numhollows<totalhollows;numhollows++)
                if(!kalah(numhollows))
                    hollows[numhollows].addBalls(6);
        }




    boolean kalah(int numballs){
            return numhollows%(playinghollows+1)==0;
        }

        public int ballshollow (int numplayer, int numhollows)
        {
            return hollows[getNumhollows(numplayer,numhollows)].getBalls();
        }

        public int getNumhollows(int numplayer,int numhollows)
        {
            return numplayer*(playinghollows+1)+numhollows;
        }

        public int ballsingame(int numplayer)
        {
            return hollows[getKalah(numplayer)].getBalls();
        }

        public int getKalah(int numplayer)
        {
            return numplayer*(playinghollows+1);
        }

        public Kalahtable makecopy()
        {
            Kalahtable newtable = new Kalahtable();
            for (int numhollows=0;numhollows<totalhollows;numhollows++)
            {
                newtable.hollows[numhollows].addBalls(this.hollows[numhollows].getBalls());
            }
            return newtable;
        }

        public boolean domove(int  crntnumplayer, int  chsnumhollows)  {
            int  numhollows  =  getNumhollows(crntnumplayer, chsnumhollows);
            int  balls  =  hollows[numhollows].removeBalls();
            while  (balls  !=  0)  {
                numhollows--;
                if  (numhollows  <  0)
                    numhollows  =  totalhollows  -  1;
                if  (numhollows  !=
                        getKalah(otrnumplayer(crntnumplayer)))  {
                    hollows[numhollows].addBalls(1);
                    balls--;
                }
            }
            if  (numhollows  ==  getKalah(crntnumplayer))
                return  true;
            if  (playerof(numhollows)  ==  crntnumplayer  &&
                    hollows[numhollows].getBalls()  ==  1)  {
                balls  =  hollows[contrarynumhollows(numhollows)].removeBalls();
                hollows[getKalah(crntnumplayer)].addBalls(balls);
            }
            return false;
        }

        public int playerof(int numhollows)
        {
            return numhollows/(playinghollows+1);
        }

        public int otrnumplayer(int numplayer)
        {
            if(numplayer==0)
                return 1;
            else return 0;
        }

        public int contrarynumhollows(int numhollows)
        {
            return totalhollows-numhollows;
        }

        public boolean jocterminat()
        {
            for(int gamer=0;gamer<2;gamer++)
            {
                int balls=0;
                for(int numhollows=1;numhollows<=playinghollows;numhollows++)
                    balls+=hollows[getNumhollows(gamer,numhollows)].getBalls();
                if(balls==0)
                    return true;
            }
            return false;
        }

    public void emptyballs()
    {
        for(int gamer=0;gamer<2;gamer++)
            for(int numhollows=0;numhollows<=playinghollows;numhollows++)
            {
                int balls=hollows[getNumhollows(gamer,numhollows)].removeBalls();
                hollows[getKalah(gamer)].addBalls(balls);
            }
    }


}

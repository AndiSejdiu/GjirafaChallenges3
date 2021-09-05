import java.util.*;

public class GjirafaChallenges3 {

    public static void main(String[] args) {
        Scanner a =new Scanner(System.in);
        int N=a.nextInt();
        int nrX=0;
        int nrO=0;
        char[][] ceils=new char[N][N];
           a.nextLine();
        for(int i=0;i<N;i++){
            String s=a.nextLine();
            for(int j=0;j<N;j++){
                ceils[i][j]=s.charAt(j);
                if(ceils[i][j]=='X')
                    nrX++;
                else if(ceils[i][j]=='O')
                    nrO++;
    
            }
         
            
        }
        if(nrX<nrO|| nrX>nrO+1){
            System.out.println("invalid");
        }else{
            String s="draw";
            boolean xhWin=true;
            boolean ohWin=true;
            boolean xvWin=true;
            boolean ovWin=true;
            boolean xd1Win=true;
            boolean od1Win=true;
            boolean xd2Win=true;
            boolean od2Win=true;
            boolean remaining=false;
            int wins=0;
            boolean invalid=false;
            for(int i=0;i<N;i++){
                xhWin=true;
                ohWin=true;
                xvWin=true;
                ovWin=true;
                  if(ceils[i][i]!='X')
                        xd1Win=false;
                    if(ceils[i][i]!='O')
                        od1Win=false;
                    if(ceils[i][N-i-1]!='X')
                        xd2Win=false;
                    if(ceils[i][N-i-1]!='O')
                        od2Win=false;
                for(int j=0;j<N;j++){
                    if(ceils[i][j]!='.'&&ceils[i][j]!='O'&&ceils[i][j]!='X'){
                        invalid=true;
                    }
                    if(ceils[i][j]=='.'){
                        remaining=true;
                    }
                    if(ceils[i][j]!='X')
                        xhWin=false;
                    if(ceils[i][j]!='O')
                        ohWin=false;
                    if(ceils[j][i]!='X')
                        xvWin=false;
                    if(ceils[j][i]!='O')
                        ovWin=false;
                }
                if(xhWin||xvWin){
                    s="X wins";
                    wins++;
                 
                }
                if(ohWin||ovWin){
                    s="O wins";
                         
                   wins++;
                }
            }
            if(xd1Win||xd2Win){
                s="X wins";
                wins++;
            }
            if(od1Win||od2Win){
                 s="O wins";
                wins++;
            }
            if(s=="draw"&&remaining){
                if(nrX>nrO){
                    s="O moves";
                }else if(nrX==nrO){
                    s="X moves";
                }
            }
            if(wins>1||invalid){
                s="invalid";
            }
            System.out.println(s);
        }
    }
}
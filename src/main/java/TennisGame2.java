import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    private static final Map<Integer, String> PUNTUACIONES = new HashMap<Integer, String>();

    static{
        PUNTUACIONES.put(0, "Love");
        PUNTUACIONES.put(1, "Fifteen");
        PUNTUACIONES.put(2, "Thirty");
        PUNTUACIONES.put(3, "Forty");
    }

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (this.P1point == this.P2point)
        {
            score = this.getDraws();
        }
        
        if (P1point > 0 && P2point==0)
        {
            score = this.getPartialScore();
        }
        if (P2point > 0 && P1point==0)
        {
            if (P2point==1)
                P2res = "Fifteen";
            if (P2point==2)
                P2res = "Thirty";
            if (P2point==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        
        if (P1point>P2point && P1point < 4)
        {
            if (P1point==2)
                P1res="Thirty";
            if (P1point==3)
                P1res="Forty";
            if (P2point==1)
                P2res="Fifteen";
            if (P2point==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point>P1point && P2point < 4)
        {
            if (P2point==2)
                P2res="Thirty";
            if (P2point==3)
                P2res="Forty";
            if (P1point==1)
                P1res="Fifteen";
            if (P1point==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
        
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }

    private String getDraws(){
        if(P1point < 3){
            String draw = "";
            if (P1point==0)
                draw = "Love";
            if (P1point==1)
                draw = "Fifteen";
            if (P1point==2)
                draw = "Thirty";
            draw += "-All";
            return draw;
        }
        return "Deuce";
    }

    private String getPlayerScore(int points){

        return PUNTUACIONES.get(points);
    }

    private String getPartialScore(){

        this.P1res = this.getPlayerScore(P1point);
        this.P2res = this.getPlayerScore(P2point);

        return this.P1res + "-" + this.P2res;
    }
}
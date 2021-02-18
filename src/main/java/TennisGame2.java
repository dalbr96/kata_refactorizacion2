import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String player1Score = "";
    public String player2Score = "";
    private String player1Name;
    private String player2Name;

    private Integer prueba = new Integer();

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
        if (this.P1point > 0 && this.P2point==0)
        {
            score = this.getPartialScore();
        }
        if (this.P2point > 0 && this.P1point==0)
        {
            score = this.getPartialScore();
        }
        
        if (this.P1point>this.P2point && this.P1point < 4)
        {
            score = this.getPartialScore();
        }
        if (this.P2point>this.P1point && this.P2point < 4)
        {
            score = this.getPartialScore();
        }
        
        if (this.P1point > this.P2point && this.P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (this.P2point > this.P1point && this.P1point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (this.P1point>=4 && this.P2point>=0 && (this.P1point-this.P2point)>=2)
        {
            score = "Win for player1";
        }
        if (this.P2point>=4 && this.P1point>=0 && (this.P2point-this.P1point)>=2)
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

            return getPlayerScore(P1point) + "-All";

        }
        return "Deuce";
    }

    private String getPlayerScore(int points){

        return PUNTUACIONES.get(points);
    }

    private String getPartialScore(){

        this.player1Score = this.getPlayerScore(P1point);
        this.player2Score = this.getPlayerScore(P2point);

        return this.player1Score + "-" + this.player2Score;
    }

}
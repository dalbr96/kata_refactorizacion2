import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    public String player1Score = "";
    public String player2Score = "";
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
        if (this.player1Points == this.player2Points)
        {
            return this.getDraws();
        }

        if (this.isNotOverTime())
        {
            return this.getPartialScore();
        }

        if(this.isOverTime()){
            return this.getAdvantage();
        }
        else {
            return this.getWinner();
        }
 /*
        if (this.player2Points > 0 && this.player1Points ==0)
        {
            score = this.getPartialScore();
        }
        
        if (this.player1Points >this.player2Points && this.player1Points < 4)
        {
            score = this.getPartialScore();
        }
        if (this.player2Points >this.player1Points && this.player2Points < 4)
        {
            score = this.getPartialScore();
        }
        
        if (this.player1Points > this.player2Points && this.player2Points >= 3)
        {
            score = "Advantage player1";
        }
        
        if (this.player2Points > this.player1Points && this.player1Points >= 3)
        {
            score = "Advantage player2";
        }
        
        if (this.player1Points >=4 && this.player2Points >=0 && (this.player1Points -this.player2Points)>=2)
        {
            score = "Win for player1";
        }
        if (this.player2Points >=4 && this.player1Points >=0 && (this.player2Points -this.player1Points)>=2)
        {
            score = "Win for player2";
        }
        return score;*/
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
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            P1Score();
        if (player.equals(player2Name))
            P2Score();
    }

    private String getDraws(){
        if(player1Points < 3){

            return getPlayerScore(player1Points) + "-All";

        }
        return "Deuce";
    }

    private String getPlayerScore(int points){

        return PUNTUACIONES.get(points);
    }

    private String getPartialScore(){

        this.player1Score = this.getPlayerScore(player1Points);
        this.player2Score = this.getPlayerScore(player2Points);

        return this.player1Score + "-" + this.player2Score;
    }

    private boolean isNotOverTime(){

        return (this.player1Points <= 3 && this.player2Points <= 3);
    }

    private boolean isOverTime(){

        boolean condicionPuntos = this.player1Points >= 3 || this.player2Points >=3;
        boolean condicionDiferencia = Math.abs(this.player1Points - this.player2Points) == 1;

        return condicionPuntos && condicionDiferencia;
    }

    private String getAdvantage(){

        if(this.player1Points > this.player2Points){
            return "Advantage " + this.player1Name;
        }

        if(this.player1Points < this.player2Points){
            return "Advantage " + this.player2Name;
        }
        return "";
    }

    private String getWinner(){
        if(this.player1Points > this.player2Points){

            return "Win for " + this.player1Name;
        }

        return "Win for " + this.player2Name;

    }

}
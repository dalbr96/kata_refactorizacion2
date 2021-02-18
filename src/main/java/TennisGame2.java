import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame
{
    private int player1Points = 0;
    private int player2Points = 0;

    private String player1Score = "";
    private String player2Score = "";
    private String player1Name;
    private String player2Name;


    private static final Map<Integer, String> PUNTUACIONES = new HashMap<>();

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

        if (this.isDraw())
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

        return this.getWinner();

    }

    public void p1Score(){
        player1Points++;
    }
    
    public void p2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            p1Score();
        if (player.equals(player2Name))
            p2Score();
    }

    private String getDraws(){
        if(player1Points < 3){

            return getPlayerScore(player1Points) + "-All";

        }
        return "Deuce";
    }

    private boolean isNotOverTime(){

        return (this.player1Points <= 3 && this.player2Points <= 3);
    }

    private boolean isOverTime(){

        boolean condicionPuntos = this.player1Points >= 3 || this.player2Points >=3;
        boolean condicionDiferencia = Math.abs(this.player1Points - this.player2Points) == 1;

        return condicionPuntos && condicionDiferencia;
    }

    private boolean isDraw(){

        return this.player1Points == this.player2Points;
    }

    private String getPlayerScore(int points){

        return PUNTUACIONES.get(points);
    }

    private String getPartialScore(){

        this.player1Score = this.getPlayerScore(this.player1Points);
        this.player2Score = this.getPlayerScore(this.player2Points);

        return this.player1Score + "-" + this.player2Score;
    }


    private String getAdvantage(){

        if(this.player1Points > this.player2Points){

            return "Advantage " + this.player1Name;
        }

        return "Advantage " + this.player2Name;
    }

    private String getWinner(){
        if(this.player1Points > this.player2Points){

            return "Win for " + this.player1Name;
        }

        return "Win for " + this.player2Name;

    }

}
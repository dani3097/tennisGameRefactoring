
public class TennisGame2 implements TennisGame
{
    public int player1points = 0;
    public int player2points = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
		
		if (isTie())
			score = getLiteral(player1points)+"-All";
	
		if (isDeuce())
		score = "Deuce";
		if (isNormal())
		    score = getLiteral(player1points) + "-" + getLiteral(player2points);
		if (isAdvantage(player1points,player2points))
		    score = "Advantage player1";
		if (isAdvantage(player2points,player1points))
		    score = "Advantage player2";
        
		if (isWinner(player1points,player2points))
		    score = "Win for player1";
		if (isWinner(player2points,player1points))
		    score = "Win for player2";
        
        return score;
    }

	private boolean isNormal() {
		return player1points != player2points;
	}

	private String getLiteral(int playerPoints) {
		String result="";
		if (playerPoints==0)
			result = "Love";
		if (playerPoints==1)
			result = "Fifteen";
		if (playerPoints==2)
			result = "Thirty";
		if (playerPoints==3)
			result = "Forty";
		return result;
	}

	private boolean isWinner(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints>=4 && secondPlayerPoints>=0 && (firstPlayerPoints-secondPlayerPoints)>=2;
	}

	private boolean isAdvantage(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints > secondPlayerPoints && secondPlayerPoints >= 3;
	}

	private boolean isDeuce() {
		return player1points==player2points && player1points>=3;
	}

	private boolean isTie() {
		return player1points == player2points && player1points < 4;
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
        player1points++;
    }
    
    public void P2Score(){
        player2points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
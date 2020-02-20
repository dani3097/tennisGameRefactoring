
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
        score = tie(score);
        score = deuce(score);
        
        score = normal(score);
        
        score = advantage(score);
		if (isWinner(player1points,player2points))
		    score = "Win for player1";
		if (isWinner(player2points,player1points))
		    score = "Win for player2";
        
        return score;
    }

	

	private String normal(String score) {
		if (player1points != player2points)
        {
            P2res = getLiteral(player2points);
            P1res = getLiteral(player1points);
            score = P1res + "-" + P2res;
        }
		return score;
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

	private String advantage(String score) {
		if (isAdvantage(player1points,player2points))
            score = "Advantage player1";
        if (isAdvantage(player2points,player1points))
            score = "Advantage player2";
		return score;
	}

	private boolean isAdvantage1() {
		return player2points > player1points && player1points >= 3;
	}

	private boolean isAdvantage(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints > secondPlayerPoints && secondPlayerPoints >= 3;
	}

	private String deuce(String score) {
		if (player1points==player2points && player1points>=3)
            score = "Deuce";
		return score;
	}

	private String tie(String score) {
		if (player1points == player2points && player1points < 4)
        {
            if (player1points==0)
                score = "Love";
            if (player1points==1)
                score = "Fifteen";
            if (player1points==2)
                score = "Thirty";
            score += "-All";
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
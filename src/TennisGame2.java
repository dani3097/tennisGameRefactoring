
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

    public String getLiteralScore(){
        String literalScore = "";
    	if (isNormal())
		    literalScore = getLiteral(player1points) + "-" + getLiteral(player2points);
		if (isTie())
			literalScore = getLiteral(player1points)+"-All";
		if (isDeuce())
			literalScore = "Deuce";
		if (isInAdvantageOver(player1points,player2points))
		    literalScore = "Advantage player1";
		if (isInAdvantageOver(player2points,player1points))
		    literalScore = "Advantage player2";
		if (isWinnerOver(player1points,player2points))
		    literalScore = "Win for player1";
		if (isWinnerOver(player2points,player1points))
		    literalScore = "Win for player2";
        
        return literalScore;
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

	private boolean isWinnerOver(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints>=4 && secondPlayerPoints>=0 && (firstPlayerPoints-secondPlayerPoints)>=2;
	}

	private boolean isInAdvantageOver(int firstPlayerPoints, int secondPlayerPoints) {
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
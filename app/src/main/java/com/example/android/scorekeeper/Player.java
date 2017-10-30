package com.example.android.scorekeeper;

/**
 * Created by liamhowe on 30/10/17.
 */

public class Player{
    String name;
    int playerScore = 0;
    int playerGameScore = 0;
    boolean hasAdvantage = false;

    public Player (String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getScore (){
        return playerScore;
    }

    public void setScore (int add){
        playerScore += add;
    }

    public int getGameScore(){
        return playerGameScore;
    }

    public void setGameScore(int add){
        playerGameScore += add;
    }

    public boolean getAdv(){
        return hasAdvantage;
    }

    public void setAdv(boolean adv){
        hasAdvantage = adv;
    }

    public void resetGame(){
        playerScore = 0;
        hasAdvantage = false;
    }

    public void resetMatch (){
        playerGameScore = 0;
        playerScore = 0;
        hasAdvantage = false;
    }

}



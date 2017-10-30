package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*
    int playerOneScore = 0;
    int playerTwoScore = 0;
    int playerOneGames = 0;
    int playerTwoGames = 0;
    boolean playerOneAdv = false;
    boolean playerTwoAdv = false;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Player playerOne = new Player("PlayerOne");
    Player playerTwo = new Player("PlayerTwo");

    public void scoreP1 (View view){
        scorePoint(playerOne, playerTwo);
    }

    public void scoreP2 (View view){
        scorePoint(playerTwo, playerOne);
    }

    public void scorePoint (Player currentPlayer, Player otherPlayer){
        if (currentPlayer.getScore() == 0 || currentPlayer.getScore() == 15) {
            currentPlayer.setScore(15);
        } else
            if (currentPlayer.getScore() == 30) {
                currentPlayer.setScore(10);
        } else
            if (currentPlayer.getScore() == 40) {
                if (currentPlayer.getAdv()) {
                    resetGame();
                    gameForPlayer(currentPlayer);
                    displayForPlayer(currentPlayer);
                    return;
                }
                if (otherPlayer.getScore() == 40) {
                    if (otherPlayer.getAdv()) {
                        otherPlayer.setAdv(false);
                        displayForPlayer(otherPlayer);
                        return;
                    }
                    currentPlayer.setAdv(true);
                    displayAdvantage(currentPlayer);
                    return;
                }
            resetGame();
                gameForPlayer(currentPlayer);
        } else {
            resetGame();
                gameForPlayer(currentPlayer);
        }

        displayForPlayer(currentPlayer);
    }

    public void displayAdvantage(Player player){
        if (player.getName().equals("PlayerOne")) {
            displayAdvantageForPlayerOne("Adv");
        }else
        if (player.getName().equals("PlayerTwo")){
            displayAdvantageForPlayerTwo("Adv");
        }
    }

    public void displayForPlayer(Player player){
        if (player == playerOne) {
            displayForPlayer(player.getScore(), R.id.player_1_score);
        }else
        if (player == playerTwo){
            displayForPlayer(player.getScore(), R.id.player_2_score);
        }
    }

    public void gameForPlayer(Player player) {
        player.setGameScore(1);
        if (player.getName().equals("PlayerOne")) {
            displayGamesForPlayerOne(player.getGameScore());
        }else
        if (player.getName().equals("PlayerTwo")){
            displayGamesForPlayerTwo(player.getGameScore());
        }
    }



    public void displayForPlayer(int score, int viewId) {
        TextView scoreView = (TextView) findViewById(viewId);
        scoreView.setText(String.valueOf(score));
    }

    public void displayAdvantageForPlayerOne(String score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGamesForPlayerOne(int score) {
        String games = "Games: " + score;
        TextView scoreView = (TextView) findViewById(R.id.player_1_games);
        scoreView.setText(String.valueOf(games));
    }


    public void displayAdvantageForPlayerTwo(String score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGamesForPlayerTwo(int score) {
        String games = "Games: " + score;
        TextView scoreView = (TextView) findViewById(R.id.player_2_games);
        scoreView.setText(String.valueOf(games));
    }

    /*
    public void pointPlayerOne(View view) {
        if (playerOneScore == 0 || playerOneScore == 15) {
            playerOneScore += 15;
        } else
            if (playerOneScore == 30) {
                playerOneScore += 10;
        } else
            if (playerOneScore == 40) {
                if (playerOneAdv) {
                    resetGame();
                    gamePlayerOne();
                    displayForPlayer(playerOneScore);
                    return;
            }
            if (playerTwoScore == 40) {
                if (playerTwoAdv) {
                    playerTwoAdv = false;
                    displayForPlayerTwo(playerTwoScore);
                    return;
                }
                playerOneAdv = true;
                displayAdvantageForPlayerOne("Adv");
                return;
            }
            resetGame();
            gamePlayerOne();
        } else {
            resetGame();
            gamePlayerOne();
        }

        displayForPlayer(playerOneScore);

    }
*/




/*
    public void pointPlayerTwo(View view) {
        if (playerTwoScore == 0 || playerTwoScore == 15) {
            playerTwoScore += 15;
        } else if (playerTwoScore == 30) {
            playerTwoScore += 10;
        } else if (playerTwoScore == 40) {
            if (playerTwoAdv) {
                resetGame();
                gamePlayerTwo();
                displayForPlayerTwo(playerTwoScore);
                return;
            }
            if (playerOneScore == 40) {
                if (playerOneAdv) {
                    playerOneAdv = false;
                    displayForPlayer(playerOneScore);
                    return;
                }
                playerTwoAdv = true;
                displayAdvantageForPlayerTwo("Adv");
                return;
            }
            resetGame();
            gamePlayerTwo();
        } else {
            resetGame();
            gamePlayerTwo();
        }

        displayForPlayerTwo(playerTwoScore);

    }

    public void gamePlayerTwo() {
        playerTwoGames++;
        displayGamesForPlayerTwo(playerTwoGames);
    }
*/

    public void resetScore(View view) {
        playerOne.resetGame();
        playerTwo.resetGame();
        displayForPlayer(playerOne.getScore(), R.id.player_1_score);
        displayForPlayer(playerTwo.getScore(), R.id.player_2_score);
    }

    public void resetGame() {
        playerOne.resetGame();
        playerTwo.resetGame();
        displayForPlayer(playerOne.getScore(), R.id.player_1_score);
        displayForPlayer(playerTwo.getScore(), R.id.player_2_score);
    }

    public void resetMatch(View view) {
        playerOne.resetMatch();
        playerTwo.resetMatch();
        displayForPlayer(playerOne.getScore(), R.id.player_1_score);
        displayForPlayer(playerTwo.getScore(), R.id.player_2_score);
    }

}
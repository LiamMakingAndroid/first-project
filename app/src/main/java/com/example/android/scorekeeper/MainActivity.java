package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Player playerOne = new Player("Player 1");
    Player playerTwo = new Player("Player 2");

    public void scoreP1 (View view){
        scorePoint(playerOne, playerTwo);
    }

    public void scoreP2 (View view){
        scorePoint(playerTwo, playerOne);
    }

    public void gameP1 (View view){
        gameForPlayer(playerOne);
    }

    public void gameP2 (View view){
        gameForPlayer(playerTwo);
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
        if (player == playerOne) {
            displayAdvantage("Adv", R.id.player_1_score);
        }else
            if (player == playerTwo){
                displayAdvantage("Adv", R.id.player_2_score);
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
        if (player == playerOne) {
            displayGames(player.getGameScore(), R.id.player_1_games);
        }else
            if (player == playerTwo){
                displayGames(player.getGameScore(), R.id.player_2_games);
            }
    }

    public void displayForPlayer(int score, int viewId) {
        TextView scoreView = (TextView) findViewById(viewId);
        scoreView.setText(String.valueOf(score));
    }

    public void displayAdvantage(String score, int viewId) {
        TextView scoreView = (TextView) findViewById(viewId);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGames(int score, int viewId) {
        String games = "Games: " + score;
        TextView scoreView = (TextView) findViewById(viewId);
        scoreView.setText(String.valueOf(games));
    }

    public void displayAll(){
        displayForPlayer(playerOne);
        displayForPlayer(playerTwo);
        displayGames(playerOne.getGameScore(), R.id.player_1_games);
        displayGames(playerTwo.getGameScore(), R.id.player_2_games);
    }

    public void resetScore(View view) {
        playerOne.resetGame();
        playerTwo.resetGame();
        displayAll();
    }

    public void resetGame() {
        playerOne.resetGame();
        playerTwo.resetGame();
        displayAll();
    }

    public void resetMatch(View view) {
        playerOne.resetMatch();
        playerTwo.resetMatch();
        displayAll();
    }

}
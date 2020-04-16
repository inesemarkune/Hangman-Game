package Hangman;
import java.util.*;

public class Hangman {
	
	//instance variable
	private String secretWord;
	private StringBuffer hiddenWord = new StringBuffer();
	private String showWord;
	
	//constructor
	public Hangman() {
	}

	
	//setMethod
	public void setSecretWord(String secretWord) {
			this.secretWord = secretWord;
	}
	
	public void setShowWord(String endWord) {
		this.showWord = endWord;
	}
	
	
	
	
	//a method to encrypt the secret word 
	public void hideWord() {
		hiddenWord = new StringBuffer();
		
		for(int i = 0; i < secretWord.length() ; i++) {  
			hiddenWord.append('-');
			
		}
	}
	
	
	//getMethods for the encrypted word to show the player
	public String getShowWord() {
		return showWord = hiddenWord.toString();
	}

	//to display the actual word that was hidden
	public String getSecretWord(String secretWord) {
		return secretWord;
}



}

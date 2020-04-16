package Hangman;
import java.util.*;

public class HangmanApp {

	public static void main(String[] args) {
		
			char playAgain;
		
		do {		
			//local variables
			Scanner input = new Scanner(System.in);
			Hangman hm = new Hangman();

			String showWord; //holds the chosen word
			String[] words = {"macchiatto", "cosmopolitan", "tequila", "americano", "cappucino", "frappucino", "espresso", "margarita" };					char[] charstring;
			int lives = 6;
		
		
			//generate a random word from string[]
			String secretWord = words[(char)(Math.random()* words.length)];
		
			//setter method
			hm.setSecretWord(secretWord);
		
			//processing method - encrypting the secretWord
			hm.hideWord();
		
			//getter method to get the encrypted word
			showWord = hm.getShowWord();
		
			//create array of chars from the encrypted word
			charstring = showWord.toCharArray();
		
		
		//introduction message
		System.out.println();
		System.out.println("                      ***          ");
		System.out.println("          Welcome to the HANGMAN game!");
		System.out.println("       =================================");
		System.out.println();
		System.out.println("In this game you have to guess the name of a drink! ");
		System.out.println("       You can only make 6 wrong guesses!");
		System.out.println("          To begin the game, press Y!");
		
		char answer = input.next().toUpperCase().charAt(0);
		
		//to store the letters already used in the guessing process
		ArrayList<Character> usedLetters = new ArrayList<Character>();


		//loop to check users answer, and in case it is Y, then continue with game
		if(answer == 'Y') {
			
			System.out.println();
			System.out.println("  Lives: " + lives);
			System.out.println(showWord);
			
			
			while(lives > 0) {
				System.out.println();
				System.out.println("Please, enter a letter!");
				char g = input.next().charAt(0);//to store a letter - user's guess 
				
				if(usedLetters.contains(g)) {
					System.out.println("This letter was already used!");
					continue;  //while loop continues
				}
				usedLetters.add(g);//entered character is added to the usedLetters list.
				
				if (secretWord.contains(g + "")) {
					for(int y = 0; y < secretWord.length(); y++) {//this loop will check all the array indexes for the
						if(secretWord.charAt(y) == g) {			  //character and will replace the '-' with the character
							charstring[y]= g;
						}
					}
				}else {
					lives--; //life decreases by 1 if char entered isn't there in the word 
					System.out.println("Sorry, wrong guess!");
					System.out.println("_______________________");
				}
				
				if(secretWord.equals(String.valueOf(charstring))) { //checking if charstring equals word
					System.out.println();
					System.out.println(charstring);
					System.out.println("           ***            ");
					System.out.println("Congratulations, You Won!");
					break;
				}
				
				//display remaining lives and the hidden word (dashes)
				System.out.println();
				System.out.println("  Lives remaining = "+ lives);
				System.out.println();
				System.out.println(charstring);
				
			}//end while 
			
			//if lives run out, end game and display message "you lost" and the secret word
			if(lives==0) {
				System.out.println();
				System.out.println("___________________________");
				System.out.println("     Sorry, you lost!");
				System.out.println("The secret word is: " + secretWord);
				
			}
			
		}else{//if user doesn't choose Y, the game does not start. a goodbye message is displayed 
				System.out.println("    Sorry to see you leave. Come back soon! :)");
				System.out.println("                      ***          ");
				break;
		}//end if 
		
		//ask the player to play again
		System.out.println("Would you like to play again?");
		playAgain = input.next().toUpperCase().charAt(0);
		
			//if player chooses not to play, show the goodbye message
			if(playAgain != 'Y') {
				System.out.println("    Sorry to see you leave. Come back soon! :)");
				System.out.println("                      ***          ");
				break;
			}
		
		}while(playAgain == 'Y');	

	}//end main
	
}//end class




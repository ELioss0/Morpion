package fr.elioss.morpion;
import java.util.Scanner;


public class Main {
	static int rounds = 0;
	static String tour = "O";
	static int xoInput;
	static String tableur[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
	public static void main(String[] args) {
		tableurMorpion();
		play();
		
	}
	
	public static void tableurMorpion() {
		System.out.println(tableur[0] + " | " + tableur[1] + " | " + tableur[2] + "\n" +
						   "--+---+--\n" +
     		   			   tableur[3] + " | " + tableur[4] + " | " + tableur[5] + "\n" +
     		   			   "--+---+--\n" +
     		   			   tableur[6] + " | " + tableur[7] + " | " + tableur[8]);
	}
	
	public static void play() {
		Scanner input = new Scanner(System.in);
		while(true) {
			switch(tour) {
				case "X":
					tour = "O";
					rounds += 1;
					break;
				case "O":
					tour = "X";
					rounds += 1;
					break;
			}
			System.out.println("C'est le tour de " + tour + ".\nEntrez la position de " + tour + " :");
		
			xoInput = input.nextInt();
			while(tableur[xoInput].equals("X") || tableur[xoInput].equals("O")) {
				System.out.println("Il y a déjà un " + tableur[xoInput] + " ici. Entrez la nouvelle position de " + tour + " :");
				xoInput = input.nextInt();
			}
		
			tableur[xoInput] = tour;	
			tableurMorpion();
			verification();
		}
	}
	
	public static void verification() {
		if(tableur[0] == tableur[1] && tableur[1] == tableur[2]||
		   tableur[3] == tableur[4] && tableur[4] == tableur[5]||
		   tableur[6] == tableur[7] && tableur[7] == tableur[8]||
	   	   tableur[0] == tableur[3] && tableur[3] == tableur[6]||
	           tableur[1] == tableur[4] && tableur[4] == tableur[7]||
	           tableur[2] == tableur[5] && tableur[5] == tableur[8]||
	           tableur[0] == tableur[4] && tableur[4] == tableur[8]||
	           tableur[2] == tableur[4] && tableur[4] == tableur[6]){
			System.out.println("Le " + tour + " a gagné !");
			System.exit(0);
		}
		
		else if(rounds == 9){
			System.out.println("Egalité !");
			System.exit(0);
		}
		
	}
}

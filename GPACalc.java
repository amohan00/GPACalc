import java.util.Scanner;

public class GPACalc {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int credits = 0;
		double score = 0.0;
		double cum = 0.0;
		String grade = "";
		double gpa = 0;
		int temp = 0;
		int count = 1;
		boolean loop = true;
		boolean go = true;
		System.out.print("Enter 1 for bulk calculation or 2 for individual: ");
		temp = key.nextInt();
		if (temp == 1) {
			System.out.print("Enter the number of credits: ");
			credits = key.nextInt();
			System.out.print("Enter the GPA: ");
			gpa = key.nextDouble();
			cum = gpa*credits;
		}
		do {
			System.out.printf("Enter class number %d's credits: ", count);
			try {
				temp = key.nextInt();
				while (go) {
					go = false;
					System.out.printf("Enter class number %d's grade: ", count);
					grade = key.next();
					switch (grade) {
						case "A+":	
						case "a+":	score = temp*4.0;		
									credits += temp;
									count++;
									break;
						case "A":	
						case "a":	score = temp*4.0;		
									credits += temp;
									count++;
									break;
						case "A-":	
						case "a-":	score = temp*3.75;		
									credits += temp;
									count++;
									break;
						case "B+":	
						case "b+":	score = temp*3.25;		
									credits += temp;
									count++;
									break;
						case "B":
						case "b":	score = temp*3.0;		
									credits += temp;
									count++;
									break;
						case "b-":			
						case "B-":	score = temp*2.75;		
									credits += temp;
									count++;
									break;
						case "c+":
						case "C+":	score = temp*2.25;		
									credits += temp;
									count++;
									break;
						case "c":
						case "C":	score = temp*2.0;
									credits += temp;
									count++;
									break;
						case "c-":
						case "C-":	score = temp*1.75;		
									credits += temp;
									count++;
									break;
						case "d+":
						case "D+":	score = temp*1.25;		
									credits += temp;
									count++;
									break;
						case "d":		
						case "D":	score = temp*1.0;		
									credits += temp;
									count++;
									break;
						case "d-":
						case "D-":	score = temp*0.75;		
									credits += temp;
									count++;
									break;
						case "f":
						case "F":	score = temp*0.0;		
									credits += temp;
									count++;
									break;
						default:
									System.out.println("Not a grade");
									go = true;
					}
				}
				cum += score;
				gpa = cum/credits;
				System.out.printf("Your GPA is: %.5f\nRounded to: %.2f\n", gpa, gpa);
				System.out.printf("You are at %d credits\n", credits);
				go = true;
				while (go) {
					System.out.println("[A]dd another, [C]lear, or [E]xit?");
					grade = key.nextLine();
					if (grade.isEmpty()) grade = "a";
					switch (grade) {
						case "A":
						case "a":	go = false;
									break;
						case "C":
						case "c":	credits = 0;
									cum = 0.0;
									gpa = 0;
									count = 1;
									go = false;
									break;
						case "E":
						case "e":	loop = false;
									go = false;
									break;
						default:
									System.out.println("huh");
					}
				}
				go = true;
			}
			catch (Exception e) {
				System.out.println("Not a number");
				grade = key.next();
			}
		}
		while (loop);
	}
}
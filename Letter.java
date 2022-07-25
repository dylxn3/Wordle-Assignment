
public class Letter {
	//instant variables
	char letter;
	int label;
	final int UNSET = 1;
	final int UNUSED = 2;
	final int USED = 3;
	final int CORRECT = 4;
	
	public Letter(char c) {
		label = UNSET;
		letter = c;
	}
	public boolean equals(Object otherObject) {
		
		if (otherObject instanceof Letter) { //makes new object of of type Letter
			Letter temp = (Letter) otherObject;
			if(this.letter == temp.letter)// if letter variable equals the other 
				return true;
			else 
				return false;}
		else 
			return false;
		

	}	
	public String decorator() {
		String used = "+"; //method to return symbols if used, unused, correct and unset
		String unused ="-";
		String correct ="!";
		String unset = " ";
		if (this.label == USED) 
			return (used);
		else if(this.label == UNUSED) 
			return (unused);
		else if (this.label == CORRECT) 
			return (correct);
		else 
			return (unset);
	}
	public String toString() {
		String x = this.decorator(); //print statement that uses the work from the method class
		String all = (x + this.letter + x);
		//System.out.print(all);
		return all;
	}
	
	// sets label varaible to a specific varaible
	public void setUnused() {
		label = UNUSED;
		
	}
	public void setUsed() {
		label = USED;
	}
	public void setCorrect() {
		label = CORRECT;
	}
	public boolean isUnused() {
		if (label == UNUSED){
			return true;
		}else 
			return false;
	}
	public static Letter[] fromString(String s) { //creates a letter array from the individual characters of the given string
		Letter[] array = new Letter[s.length()];
		for (int i = 0; i <s.length();i++) { //loops through each character
			array[i] = new Letter(s.charAt(i));
			
		}
		return array;
		
	}	
}

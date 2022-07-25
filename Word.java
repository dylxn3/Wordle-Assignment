
public class Word  {
	private LinearNode <Letter> firstLetter;
	
 	public Word(Letter[] letters) {// constructor makes objects	
			//LinearNode<Letter> nodeAfter = new LinearNode<Letter>();//new nodes
			LinearNode<Letter> curr = new LinearNode<Letter>();// makes a new node
			LinearNode<Letter> prev = new LinearNode<Letter>();//makes a new node
			int letterLength= letters.length; // varaible for letter length
			for (int i = 0; i<letterLength; i++) { // loops through letter array
				curr = new LinearNode<Letter>(letters[i]);
				if (i==0) {
					this.firstLetter = curr; //initializes new node as pointer
					prev = curr;
					continue;
				}
				prev.setNext(curr);
				prev = curr;
			}
					
			}

	public String toString() {	//overriden method
		String Word = "Word: ";
		String all = "";
	
		LinearNode<Letter> elements = this.firstLetter;
		while (elements!= null) { //loops through linked list
			if (elements.getNext()== null) { // if the next node after the current one is null
				all += elements.getElement().toString(); // add element as a string into the already made string 
				break;
			}
			all += elements.getElement().toString() + " "; // gets all the elemnents as a collective
			elements = elements.getNext();// gets next node 
		
		
		}
		System.out.println(Word + all + " ");
		return Word + all +" ";
	}
	private boolean has(LinearNode<Letter>letter) {
		LinearNode<Letter>current = firstLetter; // makes varaible for instant varaivle firstLetter
		while(current!= null) { // loops through linked list 
			if(current.getElement().equals(letter.getElement())) { 
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	public boolean labelWord(Word mystery) { 
		 LinearNode <Letter> mysteryWord = mystery.firstLetter; //makes two firstLetter nodes for tow linked lists
		 LinearNode <Letter> guess = this.firstLetter; 
		 boolean mark1 = true;
		 while (true) { //loops through each lsit 
			 if (guess == null ||mysteryWord ==null) {
				 if (guess == null && mysteryWord == null) { // if null break
					 break;
				 }
		//System.out.print(guess.getElement());
			while (guess != null) { //loops through one linked list
				if (mysteryWord == null &&mystery.has(guess)) { // if next node is null and a linked list has an element of another
					guess.getElement().setUsed();// set used
					mark1 = false;
				} else {
					guess.getElement().setUnused(); // set unused
					mark1 = false;
				}
				guess = guess.getNext();
			}
			if (guess == null) {
				mark1 = false;
				break;
			}
			 }
			if (guess.getElement().equals(mysteryWord.getElement())) { // if the exact element has the other exact element
				guess.getElement().setCorrect(); // set correct
			}else {
				if (mystery.has(guess)) { // if linked list mystery has guess
					guess.getElement().setUsed();
				}else {
					guess.getElement().setUnused();
				}
				mark1 = false;
			}
			guess = guess.getNext(); //gets next guess node
			mysteryWord = mysteryWord.getNext();  //gets next msytery node
		 }
		return mark1;
			 }
	

}

		
		

	




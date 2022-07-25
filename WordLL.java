
public class WordLL {
	Word mysteryWord;
	LinearNode<Word> history;
	
	public WordLL(Word mystery) {
		history = null; //mkaes node null
		mysteryWord = mystery;
	}
	public boolean tryWord(Word guess) {
		LinearNode<Word> firstNode = new LinearNode<Word>();
		LinearNode<Word> secondNode = new LinearNode<Word>();
		boolean check = false; 
		if (this.history == null) {
			secondNode.setElement(guess);
			this.history = secondNode;
			
		}
		else {
			secondNode = this.history;
			this.history = firstNode;
			firstNode.setElement(guess);
			firstNode.setNext(secondNode);
		}
		if(guess.labelWord(this.mysteryWord)== true) {
			check = true;
			
		}
		return check;
	}
	public String toString() {
		String collection = "";
		LinearNode<Word> nodeAhistory = history;
		while (nodeAhistory != null) {// loops through linked list 
			//System.out.println(nodeAhistory.getElement());
			collection += nodeAhistory.getElement().toString() + "\n";// adds elements to collection string 
			nodeAhistory = nodeAhistory.getNext();
		
			
		}
		return collection;
	}
}


public class ExtendedLetter extends Letter {
	private String content;
	private int family;
	private Boolean related;
	private final int Singleton = -1;
	
	public ExtendedLetter(String s) {
		super('d'); // inherits from letter class
		content = s;
		related= false;
		family = Singleton;
		
	}
	public ExtendedLetter(String s, int fam) {
		super('a');  // inherits from letter class
		content = s;
		content = s;
		related = false;
		family = fam;
	}
	public boolean equals(Object other) {
		if (other instanceof ExtendedLetter) { // if both objects are the same type
			ExtendedLetter x = (ExtendedLetter) other;// cast new object as that type
			if (this.family == x.family) {// if two object family variables are the same
				this.related= true;
			}
			if (this.content == x.content) {// if two object content variables are the same
				return true;
			}
			else 
				return false;
				
			}
		else return false;
				
	}
	
	public String toString() {
		//String object1 = this.content;// variable for content. 
		String s = "";
		if (this.isUnused() == true && this.related == true) {// if decorator method return specific statement
			s = "." + this.content + ".";
		} else {
			s = this.decorator() + this.content + this.decorator();
		}
		System.out.println(s);
		return s;	
	}		
	public static Letter[] fromStrings(String[] content, int[] codes){
		Letter[] letters = new Letter[content.length];// new array with content length
		for(int i = 0; i<letters.length; i++) {
			//for(int j = 0; j<content.length; j++)
			if (codes == null) {// if array is null
				letters[i] = new ExtendedLetter(content[i]);
			}
			else
				letters[i] = new ExtendedLetter(content[i], (char)codes[i]);
		
		}
		return letters;
	}
}

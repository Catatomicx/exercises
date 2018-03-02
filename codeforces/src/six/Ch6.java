package six;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Ch6 {

	public static void main(String[] args) throws FileNotFoundException {
		new Ch6().run();
	}
	
	public void run() throws FileNotFoundException {
		//boyGirl();
		//evenNumbers();
		//negativeSum(new Scanner (new File("negative")));
		//coinCount(new Scanner(new File("coin")));
		//collapseSpaces(new Scanner(new File("spaces")));
		//System.out.println(readEntireFile(new Scanner(new File("file"))));
		//flipLines(new Scanner(new File("lines")));
		//doubleSpace(new Scanner(new File("doubleSpace")));
		//wordWrap(new Scanner(new File("wrap")), 60);
		//wordWrapAlt(new Scanner(new File("test")), 60);
		//wordWrapWord(new Scanner(new File("wrap")), 60);
		//stripHtmlTags(new Scanner(new File("html")));
		//stripComments(new Scanner(new File("comments")));
		//printDuplicates(new Scanner(new File("duplicates")));
		//coinFlip(new Scanner(new File("flip")));
		//mostCommonNames(new Scanner(new File("common")));
		//inputStats(new Scanner(new File("stats")));
		//plusScores(new Scanner(new File("scores")));
		//leetSpeak(new Scanner(new File("leet")));
	}
	
	//This one was more obnoxious than anything. At least it exposed me to some methods in Character
	public void leetSpeak(Scanner input) {
	    while(input.hasNextLine()) {
	        String line = input.nextLine();
	        StringBuilder leetLine = new StringBuilder();	        
	        for(int i = 0; i < line.length(); i++) {
	            char c = line.charAt(i);	            
	            if(Character.isWhitespace(c)) {
	                leetLine.append(c);
	            } else {
	                if(i == 0 || (i > 0 && Character.isWhitespace(line.charAt(i - 1))))
	                    leetLine.append('(');
	                if(c == 'o') {
	                    leetLine.append('0');
	                } else if(c == 'l') {
	                    leetLine.append('1');
	                } else if(c == 'e') {
	                    leetLine.append('3');
	                } else if(c == 'a') {
	                    leetLine.append('4');
	                } else if(c == 't') {
	                    leetLine.append('7');
	                } else if(c == 's' && (i == line.length() - 1 || Character.isWhitespace(line.charAt(i + 1)))) {
	                    leetLine.append('Z');
	                } else {
	                    leetLine.append(c);
	                }	                
	                if(i == line.length() - 1 || Character.isWhitespace(line.charAt(i + 1)))
	                    leetLine.append(')');
	            }
	        }
	        System.out.println(leetLine);
	    }
	}
	
	public void plusScores(Scanner sc) {
	    while(sc.hasNextLine()) {
	        String name = sc.nextLine();
	        String scores = sc.nextLine();
	        int pluses = 0;
	        int minuses = 0;  
	        for(int i = 0; i < scores.length(); i++) {
	            if(scores.charAt(i) == '+')
	                pluses++;
	            else
	                minuses++;	            
	        }       
	        double percent = 100.0 * pluses / (pluses + minuses);
	        System.out.println(name + ": " + percent + "% plus");
	    }
	}
	
	public static void inputStats(Scanner sc) {
	    int lineNum = 0;
	    int longestLine = 0;
	    String longestString = new String();	    
	    while (sc.hasNextLine()) {
	        lineNum++;
	        String line = sc.nextLine();
	        if(line.length() > longestLine) {
	            longestLine = line.length();
	            longestString = line;
	        }
	        int tokens = 0;
	        int longestToken = 0;
	        Scanner linesc = new Scanner(line);	        
	        while (linesc.hasNext()) {
	            tokens++;
	            String word = linesc.next();
	            if (word.length() > longestToken)
	            		longestToken = word.length();
	        }
	        System.out.println("Line " + lineNum + " has " + tokens + " tokens (longest = " + longestToken + ")");
	    }    
	    System.out.println("Longest line: " + longestString);
	}
	
	public int mostCommonNames(Scanner sc) {
	    int uniqueName = 0;
	    while (sc.hasNextLine()) {
	        Scanner line = new Scanner(sc.nextLine());
	        String last = line.next();
	        uniqueName++;
	        String commonWord = last;
	        int mostCommon = 1;
	        int count = 1;
	        while (line.hasNext()) {
	            String current = line.next();
	            if (current.equals(last))
	                count++;
	            else {
	                if (count > mostCommon) {
	                    mostCommon = count;
	                    commonWord = last;     
	                }
	                count = 1;
	                uniqueName++;
	            }
	            last = current;
	        }
	        if (count > mostCommon)
	            commonWord = last;
	        System.out.println("Most common: " + commonWord);
	    }
	    
	    return uniqueName;
	}
	
	public void coinFlip(Scanner sc) {
		while(sc.hasNextLine()) {
			Scanner line = new Scanner(sc.nextLine());
			int heads = 0;
			int tails = 0;
			while(line.hasNext()) {
				String next = line.next();
				if(next.toLowerCase().equals("h"))
					heads++;
				else
					tails++;
			}
			double percent = Math.round(1.0 * heads / (heads + tails) * 1000.0) / 10.0; //odd calculation for rounding.
										//I did this in another problem but didn't address it in a comment until now.
			System.out.println(heads + " heads (" + percent + "%)");
			if(percent >= 50)
				System.out.println("You win!");
		}
	}
	
	public void printDuplicates(Scanner sc) {
	    while(sc.hasNextLine()) {
	        Scanner line = new Scanner(sc.nextLine());
	        String current = "";
	        int count = 0;	  
	        while(line.hasNext()) {
	            String next = line.next();
	            if(next.equals(current))
	                count++;
	            else {
	                if(count > 1)
	                    System.out.print(current + "*" + count + " ");	                
	                current = next;
	                count = 1;
	            }
	        }	        
	        if(count > 1)
	            System.out.print(current + "*" + count);	        
	        System.out.println();
	    }
	}
	
	public void stripComments(Scanner sc) {
	    while (sc.hasNextLine()) {
	        String line = sc.nextLine();
	        if (!line.trim().startsWith("/*")) {
	            if (!line.contains("/*") && line.endsWith("*/")) {
	                line = "";
	            } else if (line.contains("/*") && line.contains("*/")) {
	                line = line.substring(0, line.indexOf("/*")) + line.substring(line.indexOf("*/") + 2);
	            } else if (line.contains("//")) {
	                line = line.substring(0, line.indexOf("//"));
	            }
	            System.out.println(line);
	        }
	    }
	}
	
	public void stripHtmlTags(Scanner sc) {
	    while (sc.hasNextLine()) {
	        String line = sc.nextLine();
	        while (line.contains("<") || line.contains(">")) {
	            int index1 = line.indexOf("<");
	            int index2 = line.indexOf(">");
	            if (index1 == 0)
	                line = line.substring(index2 + 1);
	            else
	                line = line.substring(0, index1) + line.substring(index2 + 1);
	        }
	        System.out.println(line);
	    }
	}
	
	//Does the same as original, but doesn't break tokens into different lines.
	public void wordWrapWord(Scanner sc, int maxLength) {
		String line = new String();
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			wrapWord(line, maxLength);
		}
	}
	
	public void wrapWord(String line, int maxLength) {
		String sixtyCharLine = new String();
		while(line.length() > maxLength) {
			for(int i = maxLength - 1; i < line.length(); i++) {
				if(line.charAt(i) == ' ' || i == line.length() - 1) {
					sixtyCharLine = line.substring(0, i + 1);
					line = line.substring(i + 1);
					i = line.length();
				}
			}
			System.out.println(sixtyCharLine);
		}
		if(line.length() != 0)
			System.out.println(line);
	}
	
	
	//note to self, don't open a PrintStream before reading it I used to have line 35 on 30
	public void wordWrapAlt(Scanner sc, int maxLength) throws FileNotFoundException {
		StringBuffer buffer = new StringBuffer();
		String line = new String();
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			buffer.append(wrapAlt(line, maxLength));
		}
		PrintStream out = new PrintStream("test");
		out.append(buffer.toString());
	}
	
	public String wrapAlt(String line, int maxLength) throws FileNotFoundException {
		StringBuffer replace = new StringBuffer();
		String sixtyCharLine = new String();
		while(line.length() > maxLength) {
			sixtyCharLine = line.substring(0, maxLength);
			line = line.substring(maxLength);
			replace.append(sixtyCharLine + "\n");
		}
		replace.append(line + "\n");
		return replace.toString();
	}
	
	//original
	public void wordWrap(Scanner sc, int maxLength) {
		String line = new String();
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			wrap(line, maxLength);
		}
	}
	
	public void wrap(String line, int maxLength) {
		String sixtyCharLine = new String();
		while(line.length() > maxLength) {
			sixtyCharLine = line.substring(0, maxLength);
			line = line.substring(maxLength);
			System.out.println(sixtyCharLine);
		}
		System.out.println(line);
	}
	
	public void doubleSpace(Scanner sc) throws FileNotFoundException {
		PrintStream out = new PrintStream(new File("output"));
		while(sc.hasNextLine()) {
			out.append(sc.nextLine());
			out.append("\n" + "\n");
		}
	}
	
	public void flipLines(Scanner sc) {
		String line1 = new String();
		String line2 = new String();
		int count = 2;
		while(sc.hasNextLine()) {
			if(count % 2 == 0)
				line1 = sc.nextLine();
			else { //only switches order once there's two lines (includes empty lines)
				line2 = sc.nextLine();
				System.out.println(line2);
				System.out.println(line1);
			}
			count++;
		}
		if(count % 2 == 1) //for files with odd numbers of lines
			System.out.println(line1);
	}
	
	public String readEntireFile(Scanner sc) {
		StringBuffer buffer = new StringBuffer();
		while(sc.hasNext()) 
			buffer.append(sc.next() + " ");
		return buffer.toString();
	}
	
	public void collapseSpaces(Scanner sc) {
		while(sc.hasNext())
			System.out.print(sc.next() + " ");
	}
	
	public void coinCount(Scanner sc) {
		double total = 0;
		int pennies = 0;
		int nickels = 0;
		int dimes = 0;
		int quarters = 0;
		while(sc.hasNext()) {
			int tempNum = sc.nextInt();
			String tempStr = sc.next().toLowerCase();
			if(tempStr.equals("pennies"))
				pennies += tempNum;
			if(tempStr.equals("nickels"))
				nickels += tempNum;
			if(tempStr.equals("dimes"))
				dimes += tempNum;
			if(tempStr.equals("quarters"))
				quarters += tempNum;
		}
		total += .01 * pennies;
		total += .05 * nickels;
		total += .10 * dimes;
		total += .25 * quarters;
		System.out.println("Total money: $" + total);
	}
	
	public boolean negativeSum(Scanner sc) {
		int sum = 0;
		int steps = 0;
		while(sc.hasNextInt() && sum > -1) {
			sum += sc.nextInt();
			steps++;
		}
		if(sum < 0) {
			System.out.println("sum of " + sum + " after " + steps + " steps");
			return true;
		}
		else {
			System.out.println("no negative sum");
			return false;
		}
	}
	
	public void evenNumbers() throws FileNotFoundException {
		int total = 0;
		int sum = 0;
		int evens = 0;
		File input = new File("even");
		Scanner sc = new Scanner(input);
		while(sc.hasNextInt()) {
			int temp = sc.nextInt();
			total++;
			sum += temp;
			if(temp % 2 == 0 )
				evens++;
		}
		double percentEven = 100.0 * evens / total;
		double rounded = Math.round(percentEven * 100.0) / 100.0;
		System.out.println(total + " numbers, sum = " + sum);
		System.out.println(evens + " evens (" + rounded + ")%");
	}
	
	public void boyGirl() throws FileNotFoundException {
        try {
            Scanner input = new Scanner(new File("names.txt"));
        int boySum = 0;
        int girlSum = 0;
        int count = 0;
        int diff = 0;
        while (input.hasNext()) {
        	input.next();
            int temp = input.nextInt();
            if (count % 2 == 0) {
                boySum += temp;
            } else {
                girlSum += temp;
            }
            count++;
        }
        diff = Math.abs(boySum - girlSum);
        System.out.println("Difference between boys' and girls' sums: " + diff);
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
	}
}

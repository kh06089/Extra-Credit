import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ExtraCredit1A {
	static ArrayList<ExtraCredit1A>maleScores = new ArrayList<>();
	static ArrayList<ExtraCredit1A>femaleScores = new ArrayList<>();
	
	private String first;
	private String last;
	private Gender g;
	private int score;
	
	public ExtraCredit1A(String first,String last){
		this.first=first;
		this.last=last;
		
	}
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public Gender getG() {
		return g;
	}

	public void setG(Gender g) {
		this.g = g;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public static void main (String [] args){
		String line = null;
		try{
			BufferedReader bReader = new BufferedReader(new FileReader("src/q3.txt"));
		
			while((line = bReader.readLine())!=null){
				String [] lineSplit = line.split("\t");
				
				if(lineSplit[2].equals("MALE")){
					ExtraCredit1A e1 = new ExtraCredit1A(lineSplit[0],lineSplit[1]);
					e1.setG(Gender.valueOf(lineSplit[2]));
					e1.setScore(Integer.valueOf(lineSplit[3]));
					maleScores.add(e1);
				}
				
				if(lineSplit[2].equals("FEMALE")){
					ExtraCredit1A e2 = new ExtraCredit1A(lineSplit[0],lineSplit[1]);
					e2.setG(Gender.valueOf(lineSplit[2]));
					e2.setScore(Integer.valueOf(lineSplit[3]));
					femaleScores.add(e2);				
				}
				
				
				
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try{
			BufferedWriter bWriter = new BufferedWriter(new FileWriter("src/q3Ans.txt"));
			Collections.sort(maleScores, new topScore());
			for(int i =0; i<5;i++){
				ExtraCredit1A ms = maleScores.get(i);
				bWriter.write(ms.getFirst()+" "+ms.getLast()+"\n");
				}
			
			bWriter.close();
			
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public enum Gender{
		MALE, FEMALE
	}
	

}
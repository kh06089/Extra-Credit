import java.util.Comparator;
public class topScore extends Object implements Comparator<ExtraCredit1A> {

	@Override
	public int compare(ExtraCredit1A o1, ExtraCredit1A o2) {
		if ((o1.getScore()>o2.getScore())) return -1;
		else if((o1.getScore()<o2.getScore()))return 1;
	
		return 0;
		
		}

}
package db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "results")
public class Results {
	@DatabaseField(canBeNull = false)
	private long beginDateTimeOfTest;
	@DatabaseField(canBeNull = false)
	private long endDateTimeOfTest;
	@DatabaseField(canBeNull = false, generatedId = true)
	private int userId;
	@DatabaseField(canBeNull = false)
	private double nrPairs;
	@DatabaseField(canBeNull = false)
	private double nrTriples;
	@DatabaseField(canBeNull = false)
	private double nrPoker;
	@DatabaseField(canBeNull = false)
	private double nrTwoPairs;
	@DatabaseField(canBeNull = false)
	private double nrFlush;
	@DatabaseField(canBeNull = false)
	private double nrStraightFlush;
	@DatabaseField(canBeNull = false)
	private double nrRoyalFlush;
	@DatabaseField(canBeNull = false)
	private double nrFullHouse;
	
	Results() {
		
	}

	public Results(long beginDateTimeOfTest, long endDateTimeOfTest, int userId, double einPaar, double tripple,
			double poker, double zweiPaar, double flush, double straightFlush, double royalFlush, double fullHouse) {
		this.beginDateTimeOfTest = beginDateTimeOfTest;
		this.endDateTimeOfTest = endDateTimeOfTest;
		this.userId = userId;
		this.nrPairs = einPaar;
		this.nrTriples = tripple;
		this.nrPoker = poker;
		this.nrTwoPairs = zweiPaar;
		this.nrFlush = flush;
		this.nrStraightFlush = straightFlush;
		this.nrRoyalFlush = royalFlush;
		this.nrFullHouse = fullHouse;
	}

	public long getBeginDateTimeOfTest() {
		return beginDateTimeOfTest;
	}

	public void setBeginDateTimeOfTest(long beginDateTimeOfTest) {
		this.beginDateTimeOfTest = beginDateTimeOfTest;
	}

	public long getEndDateTimeOfTest() {
		return endDateTimeOfTest;
	}

	public void setEndDateTimeOfTest(long endDateTimeOfTest) {
		this.endDateTimeOfTest = endDateTimeOfTest;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getNrPairs() {
		return nrPairs;
	}

	public void setNrPairs(int nrPairs) {
		this.nrPairs = nrPairs;
	}

	public double getNrTriples() {
		return nrTriples;
	}

	public void setNrTriples(int nrTriples) {
		this.nrTriples = nrTriples;
	}

	public double getNrPoker() {
		return nrPoker;
	}

	public void setNrPoker(int nrPoker) {
		this.nrPoker = nrPoker;
	}

	public double getNrTwoPairs() {
		return nrTwoPairs;
	}

	public void setNrTwoPairs(int nrTwoPairs) {
		this.nrTwoPairs = nrTwoPairs;
	}

	public double getNrFlush() {
		return nrFlush;
	}

	public void setNrFlush(int nrFlush) {
		this.nrFlush = nrFlush;
	}

	public double getNrStraightFlush() {
		return nrStraightFlush;
	}

	public void setNrStraightFlush(int nrStraightFlush) {
		this.nrStraightFlush = nrStraightFlush;
	}

	public double getNrRoyalFlush() {
		return nrRoyalFlush;
	}

	public void setNrRoyalFlush(int nrRoyalFlush) {
		this.nrRoyalFlush = nrRoyalFlush;
	}

	public double getNrFullHouse() {
		return nrFullHouse;
	}

	public void setNrFullHouse(int nrFullHouse) {
		this.nrFullHouse = nrFullHouse;
	}

}

public class Datum {

	private String maandname[] = {"januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november","december"};
	private int dag;
	private int maand;
	private int jaar;

	  /**
	   * Constructor
	   */
	  public Datum(){
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	  }

	  public Datum(int d, int m, int j){
		this.dag = d;
		this.maand = m;
		this.jaar = j;
	  }


	  public void setDag(int d){
	  	this.dag = d;
	  }

	public int getDag() {
		return dag;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getMaand() {
		return maand;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public int getJaar() {
		return jaar;
	}

	public boolean bestaatDatum(int dag, int maand, int jaar){
		if (dag >= 1 && maand >= 1 && maand <= 12 && jaar >= 1900 && jaar <= 2100) {
			if (maand+2 % 2 == 1 && dag <= 31) {
				return true;
			}
			else if(maand+2 % 2 == 0 && dag <=30) {
				if (maand == 2 && dag <= 29 && jaar % 100 == 0) {
					if (maand == 2 && dag <= 29 && jaar % 400 == 0) {return true;}
					return false;
				}
				else if (maand == 2 && dag <= 29 && jaar % 4 == 0) {return true;}
				else if (maand == 2 && dag <= 28) {return true;}
			}
		}
		return false;
	}
	
	/**
	 * Getter voor Sting weergave van datum
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		return dag + " " + maandname[this.maand-1] + " " + jaar;
	}
}

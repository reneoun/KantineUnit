public class Student extends Persoon {

    private int studentnummer;
    private String studierichting;

    public Student(int st, String richting, String bsn, String vnaam, String anaam,Datum datum, char geslacht){
        super(bsn,vnaam,anaam,datum,geslacht);
        studentnummer = st;
        studierichting = richting;
    }

    public int getStudentnummer() {
        return studentnummer;
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }

    public String toString() {
        return "Student "+voornaam+" is net naar binnengekomen.";
    }
}

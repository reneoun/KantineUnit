import java.time.LocalDate;

public class Kassa {

    private KassaRij kassaRij;
    private double omzet;
    private int aantalArtikelenDoor;
    private javax.persistence.EntityManager manager;

    public Kassa(KassaRij kassarij, javax.persistence.EntityManager manager) {
        this.kassaRij = kassarij;
        omzet = 0;
        aantalArtikelenDoor = 0;
        this.manager = manager;
    }

    public void rekenAf(Dienblad klant){

        LocalDate datum = LocalDate.now();
        Factuur factuur = new Factuur(klant,datum);

        omzet += factuur.getTotaal();
    }

    public int aantalArtikelen() {
        return aantalArtikelenDoor;
    }

    public double hoeveelheidGeldInKassa() {
        return omzet;
    }

    public void resetKassa() {
        omzet = 0;
        aantalArtikelenDoor = 0;
    }
}
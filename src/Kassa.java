import java.util.Iterator;

public class Kassa {

    private KassaRij kassaRij;
    private double omzet;
    private int aantalArtikelenDoor;

    public Kassa(KassaRij kassarij) {
        this.kassaRij = kassarij;
        omzet = 0;
        aantalArtikelenDoor = 0;
    }

    public void rekenAf(Persoon klant) {
        for (Dienblad d : kassaRij.getDienbladen()) {
            if (d.getPersoon().equals(klant)){
                Iterator<Artikel> it = d.getItArtikel();
                while(it.hasNext()){
                    omzet = omzet + it.next().getPrice();
                    aantalArtikelenDoor++;
                }
            }
        }
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
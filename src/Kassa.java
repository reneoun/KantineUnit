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

        double totaal = 0;          //Word totaalprijs van het dienblad
        int aantalArtikel = 0;      //Het aantal artikelen van het dienblad

        for (Dienblad d : kassaRij.getDienbladen()) {
            if (d.getPersoon().equals(klant)){                  //Vind het dienblad die bij de persoon hoort
                Iterator<Artikel> it = d.getItArtikel();
                while(it.hasNext()){

                    totaal = totaal + it.next().getPrice();     //Bereken de totaalprijs van het dienblad
                    aantalArtikel++;                            //Bereken het aantal producten van een dienblad

                }
                if (klant.getBetaalwijze().betaal(totaal)){     //Bekijk of de klant genoeg Moneyzz heeft
                    omzet += totaal;
                    aantalArtikelenDoor += aantalArtikel;
                    System.out.println("Klant heeft "+totaal+" betaald");
                } else {
                    System.out.println("Klant heeft niet genoeg Moneyzz");  //Klant heeft hier gefaald met de betaling
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
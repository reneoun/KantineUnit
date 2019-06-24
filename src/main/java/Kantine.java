public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
//    public void loopPakSluitAan() {
//        // method body omitted
//        Persoon persoon = new Persoon();
//
//        Dienblad dienblad = new Dienblad();
//        dienblad.voegToe(new Artikel("dildo", 5.99));
//        dienblad.voegToe(new Artikel("buttplug", 9.99));
//        dienblad.setPersoon(persoon);
//
//        kassarij.sluitAchteraan(persoon);
//    }

    public void setKantineAanbod(KantineAanbod kantineAanbod){
        this.kantineAanbod = kantineAanbod;
    }

    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
        Dienblad dienblad = new Dienblad();
        dienblad.setPersoon(persoon);
        for (String s : artikelnamen) {
            dienblad.voegToe(kantineAanbod.getArtikel(s));
        }
        kassarij.sluitAchteraan(persoon,dienblad);
    }


    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while(kassarij.erIsEenRij()) {
            // omitted
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    /**
     * Deze methode telt het geld uit de kassa
     *
     * @return hoeveelheid geld in kassa
     */
    public double hoeveelheidGeldInKassa() {
       // method body omitted
        return kassa.hoeveelheidGeldInKassa();
    }

    /**
     * Deze methode geeft het aantal gepasseerde artikelen.
     *
     * @return het aantal gepasseerde artikelen
     */
    public int aantalArtikelen() {
        // method body omitted
        return kassa.aantalArtikelen();
    }

    /**
     * Deze methode reset de bijgehouden telling van
     * het aantal artikelen en "leegt" de inhoud van de kassa.
     */
    public void resetKassa() {
        // method body omitted
        kassa.resetKassa();
    }
}
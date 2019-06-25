package yolo;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;
    private javax.persistence.EntityManager manager;
    /**
     * Constructor
     */
    public Kantine(javax.persistence.EntityManager manager) {
        kassarij = new KassaRij();
        this.manager = manager;
        kassa = new Kassa(kassarij, this.manager);
    }

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
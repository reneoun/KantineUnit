package yolo;

import javax.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Iterator;

@Entity
public class Factuur implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "factuurDatum", nullable = false)
    private LocalDate datum;

    @Column(name = "korting")
    private double korting;

    @Column(name = "totaal")
    private double totaal;

//    @OneToMany(targetEntity = FactuurRegel.class, mappedBy = "factuur", cascade = CascadeType.ALL, orphanRemoval = true)
//    private ArrayList<FactuurRegel> regels;

    public Factuur() {
        totaal = 0;
        korting = 0;
    }

    public Factuur(Dienblad klant, LocalDate datum) {
        this();
        this.datum = datum;
        verwerkBestelling(klant);
    }

    /**
     * Verwerk artikelen en pas kortingen toe.
     * <p>
     * Zet het totaal te betalen bedrag en het
     * totaal aan ontvangen kortingen.
     *
     * @param klant
     */
    private void verwerkBestelling(Dienblad klant) {

        Iterator<Artikel> it = klant.getItArtikel();
        while(it.hasNext()){

            totaal = totaal + it.next().getPrice();     //Bereken de totaalprijs van het dienblad

        }
        Persoon persoon = klant.getPersoon();

        if (persoon instanceof KortingskaartHouder) {
            if (((KortingskaartHouder) persoon).heeftMaximum()){
                if ( (totaal*((KortingskaartHouder) persoon).geefKortingsPercentage()) > ((KortingskaartHouder) persoon).geefMaximum()){
                    totaal = totaal - ((KortingskaartHouder) persoon).geefMaximum();
                    korting = ((KortingskaartHouder) persoon).geefMaximum();
                }
                else {
                    totaal = totaal - totaal * ((KortingskaartHouder) persoon).geefKortingsPercentage();
                    korting = totaal * ((KortingskaartHouder) persoon).geefKortingsPercentage();
                }
            }
        }

        try {
            persoon.getBetaalwijze().betaal(totaal);

        } catch (TeWeinigGeldException e) {
            System.out.println(e.getMessage() + persoon.getVoornaam() + " " + persoon.getAchternaam());  //Klant heeft hier gefaald met de betaling
        }
    }

    /*
     * @return het totaalbedrag
     */
    public double getTotaal() {
        return totaal;
    }

    /**
     * @return de toegepaste korting
     */
    public double getKorting() {
        return korting;
    }

    /**
     * @return een printbaar bonnetje
     */
    public String toString() {
        // method body omitted
        return "Het bedrag was "+getTotaal()+" euro \n"
                +"De klant heeft "+getKorting() + " euro korting gekregen \n"
                +"de klant heeft afgerekent op "+ datum;
    }
}

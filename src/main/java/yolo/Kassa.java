package yolo;

import javax.persistence.EntityTransaction;
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

        if (factuur.getTotaal()!=0){
            EntityTransaction transaction = null;
            try {
                // Get a transaction, sla de student gegevens op en commit de transactie
                transaction = manager.getTransaction();
                transaction.begin();
                manager.persist(factuur);
                transaction.commit();
            } catch (Exception ex) {
                // If there are any exceptions, roll back the changes
                if (transaction != null) {
                    transaction.rollback();
                }
                ex.printStackTrace();
            }
        }

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
package yolo;

public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        // method body omitted
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException{
            if(saldo+kredietlimiet >= tebetalen){
                saldo = saldo - tebetalen;
            }
            else {
                throw new TeWeinigGeldException("U heeft onvoldoende saldo ");
            }
    }
}

import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {

    //ArrayList<Dienblad> positieInRij;
    private String persoon;


    public KassaRij() {
        //positieInRij = new ArrayList<>();
        LinkedList persoon = new LinkedList();
    }

    public void sluitAchteraan(Dienblad klant) {

        //positieInRij.add(klant);
        LinkedList.add(persoon);
    }

    public Dienblad eerstePersoonInRij() {
//        if(positieInRij.get(0) == null) {a
//            return null;
//        }
        if(persoon.add(0) == null) {
            return null;
        }
//        if(positieInRij.get(0) == null) {
//            return null;
//        }

        if(persoon.get(0) == null) {
            return null;
        }
//        Dienblad eerste = positieInRij.get(0);
//        positieInRij.remove(0);
//        return eerste;
        Dienblad eerste = persoon.get(0);
        persoon.remove(0);
        return eerste;
    }

//    public boolean erIsEenRij() {
//        if(positieInRij.size() > 0){
//            return true;
//        }    else{
//            return false;
//        }
//    }

    public boolean erIsEenRij() {
        if(persoon.size() > 0){
            return true;
        }    else{
            return false;
        }
    }
}
package yolo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FactuurRegel implements Serializable {

    @Id
    @Column(name = "id",unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factuur_id")
    private Factuur factuur;

    @ManyToOne
    private Artikel artikel;

    public FactuurRegel(){}

    public FactuurRegel(Factuur factuur, Artikel artikel){
        this.factuur = factuur;
        this.artikel = artikel;
    }

    public String toString(){
        return "Artikel, "+artikel.getName()+", hoort bij factuur: "+factuur.toString();
    }





}

package htw.berlin.webtech.Projekt.persistence;


import javax.persistence.*;


@Entity
public class GerichtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "zubereitungsdauer")
    int zubereitungsdauer;

    @Column(name = "vegan", nullable = false)
    boolean vegan;

    @Column(name = "tageszeit")
    String tageszeit;

//    @Column(name = "counter")
//    int counter;

    public GerichtEntity(String name, int zubereitungsdauer, boolean vegan, String tageszeit
//                         int counter
    ) {

        this.name = name;
        this.zubereitungsdauer = zubereitungsdauer;
        this.vegan = vegan;
        this.tageszeit = tageszeit;
//        this.counter = counter;
    }

    protected GerichtEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId() {this.id = id;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZubereitungsdauer() {
        return zubereitungsdauer;
    }

    public void setZubereitungsdauer(int zubereitungsdauer) {
        this.zubereitungsdauer = zubereitungsdauer;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public String getTageszeit() {
        return tageszeit;
    }

    public void setTageszeit(String tageszeit) {
        this.tageszeit = tageszeit;
    }

//    public int getCounter() {return counter;}
//
//    public void setCounter(int counter) { this.counter = counter; }

}

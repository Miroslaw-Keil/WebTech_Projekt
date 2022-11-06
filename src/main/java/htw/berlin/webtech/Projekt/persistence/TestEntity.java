package htw.berlin.webtech.Projekt.persistence;


import javax.persistence.*;


@Entity
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "zubereitungsdauer")
    int zubereitungsdauer;

    @Column(name = "vegan", nullable = false)
    boolean vegan;

    @Column(name = "tageszeit")
    String tageszeit;

    public TestEntity(long id, String name, int zubereitungsdauer, boolean vegan, String tageszeit) {
        this.id = id;
        this.name = name;
        this.zubereitungsdauer = zubereitungsdauer;
        this.vegan = vegan;
        this.tageszeit = tageszeit;
    }

    protected TestEntity() {

    }

    public long getId() {
        return id;
    }


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

}

package htw.berlin.webtech.Projekt.web.api;

public class Gericht {

//    private int counter;
    private long id;
    private String name;
    private int zubereitungsdauer;
    private boolean vegan;
    private String tageszeit;

    public Gericht(long id, String name, int zubereitungsdauer, boolean vegan, String tageszeit
//                   int counter
    ) {
        this.id = id;
        this.name = name;
        this.zubereitungsdauer = zubereitungsdauer;
        this.vegan = vegan;
        this.tageszeit = tageszeit;
//        this.counter = counter;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getZubereitungsdauer() { return zubereitungsdauer; }

    public void setZubereitungsdauer(int zubereitungsdauer) { this.zubereitungsdauer = zubereitungsdauer; }

    public boolean isVegan() { return vegan; }

    public void setVegan(boolean vegan) { this.vegan = vegan; }

    public String getTageszeit() { return tageszeit; }

    public void setTageszeit(String tageszeit) { this.tageszeit = tageszeit; }

    public int getCounter(int counter) {return counter;}

}

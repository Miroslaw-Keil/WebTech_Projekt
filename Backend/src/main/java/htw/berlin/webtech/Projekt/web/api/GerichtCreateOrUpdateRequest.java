package htw.berlin.webtech.Projekt.web.api;

public class GerichtCreateOrUpdateRequest {

    private String name;
    private int zubereitungsdauer;
    private boolean vegan;
    private String tageszeit;

    public GerichtCreateOrUpdateRequest(String name, int zubereitungsdauer, boolean vegan, String tageszeit) {
        this.name = name;
        this.zubereitungsdauer = zubereitungsdauer;
        this.vegan = vegan;
        this.tageszeit = tageszeit;
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

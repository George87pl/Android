package academy.learnprogramming.listview;

class Owoc {
    private String nazwa;
    private String smak;
    private int ilosc;

    public Owoc(String nazwa, String smak, int ilosc) {
        this.nazwa = nazwa;
        this.smak = smak;
        this.ilosc = ilosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getSmak() {
        return smak;
    }

    public int getIlosc() {
        return ilosc;
    }
}

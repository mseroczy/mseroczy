import java.io.FileWriter;

public class Produkt {

    private int id;
    private String nazwa;
    private float objetosc;
    private String kolor;

//    konstruktory
   public Produkt(int id, float objetosc){
        this.id = id;
        this.nazwa = "Nieznana nazwa";
        this.objetosc = objetosc;
        this.kolor =  "nieznany";
    }

    public Produkt(int id, String nazwa, float objetosc){
        this.id = id;
        this.nazwa = nazwa;
        this.objetosc = objetosc;
        this.kolor = "nieznany";
    }

    public Produkt(int id, float objetosc, String kolor){
        this.id = id;
        this.nazwa = "Nieznana nazwa";
        this.objetosc = objetosc;
        this.kolor = kolor;
    }

    public Produkt(int id, String nazwa, float objetosc, String kolor){
        this.id = id;
        this.nazwa = nazwa;
        this.objetosc = objetosc;
        this.kolor = kolor;
    }

//    gettery / settery
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getObjetosc() {
        return objetosc;
    }

    public void setObjetosc(float objetosc) {
        this.objetosc = objetosc;
    }

    @Override
    public String toString() {
        String s = "ID: " + this.id + "\n";
        s += "Nazwa: " + this.nazwa +"\n";
        s += "Objętosc: " + this.objetosc +"\n";
        s += "Kolor: " + this.kolor +"\n";
        return s ;
    }

//    zapisywanie informacji o produkcie do pliku txt
    public void saveProdukt(){
        try {
            FileWriter w = null;
            w = new FileWriter("zapisane_produkty/"+this.nazwa + "_" + this.id + "_.txt");
            w.write("ID: " + this.id + "\n");
            w.write("Nazwa: " + this.nazwa + "\n");
            w.write("Objetosc: " + this.objetosc + "\n");
            w.close();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

}











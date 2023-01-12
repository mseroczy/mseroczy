import java.util.ArrayList;

public class Slot {

    private float objetoscSlotu;
    private ArrayList<Produkt> produktyWSlocie;

//    konstruktor
    public Slot(float objetoscSlotu){
        this.produktyWSlocie = new ArrayList<Produkt>();
        this.objetoscSlotu = objetoscSlotu;
    }

//  gettery / settery
    public float getObjetoscSlotu() {
        return objetoscSlotu;
    }

    public void setObjetoscSlotu(float objetoscSlotu) {
        this.objetoscSlotu = objetoscSlotu;
    }

    public ArrayList<Produkt> getProduktyWSlocie() {
        return produktyWSlocie;
    }

//    dodawanie produktu
    public void addProdukt(Produkt p){
        this.produktyWSlocie.add(p);
    }

//    usuwanie produktu
    public Produkt delProdukt(int id){
        Produkt tempProdukt = null;
        for(int i=0; i<produktyWSlocie.size(); i++){
            if(produktyWSlocie.get(i).getId() == id){
                tempProdukt = produktyWSlocie.get(i);
                produktyWSlocie.remove(i);
                break;
            }
        }
        return tempProdukt;
    }

//    zwraca objętość produktów znajdujących się w slocie
    public float getZapelnienieSlotu(){
        float suma = 0;
        for(Produkt produkt : produktyWSlocie){
            suma += produkt.getObjetosc();
        }
        return suma;
    }


    @Override
    public String toString() {
        String produkty = "";
        for(Produkt produkt : produktyWSlocie){
            produkty += produkt.toString();
            produkty += "---------------------------------\n";
        }
        String s = "=== INFORMACJA O SLOCIE ===\n";
        s += "+ Objetosc slotu: " + this.objetoscSlotu + "\n";
        s += "+ Produkty w slocie: \n";
        s += "---------------------------------\n";
        s += produkty;
        return s ;
    }


}




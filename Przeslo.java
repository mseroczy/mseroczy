import java.util.ArrayList;

public class Przeslo {

    private ArrayList<Slot> slotyWPrzesle;

//    konstruktor
    public Przeslo(Slot s){
        this.slotyWPrzesle = new ArrayList<Slot>();
        this.addSlot(s);
    }

//  gettery / settery
    public ArrayList<Slot> getSlotyWPrzesle() {
        return slotyWPrzesle;
    }

//  dodawanie slotu
    public void addSlot(Slot s){
        if(this.slotyWPrzesle.size()<3){
            this.slotyWPrzesle.add(s);
        }
        else{
            System.out.println("Slot jest pelny!");
        }
    }

//  usuwanie slotu
    public void delSlot(int slotId){
        this.slotyWPrzesle.remove(slotId-1);
    }

//  pobieranie produktu
    public void addProdukt(int nrSlotu, Produkt p){
        this.slotyWPrzesle.get(nrSlotu-1).addProdukt(p);
    }

//  pobieranie produktu
    public Produkt getProdukt(int idProduktu){
        Produkt tempProdukt = null;
        for(Slot slot : slotyWPrzesle){
            ArrayList<Produkt> produktyWSlocie = slot.getProduktyWSlocie();
            for(Produkt produkt : produktyWSlocie){
                if(produkt.getId() == idProduktu) {
                    tempProdukt = produkt;
                    break;
                }
            }
        }
        return tempProdukt;
    }

//    sprawdza czy układ elementów w przęśle jest poprawny
    public boolean isOk(){
        for(Slot slot : slotyWPrzesle){
            ArrayList<Produkt> produktyWSlocie = slot.getProduktyWSlocie();
            float tempObjetoscSlotu = slot.getObjetoscSlotu();
            float tempObjetoscProduktow = 0;
            for(Produkt produkt : produktyWSlocie){
              tempObjetoscProduktow += produkt.getObjetosc();
            }
            if(tempObjetoscProduktow>tempObjetoscSlotu){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String sloty = "";
        int nr = 0;
        for(Slot slot : slotyWPrzesle){
            sloty += "Nr slotu: " + nr + "\n";
            sloty += "Objetosc slotu: " + slot.getObjetoscSlotu() + "\n";
            sloty += "Ilosc produktow w slocie: " + slot.getProduktyWSlocie().size() + "\n";
            sloty += "---------------------------------\n";
            nr++;
        }

        String s = "=== INFORMACJA O PRZESLE ===\n";
        s += "+ Ilosc slotow: " + this.slotyWPrzesle.size() + "\n";
        s += "+ Czy ulad jest poprawny? " + this.isOk() + "\n";
        s += "+ Sloty w przesle: \n";
        s += "---------------------------------\n";
        s += sloty;
        return s ;
    }

}

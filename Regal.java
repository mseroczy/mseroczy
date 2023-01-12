import java.util.ArrayList;

public class Regal {

    private ArrayList<Przeslo> przeslaWRegale;
    private String oznaczenie;

    public Regal(String oznaczenie) {
        this.oznaczenie = oznaczenie;
        this.przeslaWRegale = new ArrayList<Przeslo>();
    }

//  gettery / settery
    public ArrayList<Przeslo> getPrzeslaWRegale() {
        return przeslaWRegale;
    }

    public String getOznaczenie() {
        return oznaczenie;
    }

    public void setOznaczenie(String oznaczenie) {
        this.oznaczenie = oznaczenie;
    }

//  dodawanie przęsła
    public void addPrzeslo(Przeslo prz){
        this.przeslaWRegale.add(prz);
    }

//  dodawanie produktu
    public void addProdukt(Produkt p){
        int przesloNo = 0;
        for(Przeslo przeslo: przeslaWRegale){
            przesloNo++;
            ArrayList<Slot> tempSloty = przeslo.getSlotyWPrzesle();
            int slotNo = 0;
            for(Slot slot : tempSloty){
                slotNo++;
                if(slot.getZapelnienieSlotu()+p.getObjetosc() <= slot.getObjetoscSlotu()){
                    int miejsceNo = slot.getProduktyWSlocie().size()+1;
                    slot.addProdukt(p);
                    System.out.println("DODAMO! \nPozycja: przeslo: "+ przesloNo +", slot: "+ slotNo +", miejsce: "+miejsceNo);
                    break;
                }
            }
        }
    }

//    pobiera produkt z regału i usuwa go
    public Produkt getProdukt(int idProduktu){
        Produkt pobranyProdukt = null;
        for(Przeslo przeslo: przeslaWRegale){
            ArrayList<Slot> tempSloty = przeslo.getSlotyWPrzesle();
            for(Slot slot : tempSloty){
                ArrayList<Produkt> tempProdukty = slot.getProduktyWSlocie();
                for(Produkt produkt : tempProdukty){
                    if(produkt.getId() == idProduktu){
                       pobranyProdukt = slot.delProdukt(idProduktu);
                       break;
                    }
                }
            }
        }
        return pobranyProdukt;
    }

//  liczy objętość egału i jego zapełnienie w zależności od parametru
    public float policzObjetosc(String co){
        float suma = 0;
        switch(co) {
            case "zapelnienie":
                    for(Przeslo przeslo: przeslaWRegale){
                        ArrayList<Slot> tempSloty = przeslo.getSlotyWPrzesle();
                        for(Slot slot : tempSloty){
                            suma += slot.getZapelnienieSlotu();
                        }
                    }
                break;
            case "pojemnosc":
                    for(Przeslo przeslo: przeslaWRegale){
                        ArrayList<Slot> tempSloty = przeslo.getSlotyWPrzesle();
                        for(Slot slot : tempSloty){
                            suma += slot.getObjetoscSlotu();
                        }
                    }
                break;
        }
        return suma;
    }

//  liczy ilość elementów regału w zależności od parametru
    public int policzElementy(String co){
        int liczba = 0;
        switch(co) {
            case "przesla":
                    liczba = przeslaWRegale.size();
                break;
            case "sloty":
                    for(Przeslo przeslo: przeslaWRegale){
                        liczba += przeslo.getSlotyWPrzesle().size();
                    }
                break;
            case "produkty":
                    for(Przeslo przeslo: przeslaWRegale){
                        ArrayList<Slot> tempSloty = przeslo.getSlotyWPrzesle();
                        for(Slot slot : tempSloty){
                            liczba += slot.getProduktyWSlocie().size();
                        }
                    }
                break;
        }
        return liczba;
    }

//  prezentuje w czytelny sposób układ regału
    public String ukladRegalu(){
        String uklad = "";
        int przesloNo = 0;
        for(Przeslo przeslo: przeslaWRegale){
            przesloNo++;
            uklad += "***** PRZESLO "+ przesloNo + " *******************************\n";
            ArrayList<Slot> tempSloty = przeslo.getSlotyWPrzesle();
            int slotNo = 0;
            for(Slot slot : tempSloty){
                slotNo++;
                uklad += "\t----- SLOT "+ slotNo + "---------------------------\n";
                ArrayList<Produkt> tempProdukty = slot.getProduktyWSlocie();
                int produktNo = 0;
                for(Produkt produkt : tempProdukty){
                    produktNo++;
                    uklad +="\t\t>>> Produkt " + produktNo + "\n";
                    uklad += "\t\t\tID :" + produkt.getId() + "\n";
                    uklad += "\t\t\tNazwa: " + produkt.getNazwa() + "\n";
                    uklad += "\t\t\tObjetosc: " + produkt.getObjetosc() +"\n";
                }
            }
        }
        uklad += "***********************************************\n";
        return uklad;
    }

    @Override
    public String toString() {
        String s = "=== REGAL - "+this.oznaczenie +" ===\n";
        s += "+ Liczba przesel: " + policzElementy("przesla") + "\n";
        s += "+ Liczba slotow: " + policzElementy("sloty") + "\n";
        s += "+ Liczba produktow: "+ policzElementy("produkty") +"\n";
        s += "-----\n";
        s += "+ Zapelnienie reaglu: "+ policzObjetosc("zapelnienie")+"/"+policzObjetosc("pojemnosc") +" j. obj.\n";
        s += "+ Procent zapelnienia regalu:  "+ Math.round(policzObjetosc("zapelnienie")/policzObjetosc("pojemnosc") * 100) +"%\n";
        s += "\n";
        s += "+ Uklad regalu:\n";
        s += ukladRegalu();
        return s ;
    }

}
;
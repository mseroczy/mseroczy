public class Magazyn {

    public static void main(String[] args){
            Produkt p1 = new Produkt(1, "Farba", 100);
            Produkt p2 = new Produkt(4, "Cement", 200);
            Produkt p3 = new Produkt(5, "Panele", 100);
            p3.saveProdukt();

            Slot s1 = new Slot(200);
            Slot s2 = new Slot(500);
            s1.addProdukt(p1);
            s2.addProdukt(p2);

            Przeslo pr1 = new Przeslo(s1);
            pr1.addSlot(s2);

            Regal r1 = new Regal("A");
            r1.addPrzeslo(pr1);
//            r1.addPrzeslo(pr1);

            r1.addProdukt(p3);

            System.out.println(r1);

            System.out.println(r1.getProdukt(1));
            p3.saveProdukt();
            System.out.println(pr1.getProdukt(4));

           System.out.println(pr1);

    }
}

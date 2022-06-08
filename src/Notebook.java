import java.util.ArrayList;

public class Notebook extends Product{
    private static int nId=1;
    private static ArrayList<Notebook> notebooks=new ArrayList<>();


    public Notebook(String name, double price, int discountRate, int amount, Brand brand, double screenSize, int ram, int memory) {

        super(nId,name, price, discountRate, amount, brand, screenSize, ram, memory);
        nId++;
    }

    public Notebook() {
        super();
    }


    @Override
    public void menu() {

        System.out.println("1- Yeni Notebook ekle\n" +
                "2- Notebook listesini g�r�nt�le\n" +
                "3- Notebook sil\n" +
                "4- Notebooklar� id numaralar�na g�re s�rala\n" +
                "5- Notebooklar� markaya g�re filtrele");
        System.out.print("Yapmak istedi�iniz i�lemi se�iniz : ");
        int value=scan.nextInt();
        if(value==1) addItem();
        if(value==2 || value==4) getProducts();
        if(value==3) deleteItem();
        if(value==5) brandFilter();

    }

    @Override
    public void addItem() {
        System.out.print("�r�n�n fiyat� : ");
        double price= scan.nextDouble();
        System.out.print("�r�n�n ad� : ");
        scan.nextLine();
        String name=scan.nextLine();
        System.out.print("�r�n�n indirim oran� : ");
        int discountRate= scan.nextInt();
        System.out.print("�r�n�n sto�u : ");
        int amount= scan.nextInt();
        System.out.print("�r�n�n rami : ");
        int ram= scan.nextInt();
        System.out.print("�r�n�n ekran� : ");
        double screenSize= scan.nextDouble();
        System.out.print("�r�n�n haf�zas� :");
        int memory= scan.nextInt();
        //System.out.println("Ekran Listesi");
        Brand.printBrands();
        System.out.print("Marka Se�iniz : ");
        Brand brand=Brand.getBrand(scan.nextInt());
        Notebook notebook=new Notebook(name,price,discountRate,amount,brand,screenSize,ram,memory);
        this.notebooks.add(notebook);
        System.out.println("Eklenen notebook'un id'si :"+notebook.getId());
    }

    @Override
    public void getProducts() {
        print(null);

    }

    public void print(ArrayList<Notebook> notebookList){
        if(notebookList==null) notebookList=this.notebooks;
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | �r�n Ad�                  | Fiyat�          | Markas�         | Sto�u        | �ndirim Oran�      | RAM    | Ekran Boyutu      | Haf�zas�   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook n:notebookList){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getName(),n.getAmount(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory());
        }
    }

    @Override
    public void deleteItem(){
        getProducts();
        System.out.print("Silinmesini istedi�iniz notebook'un Id numaras�n� giriniz : ");
        int id=scan.nextInt();
        notebooks.remove(id-1);
        System.out.println("G�ncel notebook listesi ");
        getProducts();
    }

    private void brandFilter() {
        scan.nextLine();
        System.out.print("Filtrelemek istedi�iniz �r�n markas�n� giriniz :");
        String filter= scan.nextLine();
        ArrayList<Notebook> filterNotebooks=new ArrayList<>();
        for (Notebook n:notebooks){
            if(filter.equals(n.getBrand().getName())){
                filterNotebooks.add(n);
            }
        }
        print(filterNotebooks);
    }

    public static int getnId() {
        return nId;
    }

}

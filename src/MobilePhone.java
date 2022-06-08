import java.util.ArrayList;

public class MobilePhone extends Product{
    private static int pId=1;
    private int battery;
    private String color;
    private int camResolution;
    private static ArrayList<MobilePhone> phones = new ArrayList<>();

    public MobilePhone(String name, double price, int discountRate, int amount,
                       Brand brand, double screenSize, int ram, int memory,
                       int battery, String color, int camResolution) {
        super(pId, name, price, discountRate, amount, brand, screenSize, ram, memory);
        pId++;
        this.battery = battery;
        this.color = color;
        this.camResolution = camResolution;
    }

    public MobilePhone() {

    }


    @Override
    public void menu(){
        System.out.println("1- Yeni Telefon Ekle\n"+
                           "2- Telefon Listesini Görüntüle\n"+
                           "3- Telefon Sil\n"+
                           "4- Telefonlarý ID Numarasýna Göre Sýrala\n"+
                           "5- Telefonlarý Markaya Göre Filtrele");
        System.out.println("Yapmak Ýstediðiniz Ýþlemi Seçiniz: ");
        int num = scan.nextInt();
        if (num==1) addItem();
        if(num==2 || num==4) getProducts();
        if(num==3) deleteItem();
        if (num==5) brandFilter();
    }

    public void addItem(){
        System.out.println("Ürünün Fiyatý: ");
        double price = scan.nextDouble();
        System.out.println("Ürünün Adý: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.println("Ürünün Ýndirim Oraný: ");
        int discountRate = scan.nextInt();
        System.out.println("Ürünün Stok Sayýsý: ");
        int amount = scan.nextInt();
        System.out.println("Ürünün Ram Kapasitesi: ");
        int ram = scan.nextInt();
        System.out.println("Ürünün Ekran Boyutu: ");
        double screenSize = scan.nextDouble();
        System.out.println("Ürünün Hafýzasý: ");
        int memory = scan.nextInt();
        System.out.println("Ürünün Pili: ");
        int battery = scan.nextInt();
        scan.nextLine();
        System.out.println("Ürünün Rengi: ");
        String color = scan.nextLine();
        System.out.println("Kamera Çözünürlüðü: ");
        int camResolution = scan.nextInt();
        Brand.printBrands();
        System.out.println("Marka Seçiniz: ");
        Brand brand = Brand.getBrand(scan.nextInt());
        MobilePhone phone = new MobilePhone(name,price,discountRate,amount,brand,screenSize,ram,memory,battery,color,camResolution);
        phones.add(phone);
        System.out.println("Eklenen Tel ID: "+phone.getId());
    }

    public void getProducts(){
        print(null);
    }

    public void print(ArrayList<MobilePhone> phoneList){
        if(phoneList==null) phoneList=this.phones;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adý                  | Fiyatý          | Markasý         | Stoðu        | Ýndirim Oraný      | RAM    | Ekran Boyutu      | Hafýzasý   | Pil Kapasitesi  | Renk           | Kamera    |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone n: phoneList){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | %-9s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getName(),n.getAmount(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory(),n.getBattery(),n.getColor(),n.getCamResolution());
        }
    }

    public void deleteItem(){
        getProducts();
        System.out.println("Silinmesini Ýstediðiniz Telefon ID: ");
        int id = scan.nextInt();
        phones.remove(id-1);
        System.out.println("Güncel Liste: ");
        getProducts();
    }

    public void brandFilter(){
        scan.nextLine();
        System.out.println("Filtrelemek Ýstediðiniz Ürünün Markasýný Giriniz: ");
        String filter  = scan.nextLine();
        ArrayList<MobilePhone> filterPhones = new ArrayList<>();
        for (MobilePhone n : phones){
            if(filter.equals(n.getBrand().getName())){
                filterPhones.add(n);
            }
        }
        print(filterPhones);
    }

    public static int getpId() {
        return pId;
    }


    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamResolution() {
        return camResolution;
    }

    public void setCamResolution(int camResolution) {
        this.camResolution = camResolution;
    }
}

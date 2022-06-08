import java.util.Scanner;

public class Store {
    Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println(" 1 - Notebook Ýþlemleri\n" +
                    " 2 - Cep Telefonu Ýþlemleri\n" +
                    " 3 - Marka Listele\n" +
                    " 4 - Çýkýþ Yap");
            System.out.print("Yapmak istediðiniz iþlem numarasýný seçiniz : ");

            switch (scanner.nextInt()) {
                case 1:
                    Notebook notebook=new Notebook();
                    notebook.menu();
                    break;
                case 2:
                    MobilePhone mobilePhone=new MobilePhone();
                    mobilePhone.menu();
                    break;
                case 3:
                    Brand.printBrands();
                    break;
                case 4:
                    System.out.println("Çýkýþ yapýlýyor.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Yanlýþ deðer girdiniz.");
                    break;
            }
        }
    }
}

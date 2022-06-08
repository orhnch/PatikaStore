import java.util.Scanner;

public class Store {
    Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("PatikaStore �r�n Y�netim Paneli !");
            System.out.println(" 1 - Notebook ��lemleri\n" +
                    " 2 - Cep Telefonu ��lemleri\n" +
                    " 3 - Marka Listele\n" +
                    " 4 - ��k�� Yap");
            System.out.print("Yapmak istedi�iniz i�lem numaras�n� se�iniz : ");

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
                    System.out.println("��k�� yap�l�yor.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Yanl�� de�er girdiniz.");
                    break;
            }
        }
    }
}

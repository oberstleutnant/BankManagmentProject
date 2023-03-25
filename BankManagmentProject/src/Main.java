import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("BANKA SİSTEMİ : İSMİNİZİ VE MÜŞTERİ NUMARAINIZI GİRİNİZ:");
        String name=sc.nextLine();
        String customerId=sc.nextLine();
        BankApplication obj1=new BankApplication(name,customerId);
        obj1.menu();
    }

    static class BankApplication {
        double bakiye;
        double prevTrans;
        String customerName;
        String customerID;

        BankApplication(String customerName, String customerID) {
            this.customerName = customerName;
            this.customerID = customerID;
        }

        void deposit(double amount) {
            if (amount != 0) {
                bakiye += amount;
                prevTrans = amount;
                //prevTrans  değişkeni, önceki işlem tutarını (amount) saklamak için kullanılan bir değişkendir.
            }
        }

        void withDraw(double amt) {
            //amt çekilecek değer
            if (amt != 0 && bakiye >= amt) {
                bakiye -= amt;//bakiye-amt=bakiye
                prevTrans = -amt;
            } else if (bakiye < amt) {
                System.out.println("ÇEKMEK İSTEDİĞİNİZ BAKİYE YETERSİZ ");
            }

        }

        void getPreviousTrans() {
            if (prevTrans > 0) {
                System.out.println("YATIRILAN TUTAR: " + prevTrans);
            } else if (prevTrans < 0) {
                System.out.println("ÇEKİLEN TUTAR: " + Math.abs(prevTrans));

            } else {
                System.out.println("HİÇ BİR İŞLEM GERÇEKLEŞMEDİ");
            }
        }

        void menu() {
            char option;
            Scanner sc = new Scanner(System.in);
            System.out.println("HOŞGELDİNİZ : " + customerName);
            System.out.println("MÜŞTERİ NUMARANIZ : " + customerID);
            System.out.println("\n");
            System.out.println("a) BAKİYE SORGULA");
            System.out.println("b) PARA YATIR");
            System.out.println("c) PARA ÇEK");
            System.out.println("d) BİR ÖNCEKİ İŞLEM");
            System.out.println("e) ÇIKIŞ");

            do {
                System.out.println("********************************************");
                System.out.println("LÜTFEN BİR İŞLEM SEÇİNİZ");
                option = sc.next().charAt(0);
                System.out.println("\n");

                switch (option) {
                    case 'a':
                        System.out.println("......................");
                        System.out.println("BAKİYE = " + bakiye);
                        System.out.println("......................");
                        System.out.println("\n");
                        break;
                    case 'b':
                        System.out.println("......................");
                        System.out.println("YATIRILACAK TUTARI BELİRTİNİZ : ");
                        System.out.println("......................");
                        double amt = sc.nextDouble();
                        deposit(amt);
                        System.out.println("\n");
                        break;
                    case 'c':
                        System.out.println("......................");
                        System.out.println("ÇEKİLECEK TUTARI BELİRTİNİZ : ");
                        System.out.println("......................");
                        double amtW = sc.nextDouble();
                        withDraw(amtW);
                        System.out.println("\n");
                        break;
                    case 'd':
                        System.out.println("......................");
                        System.out.println("BİR ÖNCEKİ İŞLEM : ");
                        getPreviousTrans();
                        System.out.println("......................");
                        System.out.println("\n");
                        break;

                    case 'e':
                        System.out.println("......................");
                        break;
                    default:
                        System.out.println("Devam etmek için doğru seçeneği seçiniz");
                        break;
                }

            } while (option != 'e');

            System.out.println("BİZİ TERCİH ETTİĞİNİZ İÇİN TEŞEKKÜR EDERİZ");

        }
    }

}

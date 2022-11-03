/*
Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın. Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın. Mesafe başına ücret 0,10 TL / km olarak alın. İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;

        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır. Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
        Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
        Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
        Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.




*/


import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        double km;
        int age;
        int tripType;
        double perKm = 0.1;
        double priceWithCampaign;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mesafeyi km bazında giriniz.");
        km = scanner.nextDouble();

        System.out.println("Yaşınızı giriniz.");
        age = scanner.nextInt();

        System.out.println("Yolculuk tipini giriniz. 1 => Tek Yön , 2 => Gidiş Dönüş.");
        tripType = scanner.nextInt();


        double priceWithoutCampaign = perKm * km;

        if (age < 12) {
            priceWithCampaign = priceWithoutCampaign / 2;
        } else if (age < 24) {
            priceWithCampaign = priceWithoutCampaign - priceWithoutCampaign / 10;
        } else if (age > 65) {
            priceWithCampaign = priceWithoutCampaign - priceWithoutCampaign * 3 / 10;
        }
        else{
            priceWithCampaign=priceWithoutCampaign;
        }


        switch (tripType) {
            case 1:
                break;
            case 2:
                priceWithCampaign=priceWithCampaign-priceWithCampaign/5;
                break;
        }
        if (age>=0&&(tripType<3||tripType>0)&&km>0){
            System.out.println("Ödemeniz gereken ücret:"+priceWithCampaign);
        }
        else {
            System.out.println("Hatalı veri girişi.");
        }
    }
}

package UniversiteTakipSistemi;

public class Main {
    // @author Zehra Çakır
    public static void main(String[] args) {
        Calisan calisan=new Calisan("Zehra Çakır","05123456789", "patikadev@gmail.com");
        System.out.println(calisan.getAdSoyad()); 
        System.out.println(calisan.getTelefon());
        System.out.println(calisan.getEposta());

        System.out.println("****************");

        Akademisyen akademisyen=new Akademisyen("Hatice Çakır","05987654321", "kodluyoruz@gmail.com",  "CENG", "Doçent");
        System.out.println(akademisyen.getAdSoyad());
        System.out.println(akademisyen.getTelefon());
        System.out.println(akademisyen.getEposta());
        akademisyen.derseGir();
        akademisyen.cikis();
        akademisyen.yemekhane();

        // Diğer sınıflardan da nesneler üretip main kısmını zneginleştirebiliriz.
    }
}

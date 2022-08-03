package UniversiteTakipSistemi;

// @author Zehra Çakır
public class OgretimGorevlisi extends Akademisyen {
    private String kapiNo;

    public OgretimGorevlisi(String adSoyad, String telefon, String eposta, String bolum, String unvan, String kapiNo) {
        super(adSoyad, telefon, eposta, bolum, unvan);
        this.kapiNo = kapiNo;
    }

    public String getKapiNo() {
        return kapiNo;
    }

    public void setkKapiNo(String kapiNo) {
        this.kapiNo = kapiNo;
    }

    public void senatoToplanti() {
        System.out.println(getAdSoyad() + " adlı öğretim görevisi toplantı yaptı");
    }

    public void sinavYap() {
        System.out.println(getAdSoyad() + " adlı öğretim görevlisi sınav yaptı");
    }
}

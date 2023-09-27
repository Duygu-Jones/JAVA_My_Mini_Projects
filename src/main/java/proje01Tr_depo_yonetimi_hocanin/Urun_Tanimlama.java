package proje01Tr_depo_yonetimi_hocanin;

public class Urun_Tanimlama {

    private String urunIsmi;

    private String urunMarkasi;
    private String urunBirimi;
    private int urunMiktari;
    private String urunRafi;



    //parametresiz costructor
    public Urun_Tanimlama(){

    }


    //parametreli costructor
    public Urun_Tanimlama(String urunIsmi, String urunMarkasi, String urunBirimi, int urunMiktari, String urunRafi) {
        this.urunIsmi = urunIsmi;
        this.urunMarkasi = urunMarkasi;
        this.urunBirimi = urunBirimi;
        this.urunMiktari = urunMiktari;
        this.urunRafi = urunRafi;
    }

    public String getUrunIsmi() {

        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {

        this.urunIsmi = urunIsmi;
    }

    public String getUrunMarkasi() {

        return urunMarkasi;
    }

    public void setUrunMarkasi(String uretici) {
        this.urunMarkasi = uretici;
    }

    public String getUrunBirimi() {
        return urunBirimi;
    }

    public void setUrunBirimi(String urunBirimi) {
        this.urunBirimi = urunBirimi;
    }

    public int getUrunMiktari() {
        return urunMiktari;
    }

    public void setUrunMiktari(int urunMiktari) {
        this.urunMiktari = urunMiktari;
    }

    public String getUrunRafi() {
        return urunRafi;
    }

    public void setUrunRafi(String urunRafi) {
        this.urunRafi = urunRafi;
    }

    @Override
    public String toString() {
        return "UrunTanimlama{" +
                "urunIsmi='" + urunIsmi + '\'' +
                ", uretici='" + urunMarkasi + '\'' +
                ", urunBirimi='" + urunBirimi + '\'' +
                ", urunMiktari=" + urunMiktari +
                ", urunRafi='" + urunRafi + '\'' +
                '}';
    }
}

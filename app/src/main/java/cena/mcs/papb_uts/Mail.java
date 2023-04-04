package cena.mcs.papb_uts;

public class Mail {
    public String nama;
    public String isi;

    public Mail(String n, String i) {
        this.nama = n;
        this.isi = i;
    }
    public String inisial(){
        if (this.nama != null && this.nama.length() != 0)
            return this.nama.substring(0, 1).toUpperCase();
        else return "";
    }
}

public class Requin extends Animal implements Nourrissable {
    // ── Attributs spécifiques au Requin ────────
    private String espece; // ex: "Blanc", "Grand Blanc", "Marteau"
    private double longueur; // en mètres

    // ── Constructeur ─────────────────────────
    public Requin(String nom, int age, double poids, String espece, double longueur) {
        super(nom, age, poids, "Poisson");
        this.espece = espece;
        this.longueur = longueur;
    }

    // ── Implémentation de la méthode abstraite de Animal ──
    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " ... (silence) ...");
    }

    // ── Implémentation de l'interface Nourrissable ──
    @Override
    public void manger(String nourriture) {
        System.out.println(getNom() + " engloutit : " + nourriture + " 🐟");
    }

    @Override
    public double getRationJournaliere() {
        return getPoids() * 0.02; // 2% du poids corporel
    }

    // ── Méthodes propres au Requin ─────────────
    public void nager() {
        System.out.println(getNom() + " nage silencieusement... 🦈");
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        if (longueur > 0) {
            this.longueur = longueur;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | " + espece + " " + longueur + "m";
    }
}

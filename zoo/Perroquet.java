public class Perroquet extends Animal implements Nourrissable {
    // ── Attributs spécifiques au Perroquet ─────
    private String couleurPlumage;
    private String motAppris; // mot que le perroquet répète

    // ── Constructeur ─────────────────────────
    public Perroquet(String nom, int age, double poids, String couleurPlumage, String motAppris) {
        super(nom, age, poids, "Oiseau");
        this.couleurPlumage = couleurPlumage;
        this.motAppris = motAppris;
    }

    // ── Implémentation de la méthode abstraite de Animal ──
    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " crie : " + motAppris + " !");
    }

    // ── Implémentation de l'interface Nourrissable ──
    @Override
    public void manger(String nourriture) {
        System.out.println(getNom() + " grignote : " + nourriture + " 🥜");
    }

    @Override
    public double getRationJournaliere() {
        return getPoids() * 0.10; // 10% pour les oiseaux
    }

    // ── Méthodes propres au Perroquet ──────────
    public void parler() {
        System.out.println(getNom() + " dit : " + motAppris + " ! 🦜");
    }

    public String getCouleurPlumage() {
        return couleurPlumage;
    }

    public void setCouleurPlumage(String couleurPlumage) {
        this.couleurPlumage = couleurPlumage;
    }

    public String getMotAppris() {
        return motAppris;
    }

    public void setMotAppris(String motAppris) {
        this.motAppris = motAppris;
    }

    @Override
    public String toString() {
        return super.toString() + " | Plumage : " + couleurPlumage;
    }
}

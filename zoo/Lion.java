public class Lion extends Animal implements Nourrissable {
    // ── Attribut spécifique au Lion ───────────
    private String race; // ex: "Berbère", "Africain"

    // ── Constructeur ─────────────────────────
    public Lion(String nom, int age, double poids, String race) {
        // Appel du constructeur parent avec super()
        super(nom, age, poids, "Félin");
        this.race = race;
    }

    // ── Implémentation de la méthode abstraite de Animal ──
    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " RUGIT ! 🦁 ROARRR !");
    }

    // ── Implémentation de l'interface Nourrissable ──
    @Override
    public void manger(String nourriture) {
        System.out.println(getNom() + " dévore : " + nourriture + " 🥩");
    }

    @Override
    public double getRationJournaliere() {
        return getPoids() * 0.04; // 4% du poids corporel
    }

    // ── Méthodes propres au Lion ───────────────
    public void rugir() {
        faireDuBruit();
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return super.toString() + " | Race : " + race;
    }
}

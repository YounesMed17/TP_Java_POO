public abstract class Animal {
    // ── Attributs PRIVÉS ─────────────────────
    private String nom;
    private int age;
    private double poids;
    private String espece;

    // ── Constructeur ─────────────────────────
    public Animal(String nom, int age, double poids, String espece) {
        this.nom = nom;
        setAge(age); // utilise le setter pour valider
        setPoids(poids);
        this.espece = espece;
    }

    // ── Méthode ABSTRAITE → sous-classes obligées d'implémenter ──
    public abstract void faireDuBruit();

    // ── Getters ──────────────────────────────
    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public double getPoids() {
        return poids;
    }

    public String getEspece() {
        return espece;
    }

    // ── Setters avec validation ───────────────
    public void setNom(String nom) {
        if (nom != null && !nom.isEmpty()) {
            this.nom = nom;
        }
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Erreur : age invalide (" + age + ")");
        }
    }

    public void setPoids(double poids) {
        if (poids > 0) {
            this.poids = poids;
        }
    }

    public void setEspece(String espece) {
        if (espece != null && !espece.isEmpty()) {
            this.espece = espece;
        }
    }

    // ── Méthode d'affichage ───────────────────
    public void afficherInfos() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "[" + espece + "] " + nom +
               " | Age : " + age + " ans" +
               " | " + poids + " kg";
    }
}

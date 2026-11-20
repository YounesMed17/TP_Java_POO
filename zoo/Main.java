public class Main {

    // Méthode utilitaire demandée dans l'Exercice 4 (Polymorphisme)
    public static void nourrirAnimal(Animal a) {
        System.out.println("\n>>> Nourrissage de " + a.getNom());
        a.faireDuBruit(); // Polymorphisme : late binding
    }

    public static void main(String[] args) {
        // ========================================================
        // 1. CRÉATION DES ENCLOS (Section 7 - Composition)
        // ========================================================
        Enclos savane = new Enclos("Savane Africaine", "Mammifères", 4);
        Enclos aquarium = new Enclos("Grand Aquarium", "Poissons", 3);
        Enclos voliere = new Enclos("Volière Tropicale", "Oiseaux", 5);

        // ========================================================
        // 2. CRÉATION DES ANIMAUX (Sections 2, 3, 4, 6)
        // ========================================================
        Lion simba = new Lion("Simba", 5, 190.0, "Africain");
        Lion nala = new Lion("Nala", 4, 135.0, "Berbère");
        Perroquet coco = new Perroquet("Coco", 3, 0.4, "Vert", "Bonjour");
        Perroquet rio = new Perroquet("Rio", 2, 0.5, "Rouge", "Ola !");
        Requin jaws = new Requin("Jaws", 10, 680.0, "Grand Blanc", 5.5);

        // ========================================================
        // 3. PLACEMENT DES ANIMAUX DANS LES ENCLOS
        // ========================================================
        savane.ajouterAnimal(simba);
        savane.ajouterAnimal(nala);
        aquarium.ajouterAnimal(jaws);
        voliere.ajouterAnimal(coco);
        voliere.ajouterAnimal(rio);

        // ========================================================
        // 4. AFFICHAGE DE LA COMPOSITION DU ZOO
        // ========================================================
        System.out.println("\n=== BIENVENUE AU ZOO ===\n");
        savane.afficherAnimaux();
        aquarium.afficherAnimaux();
        voliere.afficherAnimaux();

        // ========================================================
        // 5. RÉVEIL DES ANIMAUX (Polymorphisme en action)
        // ========================================================
        savane.reveillerAnimaux();
        voliere.reveillerAnimaux();

        // ========================================================
        // 6. NOURRISSAGE DES ANIMAUX (Interface Nourrissable)
        // ========================================================
        Animal[] tous = { simba, nala, coco, rio, jaws };
        System.out.println("\n=== Nourrissage du soir ===");
        for (Animal a : tous) {
            if (a instanceof Nourrissable) {
                Nourrissable n = (Nourrissable) a;
                System.out.print(a.getNom() + " -> ");
                n.manger("sa ration quotidienne");
                System.out.print("   ");
                n.afficherRegime();
            }
        }

        // ========================================================
        // 7. COMPORTEMENTS SPÉCIFIQUES (Exercice 3)
        // ========================================================
        System.out.println("\n=== Comportements spécifiques des sous-classes ===");
        simba.rugir();
        coco.parler();
        jaws.nager();

        // ========================================================
        // 8. TEST DU CONTRÔLE D'ACCÈS & ENCAPSULATION (Exercice 2)
        // ========================================================
        System.out.println("\n=== Test Encapsulation & Validation des Setters ===");
        System.out.println("Nom actuel : " + simba.getNom() + " | Age actuel : " + simba.getAge() + " ans");
        System.out.print("Tentative d'affecter un âge négatif (-5) à Simba : ");
        simba.setAge(-5); // Doit afficher un message d'erreur
        System.out.println("Age après tentative invalide : " + simba.getAge() + " ans (inchangé)");
    }
}

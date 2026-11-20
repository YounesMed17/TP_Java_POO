# Système de Gestion d'un Zoo — TP Java POO

Ce projet implémente l'ensemble des exercices du TP **Programmation Orientée Objet en Java** : *Système de Gestion d'un Zoo* (AU : 2026–2027).

---

## 📁 Architecture du projet

```text
zoo/
├── Animal.java         <- Classe abstraite de base (Encapsulation + Abstraction)
├── Nourrissable.java   <- Interface (Contrat + Méthode par défaut Java 8+)
├── Lion.java           <- Sous-classe Mammifère (Héritage + Implémentation Nourrissable)
├── Perroquet.java      <- Sous-classe Oiseau (Héritage + Implémentation Nourrissable)
├── Requin.java         <- Sous-classe Poisson (Héritage + Implémentation Nourrissable)
├── Enclos.java         <- Classe de gestion par Composition (List<Animal>)
├── Main.java           <- Point d'entrée principal (Assemblage final + Démonstrations)
└── README.md           <- Documentation et explications détaillées
```

---

## 🎯 Concepts POO Couverts

| Section | Concept POO | Mots-clés Java | Rôle dans le projet |
| :--- | :--- | :--- | :--- |
| **Section 2** | **Classe & Objet** | `class`, `new` | Définir les modèles et instancier les objets concrètement |
| **Section 3** | **Encapsulation** | `private`, `get...()`, `set...()` | Protéger les données avec validation (`setAge`, `setPoids`) |
| **Section 4** | **Héritage** | `extends`, `super()` | Réutiliser et spécialiser le code parent dans les sous-classes |
| **Section 5** | **Polymorphisme** | `@Override`, liaison dynamique | Exécution automatique de la méthode de la classe réelle |
| **Section 6** | **Abstraction & Interface** | `abstract`, `interface`, `implements` | Imposer des contrats stricts (`faireDuBruit()`, `Nourrissable`) |
| **Section 7** | **Composition** | `List<Animal>`, `ArrayList` | Relation "contient un" : un Enclos regroupe plusieurs animaux |

---

## 🚀 Compilation et Exécution

### En ligne de commande (Terminal / PowerShell)

1. **Compilation** de tous les fichiers :
   ```bash
   javac -encoding UTF-8 zoo/*.java
   ```

2. **Exécution** de la classe principale :
   ```bash
   java -cp zoo Main
   ```

*(Ou placez-vous directement dans le dossier `zoo` :)*
```bash
cd zoo
javac *.java
java Main
```

---

## 💡 Réponses aux Exercices du TP

### Exercice 1 — Classe & Objet
- Création de la classe `Animal` avec attributs de base (`nom`, `age`, `poids`, `espece`), constructeur et méthode `afficherInfos()`.

### Exercice 2 — Encapsulation
- Attributs déclarés `private`.
- Getters et setters ajoutés avec validation métier :
  - `setAge(int age)` : vérifie que `0 <= age <= 100`, affiche une erreur sinon.
  - `setPoids(double poids)` : vérifie que le poids est strictement positif.
  - `setNom(String nom)` : vérifie que le nom n'est ni nul ni vide.
- **Question 6** : Pourquoi `a1.nom` génère une erreur ?  
  *Réponse :* Car l'attribut est `private`. Sa visibilité est restreinte à la classe `Animal`. On doit obligatoirement passer par `a1.getNom()` ou `a1.setNom(...)`.

### Exercice 3 — Héritage
- Création des classes `Lion`, `Perroquet` et `Requin` qui héritent de `Animal` via `extends`.
- Appel du constructeur de la super-classe avec `super(nom, age, poids, espece)`.
- Méthodes spécifiques : `rugir()`, `parler()`, `nager()`.
- Redéfinition de `toString()` pour enrichir l'affichage parent.

### Exercice 4 — Polymorphisme
- Méthode utilitaire statique :
  ```java
  public static void nourrirAnimal(Animal a) {
      System.out.println("\n>>> Nourrissage de " + a.getNom());
      a.faireDuBruit(); // Liaison dynamique (late binding)
  }
  ```
- Bien que le type statique de la variable soit `Animal`, Java exécute à l'exécution la méthode redéfinie correspondant au type dynamique (réel) de l'objet (`Lion`, `Perroquet`, `Requin`).

### Exercice 5 — Abstraction & Interface
- `Animal` devient `abstract class` et sa méthode `faireDuBruit()` devient abstraite (`public abstract void faireDuBruit();`).
- **Question 22** : Pourquoi `new Animal(...)` provoque une erreur de compilation ?  
  *Réponse :* Une classe abstraite est un modèle incomplet qui ne peut pas être instancié directement. Seules ses sous-classes concrètes peuvent être instanciées.
- Interface `Nourrissable` avec méthodes abstraites `manger(String)`, `getRationJournaliere()` et méthode par défaut `afficherRegime()`. Implémentée par `Lion`, `Perroquet` et `Requin`.

### Section 7 — Composition (Classe `Enclos`)
- Modélisation de la relation 1-à-Plusieurs où un `Enclos` possède une `List<Animal>`.
- Gestion d'une capacité maximale (`capaciteMax`), ajout sécurisé (`ajouterAnimal`), réveil polymorphe (`reveillerAnimaux`) et affichage complet.

/**
 * TP Java de l'Université de Montpellier (Master Bioinformatique)
 * Réalisé en autonomie à partir d'un fichier vide
 * Objectif est de mettre en place un logiciel de suivi du courrier
 * La devise utilisée est l'euro. 2 sortes d'objets postaux sont
 * envoyés : les lettres et les colis
 */

package TP_Java.TP_Etudiant;

public class ExoPoste {
    
    public static void main(String[] args){

        // Exemple création d'un objet postal
        ObjetPostal objet1 = new ObjetPostal("Paris", "Montpellier", 34000, 2500, 0.24, 3);

        // Test méthode toString()
        System.out.println(objet1);

        // Créer des lettres (on utilise la classe mère pour créer des instances d'une classe fille)
        ObjetPostal lettre1 = new Lettre("Guillaume, igloo 3", "famille Kouk, igloo 2, banquise nord", 4000, 100, 0.02, 2, "ordinaire");
        ObjetPostal lettre2 = new Lettre("Klak", "chaman Sbouk, igloo 8, banquise nord", 3500, 350, 0.12, 2, "urgente");
        // Affichage des lettres
        System.out.println(lettre1);
        System.out.println(lettre2);

        // Créer des colis
        ObjetPostal colis1 = new Colis("Pôle Sud", "famille Miko, igloo 2, banquise ouest", 560, 2350, 0.23, 1, "console", 450);
        ObjetPostal colis2 = new Colis("Pôle Sud", "sculpteur Frodok, hangar 200, terres ouest", 246, 2679, 0.34, 3, "fournitures travaux", 250);
        System.out.println(colis1);
        System.out.println(colis2);

        // Test de la méthode tarrifAffranchissement
        System.out.println(objet1.tarrifAffranchissement()); // -> 1.5 car taux recommandation == 3
        System.out.println(lettre1.tarrifAffranchissement()); // -> 1 car non prioritaire, recommandation == 2, lettre donc +0.5 euros
        System.out.println(colis1.tarrifAffranchissement()); // -> 5 car volume > 1/8 et colis donc +2 euros
    }
}

// Création d'une classe ObjetPostal contenant les éléments communs aux objets postaux
class ObjetPostal{
    // Attributs de la classe
    private String origine;
    private String destination;
    private int codePostal;
    private double poids; // en grammes
    private double volume; // en m3
    private int tauxRecommandation; // 1, 2 ou 3

    // Constructeurs vide (valeurs peuvent être attribuées lors de l'initialisation)
    public ObjetPostal(){}

    // Cosntructeur avec origine, destination et le code postal
    public ObjetPostal(String origine, String destination, int codePostal){
        this.setOrigine(origine);
        this.setDestination(destination);
        this.setcodePostal(codePostal);
    }

    // Constructeur avec tous les attributs
    public ObjetPostal(String origine, String destination, int codePostal, double poids, double volume, int tauxRecommandation){
        this.setOrigine(origine);
        this.setDestination(destination);
        this.setcodePostal(codePostal);
        this.setPoids(poids);
        this.setVolume(volume);
        this.setTauxRecommandation(tauxRecommandation);
    }

    // Accesseurs des attributs (déclarés comme privés)
    public String getOrigine(){
        return this.origine;
    }
    public void setOrigine(String origine){
        this.origine = origine;
    }
    
    public String getDestination(){
        return this.destination;
    }
    public void setDestination(String destination){
        this.destination = destination;
    }

    public int getCodePostal(){
        return this.codePostal;
    }
    public void setcodePostal(int codePostal){
        this.codePostal = codePostal;
    }

    public double getPoids(){
        return this.poids;
    }
    public void setPoids(double poids){
        if (poids > 0){
            this.poids = poids;
        } else {
            System.out.println("Erreur, le poids doit être strictement positif");
        }
    }

    public double getVolume(){
        return this.volume;
    }
    public void setVolume(double volume){
        if (volume > 0){
            this.volume = volume;
        } else {
            System.out.println("Erreur, le volume doit être strictement positif");
        }
    }

    public int getTauxRecommandation(){
        return this.tauxRecommandation;
    }
    public void setTauxRecommandation(int tauxRecommandation){
        if ((tauxRecommandation == 1) || (tauxRecommandation == 2) || (tauxRecommandation == 3)){
            this.tauxRecommandation = tauxRecommandation;
        } else {
            System.out.println("Erreur, le taux de recommandation doit être égale à 1, 2 ou 3");
        }
        
    }

    // Redéfinir la méthode toString()
    public String toString(){
        return "L'objet postal provient de " + this.origine + " et est à destination de " + this.destination + " (code postal : " + this.codePostal + "). Poids de l'objet : " +
        this.poids + " grammes, volume de l'objet : " + this.volume + " m3 et taux de recommandation de l'expéditeur : " + this.tauxRecommandation + ".";
    }

    // Création méthode qui calcul taux d'affrichement (ici, ce qui est commun aux objets postaux)
    // Il va falloir spécialiser cette méthode dans les sous-classes
    public double tarrifAffranchissement(){
        double tarif = 0;
        if (tauxRecommandation == 2){
            tarif = 0.5;
        } else {
            if (tauxRecommandation == 3){
                tarif = 1.5;
            }
        }
        return tarif;
    }
}


// Création d'une sous classe Lettre de la classe ObjetPostal
class Lettre extends ObjetPostal{
    // Attributs de la classe (hérite des attributs de la classe ObjetPostal)
    private String priorite; // ordinaire ou urgente

    // Constructeur vide
    public Lettre(){}

    // Constructeur avec tous les attributs
    public Lettre (String origine, String destination, int codePostal, double poids, double volume, int tauxRecommandation, String priorite){
        // On utilise super pour les attributs de la classe mère
        super(origine, destination, codePostal, poids, volume, tauxRecommandation); 
        this.setPriorite(priorite);
    }

    // Accesseurs
    public String getPriorite(){
        return this.priorite;
    }
    public void setPriorite(String priorite){
        if ((priorite == "ordinaire") || (priorite == "urgente")){
            this.priorite = priorite;
        } else {
            System.out.println("Erreur, la priorite doit être ordinaire ou urgente");
        }
    }

    // Redéfinir la méthode toString()
    public String toString(){
        // Pour appeler une méthode de la classe mère, on utilise également 'super'
        return super.toString() + " Priorite de la lettre : " + this.priorite + ".";
    }

    // Spécialisation de la méthode tarrifAffranchissement
    public double tarrifAffranchissement(){
        // lettre = 0.5 euros de base
        double tarif = 0.5 + super.tarrifAffranchissement();
        if (priorite == "urgente"){
            tarif += 0.3;
        }
        return tarif;
    }
}

// Création d'une sous classe Colis de la classe ObjetPostal
class Colis extends ObjetPostal{
    // Attributs de la classe (héritage des attributs de la classe ObjetPostal)
    private String declarationContenu;
    private double valeurDeclaree; // en euros

    // Constructeur vide
    public Colis(){}

    public Colis(String origine, String destination, int codePostal, double poids, double volume, int tauxRecommandation, String declarationContenu, double valeurDeclaree){
        super(origine, destination, codePostal, poids, volume, tauxRecommandation);
        this.declarationContenu = declarationContenu;
        this.valeurDeclaree = valeurDeclaree;
    }

    // Accesseurs 
    public String getDeclarationContenu(){
        return this.declarationContenu;
    }
    public void setDeclarationContenu(String declarationContenu){
        this.declarationContenu = declarationContenu;
    }

    public double getValeurDeclaree(){
        return this.valeurDeclaree;
    }
    public void setValeurDeclaree(double valeurDeclaree){
        this.valeurDeclaree = valeurDeclaree;
    }

    // Redefinir méthode toString()
    public String toString(){
        return super.toString() + " Contenu de colis : " + this.declarationContenu + ". Valeur declaree : " + this.valeurDeclaree + " euros.";
    }

    // Spécialisation de la méthode tarrifAffranchissement
    public double tarrifAffranchissement(){
        // colis = 2 euros de base
        double tarif = 2 + super.tarrifAffranchissement();
        if (getVolume() > 1/8){
            tarif += 3;
        }
        return tarif;
    }
}



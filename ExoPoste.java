/**
 * TP Java de l'Université de Montpellier (Master Bioinformatique)
 * Réalisé en autonomie à partir d'un fichier vide
 * Objectif est de mettre en place un logiciel de suivi du courrier
 * La devise utilisée est l'euro. 2 sortes d'objets postaux sont
 * envoyés : les lettres et les colis
 */

package TP_Java.TP_Etudiant;

import java.util.ArrayList;

public class ExoPoste {
    
    public static void main(String[] args){

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
        System.out.println(lettre1.tarifAffranchissement()); // -> 1 car non prioritaire, recommandation == 2, lettre donc +0.5 euros
        System.out.println(colis1.tarifAffranchissement()); // -> 5 car volume > 1/8 et colis donc +2 euros

        // Test de la méthode tarifRemboursement
        System.out.println(lettre1.tarifRemboursement()); // 1.5 car recommandation == 2
        System.out.println(colis2.tarifRemboursement()); // 125, recommandation == 3 donc 50% de la valeur déclarée (250)


        // Tester la classe SacPostal
        SacPostal sac1 = new SacPostal(3); // maximum 3m3
        
        // Ajout d'objets
        sac1.ajoute(lettre1); sac1.ajoute(colis1); sac1.ajoute(lettre2); sac1.ajoute(colis2);

        // Affichage
        System.out.println(sac1);
    }
}

// Création d'une classe ObjetPostal contenant les éléments communs aux objets postaux
abstract class ObjetPostal{
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


    // Pour améliorer méthode tarifAffranchissement, on définit un tarif de base
    // Quand on a simplement besoin de déclarer une méthode, on utilise 'abstract'
    abstract double getTarifBase();

    // Création méthode qui calcul taux d'affrichement (ici, ce qui est commun aux objets postaux)
    // Il va falloir spécialiser cette méthode dans les sous-classes
    // Amélioration en utilisant getTarifBase()
    public double tarifAffranchissement(){
        double tarif = this.getTarifBase();
        if (tauxRecommandation == 2){
            tarif += 0.5;
        } else {
            if (tauxRecommandation == 3){
                tarif += 1.5;
            }
        }
        return tarif;
    }

    // Création méthode qui calcul tarif de remboursement, va être spécialisée dans les sous-classes
    abstract double tarifRemboursement();
}


// Création d'une sous classe Lettre de la classe ObjetPostal
class Lettre extends ObjetPostal{
    // Attributs de la classe (hérite des attributs de la classe ObjetPostal)
    private String priorite; // ordinaire ou urgente

    // On ajoute tarif de base en attribut
    private static double tarifBase = 0.5;

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

    // Surcharge de getTarifBase() donc on précise @Override
    @Override
    double getTarifBase(){
        return Lettre.tarifBase;
    }
    public static void setTarifBase(double tarifBase){
        Lettre.tarifBase = tarifBase;
    }

    // Redéfinir la méthode toString()
    @Override
    public String toString(){
        // Pour appeler une méthode de la classe mère, on utilise également 'super'
        return super.toString() + " Priorite de la lettre : " + this.priorite + ".";
    }

    // Spécialisation de la méthode tarifAffranchissement
    @Override
    public double tarifAffranchissement(){
        // lettre = 0.5 euros de base
        double tarif = super.tarifAffranchissement();
        if (priorite == "urgente"){
            tarif += 0.3;
        }
        return tarif;
    }

    // Spécialisation de la méthode tarifRemboursement
    @Override
    public double tarifRemboursement(){
        double tarif = 0;
        if (getTauxRecommandation() == 2){
            tarif += 1.5;
        } else {
            if (getTauxRecommandation() == 3){
                tarif += 15;
            }
        }
        return tarif;
    }
}

// Création d'une sous classe Colis de la classe ObjetPostal
class Colis extends ObjetPostal{
    // Attributs de la classe (héritage des attributs de la classe ObjetPostal)
    private String declarationContenu;
    private double valeurDeclaree; // en euros

    // Ici aussi on ajoute tarif de base
    private static double tarifBase = 2;

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

    @Override
    double getTarifBase(){
        return Colis.tarifBase;
    }
    public static void setTarifBase(double tarifBase){
        Colis.tarifBase = tarifBase;
    }

    // Redefinir méthode toString()
    public String toString(){
        return super.toString() + " Contenu de colis : " + this.declarationContenu + ". Valeur declaree : " + this.valeurDeclaree + " euros.";
    }

    // Spécialisation de la méthode tarifAffranchissement
    @Override
    public double tarifAffranchissement(){
        // colis = 2 euros de base
        double tarif = super.tarifAffranchissement();
        if (getVolume() > 1/8){
            tarif += 3;
        }
        return tarif;
    }

    // Spécialisation de la méthode tarifRemboursement
    @Override
    public double tarifRemboursement(){
        double tarif = 0;
        if (getTauxRecommandation() == 2){
            tarif += (getValeurDeclaree()*0.1);
        } else {
            if (getTauxRecommandation() == 3){
                tarif += (getValeurDeclaree()*0.5);
            }
        }
        return tarif;
    }
}

// Création d'une classe SacPostal (peut contenir des objets postaux)
class SacPostal{
    // Comme un sac peut contenir un certain nombre d'objets, il faut une liste en attribut
    private ArrayList<ObjetPostal> contenu = new ArrayList<>();
    private double capaciteMaximale = 0.5; // en m3

    // Constructeur vide 
    public SacPostal(){}

    // Constructeur avec attribut capacite max
    public SacPostal(double capaciteMaximale){
        this.capaciteMaximale = capaciteMaximale;
    }

    // Accesseurs
    public double getCapaciteMaximale(){
        return this.capaciteMaximale;
    }
    public void setCapaciteMaximale(double capaciteMaximale){
        this.capaciteMaximale = capaciteMaximale;
    }

    // Création d'une méthode qui renvoie le volume occupé du sac
    public double volumeSac(){
        double volume = 0;
        for (ObjetPostal objet:contenu){
            volume += objet.getVolume();
        }
        return volume;
    }

    // Création méthode pour ajouter un objet dans le sac, s'il y rentre
    public void ajoute(ObjetPostal objet){
        /** 
         * On vérifie d'abord si l'objet n'est pas déjà dans le sac
         * Puis on vérifie que le volume du sac disponible permet de faire entrer l'objet
         * Si oui, on ajoute l'objet dans le sac
         */
        if ((!contenu.contains(objet)) && ((objet.getVolume() + this.volumeSac()) <= this.getCapaciteMaximale())){
            contenu.add(objet);
        }
    }

    // Création méthode pour connaitre la valeur de remboursement en cas de perte
    public double tarifRemboursement(){
        double tarif = 0;
        for (ObjetPostal objet:contenu){
            tarif += objet.tarifRemboursement();
        }
        return tarif;
    }
    
    // Création méthode pour créer, remplir et retourner un nouveau sac à tous les objets de même code postal, extraits d'un autre sac
    public SacPostal remplissage(int postal){
        SacPostal nouveau = new SacPostal(this.getCapaciteMaximale());
        for (ObjetPostal objet:contenu){
            if (objet.getCodePostal() == postal){
                nouveau.ajoute(objet);
            }
        }
        return nouveau;
    }

    // Méthode toString()
    public String toString(){
        String chaine="[";
        for (ObjetPostal objet:contenu){
            chaine += objet.toString() + "\n";
        }
        return chaine + "]";
    }
}
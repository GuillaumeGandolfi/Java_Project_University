/**
 * TP Java de l'Université de Montpellier (Master Bioinformatique)
 * Réalisé en autonomie à partir d'un fichier vide
 * Objectif est de créer une classe Etudiant avec différents attributs 
 * pour créer des instances de cette classe.
 */

package TP_Java.TP_Etudiant;
import java.util.Scanner; // Import Scanner

public class ExoEtudiant {
    public static void main(String[] args){

        // Instanciation de différents étudiants
        Etudiant etudiant1 = new Etudiant("Jean", 24);
        Etudiant etudiant2 = new Etudiant("Abdoulkhader", 23);
        Etudiant etudiant3 = new Etudiant("Astrid", 26);
        Etudiant etudiant4 = new Etudiant("Paolo", 27);
        Etudiant etudiant5 = new Etudiant("Zoe", 26, 12, 14, 17);

        // Affichage des informations pour chaque étudiant à l'aide de l'accesseur get()
        System.out.println("L'étudiant " + etudiant1.getNom() + " est agé de " + etudiant1.getAge() + " ans.");
        System.out.println("L'étudiant " + etudiant2.getNom() + " est agé de " + etudiant2.getAge() + " ans.");
        System.out.println("L'étudiant " + etudiant3.getNom() + " est agé de " + etudiant3.getAge() + " ans.");
        System.out.println("L'étudiant " + etudiant4.getNom() + " est agé de " + etudiant4.getAge() + " ans.");
        System.out.println("L'étudiant " + etudiant5.getNom() + " est agé de " + etudiant5.getAge() +  
        " ans et a obtenu les notes de " + etudiant5.getNoteProgrammation() + " en programmation, " + etudiant5.getNoteSysteme() + 
        " en système et " + etudiant5.getNoteStage() + " à son stage");

        // Maintenant le but va être de modifier des attributs à l'aide de l'acceseur set()
        etudiant1.setAge(25);
        etudiant5.setNoteProgrammation(15);
        etudiant1.setNoteProgrammation(8); 
        etudiant1.setNoteSysteme(7);
        etudiant1.setNoteStage(11);
        etudiant2.setNoteProgrammation(10); 
        etudiant2.setNoteSysteme(14);
        etudiant2.setNoteStage(11);
        etudiant3.setNoteProgrammation(12); 
        etudiant3.setNoteSysteme(5);
        etudiant3.setNoteStage(18);
        etudiant4.setNoteProgrammation(2); 
        etudiant4.setNoteSysteme(10);
        etudiant4.setNoteStage(11);

        // Affichage pour voir si les modifications ont bien été prises en compte
        System.out.println("L'étudiant " + etudiant1.getNom() + " est agé de " + etudiant1.getAge() +  
        " ans et a obtenu les notes de " + etudiant1.getNoteProgrammation() + " en programmation, " + etudiant1.getNoteSysteme() + 
        " en système et " + etudiant1.getNoteStage() + " à son stage");
        System.out.println("L'étudiant " + etudiant2.getNom() + " est agé de " + etudiant2.getAge() +  
        " ans et a obtenu les notes de " + etudiant2.getNoteProgrammation() + " en programmation, " + etudiant2.getNoteSysteme() + 
        " en système et " + etudiant2.getNoteStage() + " à son stage");
        System.out.println("L'étudiant " + etudiant3.getNom() + " est agé de " + etudiant3.getAge() +  
        " ans et a obtenu les notes de " + etudiant3.getNoteProgrammation() + " en programmation, " + etudiant3.getNoteSysteme() + 
        " en système et " + etudiant3.getNoteStage() + " à son stage");
        System.out.println("L'étudiant " + etudiant4.getNom() + " est agé de " + etudiant4.getAge() +  
        " ans et a obtenu les notes de " + etudiant4.getNoteProgrammation() + " en programmation, " + etudiant4.getNoteSysteme() + 
        " en système et " + etudiant4.getNoteStage() + " à son stage");
        System.out.println("L'étudiant " + etudiant5.getNom() + " est agé de " + etudiant5.getAge() +  
        " ans et a obtenu les notes de " + etudiant5.getNoteProgrammation() + " en programmation, " + etudiant5.getNoteSysteme() + 
        " en système et " + etudiant5.getNoteStage() + " à son stage");

        // Méthode toString() prédéfini renvoi par défaut : nom de la classe de l'objet et son adresse
        // Plus bas, la méthode toString() a été redéfini pour retourner nom et age de l'étudiant, test :
        System.out.println(etudiant1);

        // Nouvelle instance d'étudiant en appelant méthode Saisie()
        // Création d'un étudiant à l'aide du constructeur vide
        Etudiant etudiant6 = new Etudiant();
        // Appelle de la méthode Saisie() pour demander à l'utilisateur de remplir les infos de l'étudiant
        etudiant6.Saisie();
        // Afficher les infos de l'étudiant
        System.out.println(etudiant6);

        // Appel de la méthode Moyenne()
        System.out.println(etudiant6.Moyenne());

        // Appel de la méthode Mention()
        System.out.println("Mention de l'étudiant " + etudiant6.getNom() + " : " + etudiant6.Mention());

        // Appel de la méthode ligneResultats()
        System.out.println(etudiant6.ligneResultats());
    }
}

// Création de la classe Etudiant
class Etudiant{

    // Différents attributs de la classe
    // private pour qu'ils ne soient pas accessibles en dehors de la classe
    private String nom;
    private int age;
    private double noteProgrammation;
    private double noteSysteme;
    private double noteStage;

    // Constructeur par défaut (vide)
    public Etudiant(){}

    // Constructeur ne prenant que le nom
    public Etudiant(String nom){
        this.nom = nom;
    }

    // Constructeur prenant nom et age
    public Etudiant(String nom, int age){
        this.nom = nom;
        this.age = age;
    }

    // Constructeur prenant tous les attributs
    public Etudiant(String nom, int age, double noteProgrammation, double noteSysteme, double noteStage){
        this.nom = nom;
        this.age = age;
        this.noteProgrammation = noteProgrammation;
        this.noteSysteme = noteSysteme;
        this.noteStage = noteStage;
    }

    // Getteur (obtenir la valeur) et Setteur (définir / modifier la valeur)
    // Nécessaire du fait que les attributs sont privés

    // Accesseurs nom
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    // Accesseurs age
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }

    // Accesseur noteProgrammation
    public double getNoteProgrammation(){
        return this.noteProgrammation;
    }
    public void setNoteProgrammation(double noteProgrammation){
        this.noteProgrammation = noteProgrammation;
    }

    // Accesseur noteSysteme
    public double getNoteSysteme(){
        return this.noteSysteme;
    }
    public void setNoteSysteme(double noteSysteme){
        this.noteSysteme = noteSysteme;
    }

    // Accesseur noteStage
    public double getNoteStage(){
        return this.noteStage;
    }
    public void setNoteStage(double noteStage){
        this.noteStage = noteStage;
    }

    // Redéfinir méthode toString() pour qu'elle retourne le nom et l'âge des étudiants
    // Ajouter dans le renvoi de la méthode les notes des étudiants
    public String toString(){
        return "Nom de l'étudiant : " + this.nom + ". Age : " + this.age + ". Notes obtenues : " +
        this.noteProgrammation + " en programmation, " + this.noteSysteme + " en système et " +
        this.noteStage + " en stage."; 
        }
            

    // Créer une méthode Saisie() qui prend un scanner en paramètre et récupère de ce scanner
    // les informations concernant un étudiant pour l'initialiser

    Scanner sc = new Scanner(System.in);
    public void Saisie(){
        System.out.println("Entrez le nom de l'étudiant");
        String nom = sc.next();
        this.nom = nom;

        System.out.println("Entrez l'age de l'étudiant");
        int age = sc.nextInt();
        this.age = age;

        System.out.println("Entrez la note de programmation");
        double noteProgrammation = sc.nextDouble();
        this.noteProgrammation = noteProgrammation;

        System.out.println("Entrez la note de système");
        double noteSysteme = sc.nextDouble();
        this.noteSysteme = noteSysteme;

        System.out.println("Entrez la note de stage");
        double noteStage = sc.nextDouble();
        this.noteStage = noteStage;
    }

    // Créer une méthode qui renvoie la moyenne de l'étudiant
    public double Moyenne(){
        double moyenne = (this.noteProgrammation + this.noteSysteme + this.noteStage)/3;
        return moyenne;
    }
    
    // Créer une méthode qui applique une mention à l'étudiant
    public String Mention(){
        double moyenne = Moyenne();
        if (moyenne < 10){
            return "ajourné";
        } else {
            if (moyenne >= 10 && moyenne < 12){
                return "passable";
            } else {
                if (moyenne >= 12 && moyenne < 14){
                    return "assez bien";
                } else if (moyenne >=14 && moyenne < 16){
                        return "bien";
                } else {
                    return "très bien";
                }
            }
        }
    }

    /**
     * Créer une méthode ligneResultats() retournant le nom, l'age, la moyenne, le mention et, 
     * s'il est ajourné, les modules validés
     */

     public String ligneResultats(){
        String prog = ""; String syst = ""; String stage = "";
        double moyenne = Moyenne();
        if (moyenne <10 && ((this.noteProgrammation >= 10) || (this.noteSysteme >= 10) || (this.noteStage >= 10))){
            if (this.noteProgrammation >= 10) prog = "programmation";
            if (this.noteSysteme >= 10) syst = "système";
            if (this.noteStage >= 10) stage = "stage";
            return ("L'étudiant " + this.getNom() + " agé de " + this.getAge() + " ans, est " + this.Mention() +
            ". " + " Il a validé : " + prog + syst + stage);
        } else if ((this.noteProgrammation < 10) && (this.noteSysteme < 10) && (this.noteStage < 10)) {
            return ("L'étudiant " + this.getNom() + " n'a validé aucune UE. Il est " + this.Mention());
        } else {
            return ("L'étudiant " + this.getNom() + " a eu " + this.Moyenne() + " de moyenne. Il reçoit la mention " +
            this.Mention());
        }
     }
}

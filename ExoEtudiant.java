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
        
        // Instanciation d'un nouvel étudiant avec en plus la classe inscription
        Etudiant etudiant7 = new Etudiant("Pierre", 24, 1, 2);
        System.out.println(etudiant7);

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

        // tests contraintes
        etudiant5.setNoteSysteme(22); 
        // On voit bien un message d'erreur, la modification de la note n'est pas prise en compte
        Etudiant etudiant8 = new Etudiant("Patrick", 25, 3, 1);
        System.out.println(etudiant8);
        // Message d'erreur également
        Etudiant etudiant9 = new Etudiant("Coline", 25, 1, 4);
        System.out.println(etudiant9); // Encore message d'erreur !

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

        //Etudiant etudiant6 = new Etudiant();

        // Appelle de la méthode Saisie() pour demander à l'utilisateur de remplir les infos de l'étudiant

        //etudiant6.Saisie();

        // Afficher les infos de l'étudiant
        System.out.println(etudiant5);

        // Appel de la méthode Moyenne()
        System.out.println(etudiant5.Moyenne());

        // Appel de la méthode Mention()
        System.out.println("Mention de l'étudiant " + etudiant5.getNom() + " : " + etudiant5.Mention());

        // Appel de la méthode ligneResultats()
        System.out.println(etudiant5.ligneResultats());


        // Modifier des étudiants pour afficher des infos d'inscriptions
        etudiant1.setInscription(new Inscription(1,2));
        System.out.println(etudiant1);
        etudiant2.setInscription(new Inscription(2, 2));
        System.out.println(etudiant2);
        etudiant3.setInscription(new Inscription(1, 3));
        System.out.println(etudiant3);
        etudiant4.setInscription(new Inscription(1, 3));
        System.out.println(etudiant4);
        etudiant5.setInscription(new Inscription(1, 1));
        System.out.println(etudiant5);
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

    // Pour faire le lien avec la classe Inscription
    private Inscription inscription;

    // Constructeur par défaut (vide)
    public Etudiant(){}

    // Constructeur ne prenant que le nom

    /**
     * Etant donné que l'on a mis des contraintes sur les accesseurs, il faut modifier les constructeurs
     * pour qu'ils prennent également ces contraintes en cas d'ajout de nouvel étudiant
     * 
     * Ainsi au lieu de this.nom = nom, on va mettre this.setNom(nom);
     */
    public Etudiant(String nom){
        this.setNom(nom);
    }

    // Constructeur prenant nom et age
    public Etudiant(String nom, int age){
        this.setNom(nom);
        this.setAge(age);
    }

    // Constructeur prenant tous les attributs
    public Etudiant(String nom, int age, double noteProgrammation, double noteSysteme, double noteStage){
        this.setNom(nom);
        this.setAge(age);
        this.setNoteProgrammation(noteProgrammation);
        this.setNoteSysteme(noteSysteme);
        this.setNoteStage(noteStage);
    }

    // Nouveau constructeur avec nom et age puis prenant en compte l'attribut inscription
    public Etudiant(String nom, int age, int codeInscription, int codePays){
        this.setNom(nom);
        this.setAge(age);
        this.inscription = new Inscription(codeInscription, codePays);
    }

    // Constructeur tous attributs etudiant + attributs inscription
    public Etudiant(String nom, int age, double noteProgrammation, double noteSysteme, double noteStage,
    int codeInscription, int codePays){
        this.nom = nom;
        this.age = age;
        this.noteProgrammation = noteProgrammation;
        this.noteSysteme = noteSysteme;
        this.noteStage = noteStage;
        this.inscription = new Inscription(codeInscription, codePays);
    }

    // Même constructeur mais sans codeInscription et codePays
    public Etudiant(String nom, int age, double noteProgrammation, double noteSysteme, 
    double noteStage, Inscription inscription){
        this.nom = nom;
        this.age = age;
        this.noteProgrammation = noteProgrammation;
        this.noteSysteme = noteSysteme;
        this.noteStage = noteStage;
        this.inscription = new Inscription();
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
        if ((age > 0) && (age <= 140)){
        this.age = age;}
    }

    // Accesseur noteProgrammation
    public double getNoteProgrammation(){
        return this.noteProgrammation;
    }
    public void setNoteProgrammation(double noteProgrammation){
        if ((noteProgrammation >= 0) && (noteProgrammation <= 20)){
        this.noteProgrammation = noteProgrammation;} else {
            System.out.println("Erreur, la note doit être comprise entre 0 et 20");
        }
    }

    // Accesseur noteSysteme
    public double getNoteSysteme(){
        return this.noteSysteme;
    }
    public void setNoteSysteme(double noteSysteme){
        if ((noteSysteme >= 0) && (noteSysteme <=20)){
        this.noteSysteme = noteSysteme;} else {
            System.out.println("Erreur, la note doit être comprise entre 0 et 20");
        }
    }

    // Accesseur noteStage
    public double getNoteStage(){
        return this.noteStage;
    }
    public void setNoteStage(double noteStage){
        if ((noteStage >=0) && (noteStage <= 20)){
        this.noteStage = noteStage;} else {
            System.out.println("Erreur, la note doit être comprise entre 0 et 20");
        }
    }

    // Accesseur Inscription
    public Inscription getInscription(){
        return this.inscription;
    }
    public void setInscription(Inscription inscription){
        this.inscription = inscription;
    }

    // Redéfinir méthode toString() pour qu'elle retourne le nom et l'âge des étudiants
    // Ajouter dans le renvoi de la méthode les notes des étudiants
    // Ajouter condition sinon programme renvoie erreur (inscription.toString() renvoi "null")
    public String toString(){
        if (this.inscription == null){
            this.inscription = new Inscription();
        }
        return "Nom de l'étudiant : " + this.nom + ". Age : " + this.age + ". Notes obtenues : " +
        this.noteProgrammation + " en programmation, " + this.noteSysteme + " en système et " +
        this.noteStage + " en stage." + inscription.toString(); 
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

        System.out.println("Entrez les codes inscription et pays");
        Inscription inscription = new Inscription(sc.nextInt(), sc.nextInt());
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


// Création d'une classe Inscription avec attributs, constructeurs, accesseurs (encapsulation)
class Inscription{
    // Attributs de la classe
    private int codeInscription;
    private int codePays;


    // Constructeurs 
    public Inscription(){}

    public Inscription(int codeInscription){
        this.setCodeInscription(codeInscription);
    }

    public Inscription(int codeInscription, int codePays){
        this.setCodeInscription(codeInscription);
        this.setCodePays(codePays);
    }


    // Accesseurs (get et set)
    // codeInscription
    public int getCodeInscription(){
        return this.codeInscription;
    }
    public void setCodeInscription(int codeInscription){
        if ((codeInscription == 1) || (codeInscription == 2)){
        this.codeInscription = codeInscription;} else {
            System.out.println("Erreur, le code inscription doit être 1 ou 2");
        }
    }
    // codePays
    public int getCodePays(){
        return this.codePays;
    }
    public void setCodePays(int codePays){
        if ((codePays == 1) || (codePays == 2) || (codePays == 3)){
        this.codePays = codePays;} else {
            System.out.println("Erreur, le code pays doit être égale à 1, 2 ou 3");
        }
    }

    // Méthode retournant un String selon le code pays

    public String Nationalite(){
        if (codePays == 1){
            return "français";
        } else {
            if (codePays == 2){
                return "étranger francophone";
            } else if (codePays == 3){
                return "étranger non francophone";
            } else {
                return "Erreur, le code pays renseigné n'existe pas";
            }
        }
    }

    public String typeInscription(){
        if (codeInscription == 1){
            return "Première inscription";
        } else if (codeInscription == 2){
            return "Réinscription";
        } else {
            return "Erreur, le code inscription renseingé n'existe pas";
        }
    }

    public String toString(){
        return "L'étudiant est : " + this.Nationalite() + " et possède le statut d'inscription suivant : " 
        + this.typeInscription();
    }
}



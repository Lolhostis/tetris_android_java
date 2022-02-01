package pack1.test.Application.model;

public class UneClasse {
    private String nom;

    public UneClasse(String nom){
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "UneClasse{" +
                "nom='" + nom + '\'' +
                '}';
    }
}

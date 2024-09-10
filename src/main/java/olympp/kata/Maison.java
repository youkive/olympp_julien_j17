package olympp.kata;

public class Maison {

    private Integer nbPieces;

    private Integer nbFenetres;

    private Integer nbEtages;

    private Integer temperature;

    private Integer codePostal;

    public Maison(Integer nbPieces, Integer nbFenetres, Integer nbEtages, Integer temperature, Integer codePostal) {
        this.nbPieces = nbPieces;
        this.nbFenetres = nbFenetres;
        this.nbEtages = nbEtages;
        this.temperature = temperature;
        this.codePostal = codePostal;
    }

    public Integer getNbPieces() {
        return nbPieces;
    }

    public Integer getNbFenetres() {
        return nbFenetres;
    }

    public Integer getNbEtages() {
        return nbEtages;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public Integer getNbPiecesParEtage() {
        return nbPieces / nbEtages;
    }
}

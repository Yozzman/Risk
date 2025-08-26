package pf.yozzman.risk.model;

public enum Couleur {
    ROUGE(1, "\u001B[31m"),
    BLEU(2, "\u001B[34m"),
    VERT(3, "\u001B[32m"),
    JAUNE(4, "\u001B[33m"),
    MAGENTA(5, "\u001B[35m");

    private final int id;
    private final String codeAscii;

    Couleur(int id, String codeAscii) {
        this.id = id;
        this.codeAscii = codeAscii;
    }

    public String getCodeAscii() {
        return codeAscii;
    }

    public int getId() {
        return id;
    }
}

package pf.yozzman.risk.model;

public enum Couleur {
    VERT(1, "\u001B[32m"),
    JAUNE(2, "\u001B[33m"),
    ROUGE(3, "\u001B[31m"),
    BLEU(4, "\u001B[34m"),
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

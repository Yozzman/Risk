public class Pays {
    private String name;
	private String VoisinNord;
    private String VoisinSud;
    private String VoisinEst;
    private String VoisinOuest;
    //private String Ocean;

	public Pays (
        String name,
        String VoisinNord,
        String VoisinSud,
        String VoisinEst,
        String VoisinOuest
       //String Ocean
    ) {
		this.name = name;
        this.VoisinNord = VoisinNord;
        this.VoisinSud = VoisinSud;
        this.VoisinOuest = VoisinOuest;
        this.VoisinEst = VoisinEst;
        //this.Ocean = Ocean;
	}
	
	public String getName() {
		return this.name;
	}
    
    public String getVoisinNord() {
        return this.VoisinNord;
    }
    public String getVoisinSud() {
        return this.VoisinSud;
    }
    public String getVoisinEst() {
        return this.VoisinEst;
    }
    public String getVoisinOuest() {
        return this.VoisinOuest;
    }
    //public String Ocean() {
      //  return this.Ocean;
    //}
}

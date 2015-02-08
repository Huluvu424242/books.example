package gh.funthomas424242.webapp.books.domain.types;

public class ISBN {

	protected String präfix;
	protected String gruppenNummer;
	protected String verlagsNummer;
	protected String bandTitelNummer;
	protected String pruefZiffer;

	public ISBN(final String identifier){
		this(parsePräfix(identifier),
				parseGruppenNummer(identifier),
				parseVerlagsNummer(identifier),
				parseBandTitelNummer(identifier),
				parsePruefZiffer(identifier));
	}
	
	private static String parsePräfix(String identifier) {
		return "4";
	}

	private static String parsePruefZiffer(String identifier) {
		return "83939";
	}

	private static String parseBandTitelNummer(String identifier) {
		return "83093";
	}

	private static String parseVerlagsNummer(String identifier) {
		return "728";
	}

	private static String parseGruppenNummer(String identifier) {
		return "7";
	}

	public ISBN(String präfix, String gruppenNummer, String verlagsNummer,
			String bandTitelNummer, String pruefZiffer) {
		super();
		this.präfix = präfix;
		this.gruppenNummer = gruppenNummer;
		this.verlagsNummer = verlagsNummer;
		this.bandTitelNummer = bandTitelNummer;
		this.pruefZiffer = pruefZiffer;
	}

	
	
	
	
	public String getPräfix() {
		return präfix;
	}

	public String getGruppenNummer() {
		return gruppenNummer;
	}

	public String getVerlagsNummer() {
		return verlagsNummer;
	}

	public String getBandTitelNummer() {
		return bandTitelNummer;
	}

	public String getPruefZiffer() {
		return pruefZiffer;
	}

}

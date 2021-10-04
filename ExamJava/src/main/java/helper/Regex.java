package helper;

public class Regex {
	public final static String NUM = "[0-9]+";
	public final static String STUID = "^[0-9]{1,50}$";
	public final static String NAME = "^[a-zA-Z\\s*]+{3,50}$";
	public final static String GENDER = "^(Fem|M)ale$";
	public final static String DATE = "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))[-|/]02[-|/]29)$"
			+ "|^(((19|2[0-9])[0-9]{2})[-|/]02[-|/](0[1-9]|1[0-9]|2[0-8]))$"
			+ "|^(((19|2[0-9])[0-9]{2})[-|/](0[13578]|10|12)[-|/](0[1-9]|[12][0-9]|3[01]))$"
			+ "|^(((19|2[0-9])[0-9]{2})[-|/](0[469]|11)[-|/](0[1-9]|[12][0-9]|30))$";
	public final static String EMAIL = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
}

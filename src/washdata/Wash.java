package washdata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wash {
    private String name;
	private static String REGEX1 = "\"n.a.\"";
    private static String REGEX2 = "\\[\\[";
    private static String REGEX3 = "\\]\\]";
    private static String REGEX4 = "null";
	//private String INPUT = name;
	private static String REPLACE1 = "\"No Record\"";
    private static String REPLACE2 = "[";
    private static String REPLACE3 = "]";

    public Wash(String name) {
        this.name = name;
    }
//0000000000000000000000000000000000000000000000000
    protected String getName() {
        return name;
    }
//00000000000000000000000000000000000000000000000000

    public String toStringOfAllInforation() {
       Pattern p = Pattern.compile(REGEX1);
       // get a matcher object
       Matcher m = p.matcher(getName());
       //INPUT = m.replaceAll(REPLACE);
       //System.out.println(INPUT);
       //return "Name is:" + getName();
       Pattern p3 = Pattern.compile(REGEX4);
       // get a matcher object
       Matcher m3 = p3.matcher(m.replaceAll(REPLACE1));
		return m3.replaceAll(REPLACE1);
    }

    public String sortOfAll() {

        Pattern p1 = Pattern.compile(REGEX2);
        // get a matcher object
        Matcher m1 = p1.matcher(getName());

        Pattern p2 = Pattern.compile(REGEX3);
        // get a matcher object
        Matcher m2 = p2.matcher(m1.replaceAll(REPLACE2));

        return m2.replaceAll(REPLACE3);
    }

}

class Wash1 extends Wash{




	public Wash1(String name) {
		super(name);
	}

	public String toStringOfAllInforation() {
		return "Name:"+getName();
	}
    
    public String sortOfAll() {
        return "Name:" + getName();
    }
}
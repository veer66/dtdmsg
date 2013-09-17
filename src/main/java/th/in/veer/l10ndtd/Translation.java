package th.in.veer.l10ndtd;

/**
 * Created with IntelliJ IDEA.
 * User: vee
 * Date: 9/17/13 AD
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Translation {
    String key;
    String value;

    public Translation(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

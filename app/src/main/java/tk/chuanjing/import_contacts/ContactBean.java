package tk.chuanjing.import_contacts;

/**
 * Created by ChuanJing on 2019/10/12.
 */

public class ContactBean {
    private String name;
    private String number;

    public ContactBean() {
        super();
    }

    public ContactBean(String name, String number) {
        super();
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ContactBean{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

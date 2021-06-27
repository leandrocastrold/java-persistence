package examplejdbc.classes;

public class MKFighter {

    private int id;
    private String name;
    private String category;
    private String weapon;

    public MKFighter() {}

    public MKFighter(int id, String name, String category, String weapon) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.weapon = weapon;
    }

    public MKFighter(String name, String category, String weapon) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.weapon = weapon;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "MKFighter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}

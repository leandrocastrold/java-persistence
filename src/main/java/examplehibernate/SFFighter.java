package examplehibernate;

import javax.persistence.*;

@Entity
@Table(name = "sffighters")
public class SFFighter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private char gender;

    public SFFighter() {}
    public SFFighter(int id, String name, String country, char gender) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.gender = gender;
    }

    public SFFighter(String name, String country, char gender) {
        this.name = name;
        this.country = country;
        this.gender = gender;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "SFFighters{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                '}';
    }
}

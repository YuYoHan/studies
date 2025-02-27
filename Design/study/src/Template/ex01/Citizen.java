package Template.ex01;

public class Citizen {
    private String id;
    private int age;
    private String name;
    private String position;
    private int strength;
    private int agility;
    private int intelligence;

    @Override
    public String toString() {
        return "Citizen{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                '}';
    }

    public Citizen() {
    }

    public Citizen(Citizen citizen) {
        this.id = citizen.getId();
        this.age = citizen.getAge();
        this.name = citizen.getName();
        this.position = citizen.getPosition();
        this.strength = citizen.getStrength();
        this.agility = citizen.getAgility();
        this.intelligence = citizen.getIntelligence();
    }

    public Citizen(String id,
                   int age,
                   String name,
                   String position,
                   int strength,
                   int agility,
                   int intelligence) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.position = position;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void updateStrength(int strength) {
        this.strength += strength;
    }

    public void updateAgility(int strength) {
        agility += strength;
    }

    public void updateIntelligence(int strength) {
        intelligence += strength;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}

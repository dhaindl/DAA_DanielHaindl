package ExtraCredit;

/**
 * A person object who has a name, zip Code and favourite food
 */

public class Person {

    private String name;
    private String zipCode;
    private String favFood;

    public Person(String name, String zipCode, String favFood){
        this.name = name;
        this.zipCode = zipCode;
        this.favFood = favFood;
    }

    public String toString(){
        return "Name: " + name + ", who lives with zipCode: " + zipCode + " and has favourite food: " + favFood;
    }
}

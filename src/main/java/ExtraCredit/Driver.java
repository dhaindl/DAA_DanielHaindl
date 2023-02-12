package ExtraCredit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Daniel Haindl
 * A very abritary piece of code to demonstrate my knowledge of Maps, LinkedLists and File IO
 * The code is very abritary, takes in an input file of a Person, maps with a generated ID Number
 * Generates an arbritarily shortened output file of some people in the input
 */

public class Driver {

    LinkedList<Integer> list = new LinkedList<>();
    HashMap<Integer, Person> map = new HashMap<>();

    public static void main (String[] args){
        Driver driver = new Driver();
        driver.getIDNumbers();
        driver.getPeople();
        driver.writeOutput();
    }

    private void getPeople(){
        try{
            File inFile = new File("input.txt");
            Scanner scanner = new Scanner(inFile);
            String info;
            String name;
            String zipCode;
            String favFood;
            int IDNumber;

            while(scanner.hasNextLine()){
                info = scanner.nextLine();
                name = info.split(" ")[0];
                zipCode = info.split(" ")[1];
                favFood = info.split(" ")[2];
                Person p = new Person(name, zipCode, favFood);
                IDNumber = list.remove(0);
                map.put(IDNumber, p);
            }
            scanner.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe);
        }
    }

    public void getIDNumbers(){
        for(int i = 100; i < 110; i++){
            list.add(i);
        }
    }

    public void writeOutput(){
        try{
            FileWriter writer = new FileWriter("output.txt");

            for(int i = 100; i < 110; i += 2){
                if(map.containsKey(i)){
                    writer.write(map.get(i).toString());
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

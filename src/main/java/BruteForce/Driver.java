package BruteForce;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Driver {

    int numVars;    //number of variables in expression
    int numCons;    //number of conditional statements
    ArrayList<Clause> allClauses = new ArrayList<>();
    ArrayList<Boolean> solvedList = new ArrayList<>();

    public static void main(String[] args){
        Driver driver = new Driver();
        File inFile = new File("u15.cnf");
        File inFile2 = new File("src/main/java/BruteForce/s15.cnf");
        driver.getData(inFile);
        System.out.println(driver.allClauses);
        driver.solvedList = driver.findSatisfy(driver.allClauses);
        System.out.println(driver.solvedList);
        driver.clearALl();


        driver.getData(inFile2);
        System.out.println(driver.allClauses);
        driver.solvedList = driver.findSatisfy(driver.allClauses);
        System.out.println(driver.solvedList);


    }

    private void getData(File inFile){
        try{
            Scanner scanner = new Scanner(inFile);
            String line;

            while(scanner.hasNext()) {
                line = scanner.nextLine();
                if(line.charAt(0) != 'c' && line.charAt(0) != 'p'){
                    Scanner scanner1 = new Scanner(line);
                    Clause clause = new Clause();
                    Variable var;
                    while(scanner1.hasNext()){
                        if(scanner1.hasNextInt()){
                            int x = scanner1.nextInt();
                            if(x != 0){
                                var = new Variable(x);
                                clause.addVar(var);
                            }
                        }
                    }
                    allClauses.add(clause);
                }
                if(line.charAt(0) == 'p'){
                    line = line.substring(6);
                    numVars = Integer.parseInt(line.split(" ")[0]);
                    numCons = Integer.parseInt(line.split(" ")[1]);
                }

            }
        }
        catch(FileNotFoundException fnfe){
            System.err.println(fnfe);
        }
    }

    private ArrayList<Boolean> findSatisfy(ArrayList<Clause> allClauses){
        int n = numVars;
        ArrayList<Boolean> list = new ArrayList<>();
        int rows = (int) Math.pow(2,n);
        for (int i=0; i<rows; i++) {
            for (int j=n-1; j>=0; j--) {
                int x = (i / (int) Math.pow(2, j))%2;
                if(x == 0){
                    list.add(false);
                }
                else{
                    list.add(true);
                }
            }
            if(areAllClausesGood(allClauses, list)){
                return list;
            }
            list.clear();
        }
        return null;
    }

    private boolean areAllClausesGood(ArrayList<Clause> list, ArrayList<Boolean> testList){
        Iterator<Clause> it = list.iterator();
        while(it.hasNext()){
            Clause clause = it.next();
            if(!clause.testClause(testList)){
                return false;
            }
        }
        return true;
    }

    private void clearALl(){
        allClauses.clear();
    }

}
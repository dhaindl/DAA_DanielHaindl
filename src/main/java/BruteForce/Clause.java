package BruteForce;

import java.util.ArrayList;
import java.util.Iterator;

public class Clause {

    private ArrayList<Variable> list = new ArrayList<>();

    public Clause(){

    }

    public Clause(Variable var){
        list.add(var);
    }

    public void addVar(Variable var){
        list.add(var);
    }

    public boolean testClause(ArrayList<Boolean> testData){
       boolean result = false;
       for(int i = 0; i < list.size(); i++){
           Variable var = list.get(i);
           if(var.getValue() == testData.get(var.getIndex())){
               return true;
           }
       }
       return result;
    }

    public String toString(){
        String result = "";
        Iterator<Variable> it = list.iterator();
        while(it.hasNext()){
            result += it.next() + " ";
        }
        return result;
    }


}

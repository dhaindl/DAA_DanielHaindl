package BruteForce;

public class Variable {

    private boolean value = true;
    private String name;
    private int index;

    public Variable(Integer var){
        if(var < 0){
            this.value = false;
        }
        this.name = var + "x";
        this.index = Math.abs(var) - 1;
    }

    public boolean getValue(){
        return this.value;
    }

    public int getIndex(){
        return this.index;
    }


    public String toString(){
        return name;
    }
}

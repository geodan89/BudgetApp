package model;

public class Expense {

    private String name;
    private int sum;

    public Expense(String name, int sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getSum() {
        return this.sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString(){
        return "Nume cheltuiala: "+this.name +"\nSuma cheltuiala: "+ this.sum;
    }
}

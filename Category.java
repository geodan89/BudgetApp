package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category {

    private String name;
    private List<Expense> expenseList;
    private int budget;


    public Category(String name) {
        this.name = name;
    }

    public Category(String name, int budget) {
        this.name = name;
        this.budget = budget;
        this.expenseList = new ArrayList<>(10);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public int getBudget() {

        return this.budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void addExpense(Expense expense){
        expenseList.add(expense);
        this.budget -=expense.getSum();
        System.out.println("Cheltuiala "+ expense.getName() +" a fost adaugata si budgetul updatat: " + this.budget);

    }
    public void removeExpense(Expense expense){
        expenseList.remove(expense);
        this.budget += expense.getSum();
        System.out.println("Cheltuiala "+ expense.getName() +" a fost stearsa si bugetul updatat: " + this.budget);

    }

    public Expense findExpense(String name){
        for(int i = 0; i < expenseList.size(); i++){
            if(name.equalsIgnoreCase(expenseList.get(i).getName())){
                return expenseList.get(i);
            }
        }
        return null;
    }

    public int size(){
        return expenseList.size();
    }

    public void listExpense(){
        for(int i = 0; i < expenseList.size(); i++){
            System.out.println(expenseList.get(i).toString());
        }
    }
    public boolean isEqualTo(Category category) {
        return this.name.equalsIgnoreCase(category.getName());
    }

    public Expense get(int index){
        if (index < 0 || index >= this.expenseList.size()) {
            return null;
        }
        return this.expenseList.get(index);
    }

    @Override
    public String toString(){
        return "Nume: "+ this.name + "\nBuget: "+ this.budget;
    }


//
////    public String describe1(){
////        return  "Nume categorie: " + this.name + "\nBuget categorie: " + this.budget;
////    }
//
//    public String describe(){
//        String res = "";
//        for(int i = 0; i < this.expenseList.size(); i++){
//            res = res +"\n"+ this.expenseList.get(i).toString();
//        }
//        String rezultat =  "Nume categorie: " + this.name + "\nBuget categorie: " + this.budget
//                +"\nCheltuieli: " + res;
//        return rezultat;
//    }
}

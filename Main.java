package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static CategoryList categoryList = new CategoryList();

    private static String getCategoryName() {
        System.out.println("Introduceti numele categoriei:");
        return scanner.nextLine();
    }

    private static String getExpenseName() {
        System.out.println("Introduceti numele cheltuielii:");
        return scanner.nextLine();
    }

    private static int getCategoryBudget() {
        while(true) {
            try {
                System.out.println("Introduceti bugetul categoriei:");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Incearca din nou, foloseste doar cifre, fara alte simboluri.");
            }
        }
    }

    private static int getExpenseBudget() {
        while (true) {
            try{
                System.out.println("Introduceti suma cheltuita:");
                return scanner.nextInt();
            }catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Incearca din nou, foloseste doar cifre, fara alte simboluri.");
            }
        }
    }

    public static void addCategory(){
        scanner.nextLine();
        String categoryName = getCategoryName();
        int categoryBudget = getCategoryBudget();
        Category category = new Category(categoryName, categoryBudget);
        int position =  categoryList.addCategory(category);
        if (position < 0) {
            System.out.println("Eroare: aceasta categorie deja exista");
        }
    }

    public static void addExpense(){
        scanner.nextLine();
        System.out.println("In ce categorie vrei sa adaugi cheltuiala? ");
        String categoryName = getCategoryName();
        Category category = categoryList.searchByName(categoryName);
        if(category == null){
            System.out.println("Aceasta categorie nu exista. Incearca din nou.");
        }else{
            String expenseName = getExpenseName();
            int expenseBudget = getExpenseBudget();
            Expense expense = new Expense(expenseName, expenseBudget);
            category.addExpense(expense);
        }
    }

    public static void listCategories(){
        for(int i = 0; i < categoryList.size(); i++){
            System.out.println(categoryList.get(i).toString());
        }

    }

    public static void listExpenses(){
        scanner.nextLine();
        System.out.println("Din ce categorie vrei sa afisezi cheltuielile? ");
        String categoryName = getCategoryName();
        Category category = categoryList.searchByName(categoryName);
        if(category == null){
            System.out.println("Aceasta categorie nu exista. Incearca din nou.");
        }else {
            category.listExpense();
        }
    }

    public static void check(){

    }
    public static void removeCategory(){
        scanner.nextLine();
        String categoryName = getCategoryName();
        for(int i = 0; i < categoryList.size(); i++){
            if(categoryName.equalsIgnoreCase(categoryList.get(i).getName())){
                int position = categoryList.removeCategory(categoryList.get(i));
                if (position < 0) {
                System.out.println("Eroare: aceasta categorie nu exista.");
                }
            }
        }
    }

    public static void removeExpense(){
        scanner.nextLine();
        System.out.println("Din ce categorie vrei sa stergi cheltuiala? ");
        String categoryName = getCategoryName();
        Category category = categoryList.searchByName(categoryName);
        if(category == null) {
            System.out.println("Aceasta categorie nu exista. Incearca");
        }else{
            String expenseName = getExpenseName();
            Expense expense = category.findExpense(expenseName);
            if(expense == null){
                System.out.println("Nu exista aceasta cheltuiala.");
            }
            category.removeExpense(expense);
        }
    }

    public static void updateCategory(){
        scanner.nextLine();
        System.out.println("Ce categorie vrei sa updatezi? ");
        String categoryName = getCategoryName();
        Category category = categoryList.searchByName(categoryName);
        if(category == null){
            System.out.println("Aceasta categorie nu exista. Incearca din nou.");
        }else{
            boolean validCommand;
            do {
                System.out.println("Alege ce vrei sa actualizezi, tastand: "
                        + "\n\t\"1\" - Nume"
                        + "\n\t\"2\" - Buget"
                        + "\n\t\"3\" - Lista cheltuieli");
                int option = scanner.nextInt();
                scanner.nextLine(); // ignore the new line
                validCommand = true;
                switch (option) {
                    case 1:
                        String name = getCategoryName();
                        category.setName(name);
                        System.out.println("Numele categoriei actualizat: "+ name);
                        break;
                    case 2:
                       int budget = getCategoryBudget();
                       category.setBudget(budget);
                        System.out.println("Bugetul categoriei actualizat: "+ budget);
                        break;
                    case 3:
                        category.listExpense();
                        System.out.println("Ce cheltuiala vrei sa modifici?");
                        String expenseName = getExpenseName();
                        Expense expense = category.findExpense(expenseName);
                        if(expense == null){
                            System.out.println("Aceasta cheltuiala nu exista. Incearca din nou.");
                        }else{
                            boolean validCommand2;
                            System.out.println("Alege ce vrei sa actualizezi, tastand: "
                                    + "\n\t\"1\" - Nume"
                                    + "\n\t\"2\" - Buget");
                            int option2 = scanner.nextInt();
                            scanner.nextLine(); // ignore the new line
                            switch (option2) {
                                case 1:
                                    String expName = getExpenseName();
                                    expense.setName(expName);
                                    System.out.println("Numele cheltuielii a fost actualizat: "+ expName);
                                    break;
                                case 2:
                                    int expBudget = getExpenseBudget();
                                    expense.setSum(expBudget);
                                    System.out.println("Bugetul cheltuielii a fost actualizat: "+ expBudget);
                                    break;
                                default:
                                    
                                    System.out.println("Ati introdus o optiune inexistenta.");
                                    System.out.println("Mai incercati o data...");
                            }
                        }
                        break;
                    default:
                        validCommand = false;
                        System.out.println("Ati introdus o optiune inexistenta.");
                        System.out.println("Mai incercati o data...");
                }
            } while (!validCommand);
        }
    }

    public static  void categories(){
        categoryList.printCategoryList();
    }

    public static void categories_no() {
        System.out.println("Sunt "+categoryList.size()+ " de categorii adaugate pana acum.");
    }

    public static void search(){
        scanner.nextLine();
        String categoryName = getCategoryName();
        if(categoryList.searchByName(categoryName)!= null){
            System.out.println("Categoria exista.");
        }else{
            System.out.println("Categoria nu exista.");
        }

    }
    public static void quit() {

    }


    private static void printCommandsList() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("addCategory  - Adauga o noua categorie");
        System.out.println("addExpense   - Adauga o noua cheltuiala");
        System.out.println("accessCategory  - Acceseaza categoria existenta din lista");
        System.out.println("accessExpense  - Acceseaza categoria existenta din lista");
        System.out.println("check        - Verifica daca exista deja o categorie cu acelasi nume");
        System.out.println("removeCategory  - Sterge categoria existenta din lista");
        System.out.println("removeExpense  - Sterge cheltuiala existenta din categorie");
        System.out.println("updateCategory       - Actualizeaza detaliile unei categori");//updated (category)
        // edit name, amount, expenseList;
        //la expenseList sa apelez o metoda din clasa Category de modificare list nde expense sio de acolo sa apeleze metoda de modifcat
        //nume de expense si suma din clasa expense

        System.out.println("categories  -   lista de categorii");
        System.out.println("categories_no    - Numarul de categorii");
        System.out.println("search       - Cauta toti invitatii conform"
                + " sirului de caractere introdus");
        System.out.println("quit         - Inchide aplicatia");
    }

    public static void main(String[] args) {

        System.out.println("Bun venit!");
        categoryList = new CategoryList();

        boolean quit = false;
        while(!quit) {
            System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            String command = scanner.next();
            switch(command) {
                case "help":
                    printCommandsList();
                    break;
                case "addCategory":
                    addCategory();
                    break;
                case "addExpense":
                    addExpense();
                    break;
                case "listCategories":
                    listCategories();
                    break;
                case "listExpenses":
                    listExpenses();
                    break;
                case "check":
                    check();
                    break;
                case "removeCategory":
                    removeCategory();
                    break;
                case "removeExpense":
                    removeExpense();
                    break;
                case "updateCategory":
                    updateCategory();
                    break;
                case "categories":
                    categories();
                    break;
                case "categories_no":
                    categories_no();
                    break;
                case "search":
                    search();
                    break;
                case "quit":
                    System.out.println("Aplicatia se inchide...");
                    quit = true;
                    break;
                default:
                    System.out.println("Comanda introdusa nu este valida.");
                    System.out.println("Incercati inca o data.");
                    break;
                }
            }
        scanner.close();
    }
}

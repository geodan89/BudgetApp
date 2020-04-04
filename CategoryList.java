package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoryList {

    private List<Category> categoryList;
    private static final String name = "Meniu";
    private int entireBudget;

    public CategoryList() {
        this.categoryList = new ArrayList<>(10);
        this.entireBudget = 0;
    }

    public List<Category> getCategoryList() {
        return this.categoryList;
    }

    public int getEntireBudget() {
        return this.entireBudget;
    }

    public void setEntireBudget(int entireBudget) {
        this.entireBudget = entireBudget;
    }

    public int addCategory(Category category){
        if (findCategory(category)) {
            return -1;
        }
        this.categoryList.add(category);
        this.entireBudget += category.getBudget();
        System.out.println("Categoria " + category.getName() +" a fost adaugata si bugetul total updatat: " + this.entireBudget);
        return 2;
    }
    public int removeCategory(Category category){
        if (!findCategory(category)) {
            return -1;
        }else {
            this.categoryList.remove(category);
            this.entireBudget -= category.getBudget();
            System.out.println("Categoria " + category.getName() +" a fost stearsa si bugetul total updatat: " + this.entireBudget);
            return 2;
        }
    }

    private boolean findCategory(Category category) {
        for (int i=0; i<this.categoryList.size(); i++) {
            if (this.categoryList.get(i).getName().equalsIgnoreCase(category.getName())) {
                return true;
            }
        }
        return false;
    }

    public int size(){
        return this.categoryList.size();
    }

    public Category searchByName(String name){
        for(int i = 0; i < size(); i++){
            if(name.equalsIgnoreCase(categoryList.get(i).getName())){
               return categoryList.get(i);
            }
        }
        return null;
    }

    public Category get(int index){
        if (index < 0 || index >= this.categoryList.size()) {
            return null;
        }
        return this.categoryList.get(index);
    }

    public void printCategoryList(){
        for(int i = 0; i < this.categoryList.size(); i++){
            System.out.println(categoryList.get(i).getName());
        }
    }

}

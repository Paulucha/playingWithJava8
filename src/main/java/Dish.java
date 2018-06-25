public class Dish {

     private String name;
     private boolean isVege;
     private int calories;

    public String getName() {
        return name;
    }

    public boolean isVege() {
        return isVege;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", isVege=" + isVege +
                ", calories=" + calories +
                '}';
    }

    public Dish(String name, boolean isVege, int calories) {

        this.name = name;
        this.isVege = isVege;
        this.calories = calories;

    }
}

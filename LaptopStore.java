import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Notebook {
    private int ram;
    private int hdd;
    private String os;
    private String color;

    // конструктор и геттеры
    public Notebook(int ram, int hdd, String os, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }
    public int getRam() { return ram; }
    public int getHdd() { return hdd; }
    public String getOs() { return os; }
    public String getColor() { return color; }
    
    @Override
    public String toString() {
        return "Notebook: " + this.ram + "GB RAM, " + this.hdd + "GB HDD, " + this.os + ", " + this.color;
    }

}

public class LaptopStore {
    public static void main(String[] args) {
        List<Notebook> laptops = new ArrayList<Notebook>();
        // создаем ноутбуки
        laptops.add(new Notebook(8, 500, "Windows 10", "Silver"));
        laptops.add(new Notebook(16, 1000, "Linux", "Black"));
        laptops.add(new Notebook(32, 500, "Windows 10", "Silver"));
        laptops.add(new Notebook(128, 1000, "Windows 10", "Black"));        laptops.add(new Notebook(8, 500, "Windows 10", "Silver"));
        laptops.add(new Notebook(512, 2000, "Windows 11", "Black"));        laptops.add(new Notebook(8, 500, "Windows 10", "Silver"));
        laptops.add(new Notebook(2048, 3000, "Windows 11", "Black"));        laptops.add(new Notebook(8, 500, "Windows 10", "Silver"));
        laptops.add(new Notebook(2048, 5000, "Windows 11", "White"));        laptops.add(new Notebook(8, 500, "Windows 10", "Silver"));
        laptops.add(new Notebook(2048, 12000, "Windows 11", "White"));        
        // ...
        Map<Integer, String> criteria = new HashMap<Integer, String>();
        System.out.println("Enter the number corresponding to the required criterion:");

        System.out.println("1 - RAM");
        criteria.put(1, "ram");
        
        System.out.println("2 - HDD volume");
        criteria.put(2, "hdd");
        
        System.out.println("3 - Operating system");
        criteria.put(3, "os");
        
        System.out.println("4 - Color");
        criteria.put(4, "color");

        Scanner in = new Scanner(System.in);
        int chosenNum = in.nextInt();
        String chosenCriterion = criteria.get(chosenNum);
        
        System.out.println("Enter the minimum value for the chosen criterion:");
        String minValue = in.next();
        in.close();
        
        filterLaptops(laptops, chosenCriterion, minValue);
    }
    
    static void filterLaptops(List<Notebook> laptops, String criterion, String minValue) {
        List<Notebook> filteredLaptops = new ArrayList<Notebook>();
        for (Notebook laptop : laptops) {
            if(criterion.equals("ram") && laptop.getRam() >= Integer.parseInt(minValue))
             filteredLaptops.add(laptop);
            else if(criterion.equals("hdd") && laptop.getHdd() >= Integer.parseInt(minValue))
             filteredLaptops.add(laptop);
            else if(criterion.equals("os") && laptop.getOs().equals(minValue))
             filteredLaptops.add(laptop);
            else if(criterion.equals("color") && laptop.getColor().equals(minValue))
             filteredLaptops.add(laptop);
        }
        // вывод отфильтрованных ноутбуков
        for(int i = 0; i < filteredLaptops.size(); i++)
         System.out.println(filteredLaptops.get(i) );
    }
}
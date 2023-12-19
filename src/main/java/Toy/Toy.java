package Toy;

import EventLog.EventLog;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Toy implements Serializable {
    public static ArrayList<Toy> arrayToy = new ArrayList<Toy>();
    public static Scanner sc = new Scanner(System.in);
    public static EventLog eventLog = new EventLog();

    private String name;
    private String size;
    private String brand;
    private String country;
    private float price;

    public Toy(String name, String size, String brand, String country, float price) {
        this.name = name;
        this.size = size;
        this.brand = brand;
        this.country = country;
        this.price = price;
    }

    public Toy() {
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }

    public String getCountry() {
        return country;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void addToy(String name, String size, String brand, String country, float price) {
        Toy t = new Toy(name,size,brand,country,price);
        arrayToy.add(t);
        System.out.println("Added new Toy :");
        eventLog.AddActionLog(t, "Added new Toy : ");
        eventLog.EmailLog("TEST");
    }
    public void updateToy(int index, String param, String str) {
        if (arrayToy.isEmpty()) {
            System.out.println("List is empty!");
            eventLog.AddLog("Error - list is empty");
        } else {
            if (index - 1 < arrayToy.size()) {

                switch (param) {
                    case "name": {
                        arrayToy.get(index - 1).setName(str);
                        break;
                    }
                    case "size": {
                        arrayToy.get(index - 1).setSize(str);
                        break;
                    }
                    case "brand": {
                        arrayToy.get(index - 1).setBrand(str);
                        break;
                    }
                    case "country": {
                        arrayToy.get(index - 1).setCountry(str);
                        break;
                    }
                    case "price": {
                        arrayToy.get(index - 1).setPrice(Float.parseFloat(str));
                        break;
                    }
                }
                eventLog.AddActionLog(arrayToy.get(index - 1), "Change Toy : ");
            } else {
                System.out.println("There are no such index Toy in the list!");
            }
        }
    }
    public static void PrintListOfToy() {
        if (arrayToy.isEmpty()) {
            System.out.println("List is empty!");
            eventLog.AddLog("Error - list is empty");
        } else {
            for (int i = 0; i < arrayToy.size(); i++) {
                System.out.println(arrayToy.get(i));
            }
            eventLog.AddLog("Printed list of toys");
        }
    }
    public void deleteToy(int index){
        if (arrayToy.isEmpty()) {
        System.out.println("List is empty!");
        eventLog.AddLog("Error - list is empty");
    } else {
        if (index - 1 < arrayToy.size()) {
            eventLog.AddActionLog(arrayToy.get(index - 1), "Deleted toy : ");
            arrayToy.remove(index - 1);
        } else {
            System.out.println("There are no such index toy in the list!");
        }
    }
    }

    public void SaveToy(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/main/resources/toyData.dat")))
    {
        oos.writeObject(arrayToy);
        System.out.println("Write data to file success");
        eventLog.AddLog("Saved data of toy");
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        eventLog.EmailLog(ex.getMessage());
        eventLog.AddLog(ex.getMessage());
    }
    }
    
    public void LoadToy() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/main/resources/toyData.dat")))
        {
            arrayToy= ((ArrayList<Toy>)ois.readObject());
            System.out.println("Load data from file success");
            eventLog.AddLog("Loaded data of toy");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            eventLog.AddLog(ex.getMessage());
        }
    }
    public void SortByPrice(){
        if (arrayToy.isEmpty()) {
            System.out.println("List is empty!");
            eventLog.AddLog("Error - list is empty");
        } else {
            Toy temp;

            for (int i = 0; i < arrayToy.size() - 1; i++) {
                    if (arrayToy.get(i).price < arrayToy.get(i + 1).price) {
                        temp = arrayToy.get(i);
                        arrayToy.set(i, arrayToy.get(i + 1));
                        arrayToy.set(i + 1, temp);
                    }}
                }

            eventLog.AddLog("Sorted list of toys");
            PrintListOfToy();
        }

public void FindBetween(Float min, Float max) {
    if (arrayToy.isEmpty()) {
        System.out.println("List is empty!");
        eventLog.AddLog("Error - list is empty");
    } else {
        for (int i = 0; i < arrayToy.size(); i++) {
            if (arrayToy.get(i).getPrice() >= min && arrayToy.get(i).getPrice()<=max) {
                System.out.println(arrayToy.get(i));
    }
    }
    }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        // 3
        Toy toy = (Toy) object;
        return  name.equals(toy.name) &&
                size.equals(toy.size) &&
                brand.equals(toy.brand) &&
                country.equals(toy.country) &&
                price == toy.price;
    }


    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", brand='" + brand + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                '}';
    }
}

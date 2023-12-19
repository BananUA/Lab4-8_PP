package Commands;

import Toy.Toy;

import java.util.List;
import java.util.Scanner;

public class AddItemsCommand implements Command {
public final static Scanner sc = new Scanner(System.in);
public final static String com = "add";

    @Override
    public void execute(List<String> params){
        String name, size, brand, country;
        float price;
        int i=0;
        if (params.size()<5)
        {
            System.out.println("In list not enough parameters! Please send parametrs now.");
            System.out.println("Input name of toy :");
            name = sc.next();
            System.out.println("Input size :");
            size = sc.next();
            System.out.println("Input brand :");
            brand = sc.next();
            System.out.println("Input country :");
            country = sc.next();
            System.out.println("Input price :");
            price = sc.nextFloat();
        }
        else {
            name = params.get(i);
            i++;
            size = params.get(i);
            i++;
            brand = params.get(i);
            i++;
            country= params.get(i);
            i++;
            price = Float.parseFloat(params.get(i));
            }

        toy.addToy(name, size, brand, country, price);
    }
}


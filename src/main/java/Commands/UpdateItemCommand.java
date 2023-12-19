package Commands;

import java.util.List;
import java.util.Scanner;

public class UpdateItemCommand implements Command{
    public static Scanner sc = new Scanner(System.in);
    public final static String com = "update";
    @Override
    public void execute(List<String> params) {
        System.out.println(params);
        toy.updateToy(Integer.parseInt(params.get(0)), params.get(1), params.get(2));
    }
}

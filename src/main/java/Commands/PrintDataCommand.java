package Commands;

import java.util.List;

public class PrintDataCommand implements Command{
    public final static String com = "print";
    @Override
    public void execute(List<String> params) {
        toy.PrintListOfToy();
    }
}

package Commands;

import java.util.List;

public class SortByPriceCommand implements Command{
    public final static String com = "sort";
    @Override
    public void execute(List<String> params) {
        toy.SortByPrice();
    }
}

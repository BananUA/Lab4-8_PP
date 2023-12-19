package Commands;

import java.util.List;

public class FindBetweenCommand implements Command{

    public final static String com = "find";
    @Override
    public void execute(List<String> params) {
        toy.FindBetween(Float.parseFloat(params.get(0)), Float.parseFloat(params.get(1)));
    }
}

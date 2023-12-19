package Commands;

import java.util.List;

public class LoadCommand implements Command{
    public final static String com = "load";
    @Override
    public void execute(List<String> params) {
        toy.LoadToy();
    }
}

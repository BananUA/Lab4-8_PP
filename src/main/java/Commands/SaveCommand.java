package Commands;

import java.util.List;

public class SaveCommand implements Command{
    public final static String com = "save";
    @Override
    public void execute(List<String> params) {
        toy.SaveToy();
    }
}

package Commands;

import java.util.List;

public class DeleteByIdCommand implements Command{
    public final static String com = "delete";
    @Override
    public void execute(List<String> params)
    {
        toy.deleteToy(Integer.parseInt(params.get(0)));
    }
}

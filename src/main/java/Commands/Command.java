package Commands;

import Toy.Toy;

import java.util.List;

public interface Command {
    Toy toy = new Toy();
    void execute(List<String> params);

}

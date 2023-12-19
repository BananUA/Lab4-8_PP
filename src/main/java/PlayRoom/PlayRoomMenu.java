package PlayRoom;
import Commands.*;
import java.util.*;

public class PlayRoomMenu {
    private Map<String, Command> menuItems;
    private Scanner scanner = new Scanner(System.in);

    public PlayRoomMenu()
    {
        menuItems = new LinkedHashMap<>();
        menuItems.put(AddItemsCommand.com, new AddItemsCommand());
        menuItems.put(PrintDataCommand.com, new PrintDataCommand());
        menuItems.put(UpdateItemCommand.com, new UpdateItemCommand());
        menuItems.put(DeleteByIdCommand.com, new DeleteByIdCommand());
        menuItems.put(SaveCommand.com, new SaveCommand());
        menuItems.put(LoadCommand.com, new LoadCommand());
        menuItems.put(SortByPriceCommand.com, new SortByPriceCommand());
        menuItems.put(FindBetweenCommand.com, new FindBetweenCommand());
    }

    public void execute(){

           while (true){
               System.out.println("Enter command");
               String command = scanner.nextLine();
               List<String> params = Arrays.asList(command.split(" ")); // command param1 param2
               Command menuItem = menuItems.get(params.get(0));
               if (menuItem!= null){
                   menuItem.execute(params.subList(1, params.size()));
               } else if ("help".equals(command)){
                   System.out.println(menuItems.keySet());
               } else {
                   System.out.println("Incorrect command!");
               }
               System.out.println("-------------------------------------");
           }
    }

}

package hell.interfaces;

public interface Engine {

    String heroCommand(String[] parameters);

    String itemCommand(String[] parameters);

    String recipeCommand(String[] parameters);

    String InspectCommand(String[] parameters);

    String quitCommand(String[] parameters);
}

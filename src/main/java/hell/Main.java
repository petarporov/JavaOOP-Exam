package hell;

import hell.interfaces.Engine;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.Input;
import hell.io.Output;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new Input();
        OutputWriter writer = new Output();
        Engine engine = new hell.Engine();

        while (true){
            String[] tokens = reader.readLine().split("\\s+");
            if(tokens[0].equals("Quit")){
                writer.writeLine(engine.quitCommand(tokens));
                break;
            }
            switch (tokens[0]){
                case "Hero":
                        writer.writeLine(engine.heroCommand(tokens));
                    break;
                case "Item":
                        writer.writeLine(engine.itemCommand(tokens));
                    break;
                case "Recipe":
                        writer.writeLine(engine.recipeCommand(tokens));
                    break;
                case "Inspect":
                        writer.writeLine(engine.InspectCommand(tokens));
                    break;
            }
        }
    }
}
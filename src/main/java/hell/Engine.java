package hell;

import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import hell.models.heroes.Assassin;
import hell.models.heroes.Barbarian;
import hell.models.heroes.Wizard;
import hell.models.items.CommonItem;
import hell.models.items.RecipeItem;

import java.util.*;

public class Engine implements hell.interfaces.Engine{

    private Map<String, Hero> heroMap;
    private int count = 1;

    Engine() {
        this.heroMap = new LinkedHashMap<>();
    }

    @Override
    public String heroCommand(String[] parameters) {
        String heroType = parameters[2];

        switch (heroType){
            case "Barbarian":
                this.heroMap.put(parameters[1], new Barbarian(parameters[1]));
                break;
            case "Assassin":
                this.heroMap.put(parameters[1], new Assassin(parameters[1]));
                break;
            case "Wizard":
                this.heroMap.put(parameters[1], new Wizard(parameters[1]));
                break;
        }
        return "Created " + heroType + " - " + parameters[1];
    }

    @Override
    public String itemCommand(String[] parameters) {

        Item commonItem = new CommonItem(parameters[1], Integer.valueOf(parameters[3])
                , Integer.valueOf(parameters[4]), Integer.valueOf(parameters[5]), Integer.valueOf(parameters[6])
                , Integer.valueOf(parameters[7]));

        this.heroMap.get(parameters[2]).addItem(commonItem);

        return "Added item - " + parameters[1] + " to Hero - " + parameters[2];
    }

    @Override
    public String recipeCommand(String[] parameters) {
        List<String> list = Arrays.asList(parameters).subList(8, parameters.length);

        Recipe recipe = new RecipeItem(parameters[1], Integer.valueOf(parameters[3])
                , Integer.valueOf(parameters[4]), Integer.valueOf(parameters[5]), Integer.valueOf(parameters[6])
                , Integer.valueOf(parameters[7]), list);

        this.heroMap.get(parameters[2]).addRecipe(recipe);

        return "Added recipe - " + parameters[1] + " to Hero - " + parameters[2];
    }

    @Override
    public String InspectCommand(String[] parameters) {
        return this.heroMap.get(parameters[1]).toString();
    }

    @Override
    public String quitCommand(String[] parameters){

        StringBuilder sb = new StringBuilder();

        this.heroMap.values().stream()
                .sorted((a,b) ->{
                    if(Long.compare((a.getAgility() + a.getIntelligence() + a.getStrength())
                            ,b.getAgility() + b.getIntelligence() + b.getStrength() ) == 0){
                        return Long.compare(b.getHitPoints() + b.getDamage(), a.getHitPoints() + a.getDamage());
                    }
                    else return Long.compare((b.getAgility() + b.getIntelligence() + b.getStrength())
                            ,a.getAgility() + a.getIntelligence() + a.getStrength());
                })
                .forEach(a -> {
                    sb.append(printQuit(a));
                });

        return sb.toString();
    }

    private String printQuit(Hero hero) {

        ArrayList<String> arrayList = new ArrayList<>();
        for (Item item : hero.getItems()) {
            arrayList.add(item.getName());
        }

        String string =  count++ + ". " + hero.getClass().getSimpleName() + ": " + hero.getName() + "\n" +
                "###HitPoints: " + hero.getHitPoints() + "\n" +
                "###Damage: "+ hero.getDamage() +"\n" +
                "###Strength: " + hero.getStrength() + "\n" +
                "###Agility: " + hero.getAgility() + "\n" +
                "###Intelligence: " + hero.getIntelligence() + "\n" +
                "###Items: " + String.join(", ", arrayList);
        if(arrayList.isEmpty()){
            string += "None";
        }
        return string + "\n";
    }
}

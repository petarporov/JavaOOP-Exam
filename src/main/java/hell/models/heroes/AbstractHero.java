package hell.models.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;


public abstract class AbstractHero implements Hero{

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private HeroInventory inventory;

    AbstractHero(String name) {
        this.name = name;
        this.inventory = new HeroInventory();
    }

    HeroInventory getInventory() {
        return this.inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + inventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() {

        Class neededClas = HeroInventory.class;
        Field field = neededClas.getDeclaredFields()[0];
        field.setAccessible(true);

        try {
            LinkedHashMap<String, Item> map = (LinkedHashMap<String, Item>) field.get(this.inventory);
            return map.values();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    String printingItems(){
        if(this.getItems().isEmpty()){
            return "None";
        }
        StringBuilder sb = new StringBuilder();

        for (Item item : this.getItems()) {
            sb.append(item.toString());
        }

        return sb.toString();
    }




}

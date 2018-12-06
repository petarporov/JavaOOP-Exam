package hell.models.items;

import hell.interfaces.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeItem extends AbstractItem implements Recipe{

    private List<String> recipeItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus
            , int hitPointsBonus, int damageBonus, List<String> recipeItems) {

        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.recipeItems = new ArrayList<>(recipeItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return this.recipeItems;
    }
}

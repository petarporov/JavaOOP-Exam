package heroInventoryTests;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InventoryTests {

    private Inventory inventory;
    private Item commonItem;
    private Item commonItem1;
    private Recipe recipe;
    private Recipe recipe1;

    @Before
    public void before(){
        inventory = new HeroInventory();
        commonItem = Mockito.mock(Item.class);
        commonItem1 = Mockito.mock(Item.class);
        recipe = Mockito.mock(Recipe.class);
        recipe1 = Mockito.mock(Recipe.class);

        Mockito.when(commonItem.getName()).thenReturn("pesho");
        Mockito.when(commonItem.getAgilityBonus()).thenReturn(2_000_000_000);
        Mockito.when(commonItem.getStrengthBonus()).thenReturn(1_000_000_000);
        Mockito.when(commonItem.getIntelligenceBonus()).thenReturn(2_000_000_000);
        Mockito.when(commonItem.getHitPointsBonus()).thenReturn(2_000_000_000);
        Mockito.when(commonItem.getDamageBonus()).thenReturn(2_000_000_000);

        Mockito.when(commonItem1.getName()).thenReturn("gosho");
        Mockito.when(commonItem1.getStrengthBonus()).thenReturn(2_000_000_000);
        Mockito.when(commonItem1.getAgilityBonus()).thenReturn(2_000_000_000);
        Mockito.when(commonItem1.getIntelligenceBonus()).thenReturn(1_500_000_000);
        Mockito.when(commonItem1.getHitPointsBonus()).thenReturn(1_600_000_000);
        Mockito.when(commonItem1.getDamageBonus()).thenReturn(1_700_000_000);

        List<String> list = new ArrayList<>();
        list.add("pesho");
        list.add("gosho");
        Mockito.when(recipe.getName()).thenReturn("petko");
        Mockito.when(recipe.getRequiredItems()).thenReturn(list);
        Mockito.when(recipe.getAgilityBonus()).thenReturn(2_000_000_000);

        inventory.addCommonItem(commonItem);
        inventory.addCommonItem(commonItem1);
    }

    @Test
    public void addCommonItemTest(){
        Assert.assertEquals(inventory.getTotalAgilityBonus(), 4_000_000_000L);
    }
    @Test
    public void addRecipeTest(){
        inventory.addRecipeItem(recipe);
        Assert.assertEquals(inventory.getTotalAgilityBonus(), 2_000_000_000L);
    }
    @Test
    public void getTotalStrengthBonusTest(){
        Assert.assertEquals(inventory.getTotalStrengthBonus(), 3_000_000_000L);
    }
    @Test
    public void getTotalIntelligenceBonusTest(){
        Assert.assertEquals(inventory.getTotalIntelligenceBonus(), 3_500_000_000L);
    }

    @Test
    public void getTotalHitPointsBonusTest(){
        Assert.assertEquals(inventory.getTotalHitPointsBonus(), 3_600_000_000L);
    }

    @Test
    public void getTotalDamageBonusTest(){
        Assert.assertEquals(inventory.getTotalDamageBonus(), 3_700_000_000L);
    }

}

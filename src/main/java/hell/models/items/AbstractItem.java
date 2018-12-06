package hell.models.items;

import hell.interfaces.Item;

public abstract class AbstractItem implements Item{

    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    AbstractItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int  damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
}

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("###Item: " + this.name + "\n");
        sb.append("###+" + this.strengthBonus + " Strength\n");
        sb.append("###+" + this.agilityBonus + " Agility\n");
        sb.append("###+" + this.intelligenceBonus + " Intelligence\n");
        sb.append("###+" + this.hitPointsBonus + " HitPoints\n");
        sb.append("###+" + this.damageBonus + " Damage");
        return sb.toString();
    }
}

package hell.models.heroes;

public class Wizard extends AbstractHero{

    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;

    public Wizard(String name) {
        super(name);
        this.strength = 25;
        this.agility = 25;
        this.intelligence = 100;
        this.hitPoints = 100;
        this.damage = 250;
    }

    @Override
    public long getStrength() {
        return this.strength + getInventory().getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + getInventory().getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + getInventory().getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + getInventory().getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + getInventory().getTotalDamageBonus();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hero: %s, Class: %s\n", super.getName(), this.getClass().getSimpleName()));
        sb.append("HitPoints: " + this.getHitPoints() + ", Damage: " + this.getDamage() + "\n");
        sb.append("Strength: " + this.getStrength() + "\n");
        sb.append("Agility: " + this.getAgility() + "\n");
        sb.append("Intelligence: " + this.getIntelligence() + "\n");
        sb.append("Items: " + printingItems());

        return sb.toString();
    }
}

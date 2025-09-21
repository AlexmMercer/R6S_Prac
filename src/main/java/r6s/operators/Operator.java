package r6s.operators;

/**
 * Базовый класс оператора Rainbow Six Siege
 */
public class Operator {
    private String name;
    private String team; // "ATTACKER" или "DEFENDER"
    private int health;
    private int row, col;
    private String gadget;
    private boolean gadgetUsed = false;
    private boolean alive = true;
    private boolean blockedNextTurn = false; // для способности Mute

    public Operator(String name, String team, String gadget) {
        this.name = name;
        this.team = team;
        this.gadget = gadget;
        this.health = r6s.Constants.HEALTH;
    }

    // Геттеры
    public String getName() { return name; }
    public String getTeam() { return team; }
    public int getHealth() { return health; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public String getGadget() { return gadget; }
    public boolean isGadgetUsed() { return gadgetUsed; }
    public boolean isAlive() { return alive; }
    public boolean isBlockedNextTurn() { return blockedNextTurn; }

    // Сеттеры
    public void setHealth(int health) { this.health = health; }
    public void setRow(int row) { this.row = row; }
    public void setCol(int col) { this.col = col; }
    public void setGadgetUsed(boolean gadgetUsed) { this.gadgetUsed = gadgetUsed; }
    public void setAlive(boolean alive) { this.alive = alive; }
    public void setBlockedNextTurn(boolean blocked) { this.blockedNextTurn = blocked; }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.alive = false;
        }
    }

    @Override
    public String toString() {
        return name + " (" + team + ") - HP: " + health + ", Позиция: [" + row + "," + col + "]";
    }
}
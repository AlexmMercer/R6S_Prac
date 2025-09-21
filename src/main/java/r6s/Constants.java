package r6s;

/**
 * Константы игры Rainbow Six Siege: Breach Simulator
 */
public class Constants {
    // Размеры карты
    public static final int MAP_SIZE = 6;

    // Символы карты
    public static final String WALL = "#";
    public static final String FLOOR = ".";
    public static final String OBJECTIVE = "X";
    public static final String TRAP = "T";

    // Позиции старта
    public static final int ATTACKER_START_ROW = 4;
    public static final int DEFENDER_START_ROW = 1;
    public static final int ATTACKER_START_COL_1 = 1;
    public static final int ATTACKER_START_COL_2 = 2;
    public static final int DEFENDER_START_COL_1 = 3;
    public static final int DEFENDER_START_COL_2 = 4;

    // Игровые параметры
    public static final int MAX_TURNS = 8;
    public static final int MOVE_RANGE = 2;
    public static final int HEALTH = 100;
    public static final int TRAP_DAMAGE = 50;

    // Символы операторов
    public static final String ATTACKER_1 = "A1";
    public static final String ATTACKER_2 = "A2";
    public static final String DEFENDER_1 = "D1";
    public static final String DEFENDER_2 = "D2";
}
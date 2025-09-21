package r6s.operators;

/**
 * Фабрика для создания операторов с предустановленными характеристиками
 */
public class OperatorFactory {

    /**
     * Создает команду атакующих операторов
     */
    public static Operator[] createAttackers() {
        return new Operator[] {
            new Operator("Ash", "ATTACKER", "breach_wall"),
            new Operator("Sledge", "ATTACKER", "break_adjacent_wall")
        };
    }

    /**
     * Создает команду защитников
     */
    public static Operator[] createDefenders() {
        return new Operator[] {
            new Operator("Jager", "DEFENDER", "place_trap"),
            new Operator("Mute", "DEFENDER", "block_movement")
        };
    }

    /**
     * Возвращает описание способности оператора
     */
    public static String getGadgetDescription(String gadget) {
        switch (gadget) {
            case "breach_wall":
                return "Может пробить стену на расстоянии (1 использование)";
            case "break_adjacent_wall":
                return "Может сломать стену рядом с собой (1 использование)";
            case "place_trap":
                return "Может поставить ловушку, наносящую урон (1 использование)";
            case "block_movement":
                return "Может заблокировать врага на 1 ход (1 использование)";
            default:
                return "Неизвестная способность";
        }
    }
}
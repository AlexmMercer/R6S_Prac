package r6s.battle;

import r6s.operators.Operator;
import r6s.map.GameMap;
import java.util.Scanner;
import static r6s.Constants.*;

/**
 * Управление ходами игроков и логикой действий
 *
 * TODO: Реализовать следующие методы:
 * 1. executeAttackerTurn() - ход атакующих
 * 2. executeDefenderTurn() - ход защитников
 * 3. moveOperator() - перемещение оператора
 * 4. useGadget() - использование способностей
 */
public class Turn {
    private GameMap map;
    private Scanner scanner;

    public Turn(GameMap map, Scanner scanner) {
        this.map = map;
        this.scanner = scanner;
    }

    public void executeAttackerTurn(Operator[] attackers) {
        System.out.println("\n=== ХОД АТАКУЮЩИХ ===");

        // TODO: Реализовать ход атакующих
        // Шаги:
        // 1. Показать живых атакующих с их способностями
        // 2. Дать игроку выбрать оператора
        // 3. Дать выбрать действие: "1. Движение  2. Способность"
        // 4. Выполнить выбранное действие
        //
        // Пример выбора оператора:
        // System.out.println("Выберите оператора:");
        // for (int i = 0; i < attackers.length; i++) {
        //     if (attackers[i].isAlive()) {
        //         System.out.println(i + ") " + attackers[i].toString());
        //     }
        // }
    }

    public void executeDefenderTurn(Operator[] defenders) {
        System.out.println("\n=== ХОД ЗАЩИТНИКОВ ===");

        // TODO: Аналогично ходу атакующих
        // Логика такая же, как для атакующих
    }

    private void moveOperator(Operator operator) {
        // TODO: Реализовать перемещение оператора
        // Шаги:
        // 1. Проверить, не заблокирован ли оператор
        // 2. Показать текущую позицию
        // 3. Запросить новые координаты
        // 4. Проверить валидность хода (в пределах MOVE_RANGE, не через стены)
        // 5. Переместить оператора
        // 6. Проверить ловушки на новой позиции
        //
        // Пример проверки расстояния:
        // int distance = Math.abs(newRow - operator.getRow()) + Math.abs(newCol - operator.getCol());
        // if (distance > MOVE_RANGE) { ... }

        System.out.println("Перемещение " + operator.getName());
        // TODO: Запросить координаты и переместить
    }

    private void useGadget(Operator operator) {
        if (operator.isGadgetUsed()) {
            System.out.println("Способность уже использована!");
            return;
        }

        String gadget = operator.getGadget();
        System.out.println("Использование способности: " + gadget);

        // TODO: Реализовать способности
        // switch (gadget) {
        //     case "breach_wall":
        //         // Ash может пробить стену на расстоянии
        //         // 1. Запросить координаты стены
        //         // 2. Проверить, что это стена
        //         // 3. Вызвать map.breakWall(row, col)
        //         break;
        //
        //     case "break_adjacent_wall":
        //         // Sledge ломает стену рядом с собой
        //         // 1. Показать соседние клетки
        //         // 2. Дать выбрать какую стену ломать
        //         // 3. Вызвать map.breakWall(row, col)
        //         break;
        //
        //     case "place_trap":
        //         // Jager ставит ловушку
        //         // 1. Запросить координаты
        //         // 2. Проверить что это пол
        //         // 3. Вызвать map.placeTrap(row, col)
        //         break;
        //
        //     case "block_movement":
        //         // Mute блокирует врага на 1 ход
        //         // 1. Показать список врагов
        //         // 2. Выбрать цель
        //         // 3. Установить target.setBlockedNextTurn(true)
        //         break;
        // }

        operator.setGadgetUsed(true);
    }

    // Вспомогательные методы
    private Operator selectOperator(Operator[] operators, String team) {
        System.out.println("Выберите оператора (" + team + "):");
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].isAlive()) {
                System.out.println(i + ") " + operators[i].toString());
            }
        }

        int choice = Integer.parseInt(scanner.nextLine());
        return operators[choice];
    }

    private int getPlayerChoice(String prompt, int maxChoice) {
        System.out.println(prompt);
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }

    private boolean isValidMove(Operator operator, int newRow, int newCol) {
        // Проверка границ карты
        if (!map.isValidPosition(newRow, newCol)) {
            return false;
        }

        // Проверка расстояния
        int distance = Math.abs(newRow - operator.getRow()) + Math.abs(newCol - operator.getCol());
        if (distance > MOVE_RANGE) {
            return false;
        }

        // Проверка что цель не стена
        if (map.isWall(newRow, newCol)) {
            return false;
        }

        return true;
    }
}
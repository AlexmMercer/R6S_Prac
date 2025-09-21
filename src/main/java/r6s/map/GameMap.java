package r6s.map;

import r6s.operators.Operator;
import static r6s.Constants.*;

/**
 * Карта игры с отображением и логикой взаимодействия
 *
 * TODO: Реализовать следующие методы:
 * 1. initializeMap() - создание базовой карты
 * 2. display() - отображение карты с операторами
 * 3. isWall(), breakWall() - работа со стенами
 * 4. placeTrap(), hasTrap() - работа с ловушками
 */
public class GameMap {
    private String[][] grid;
    private boolean[][] traps; // для ловушек Jager

    public GameMap() {
        initializeMap();
    }

    private void initializeMap() {
        grid = new String[MAP_SIZE][MAP_SIZE];
        traps = new boolean[MAP_SIZE][MAP_SIZE];

        // TODO: Заполнить карту
        // Логика создания карты:
        // 1. Внешние границы (i=0, i=MAP_SIZE-1, j=0, j=MAP_SIZE-1) = WALL
        // 2. Центр карты (MAP_SIZE/2, MAP_SIZE/2) = OBJECTIVE
        // 3. Все остальное = FLOOR
        //
        // Пример кода:
        // for (int i = 0; i < MAP_SIZE; i++) {
        //     for (int j = 0; j < MAP_SIZE; j++) {
        //         if (i == 0 || i == MAP_SIZE-1 || j == 0 || j == MAP_SIZE-1) {
        //             grid[i][j] = WALL;
        //         } else if (i == MAP_SIZE/2 && j == MAP_SIZE/2) {
        //             grid[i][j] = OBJECTIVE;
        //         } else {
        //             grid[i][j] = FLOOR;
        //         }
        //     }
        // }
    }

    public void display(Operator[] attackers, Operator[] defenders) {
        // TODO: Отобразить карту с операторами
        // Шаги:
        // 1. Создать копию карты: String[][] tempMap = copyGrid();
        // 2. Поставить живых атакующих на карту (A1, A2)
        // 3. Поставить живых защитников на карту (D1, D2)
        // 4. Показать ловушки символом TRAP
        // 5. Вывести карту построчно
        //
        // Пример размещения операторов:
        // if (attackers[0].isAlive()) {
        //     tempMap[attackers[0].getRow()][attackers[0].getCol()] = ATTACKER_1;
        // }

        System.out.println("\n=== КАРТА ОПЕРАЦИИ ===");
        // TODO: Вывести tempMap
        System.out.println("Легенда: # = стена, . = пол, X = цель, T = ловушка");
        System.out.println("A1/A2 = атакующие, D1/D2 = защитники");
    }

    public boolean isWall(int row, int col) {
        // TODO: Проверить, является ли клетка стеной
        // return grid[row][col].equals(WALL);
        return false;
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < MAP_SIZE && col >= 0 && col < MAP_SIZE;
    }

    public void breakWall(int row, int col) {
        // TODO: Превратить стену в пол
        // if (isWall(row, col)) {
        //     grid[row][col] = FLOOR;
        // }
    }

    public void placeTrap(int row, int col) {
        // TODO: Поставить ловушку
        // traps[row][col] = true;
    }

    public boolean hasTrap(int row, int col) {
        // TODO: Проверить наличие ловушки
        // return traps[row][col];
        return false;
    }

    public String getCell(int row, int col) {
        if (isValidPosition(row, col)) {
            return grid[row][col];
        }
        return WALL; // За границами карты считаем стеной
    }

    // Вспомогательный метод для копирования карты
    private String[][] copyGrid() {
        String[][] copy = new String[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }
}
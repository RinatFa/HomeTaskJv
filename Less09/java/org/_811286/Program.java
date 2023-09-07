package org._811286;

import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final int MIN = 3; // _Минимальное значение размерности и комбинации
    private static final int WIN_COUNT_MAX = 15; // _Максимальная Выигрышная комбинация
    private static final int FIELD_SIZE_MAX = 15; // _Максимальная Размерность игрового поля
    private static final char DOT_HUMAN = 'X'; // Фишка игрока - человека
    private static final char DOT_AI = '0'; // Фишка игрока - компьютер
    private static final char DOT_EMPTY = '.'; // Признак пустого поля
    private static final Random random = new Random();
    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля
    private static int fieldSizeX; // Размерность игрового поля _по X
    private static int fieldSizeY; // Размерность игрового поля _по Y
    private static int iWinCount; // _Выигрышная комбинация
    private static int iFindPointX; // _Найденная кордината x
    private static int iFindPointY; // _Найденная кордината y

    public static void main(String[] args) {
        String sStr = "";
        int iFieldSize = 3;
        while (true) {
            System.out.println();
            System.out.println("--------------- START GAME ---------------");
            sStr = "Введите Размерность игрового поля от 3 до 15 (Enter - 5): ";
            iFieldSize = iNumber(sStr, MIN, FIELD_SIZE_MAX);
            if (iFieldSize == -1)
                iFieldSize = 5;
            sStr = "Введите Выигрышную комбинацию от 3 до 15 (Enter - 4): ";
            iWinCount = iNumber(sStr, MIN, WIN_COUNT_MAX);
            if (iWinCount == -1)
                iWinCount = 4;
            if (iWinCount > iFieldSize) {
                iWinCount = iFieldSize;
                System.out.println("Выигрышная комбинация не может быть больше разиерности поля!");
            }
            initialize(iFieldSize);
            System.out.println("    Размерность:  " + iFieldSize + " x " + iFieldSize);
            System.out.println("    Выигрышная комбинация:  " + iWinCount);
            printField();
            while (true) {
                humanTurn(iFieldSize);
                printField();
                if (checkGameState(DOT_HUMAN, "******* Вы победили! *******")) {
                    break;
                }
                System.out.println("Ход компьютера:");
                aiTurn(DOT_HUMAN);
                printField();
                if (checkGameState(DOT_AI, "------- Победил компьютер! -------"))
                    break;
            }
            System.out.println();
            sStr = "Желаете сыграть еще раз? (3 - нет, Enter - да): ";
            iFieldSize = iNumber(sStr, MIN, MIN);
            if (iFieldSize == 3)
                break;
        }
        System.out.println();
        System.out.println("*************** GAME OVER ***************");
        System.out.println();

    }

    /**
     * Инициализация объектов игры
     */
    private static void initialize(int fieldSize) {
        fieldSizeX = fieldSize;
        fieldSizeY = fieldSize;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     * 
     * +++-1---2---3--
     * _1| . | X | 0 |
     * _2| . | . | 0 |
     * _3| . | . | 0 |
     * ---------------
     */
    private static void printField() { // _Для 1-9 и двузначных чисел
        System.out.print("---");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++) {
            if (x < 18) {
                System.out.print((x % 2 == 0) ? "-" : "-" + (x / 2 + 1) + "-");
            } else {
                System.out.print((x % 2 == 0) ? "-" : (x / 2 + 1) + "-");
            }
        }
        System.out.println();

        for (int x = 0; x < fieldSizeX; x++) {
            if (x < 9) {
                System.out.print(" " + (x + 1) + " |");
            } else {
                System.out.print(x + 1 + " |");
            }
            for (int y = 0; y < fieldSizeY; y++) {
                if (y < 18) {
                    System.out.print(" " + field[x][y] + " |");
                } else {
                    System.out.print(field[x][y] + " ");
                }
            }
            System.out.println();
        }
        for (int x = 0; x < fieldSizeX * 4 + 4; x++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn(int iFieldSize) {
        String sStr = "";
        int x, y;
        int min = 1;
        do {
            sStr = "Введите координаты хода по X (от " + min + " до " + iFieldSize + ") (Enter - 1): ";
            x = iNumber(sStr, min, iFieldSize) - 1;
            if (x == -2)
                x = 0;
            sStr = "Введите координаты хода по Y (от " + min + " до " + iFieldSize + ") (Enter - 1): ";
            y = iNumber(sStr, min, iFieldSize) - 1;
            if (y == -2)
                y = 0;
        } while (!isCellEmpty(x, y));

        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Обработка хода компьютера
     */
    private static void aiTurn(char c) {
        int x, y;
        if (checkBeforeWin(DOT_AI)) {
            x = iFindPointX;
            y = iFindPointY;
        } else {

            if (checkBeforeWin(DOT_HUMAN)) {
                x = iFindPointX;
                y = iFindPointY;
            } else {
                do {
                    x = random.nextInt(fieldSizeX);
                    y = random.nextInt(fieldSizeY);
                } while (!isCellEmpty(x, y));
            }
        }
        field[x][y] = DOT_AI;
    }

    /**
     * ]
     * Проверка состояния игры
     *
     * @param c фишка игрока
     * @param s победный слоган
     * @return
     */
    private static boolean checkGameState(char c, String s) {
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

    /**
     * Проверка победы
     *
     * @param c
     * @return
     */
    private static boolean checkWin(char c) {
        int index = 0;
        String spWin = "";
        String spNullX = "";
        for (int i = 0; i < iWinCount; i++) {
            spWin += c;
        }

        for (int i = 0; i < fieldSizeX; i++) {
            spNullX = "";
            for (int j = 0; j < fieldSizeX; j++) {
                spNullX += field[i][j];
            }
            index = spNullX.indexOf(spWin);
            if (index >= 0)
                return true;
        } // _Проверка по горизонталям

        for (int j = 0; j < fieldSizeX; j++) {
            spNullX = "";
            for (int i = 0; i < fieldSizeX; i++) {
                spNullX += field[i][j];
            }
            index = spNullX.indexOf(spWin);
            if (index >= 0)
                return true;
        } // _Проверка по вертикалям

        String[] diag1 = new String[fieldSizeX * 2 - 1];
        for (int i = 0; i < fieldSizeX * 2 - 1; i++) {
            diag1[i] = "";
        }
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                diag1[fieldSizeX + i - j - 1] += field[i][j];
            }
        } // _Сборка массива диагоналей параллельно 1 - \
        for (int k = 0; k < (fieldSizeX * 2 - 1); k++) {
            spNullX = diag1[k];
            index = spNullX.indexOf(spWin);
            if (index >= 0)
                return true;
        } // _Проверка по 1 диагонали \

        String[] diag2 = new String[fieldSizeX * 2 - 1];
        for (int i = 0; i < fieldSizeX * 2 - 1; i++) {
            diag2[i] = "";
        }
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                diag2[i + j] += field[i][j];
            }
        } // _Сборка массива диагоналей параллельно 2 - /
        for (int k = 0; k < (fieldSizeX * 2 - 1); k++) {
            spNullX = diag2[k];
            index = spNullX.indexOf(spWin);
            if (index >= 0)
                return true;
        } // _Проверка по 2 диагонали /

        return false;
    }

    /**
     * Проверка на ничью
     *
     * @return
     */
    private static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }

    /**
     * Проверка пред-победы
     *
     * @param c
     * @return
     */
    private static boolean checkBeforeWin(char c) {
        int index = 0;
        String spWin = "";
        String spNullX = "";
        String[] beforeWin = new String[iWinCount];
        for (int k = 0; k < iWinCount; k++) {
            spWin = "";
            for (int i = 0; i < iWinCount; i++) {
                if (i == k) {
                    spWin += DOT_EMPTY;
                } else {
                    spWin += c;
                }
            }
            beforeWin[k] = spWin; // _Массив прдвыигрышных вариантов
            // _Для трех: .XX X.X XX. или .00 0.0 00.
        }

        String[] diag1 = new String[fieldSizeX * 2 - 1];
        for (int i = 0; i < fieldSizeX * 2 - 1; i++) {
            diag1[i] = "";
        }
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                diag1[fieldSizeX + i - j - 1] += field[i][j];
            }
        } // _Сборка массива диагоналей параллельно 1 - \

        String[] diag2 = new String[fieldSizeX * 2 - 1];
        for (int i = 0; i < fieldSizeX * 2 - 1; i++) {
            diag2[i] = "";
        }
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                diag2[i + j] += field[i][j];
            }
        } // _Сборка массива диагоналей параллельно 2 - /

        for (int k = 0; k < iWinCount; k++) {
            spWin = beforeWin[k];
            for (int i = 0; i < fieldSizeX; i++) {
                spNullX = "";
                for (int j = 0; j < fieldSizeX; j++) {
                    spNullX += field[i][j];
                }
                index = spNullX.indexOf(spWin);
                if (index >= 0) {
                    iFindPointX = i;
                    iFindPointY = index + k;
                    System.out.println("Комп угадал по горизонтали точку " +
                            (i + 1) + " " + (index + k + 1) + " !");
                    return true;
                }
            } // _Проверка по горизонталям

            for (int j = 0; j < fieldSizeX; j++) {
                spNullX = "";
                for (int i = 0; i < fieldSizeX; i++) {
                    spNullX += field[i][j];
                }
                index = spNullX.indexOf(spWin);
                if (index >= 0) {
                    iFindPointX = index + k;
                    iFindPointY = j;
                    System.out.println("Комп угадал по вертикали точку " +
                            (index + k + 1) + " " + (j + 1) + " !");
                    return true;
                }
            } // _Проверка по вертикалям

            int iPoint = spWin.indexOf(DOT_EMPTY);
            for (int m = 0; m < (fieldSizeX * 2 - 1); m++) {
                spNullX = diag1[m];
                index = spNullX.indexOf(spWin);
                if (index >= 0) {
                    if (m < fieldSizeX) {
                        iFindPointX = index + iPoint;
                        iFindPointY = fieldSizeX - m + index + iPoint - 1;
                    } else {
                        iFindPointX = m + index + iPoint - fieldSizeX + 1;
                        iFindPointY = index + iPoint;
                    } // _Формулы для диагоналей \
                    System.out.println("Комп угадал по 1 диагонали точку " +
                            (iFindPointX + 1) + " " + (iFindPointY + 1) + " !");
                    return true;
                }
            } // _Проверка по 1 диагонали \

            for (int m = 0; m < (fieldSizeX * 2 - 1); m++) {
                spNullX = diag2[m];
                index = spNullX.indexOf(spWin);
                if (index >= 0) {
                    if (m < fieldSizeX) {
                        iFindPointX = index + iPoint;
                        iFindPointY = m - index - iPoint;
                    } else {
                        iFindPointX = m + index + iPoint - fieldSizeX + 1;
                        iFindPointY = fieldSizeX - index - iPoint - 1;
                    } // _Формулы для диагоналей /
                    System.out.println("Комп угадал по 2 диагонали точку " +
                            (iFindPointX + 1) + " " + (iFindPointY + 1) + " !");
                    return true;
                }
            } // _Проверка по 2 диагонали /
        }

        return false;

    }

    /**
     * _Ввод числа или Enter
     *
     * @param str
     * @param min
     * @param max
     * @return
     */
    static int iNumber(String str, int min, int max) {
        boolean flag = false;
        String sName = "";
        int n = 0;
        Scanner iScanner = new Scanner(System.in);
        while (!flag) {
            System.out.printf(str); // _Вывод сообщения
            sName = iScanner.nextLine();
            flag = isNumeric(sName);
            if (flag) {
                n = Integer.parseInt(sName);
                if ((n < min) || (n > max)) // _Диапазон min-max
                    flag = false;
            } else {
                if (sName.equals("")) { // _Проверка на пустую строку - Enter
                    n = -1;
                    flag = true;
                }
            }
        }
        if (n > 1000)
            iScanner.close();
        return n;
    }

    /**
     * _Проверка строки на число
     *
     * @param str
     * @return
     */
    static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

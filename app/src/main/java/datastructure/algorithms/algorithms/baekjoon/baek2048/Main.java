package datastructure.algorithms.algorithms.baekjoon.baek2048;

import java.util.Scanner;

public class Main {
    static class Block{
        int y;
        int x;
        int value;
        int originValue;
        boolean isSum;

        public Block(int y, int x,int value) {
            this.y = y;
            this.x = x;
            this.value = value;
            this.originValue = value;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        Block[][] _2048 = new Block[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                _2048[i][j] = new Block(i, j, scn.nextInt());
            }
        }
        scn.close();
        int maxVal = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        for (int m = 0; m < 4; m++) {
                            move2048(i, _2048);
                            move2048(j, _2048);
                            move2048(k, _2048);
                            move2048(l, _2048);
                            move2048(m, _2048);
                            for (int x = 0; x < N; x++) {
                                for (int z = 0; z < N; z++){
                                    if (maxVal < _2048[x][z].value)
                                        maxVal = _2048[x][z].value;
                                    _2048[x][z].value = _2048[x][z].originValue;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(maxVal);

//        printArray(_2048);
//        printTF(_2048);
//        move2048(0, _2048);
//        System.out.println();
//        printArray(_2048);
//        printTF(_2048);
//        move2048(3, _2048);
//        System.out.println();
//        printArray(_2048);
//        printTF(_2048);
    }

    private static void printArray(Block[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j].value + " ");
            }
            System.out.println();
        }
    }

    private static void printTF(Block[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j].isSum);
            }
            System.out.println();
        }
    }

    private static void move2048(int direction, Block[][] _2048) {
        switch (direction) {
            case 0://up
                for (int i = 0; i < _2048.length; i++) {
                    for (int j = 0; j < _2048.length; j++) {
                        move2048_up(j, i, _2048, _2048[j][i].value, j, i);
                    }
                    for (int k = 0; k < _2048.length; k++) {
                        _2048[k][i].isSum = false;
                    }
                }
                break;
            case 1://right
                for (int i = 0; i < _2048.length; i++) {
                    for (int j = _2048.length - 1; j > -1; j--) {
                        move2048_right(i, j, _2048, _2048[i][j].value, i, j);
                    }
                    for (int k = _2048.length - 1; k > -1; k--) {
                        _2048[i][k].isSum = false;
                    }
                }
                break;
            case 2://down
                for (int i = 0; i < _2048.length; i++) {
                    for (int j = _2048.length - 1; j > - 1; j--) {
                        move2048_down(j, i, _2048, _2048[j][i].value, j, i);
                    }
                    for (int k = _2048.length - 1; k > -1; k--) {
                        _2048[k][i].isSum = false;
                    }
                }
                break;
            case 3://left
                for (int i = 0; i < _2048.length; i++) {
                    for (int j = 0; j < _2048.length; j++) {
                        move2048_left(i, j, _2048, _2048[i][j].value, i, j);
                    }
                    for (int k = 0; k < _2048.length; k++) {
                        _2048[i][k].isSum = false;
                    }
                }
                break;
        }

    }

    private static void move2048_up(int y, int x, Block[][] _2048, int value, int originY, int originX) {
        if (y == 0) {
            return;
        }
        if (_2048[y - 1][x].value != 0) {
            if (_2048[y - 1][x].value == value && !_2048[y - 1][x].isSum) {
                _2048[y - 1][x].value += value;
                _2048[y - 1][x].isSum = true;
                _2048[originY][originX].value = 0;
            } else {
                _2048[originY][originX].value = 0;
                _2048[y][x].value = value;
                return;
            }
        }
        if (_2048[y - 1][x].value == 0) {
            if (y == 1) {
                _2048[originY][originX].value = 0;
                _2048[y - 1][x].value = value;
                return;
            }
            move2048_up(y - 1, x, _2048, value, originY, originX);
        }
    }

    private static void move2048_right(int y, int x, Block[][] _2048, int value, int originY, int originX) {
        if (x == _2048.length - 1) {
            return;
        }
        if (_2048[y][x + 1].value != 0) {
            if (_2048[y][x + 1].value == value && !_2048[y][x + 1].isSum) {
                _2048[y][x + 1].value += value;
                _2048[y][x + 1].isSum = true;
                _2048[originY][originX].value = 0;
            } else {
                _2048[originY][originX].value = 0;
                _2048[y][x].value = value;
                return;
            }
        }
        if (_2048[y][x + 1].value == 0) {
            if (x == _2048.length - 2) {
                _2048[originY][originX].value = 0;
                _2048[y][x + 1].value = value;
                return;
            }
            move2048_right(y, x + 1, _2048, value, originY, originX);
        }
    }

    private static void move2048_left(int y, int x, Block[][] _2048, int value, int originY, int originX) {
        if (x == 0) {
            return;
        }
        if (_2048[y][x - 1].value != 0) {
            if (_2048[y][x - 1].value == value && !_2048[y][x - 1].isSum) {
                _2048[y][x - 1].value += value;
                _2048[y][x - 1].isSum = true;
                _2048[originY][originX].value = 0;
                return;
            } else {
                _2048[originY][originX].value = 0;
                _2048[y][x].value = value;
                return;
            }
        }
        if (_2048[y][x - 1].value == 0) {
            if (x == 1) {
                _2048[originY][originX].value = 0;
                _2048[y][x - 1].value = value;
                return;
            }
            move2048_left(y, x - 1, _2048, value, originY, originX);
        }
    }

    private static void move2048_down(int y, int x, Block[][] _2048, int value, int originY, int originX) {
        if (y == _2048.length - 1) {
            return;
        }
        if (_2048[y + 1][x].value != 0) {
            if (_2048[y + 1][x].value == value && !_2048[y + 1][x].isSum) {
                _2048[y + 1][x].value += value;
                _2048[y + 1][x].isSum = true;
                _2048[originY][originX].value = 0;
            } else {
                _2048[originY][originX].value = 0;
                _2048[y][x].value = value;
                return;
            }
        }
        if (_2048[y + 1][x].value == 0) {
            if (y == _2048.length - 2) {
                _2048[originY][originX].value = 0;
                _2048[y + 1][x].value = value;
                return;
            }
            move2048_down(y + 1, x, _2048, value, originY, originX);
        }
    }

}

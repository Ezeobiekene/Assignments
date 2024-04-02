package com.company;


public class Main {

    public static void main(String[] args) {

        char[][] pixel = make_forward();
        make_mirror(pixel);
        display_mirrored_car(pixel);

    }


    public static char[][] make_forward() {

        char[][] pixel = new char[4][13];

        pixel[0][0] = ' ';
        pixel[0][1] = ' ';
        pixel[0][2] = '_';
        pixel[0][3] = '_';
        pixel[0][4] = '_';
        pixel[0][5] = '_';
        pixel[0][6] = '_';
        pixel[0][7] = '_';
        pixel[0][8] = ' ';
        pixel[0][9] = ' ';
        pixel[0][10] = ' ';
        pixel[0][11] = ' ';
        pixel[0][12] = ' ';
        pixel[1][0] = ' ';
        pixel[1][1] = '/';
        pixel[1][2] = '|';
        pixel[1][3] = '_';
        pixel[1][4] = '|';
        pixel[1][5] = '|';
        pixel[1][6] = '_';
        pixel[1][7] = '\\';
        pixel[1][8] = '\'';
        pixel[1][9] = '.';
        pixel[1][10] = '_';
        pixel[1][11] = '_';
        pixel[1][12] = ' ';
        pixel[2][0] = '(';
        pixel[2][1] = ' ';
        pixel[2][2] = ' ';
        pixel[2][3] = ' ';
        pixel[2][4] = '_';
        pixel[2][5] = ' ';
        pixel[2][6] = ' ';
        pixel[2][7] = ' ';
        pixel[2][8] = ' ';
        pixel[2][9] = '_';
        pixel[2][10] = ' ';
        pixel[2][11] = '_';
        pixel[2][12] = '\\';
        pixel[3][0] = '=';
        pixel[3][1] = '\'';
        pixel[3][2] = '-';
        pixel[3][3] = '(';
        pixel[3][4] = '_';
        pixel[3][5] = ')';
        pixel[3][6] = '-';
        pixel[3][7] = '-';
        pixel[3][8] = '(';
        pixel[3][9] = '_';
        pixel[3][10] = ')';
        pixel[3][11] = '-';
        pixel[3][12] = '\'';

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(pixel[i][j]);
            }
            System.out.println(' ');

        }
        return pixel;
    }

    public static void make_mirror(char[][] pixel) {
        for (int h= 0; h < 4; h++) {
            for (int i = 0, j = 12; 6 > i; i++, j--) {
                char temp = pixel[h][j];
                pixel[h][j] = pixel[h][i];
                pixel[h][i] = temp;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                switch (pixel[i][j]) {
                    case '(' -> pixel[i][j] = ')';
                    case ')' -> pixel[i][j] = '(';
                    case '/' -> pixel[i][j] = '\\';
                    case '\\' -> pixel[i][j] = '/';
                }
                System.out.print(pixel[i][j]);
            }
            System.out.println(' ');
        }

    }

    public static void display_mirrored_car(char[][] pixel) {

        for (int r = 0; r < 4; r++) {
            for (int p = 0; p < 2; p++) {
                for (int h= 0; h < 4; h++) {
                    for (int i = 0, j = 12; 6 > i; i++, j--) {
                        char temp = pixel[h][j];
                        pixel[h][j] = pixel[h][i];
                        pixel[h][i] = temp;
                    }
                }

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 13; j++) {
                        switch (pixel[i][j]) {
                            case '(' -> pixel[i][j] = ')';
                            case ')' -> pixel[i][j] = '(';
                            case '/' -> pixel[i][j] = '\\';
                            case '\\' -> pixel[i][j] = '/';
                        }
                    }
                }

                for (int j = 0; j < 13; j++) {
                    System.out.print(pixel[r][j]);
                }
            }
            System.out.println(' ');
            }
        }
    }
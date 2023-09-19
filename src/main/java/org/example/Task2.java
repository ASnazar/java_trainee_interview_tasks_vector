package org.example;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(transform(998));
    }

    public static int transform(int num) {
        if (num < 10) {
            return num + 1;
        }
        int a = num % 10 + 1;
        int b = transform(num / 10) * 10;
        return  ((a == 10) ? ((b + 1) * 10) : (b + a));
    }
}

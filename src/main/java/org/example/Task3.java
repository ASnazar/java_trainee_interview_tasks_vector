package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
public class Task3 {

    public static void main(String[] args) {
        List<List<Integer>> sudokuBoard = new ArrayList<>();

        sudokuBoard.add(Arrays.asList(7, 8, 4, 1, 5, 9, 3, 2, 6));
        sudokuBoard.add(Arrays.asList(5, 3, 9, 6, 7, 2, 8, 4, 1));
        sudokuBoard.add(Arrays.asList(6, 1, 2, 4, 3, 8, 7, 5, 9));
        sudokuBoard.add(Arrays.asList(9, 2, 8, 7, 1, 5, 4, 6, 3));
        sudokuBoard.add(Arrays.asList(3, 5, 7, 8, 4, 6, 1, 9, 2));
        sudokuBoard.add(Arrays.asList(4, 6, 1, 9, 2, 3, 5, 8, 7));
        sudokuBoard.add(Arrays.asList(8, 7, 6, 3, 9, 4, 2, 1, 5));
        sudokuBoard.add(Arrays.asList(2, 4, 3, 5, 6, 1, 9, 7, 8));
        sudokuBoard.add(Arrays.asList(1, 9, 5, 2, 8, 7, 6, 3, 4));
        boolean isValid = isValidSudoku(sudokuBoard);
        System.out.println(isValid);
    }

    public static boolean isValidSudoku(List<List<Integer>> board) {
        int N = board.size();
        int subgridSize = (int) Math.sqrt(N);
        if (N < 2 || subgridSize * subgridSize != N) {
            return false;
        }
        for (List<Integer> row : board) {
            if (!isValidSet(row)) {
                return false;
            }
        }
        for (int col = 0; col < N; col++) {
            List<Integer> column = new ArrayList<>();
            for (int row = 0; row < N; row++) {
                column.add(board.get(row).get(col));
            }
            if (!isValidSet(column)) {
                return false;
            }
        }
        for (int rowStart = 0; rowStart < N; rowStart += subgridSize) {
            for (int colStart = 0; colStart < N; colStart += subgridSize) {
                List<Integer> subgrid = new ArrayList<>();
                for (int row = rowStart; row < rowStart + subgridSize; row++) {
                    for (int col = colStart; col < colStart + subgridSize; col++) {
                        subgrid.add(board.get(row).get(col));
                    }
                }
                if (!isValidSet(subgrid)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidSet(List<Integer> set) {
        Set<Integer> seen = new HashSet<>();
        for (int num : set) {
            if (num < 1 || num > set.size() || seen.contains(num)) {
                return false;
            }
            seen.add(num);
        }
        return true;
    }
}

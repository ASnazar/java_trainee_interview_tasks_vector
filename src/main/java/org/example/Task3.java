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
        int boardSize = board.size();
        int subgridSize = (int) Math.sqrt(boardSize);

        if (boardSize < 2 || subgridSize * subgridSize != boardSize) {
            return false;
        }
        for (int i = 0; i < boardSize; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i)) {
                return false;
            }
        }
        for (int rowStart = 0; rowStart < boardSize; rowStart += subgridSize) {
            for (int colStart = 0; colStart < boardSize; colStart += subgridSize) {
                if (!isValidSubgrid(board, rowStart, colStart, subgridSize)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidRow(List<List<Integer>> board, int rowIndex) {
        Set<Integer> rowSet = new HashSet<>();
        for (int num : board.get(rowIndex)) {
            if (num != 0 && !rowSet.add(num)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidColumn(List<List<Integer>> board, int colIndex) {
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < board.size(); i++) {
            int num = board.get(i).get(colIndex);
            if (num != 0 && !colSet.add(num)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidSubgrid(List<List<Integer>> board, int rowStart, int colStart, int subgridSize) {
        Set<Integer> subgridSet = new HashSet<>();
        for (int i = rowStart; i < rowStart + subgridSize; i++) {
            for (int j = colStart; j < colStart + subgridSize; j++) {
                int num = board.get(i).get(j);
                if (num != 0 && !subgridSet.add(num)) {
                    return false;
                }
            }
        }
        return true;
    }
}

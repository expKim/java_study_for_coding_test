import Programmers.*;

public class Main {
    public static void main(String[] args) {
        TrainTracks t = new TrainTracks();
        int[][] arr ={{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}};
        System.out.println(t.solution(arr));

    }
}
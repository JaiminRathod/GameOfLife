package com.gojek.bootcamp007.gameoflife;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input file path");
        final String inputFilePath = sc.nextLine();

        Set<Point> livePointsSet = new HashSet<>();

        File file = new File(inputFilePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int lineCounter = 0;
        int hashtagCount = 0;
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '#') {
                    livePointsSet.add(new Point(lineCounter, i));
                    hashtagCount++;
                }
            }
            lineCounter++;
        }
        fr.close();

        Point[] livePoints = new Point[hashtagCount];
        int counter = 0;
        for (Point livePoint : livePointsSet) {
            livePoints[counter] = livePoint;
            counter++;
        }

        Game game = new Game(livePoints);
        game.play();
    }
}

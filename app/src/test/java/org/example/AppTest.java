/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testRobotSim() {
        int[] command = {6, -1, -1, 6};
        int[][] obstacle = {};
        assertEquals(36, App.robotSim(command, obstacle));
    }
    @Test
    public void testRobotSim2() {
        int[] command = {4,-1,4,-2,4};
        int[][] obstacle = {{2,4}};
        assertEquals(65, App.robotSim(command, obstacle));
    }
    @Test
    public void testRobotSim3() {
        int[] command = {4, -1, 3};
        int[][] obstacle = {};
        assertEquals(25, App.robotSim(command, obstacle));
    }
    @Test
    public void testRobotSim4() {
        int[] command = {-2, 8, 3, 7, -1};
        int[][] obstacle = {{-4,-1}, {1, -1}, {1, 4}, {5, 0}, {4, 5}, {-2, -1}, {2, -5}, {5, 1}, {-3, -1}, {5, -3}};
        assertEquals(324, App.robotSim(command, obstacle));
    }
    @Test
    public void testRobotSim5() {
        int[] command = {4,-1,4,-2,4};
        int[][] obstacle = {{2,4}, {1, 1}, {4, 4}, {3, 3}, {5, 5}};
        assertEquals(65, App.robotSim(command, obstacle));
    }

}

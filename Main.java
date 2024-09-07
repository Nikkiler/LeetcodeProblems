import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] command = {4,-1,4,-2,4};
        int[][] obstacle = {{2,4}};
        System.out.println(robotSim(command, obstacle));
    }
    public static int robotSim(int[] commands, int[][] obstacles) {
        int[] coords = {0, 0};
        char direction = 'n';
        int[] furhest = {0, 0};
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1 || commands[i] == -2) {
                direction = directionChange(commands[i], direction);
            } else {
                coords = movement(direction, coords, commands[i], obstacles);
                if (((coords[0] * coords[0]) + (coords[1] * coords[1])) > ((furhest[0] * furhest[0]) + (furhest[1] * furhest[1]))) {
                    furhest[1] = coords[1];
                    furhest[0] = coords[0];
                }
            }
        }
        return (furhest[0] * furhest[0]) + (furhest[1] * furhest[1]);
    }
    public static int[] movement(char direction, int[] coords, int command, int[][] obstacle) {
        switch (direction) {
            case 'n':
                int[] result1 = {0, 0};
                int[] temp1 = {0, 0};
                for (int i = 0; i < command; i++) {
                    coords[1] = coords[1] + 1;
                    if (obstacle.length > 0) {
                        for (int j = 0; j < obstacle.length; j++) {
                            result1 = new int[]{coords[0], (coords[1]) - 1};
                            temp1 = new int[]{obstacle[j][0], obstacle[j][1]};
                            if (Arrays.equals(temp1, coords))
                                return result1;

                        }
                    }
                }
                result1 = coords;
                return result1;
            case 'e':
                int[] result2 = {0, 0};
                int[] temp2 = {0, 0};
                for (int i = 0; i < command; i++) {
                    coords[0] = coords[0] + 1;
                    if (obstacle.length > 0) {
                        for (int j = 0; j < obstacle.length; j++) {
                            result2 = new int[]{coords[0] - 1, coords[1]};
                            temp2 = new int[]{obstacle[j][0], obstacle[j][1]};
                            if (Arrays.equals(temp2, coords))
                                return result2;

                        }
                    }
                }
                result2 = coords;
                return result2;
            case 's':
                int[] result3 = {0, 0};
                int[] temp3 = {0, 0};
                for (int i = 0; i < command; i++) {
                    coords[1] = coords[1] - 1;
                    if (obstacle.length > 0) {
                        for (int j = 0; j < obstacle.length; j++) {
                            result3 = new int[]{coords[0], (coords[1]) + 1};
                            temp3 = new int[]{obstacle[j][0], obstacle[j][1]};
                            if (Arrays.equals(temp3, coords))
                                return result3;

                        }
                    }
                }
                result3 = coords;
                return result3;
            case 'w':
                int[] result4 = {0, 0};
                int[] temp4 = {0, 0};
                for (int i = 0; i < command; i++) {
                    coords[0] = coords[0] - 1;
                    if (obstacle.length > 0) {
                        for (int j = 0; j < obstacle.length; j++) {
                            result4 = new int[]{coords[0] + 1, coords[1]};
                            temp4 = new int[]{obstacle[j][0], obstacle[j][1]};
                            if (Arrays.equals(temp4, coords))
                                return result4;

                        }
                    }
                }
                result4 = coords;
                return result4;
        }
        return coords;
    }
    public static char directionChange(int change, char direction) {
        switch (change) {
            case -2:
                switch (direction) {
                    case 'n':
                        return 'w';
                    case 'e':
                        return 'n';
                    case 's':
                        return 'e';
                    case 'w':
                        return 's';
                }
            case -1:
                switch (direction) {
                    case 'n':
                        return 'e';
                    case 'e':
                        return 's';
                    case 's':
                        return 'w';
                    case 'w':
                        return 'n';
                }

        }
        return direction;
    }
    public static int[] furthest(int[] coords, int[] furhest) {
        if ((coords[0] + coords[1]) > (furhest[0] + furhest[1])) {
            furhest[0] = coords[0];
            furhest[1] = coords[1];
        }
        return furhest;
    }
}
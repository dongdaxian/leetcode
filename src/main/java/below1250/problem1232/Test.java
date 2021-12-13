package below1250.problem1232;

public class Test {
	
	
	public boolean checkStraightLine(int[][] coordinates) {
		int[] record = coordinates[0];
        int disx = coordinates[1][0] - record[0];
        int disy = coordinates[1][1] - record[1];
        double k = 0;
        if(disx != 0) {
            k = (double)disy / disx;
            for(int i = 2; i < coordinates.length; i++) {
                int[] temp = coordinates[i];
                if((temp[0] - record[0]) * k != temp[1] - record[1])
                    return false;
            }
        } else {
            for(int[] temp: coordinates) {
                if(temp[0] != record[0])
                    return false;
            }
        }
        return true;
    }
//	方法1需要特殊处理竖直线上的点，且浮点数不一定能精确保存
	public boolean checkStraightLine2(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }
	
}



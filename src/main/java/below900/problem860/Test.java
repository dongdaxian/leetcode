package below900.problem860;

public class Test {
	public boolean lemonadeChange(int[] bills) {
        int[] money = new int[2];
        for(int bill: bills){
            if(bill == 5){
                money[0]++;
            } else if(bill == 10 && money[0] > 0){
                money[0]--;
                money[1]++;
            } else if(bill == 20 && ((money[0] > 0 && money[1] > 0) || money[0] > 2)){
                if(money[0] > 0 && money[1] > 0){
                    money[0]--;
                    money[1]--;
                } else {
                	money[0] -= 3;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

package com.contal.group.service.device;


import java.util.Arrays;

/**
 * To implement cash withdraw
 */
public class CashWithdrawService {
    int twentyCount = 0;
    int fiftyCount = 0;
    int[] arr = {Integer.parseInt((DeviceService.fiftyNote.getNoteType())),
            Integer.parseInt((DeviceService.twentyNote.getNoteType()))};

    /**
     * when the client withdraws money from their account, it shows the information of note's count.
     */
    public String cashDispensing(final int money) {
        final int[] style = checkAmountWithdraw(money);
        if (style == null) return "Unable to withdraw";

        int countFiftyNote = DeviceService.fiftyNote.getCurrentCount();
        int countTwentyNote = DeviceService.twentyNote.getCurrentCount();

        if (money == style[style.length -1]){
            if(!(countFiftyNote >= 3 && countTwentyNote >= 8)) {
                return "Unable to withdraw";
            }else{
                DeviceService.fiftyNote.setCurrentCount(countFiftyNote - 2);
                DeviceService.twentyNote.setCurrentCount(countTwentyNote - 5);
                return "2 x 50 note and 5 x 20 note";
            }
        }

        countNote(money);
        DeviceService.twentyNote.setCurrentCount(countTwentyNote - twentyCount);
        DeviceService.fiftyNote.setCurrentCount(countFiftyNote - fiftyCount);

        return fiftyCount + " x 50 note(s) and " + twentyCount + " x 20 note(s)";
    }

    private void countNote(int money){
        if (money != 0) {
            if (money % arr[0] != 0 && money % arr[1] == 0) {
                twentyCount = money / arr[1];
            } else {
                fiftyCount++;
                countNote(money - arr[0]);
            }
        }
    }

    public int[] checkAmountWithdraw(int money) {
        final int[] style = {20, 40, 50, 70, 80, 100, 150, 60, 110, 200};
        if (Arrays.stream(style).noneMatch((i -> i == money))) {
            return null;
        }
        return style;
    }
}

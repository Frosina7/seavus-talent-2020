import java.util.Scanner;

public class YearlyCalendar {

    public static void main(String[] args) {

        String s = new Scanner(System.in).nextLine();
        Boolean isLeap = false;
        if (Integer.parseInt(s) % 4 == 0) {
            isLeap = true;
        }
        String[] date;
        if (isLeap) {
            date = new String[366];
        } else {
            date = new String[365];
        }
        Integer year = Integer.parseInt(s);
        Integer days = 0;

        while (days < date.length) {
            for (int i = 1; i <= 12; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                    for (int j = 1; j <= 31; j++) {
                        String month = String.format("%02d", i);
                        String day = String.format("%02d", j);
                        date[days] = year + "-" + month + "-" + day;
                        days++;

                    }
                } else if (i == 2) {
                    if (isLeap) {
                        for (int j = 1; j <= 29; j++) {
                            String month = String.format("%02d", i);
                            String day = String.format("%02d", j);
                            date[days] = year + "-" + month + "-" + day;
                            days++;
                        }
                    } else {
                        for (int j = 1; j <= 28; j++) {
                            String month = String.format("%02d", i);
                            String day = String.format("%02d", j);
                            date[days] = year + "-" + month + "-" + day;
                            days++;
                        }

                    }

                } else {
                    for (int j = 1; j <= 30; j++) {
                        String month = String.format("%02d", i);
                        String day = String.format("%02d", j);
                        date[days] = year + "-" + month + "-" + day;
                        days++;
                    }
                }
            }
        }

        for (int i = 0; i < date.length; i++) {
            System.out.println(date[i]);
        }
    }

}

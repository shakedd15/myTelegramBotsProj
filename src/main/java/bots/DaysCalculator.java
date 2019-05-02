package bots;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaysCalculator {

    public static void calculateDays(){
        Date today = new Date();
        Calendar neededWeekend = Calendar.getInstance();
        neededWeekend.setTime(today);
        int dayOfWeek = neededWeekend.get(Calendar.DAY_OF_WEEK);

        if(dayOfWeek < 7){
            neededWeekend.add(Calendar.DATE, (6-dayOfWeek));  // number of days to add
        } else {
            neededWeekend.add(Calendar.DATE, 6);  // number of days to add
        }
        try {
            calcuateAllFridayNightsForMonths(neededWeekend);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void calcuateAllFridayNightsForMonths(Calendar comingFriday) throws ParseException {
        ArrayList<String> freefriday = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(checkSharon(comingFriday) && checkZivChildrens(comingFriday) && checkShakedMenses(comingFriday) && checkZivMenses(comingFriday)){
            freefriday.add(sdf.format(comingFriday.getTime()));
        }
        int counter = 0;
        while (counter != 8){
            comingFriday.add(Calendar.DATE, 7);
            if(checkSharon(comingFriday) && checkZivChildrens(comingFriday) && checkShakedMenses(comingFriday) && checkZivMenses(comingFriday)){
                freefriday.add(sdf.format(comingFriday.getTime()));
            }
            counter++;
        }
    }


    private static boolean checkSharon(Calendar testWeekend) throws ParseException {
        String date = "2019-04-19";  // Start date with children
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar weekendWithChildrens = Calendar.getInstance();
        weekendWithChildrens.setTime(sdf.parse(date));

        long disff = testWeekend.getTimeInMillis() - weekendWithChildrens.getTimeInMillis();
        long passDays = TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS);
        System.out.println ("Days: " + TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS));
        return (((passDays/7)%2)>0); // true if available
    }

    private static boolean checkZivChildrens(Calendar testWeekend) throws ParseException {
        String date = "2019-04-19";  // Start date no children
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar weekendWithChildrens = Calendar.getInstance();
        weekendWithChildrens.setTime(sdf.parse(date));

        long disff = testWeekend.getTimeInMillis() - weekendWithChildrens.getTimeInMillis();
        long passDays = TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS);
        System.out.println ("Days: " + TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS));
        return (((passDays/7)%3)==0); // true if available
    }

    private static boolean checkShakedMenses(Calendar testWeekend) throws ParseException {
        String date = "2019-04-01";  // Start date of menses
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar weekendWithChildrens = Calendar.getInstance();
        weekendWithChildrens.setTime(sdf.parse(date));

//        //test
//        String testingDate = "2019-05-24";  // Start date no children
//        Calendar testingD = Calendar.getInstance();
//        SimpleDateFormat kaka = new SimpleDateFormat("yyyy-MM-dd");
//        testingD.setTime(kaka.parse(testingDate));
//        long disff = testingD.getTimeInMillis() - weekendWithChildrens.getTimeInMillis();

        long disff = testWeekend.getTimeInMillis() - weekendWithChildrens.getTimeInMillis();
        long passDays = TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS);
        System.out.println ("Days: " + TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS));
        return (((passDays+1)%24)>5); // 24-between, 5-5 Menses days
    }

    private static boolean checkZivMenses(Calendar testWeekend) throws ParseException {
        String date = "2019-04-01";  // Start date of menses
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar weekendWithChildrens = Calendar.getInstance();
        weekendWithChildrens.setTime(sdf.parse(date));

//        //test
//        String testingDate = "2019-05-24";  // Start date no children
//        Calendar testingD = Calendar.getInstance();
//        SimpleDateFormat kaka = new SimpleDateFormat("yyyy-MM-dd");
//        testingD.setTime(kaka.parse(testingDate));
//        long disff = testingD.getTimeInMillis() - weekendWithChildrens.getTimeInMillis();

        long disff = testWeekend.getTimeInMillis() - weekendWithChildrens.getTimeInMillis();
        long passDays = TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS);
        System.out.println ("Days: " + TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS));
        return (((passDays+1)%24)>5); // 24-between, 5-5 Menses days
    }
}

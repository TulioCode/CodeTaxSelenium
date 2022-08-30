package utils;

import java.util.Date;
import java.util.Random;

import static utils.DateUtils.formattedDate;

public class RandomUser {

    public static String RandomTestEmail(){
        Random random = new Random();
        Date date = DateUtils.dateWithDaysDifference(0);
        int numberId = random.nextInt(1000);

        String email = "testeSelenium" + formattedDate(date) +"ID"+ numberId + "@codebit.com.br";

        return email;
    }

}

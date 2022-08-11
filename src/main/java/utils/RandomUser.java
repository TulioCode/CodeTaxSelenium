package utils;

import java.util.Date;

import static utils.DateUtils.formattedDate;

public class RandomUser {

    public static String RandomTestEmail(){
        Date date = DateUtils.dateWithDaysDifference(0);
        String email = "testeSelenium" + formattedDate(date) + "@codebit.com.br";

        return email;
    }

}

package personalfinance.settings;

import personalfinance.model.Currency;
import personalfinance.model.Filter;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {

    //формат числа (15.00)
    public static String amount(double amount) {
        return String.format(Settings.FORMAT_AMOUNT, amount);
    }

    //формат числа + код валюты (15.00 USD)
    public static String amount(double amount, Currency currency) {
        return amount(amount) + " " + currency;
    }

    //формат валюты
    public static String rate(double rate) {
        return String.format(Settings.FORMAT_RATE, rate);
    }
// формат валюты + код
    public static String rate(double rate, Currency currency) {
        return rate(rate) + currency.getCode();
    }
//формат даты
    public static String dateFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, new MainDateFormatSymbols());
        return sdf.format(date);
    }

    public static String date(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE);
    }
    public static String dateMonth(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_MONTH);
    }
    public static String dateYear(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_YEAR);
    }

    public static String yesNo(boolean yes){
        if (yes) return Text.get("YES");
        return Text.get("NO");
    }

    //парсер суммы из текста в число
    public static double fromAmountToNumber (String amount) throws NumberFormatException{
        amount = amount.replaceAll(",", ".");
        return Double.parseDouble(amount);
    }


    // todo добавить Filter в SaveData
    public static String getTitleFilter (Filter filter) {
        Date time = filter.getTo();
        switch (filter.getStep()){
            case Filter.STEP_DAY:
                return date(time);
            case Filter.STEP_MONTH:
                return dateMonth(time);
            case Filter.STEP_YEAR:
                return dateYear(time);
        }
        return null;
    }

//переопределение для вывода корректного формата месяца
    private static class MainDateFormatSymbols extends DateFormatSymbols {
        @Override
        public String[] getMonths() {
            return Text.getMonths();
        }
    }
}

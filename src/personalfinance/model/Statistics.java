package personalfinance.model;

import personalfinance.saveload.SaveData;

import java.util.HashMap;
import java.util.List;

public class Statistics {


    public static double getBalanceCurrency(Currency currency) {

        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()) {
            if (currency.equals(account.getCurrency()))
                amount += account.getAmount();
        }
        return amount;
    }

    //Возвращает сумму всех аккаунтов в единой валюте
    public static double getBalance(Currency currency) {
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()) {
            amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }

    public static HashMap<String, Double> getDataForChartOnIncomeArticles (){
        return getDataForChartOnArticles(true);
    }
    public static HashMap<String, Double> getDataForChartOnExpArticles (){
        return getDataForChartOnArticles(false);
    }



    private static HashMap<String, Double> getDataForChartOnArticles(boolean income) {
        List<Transaction> transactions = SaveData.getInstance().getTransactions();
        HashMap<String, Double> data = new HashMap<>();
        for (Transaction t : transactions) {
            if ((income && t.getAmount() > 0) || (!income && t.getAmount() < 0)) {
                String key = t.getArticle().getTitle();
                double summ = 0;
                double amount = t.getAmount();
                if (!income) amount *= -1;
                if (data.containsKey(key)) summ = data.get(key);
                summ += amount * t.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                data.put(key, round(summ));
            }
        }
        return data;
    }

    private static double round(double value) {
        return (double) Math.round(value * 100 ) / 100;
    }

}

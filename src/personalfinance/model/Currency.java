package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

import java.util.Objects;

public class Currency extends Common {

    private String title;
    private String code;
    private Double rate;
    private boolean on;
    private boolean base;


    public Currency(){}

    public Currency(String title, String code, Double rate, boolean on, boolean base) throws ModelException {
        if(title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if(code .length() == 0) throw new ModelException(ModelException.CODE_EMPTY);
        if(rate <= 0) throw new ModelException(ModelException.RATE_INCORRECT);

        this.title = title;
        this.code = code;
        this.rate = rate;
        this.on = on;
        this.base = base;
    }

    @Override
    public void postAdd(SaveData sd) {
        clearBase(sd);
    }

    @Override
    public void postEdit(SaveData sd) {
        clearBase(sd);
        for (Account a: sd.getAccounts())
            if(a.getCurrency().equals(sd.getOldCommon())) a.setCurrency(this);
    }

    private void clearBase(SaveData sd) {
        if (base){
            rate = Double.valueOf(1);
        Currency old = (Currency) sd.getCurrencies();
        for (Currency c : sd.getCurrencies()){
            if (!this.equals(c)){
                c.setBase(false);
                if(old != null) c.setRate(c.rate/ old.rate);
            }
        }

        }
    }


    public double getRateByCurrency(Currency currency){
        return rate/ currency.rate;
    }

    @Override
    public String getValueForCombobox() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", rate=" + rate +
                ", isOn=" + on +
                ", isBase=" + base +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isBase() {
        return base;
    }

    public void setBase(boolean base) {
        this.base = base;
    }
}

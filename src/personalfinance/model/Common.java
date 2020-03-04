package personalfinance.model;

import personalfinance.saveload.SaveData;

abstract public class Common {

    public String getValueForCombobox(){
        return null;
    }

    //требуется для механизма сохранения
    public Common(){}

    public void postAdd(SaveData sd ) {

    }

    public void postEdit(SaveData sd ){

    }

    public void postRemove(SaveData sd ){

    }

}

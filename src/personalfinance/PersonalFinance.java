package personalfinance;

import personalfinance.settings.Format;
import personalfinance.settings.Settings;
import personalfinance.settings.Text;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class PersonalFinance {

    public static void main(String[] args) {
        init();
        System.out.println(Format.dateMonth(new Date()));
//        System.out.println(Text.get("PROGRAMM_NAME"));
//        System.out.println(Arrays.toString(Text.getMonths()));
    }

    private static void init() {

        try {
            Settings.init();
            Text.init();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_ROBOTO_LIGHT));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

    }

}

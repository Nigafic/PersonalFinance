package personalfinance.gui.toolbar;

import personalfinance.gui.MainButton;
import personalfinance.gui.Refresh;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

abstract public class AbstractToolbar extends JPanel implements Refresh {

    public AbstractToolbar(EmptyBorder border) {
        super();
        setBorder(border);

    }

    abstract protected void init();

    protected MainButton addButton(String title, ImageIcon icon, String action, boolean topIcon) {
        MainButton mainButton = new MainButton(title, icon, null, action);
        if (topIcon) {
            mainButton.setHorizontalTextPosition(SwingConstants.CENTER);
            mainButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        } else {
            mainButton.setHorizontalTextPosition(SwingConstants.RIGHT);
            mainButton.setVerticalTextPosition(SwingConstants.CENTER);

        }
        add(mainButton);
        return mainButton;
    }

    @Override
    public void refresh() {
        removeAll();
        init();
    }

}

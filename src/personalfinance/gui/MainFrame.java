package personalfinance.gui;

import personalfinance.gui.menu.MainMenu;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh {

    private GridBagConstraints constraints;
    private final MainMenu mb;

    public MainFrame() {

        super(Text.get("PROGRAMM_NAME"));
        setResizable(false);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        mb = new MainMenu(this);
        setJMenuBar(mb);

        constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

//        add(new MainButton("Button", Style.ICON_MAIN,null, "JJJJ" ));
        //add toolbar

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        //add leftpanel



        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this); //перересовка Фрейма
        mb.refresh();
        pack();
    }
}

package personalfinance.gui;

import personalfinance.gui.menu.MainMenu;
import personalfinance.gui.toolbar.FunctionsToolbar;
import personalfinance.gui.toolbar.MainToolbar;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh {

    private final GridBagConstraints constraints;
    private final MainMenu mb;
    private final MainToolbar toolbar;

    public MainFrame() {

        super(Text.get("PROGRAMM_NAME"));

        MainFileChooser mfc = new MainFileChooser(this);
        System.out.println(mfc.save());

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


        //add(new MainButton("Button", Style.ICON_MAIN,null, "JJJJ" ));
        //add toolbar
        toolbar = new MainToolbar();
        add(toolbar, constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;

        //add(new MainDatePicker().getDatePicker(), constraints);
        //add leftpanel

        //add(new FunctionsToolbar(), constraints);



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

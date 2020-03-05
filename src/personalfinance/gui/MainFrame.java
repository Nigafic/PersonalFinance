package personalfinance.gui;

import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private GridBagConstraints constraints;

    public MainFrame() {


        super(Text.get("PROGRAMM_NAME"));
        setResizable(false);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        //add toolbar

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        //add leftpanel



        setLayout(new GridBagLayout());


        setLocationRelativeTo(null);
    }
}

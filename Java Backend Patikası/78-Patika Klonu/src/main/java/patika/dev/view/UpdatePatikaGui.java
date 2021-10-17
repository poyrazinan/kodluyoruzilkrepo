package patika.dev.view;

import patika.dev.manager.Config;
import patika.dev.manager.GuiManager;
import patika.dev.model.Patika;

import javax.swing.*;

public class UpdatePatikaGui extends JFrame {
    private JPanel wrapper;
    private JTextField fld_patika_name_input;
    private JButton btn_complete_update_patika;
    private Patika patika;

    public UpdatePatikaGui(Patika patika) {
        this.patika = patika;

        add(wrapper);
        setSize(300, 150);
        setLocation(GuiManager.getScreenCenter(getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        fld_patika_name_input.setText(patika.getName());

        btn_complete_update_patika.addActionListener( e -> {
            if (GuiManager.isInputFilled(fld_patika_name_input.getText())) {
                if (Patika.updatePatika(patika.getId(), fld_patika_name_input.getText()))
                    GuiManager.sendNotification("update");
            } else
                GuiManager.sendNotification("fill");

            dispose();
        });
    }
}

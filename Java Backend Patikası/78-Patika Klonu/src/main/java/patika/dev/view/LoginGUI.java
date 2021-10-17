package patika.dev.view;

import patika.dev.manager.Config;
import patika.dev.manager.GuiManager;
import patika.dev.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_login_uname;
    private JTextField fld_login_pass;
    private JButton btn_login;

    public LoginGUI() {

        add(wrapper);
        setSize(600, 500);
        setLocation(GuiManager.getScreenCenter(getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);


        btn_login.addActionListener(e -> {
            if (!GuiManager.isInputFilled(fld_login_uname.getText()) || !GuiManager.isInputFilled(fld_login_pass.getText()))
                GuiManager.sendNotification("fill");
            else {
                User user = User.getUser(fld_login_uname.getText());
                if (user == null)
                    GuiManager.sendNotification("noUser");
                else {
                    if (user.getPass().equals(fld_login_pass.getText())) {
                        switch (user.getType()) {
                            case "operator":
                                new OperatorGUI(user);
                                dispose();
                                break;
                            case "student":
                                // new StudentGui(user);
                                break;
                            case "educator":
                                // new EducatorGui(user);
                                break;
                            default:
                                break;
                        }
                    }
                    else
                        GuiManager.sendNotification("passwordIncorrect");
                }
                fld_login_uname.setText(null);
                fld_login_pass.setText(null);
            }
        });
    }

    public static void main(String[] args) {
        GuiManager.setLookAndFeel();
        LoginGUI gui = new LoginGUI();
    }
}

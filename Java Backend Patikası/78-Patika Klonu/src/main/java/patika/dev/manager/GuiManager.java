package patika.dev.manager;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GuiManager {

    public static Point getScreenCenter(Dimension dimension) {
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - dimension.width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - dimension.height) / 2;
        return new Point(x, y);
    }

    public static void setLookAndFeel() {
        if (Arrays.stream(UIManager.getInstalledLookAndFeels())
                .anyMatch(look -> (look.getName().equalsIgnoreCase("Nimbus")))) {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {}
        }
    }

    public static void sendNotification(String str) {
        String msg = "Lütfen alanları doldurunuz.";
        String title = "Hata!";
        int pane = JOptionPane.ERROR_MESSAGE;
        switch (str) {
            case "userAdded":
                msg = "Veri başarıyla eklendi.";
                title = "Başarılı!";
                pane = JOptionPane.INFORMATION_MESSAGE;
                break;
            case "userExists":
                msg = "Bu verilere sahip bir veri zaten var!";
                break;
            case "userRemoved":
                msg = "Veri başarıyla silindi.";
                title = "Başarılı";
                pane = JOptionPane.INFORMATION_MESSAGE;
                break;
            case "typeNotMatch":
                msg = "Girdiğiniz üye tipi yanlış!";
                break;
            case "update":
                msg = "Veri güncellendi";
                title = "Başarılı";
                pane = JOptionPane.INFORMATION_MESSAGE;
                break;
            case "permissionDenied":
                msg = "Silme işlemi iptal edildi.";
                break;
            case "noUser":
                msg = "Kullanıcı adı bulunamadı!";
                break;
            case "passwordIncorrect":
                msg = "Parola yanlış!";
                break;
            default:
                break;
        }
        JOptionPane.showMessageDialog(null, msg, title, pane);
    }

    public static boolean confirm(String str) {
        String msg;
        switch (str) {
            case "sure":
                msg = "Bu işlemi gerçekleştirmek istediğinize emin misiniz?";
                break;
            default:
                msg = str;
                break;
        }

        return JOptionPane.showConfirmDialog(null, msg, "Onay", JOptionPane.YES_NO_OPTION) == 0;
    }

    public static boolean isInputFilled(String input) {
        if (input.length() == 0)
            return false;
        else return true;
    }

    public static String createSearchQuery(String name, String uname, String type) {
        String SQL_QUERY = "SELECT * FROM user WHERE name LIKE '%{{name}}%' AND uname LIKE '%{{uname}}%'";
        if (!type.isEmpty()) {
            SQL_QUERY += " AND type = '{{type}}'";
            SQL_QUERY = SQL_QUERY.replace("{{type}}", type);
        }
        SQL_QUERY = SQL_QUERY.replace("{{name}}", name);
        SQL_QUERY = SQL_QUERY.replace("{{uname}}", uname);
        return SQL_QUERY;
    }
}

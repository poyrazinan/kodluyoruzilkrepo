package patika.dev.view;

import patika.dev.model.*;
import patika.dev.manager.Config;
import patika.dev.manager.GuiManager;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {

    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_userList;
    private JScrollPane scrl_userList;
    private JTable tbl_userList;
    private JPanel pnl_userForm;
    private JTextField fld_name;
    private JLabel lbl_name;
    private JTextField fld_userName;
    private JLabel lbl_pass;
    private JLabel lbl_userName;
    private JTextField fld_pass;
    private JLabel lbl_type;
    private JComboBox cmb_type;
    private JButton btn_submitUser;
    private JLabel lbl_id;
    private JTextField fld_userId;
    private JButton btn_userDelete;
    private JTextField fld_search_name;
    private JTextField fld_search_uname;
    private JComboBox cmb_search_type;
    private JButton btn_search;
    private JPanel pnl_patika;
    private JScrollPane scrl_patika_list;
    private JTable tbl_ptk_list;
    private JTextField fld_search_patika;
    private JButton btn_search_patika;
    private JPanel pnl_patika_search;
    private JTextField fld_patika_name;
    private JButton btn_add_patika;
    private JPanel pnl_courses;
    private JScrollPane scrl_courses;
    private JTable tbl_course_list;
    private JTextField fld_course_name;
    private JTextField fld_course_lang;
    private JComboBox cmb_course_patika;
    private JComboBox cmb_course_user;
    private JButton btn_course_add;
    private JTextField fld_course_video;
    private JPanel pnl_course_add;
    private JTextField fld_remove_patika_id;
    private JButton btn_remove_patika;
    private User operator;

    private DefaultTableModel mdl_userList;
    private DefaultTableModel mdl_patikaList;
    private DefaultTableModel mdl_courses;
    private JPopupMenu patikaMenu;

    public OperatorGUI(User operator) {
        this.operator = operator;

        add(wrapper);
        setSize(1000, 500);
        setLocation(GuiManager.getScreenCenter(getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText(lbl_welcome.getText() + " " + operator.getUname());

        // Model User List
        mdl_userList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        mdl_patikaList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        mdl_courses = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
        mdl_userList.setColumnIdentifiers(col_user_list);

        Object[] col_patika_list = {"ID", "Patika İsmi"};
        mdl_patikaList.setColumnIdentifiers(col_patika_list);

        Object[] col_course_list = {"ID", "Eğitmen Adı", "Patika Adı", "Ders Adı", "Dil", "Video"};
        mdl_courses.setColumnIdentifiers(col_course_list);

        tbl_userList.setModel(mdl_userList);
        tbl_userList.getTableHeader().setReorderingAllowed(false);

        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Güncelle");
        JMenuItem deleteMenu = new JMenuItem("Sil");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);

        tbl_ptk_list.setModel(mdl_patikaList);
        tbl_ptk_list.setComponentPopupMenu(patikaMenu);
        tbl_ptk_list.getTableHeader().setReorderingAllowed(false);
        tbl_ptk_list.getColumnModel().getColumn(0).setMaxWidth(75);

        tbl_course_list.setModel(mdl_courses);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);

        updateMenu.addActionListener( e -> {
            int selectedId = Integer.parseInt(tbl_ptk_list.getValueAt(tbl_ptk_list.getSelectedRow(), 0).toString());
            UpdatePatikaGui gui = new UpdatePatikaGui(Patika.getPatika(selectedId));
            gui.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshPatikaList();
                }
            });
        });

        deleteMenu.addActionListener(e -> {
            int selectedId = Integer.parseInt(tbl_ptk_list.getValueAt(tbl_ptk_list.getSelectedRow(), 0).toString());
            if (GuiManager.confirm("sure")) {
                Patika.removePatika(selectedId);
                GuiManager.sendNotification("userRemoved");
                refreshPatikaList();
            }
            else
                GuiManager.sendNotification("permissionDenied");
        });

        refreshUserList();
        refreshPatikaList();
        refreshCourseList();


        courseButtonListener();
        patikaMouseAdaptor();
        selectUser();
        patikaButtonListener();
        usersButtonListener();
        btn_logout.addActionListener(e -> {
            dispose();
            new LoginGUI();
        });
    }

    public static void main(String[] args) {
        GuiManager.setLookAndFeel();
        Operator operator = new Operator();
        operator.setId(1);
        operator.setName("Poyraz Inan");
        operator.setPass("123");
        operator.setType("operator");
        operator.setUname("Poyraz");

        OperatorGUI gui = new OperatorGUI(operator);
    }

    private void courseButtonListener() {
        btn_course_add.addActionListener(e -> {
            String courseName = fld_course_name.getText(),
                    lang = fld_course_lang.getText(),
                    video = fld_course_video.getText();

            int patikaId = ((Item) cmb_course_patika.getSelectedItem()).getId(),
                    userId = ((Item) cmb_course_user.getSelectedItem()).getId();

            if (!GuiManager.isInputFilled(courseName) || !GuiManager.isInputFilled(lang) || !GuiManager.isInputFilled(video))
                GuiManager.sendNotification("fillBanks");
            else {
                if (Course.addCourse(courseName, lang, video, patikaId, userId)) {
                    GuiManager.sendNotification("userAdded");
                    refreshCourseList();
                    fld_course_name.setText(null);
                    fld_course_lang.setText(null);
                    fld_course_video.setText(null);
                }
            }
        });
    }

    private void patikaButtonListener() {
        btn_add_patika.addActionListener( e-> {
            String name = fld_patika_name.getText();
            if (!GuiManager.isInputFilled(name))
                GuiManager.sendNotification("fillBlanks");
            else {
                if (Patika.addPatika(name)) {
                    GuiManager.sendNotification("userAdded");
                    refreshPatikaList();
                    fld_patika_name.setText(null);
                }
            }
        });
    }

    private void usersButtonListener() {
        btn_submitUser.addActionListener(e -> {

            String name = fld_name.getText(),
                    userName = fld_userName.getText(),
                    pass = fld_pass.getText(),
                    type = cmb_type.getSelectedItem().toString();

            if (!GuiManager.isInputFilled(fld_name.getText())
                    || !GuiManager.isInputFilled(fld_pass.getText())
                    || !GuiManager.isInputFilled(fld_userName.getText()))
                GuiManager.sendNotification("fillBlanks");
            else {
                if (User.addUser(name, userName, pass, type)) {
                    GuiManager.sendNotification("userAdded");
                    refreshUserList();
                    fld_name.setText(null);
                    fld_userName.setText(null);
                    fld_pass.setText(null);
                }
            }
        });

        btn_userDelete.addActionListener(e -> {

            if (GuiManager.confirm("sure")) {
                if (!GuiManager.isInputFilled(fld_userId.getText()))
                    GuiManager.sendNotification("fillBlanks");
                else {
                    int removeId = Integer.parseInt(fld_userId.getText());
                    User.removeUser(removeId);
                    refreshUserList();
                    GuiManager.sendNotification("userRemoved");
                    fld_userId.setText(null);
                }
            }
            else
                GuiManager.sendNotification("permissionDenied");
        });

        btn_search.addActionListener(e -> {
            String name = fld_search_name.getText(),
                    uname = fld_search_uname.getText(),
                    type = cmb_search_type.getSelectedItem().toString();

            String SQL_QUERY = GuiManager.createSearchQuery(name, uname, type);
            refreshUserList(User.getUserArray(SQL_QUERY));
        });
    }

    private void selectUser() {
        tbl_userList.getSelectionModel().addListSelectionListener( e -> {
            try {
                String selectedUser = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 0).toString();
                fld_userId.setText(selectedUser);
            }
            catch (Exception e1) {}
        });

        tbl_userList.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int userId = Integer.parseInt(tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 0).toString());
                String name = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 1).toString();
                String uname = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 2).toString();
                String pass = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 3).toString();
                String type = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 4).toString();
                if (type.equalsIgnoreCase("educator")
                        || type.equalsIgnoreCase("student")
                        || type.equalsIgnoreCase("operator")) {
                    if (GuiManager.isInputFilled(name) && GuiManager.isInputFilled(uname) && GuiManager.isInputFilled(pass)
                            && GuiManager.isInputFilled(type)) {
                        User.updateUser(userId, name, uname, pass, type);
                    }
                    else GuiManager.sendNotification("error");
                }
                else
                    GuiManager.sendNotification("typeNotMatch");

                refreshUserList();
            }
        });
    }

    private void patikaMouseAdaptor() {
        tbl_ptk_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int selectedRow = tbl_ptk_list.rowAtPoint(e.getPoint());
                tbl_ptk_list.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });

    }

    private void refreshUserList() {
        refreshCourseList();
        ((DefaultTableModel) tbl_userList.getModel()).setRowCount(0);
        User.getUserArray().stream().forEach(user -> {
            Object[] row = {user.getId(), user.getName(), user.getUname(), user.getPass(), user.getType()};
            mdl_userList.addRow(row);
        });
    }

    private void refreshUserList(ArrayList<User> users) {
        refreshCourseList();
        ((DefaultTableModel) tbl_userList.getModel()).setRowCount(0);
        users.stream().forEach(user -> {
            Object[] row = {user.getId(), user.getName(), user.getUname(), user.getPass(), user.getType()};
            mdl_userList.addRow(row);
        });
    }

    private void refreshPatikaList() {
        refreshCourseList();
        ((DefaultTableModel) tbl_ptk_list.getModel()).setRowCount(0);
        Patika.getPatikaArray().stream().forEach(patika -> {
            Object[] row = {patika.getId(), patika.getName()};
            mdl_patikaList.addRow(row);
        });
    }

    private void refreshCourseList() {
        loadCoursesCombos();
        ((DefaultTableModel) tbl_course_list.getModel()).setRowCount(0);
        Course.getCourseArray().stream().forEach(course -> {
            Object[] row = {course.getId(), course.getUser().getName(),
                    course.getPatika().getName(), course.getName(), course.getLang(), course.getVideo()};
            mdl_courses.addRow(row);
        });
    }

    public void loadCoursesCombos() {
        cmb_course_patika.removeAllItems();
        Patika.getPatikaArray().stream().forEach(patika -> {
            cmb_course_patika.addItem(new Item(patika.getId(), patika.getName()));
        });

        cmb_course_user.removeAllItems();
        User.getUserArray().stream().filter(user -> (user.getType().equals("educator"))).forEach(user -> {
            cmb_course_user.addItem(new Item(user.getId(), user.getName()));
        });
    }
}

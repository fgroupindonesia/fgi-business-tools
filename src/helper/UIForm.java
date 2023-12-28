package helper;

import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author staff
 */
public class UIForm {

    public static final int AS_NUMERIC = 1;
    public static final int AS_TEXT = 0;
    public static final int VALUE_NUMERIC_SELECTED = 1;
    public static final int VALUE_NUMERIC_NOT_SELECTED = 0;

    public static String getCheckedValue(JCheckBox jc, int mode_as) {
        if (jc.isSelected()) {
            if (mode_as == AS_NUMERIC) {
                return "1";
            } else {
                return "true";
            }
        } else {
            if (mode_as == AS_NUMERIC) {
                return "0";
            } else {
                return "false";
            }
        }
    }

    public static String getText(JTextField jf) {
        return jf.getText();
    }

    public static String getTextPass(JPasswordField jf) {
        return new String(jf.getPassword());
    }

    public static String getSelectedRadioButton(JRadioButton... comp) {
        String name = null;

        for (JRadioButton jr : comp) {
            if (jr.isSelected()) {
                // because the data string is stored hidden here 
                // in the name tag used for db purposes
                name = jr.getName();
                break;
            }
        }

        return name;
    }

    public static boolean isSelected(JComboBox comp, int... excludedIndex) {

        boolean selected = false;

        for (int post : excludedIndex) {

            if (comp.getSelectedIndex() != post) {
                selected = true;
                break;
            }

        }

        return selected;

    }

    public static void setComboboxData(String nameData, JComboBox comp) {

        ComboBoxModel<String> cbox = comp.getModel();
        int iPost = -1;

        for (int i = 0; i < cbox.getSize(); i++) {
            String n = cbox.getElementAt(i);
            if (n.equalsIgnoreCase(nameData)) {

                iPost = i;
                break;
            }
        }

        comp.setSelectedIndex(iPost);

    }

    public static void setRadioButtonData(String name, JRadioButton... jr) {

        for (JRadioButton jrNa : jr) {
            if (jrNa.getText().equalsIgnoreCase(name)) {
                jrNa.setSelected(true);
                break;
            }
        }

    }

}

package helper;

import helper.objects.AppsProfile;
import helper.objects.WebToAPK;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author staff
 */
public class TableRender {

    public static final int DATA_NOT_AVAILABLE = -1;

    public void render_AppProfile(JTable table, ArrayList<AppsProfile> list) {
        clearData(table);

        for (AppsProfile cat : list) {
            Object[] data = {false, cat.getId(), cat.getName(), cat.getPlatform_Type(), cat.getVersion()};
            this.getTableModel(table).addRow(data);
        }
    }

    public void render_WebToAPK(JTable table, ArrayList<WebToAPK> list) {
        clearData(table);

        for (WebToAPK cat : list) {
            Object[] data = {false, cat.getId(), cat.getQueue_id(), cat.getAppname(), cat.getUrl(), cat.getStatus(), cat.getSubmitted_date(), cat.getCompleted_date()};
            this.getTableModel(table).addRow(data);
        }
    }

    public int getCheckedData(JTable table, int positionIndexedID) {
        int val = -1;

        for (int i = 0; i < table.getRowCount(); i++) {
            boolean b = (Boolean) this.getTableModel(table).getValueAt(i, 0);
            if (b) {
                val = (Integer) this.getTableModel(table).getValueAt(i, positionIndexedID);
                break;
            }
        }

        return val;
    }

    public String getCheckedDataAsText(JTable table, int colIndex) {
        String val = null;

        for (int i = 0; i < table.getRowCount(); i++) {
            boolean b = (Boolean) this.getTableModel(table).getValueAt(i, 0);
            if (b) {
                val = (String) this.getTableModel(table).getValueAt(i, colIndex);
                break;
            }
        }

        return val;
    }

    public String getValueAt(JTable table, int col_target, int col_start, String identifier) {
        String val = null;
        String matched = null;

        for (int i = 0; i < table.getRowCount(); i++) {
            matched = (String) this.getTableModel(table).getValueAt(i, col_start);
            if (matched.equalsIgnoreCase(identifier)) {
                val = (String) this.getTableModel(table).getValueAt(i, col_target);
                break;
            }
        }

        return val;
    }

    public ArrayList<Integer> getAllCheckedData(JTable table, int colIndex) {
        int val = -1;
        ArrayList<Integer> data = new ArrayList<Integer>();

        for (int i = 0; i < table.getRowCount(); i++) {
            boolean b = (Boolean) this.getTableModel(table).getValueAt(i, 0);
            if (b) {
                val = (Integer) this.getTableModel(table).getValueAt(i, colIndex);
                data.add(val);
            }
        }

        return data;
    }

    public void prepareEmptyQuestionData(JTable table) {
        clearData(table);

        emptyQuestionDataSet(table);

    }

    private String getAlphabet(int i) {
        if (i < 0) {
            return "-" + getAlphabet(-i - 1);
        }

        int quot = i / 26;
        int rem = i % 26;
        char letter = (char) ((int) 'A' + rem);
        if (quot == 0) {
            return "" + letter;
        } else {
            return getAlphabet(quot - 1) + letter;
        }
    }

    private void emptyQuestionDataSet(JTable table) {
        for (int j = 0; j < 4; j++) {
            Object[] data = {false, getAlphabet(j), ""};
            this.getTableModel(table).addRow(data);
        }
    }

    private void clearData(JTable table) {
        DefaultTableModel dfm = (DefaultTableModel) table.getModel();
        dfm.setRowCount(0);
    }

    private DefaultTableModel getTableModel(JTable table) {
        DefaultTableModel dfm = (DefaultTableModel) table.getModel();
        return dfm;
    }

}

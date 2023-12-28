/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import helper.objects.ListItem;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author staff
 */
public class CustomListCellRenderer extends JLabel implements ListCellRenderer<ListItem> {

    private final ImageIcon defaultIcon = new ImageIcon();

    public CustomListCellRenderer() {
        setOpaque(true);
        setBorder(new EmptyBorder(5, 10, 5, 10)); // Add padding
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ListItem> list, ListItem value, int index,
            boolean isSelected, boolean cellHasFocus) {
        this.setText("<html><h3>" + value.getTitle() + "</h3><p>" + value.getDate() + "</p>"+ value.getDescription() + "</html>");

        // Load and set the image icon
        setIcon(value.getImageIcon());

        // Set background and foreground colors based on selection
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            
            value.setReaded(true);
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }

}

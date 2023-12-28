package helper.objects;

import javax.swing.ImageIcon;

/**
 *
 * @author staff
 */
public class ListItem {

    private String title;
    private String description;
    private boolean readed;
    private String date;

    ImageIcon iconOpen = new javax.swing.ImageIcon(getClass().getResource("/frames/images/yellow-mail-open-icon32.png"));
    ImageIcon iconClosed = new javax.swing.ImageIcon(getClass().getResource("/frames/images/yellow-mail-icon32.png"));

    ImageIcon iconblueOpen = new javax.swing.ImageIcon(getClass().getResource("/frames/images/blue-mail-open-icon32.png"));
    ImageIcon iconblueClosed = new javax.swing.ImageIcon(getClass().getResource("/frames/images/blue-mail-icon32.png"));

    
    public ImageIcon getImageIcon() {
        if (this.isReaded()) {
            return iconOpen;
        }

        return iconblueClosed;
    }

    public ListItem(String title, String description, String dateNa) {
        this.title = title;
        this.description = description;
        this.date = dateNa;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return the readed
     */
    public boolean isReaded() {
        return readed;
    }

    /**
     * @param readed the readed to set
     */
    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
}

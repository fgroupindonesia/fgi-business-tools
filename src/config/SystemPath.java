package config;

/**
 *
 * @author staff
 */
public class SystemPath {

    private static final String FOLDER_SYSTEM_PATH = "\\fgroupindonesia\\fgi-business-tools\\";
    private static final String FOLDER_TEMPLATE_PATH = System.getenv("APPDATA") + FOLDER_SYSTEM_PATH + "templates\\";
    private static final String FOLDER_WORKS_PATH = FOLDER_TEMPLATE_PATH + "works\\";
    private static final String FOLDER_RECOVERY_PATH = System.getenv("APPDATA") + FOLDER_SYSTEM_PATH + "recovery\\";
    private static final String FOLDER_UPDATES_PATH = System.getenv("APPDATA") + FOLDER_SYSTEM_PATH + "updates\\";
    public static final String DB_FILE = System.getenv("APPDATA") + FOLDER_SYSTEM_PATH + "db.sqlite";
    public static final String BACKUP_THEME_FILE = "index.html.bak";
    public static final String EDITED_THEME_FILE = "index-edit.html";
    public static final String INDEX_THEME_FILE = "index.html";
    public static final String SETUP_UPDATES_FILE = "update-installer.msi";

    public static String getFolderUpdates() {
        return FOLDER_UPDATES_PATH;
    }

    public static String getFolderUpdates(double ver) {
        return FOLDER_UPDATES_PATH + "\\" + ver;
    }

    public static String getFolderTemplate() {
        return FOLDER_TEMPLATE_PATH;
    }
    public static String getFolderRecovery() {
        return FOLDER_RECOVERY_PATH;
    }

    public static String getFolderWorks() {
        return FOLDER_WORKS_PATH;
    }

    public static String getIndexFile() {
        return INDEX_THEME_FILE;
    }

    public static String getSetupUpdatesFile() {
        return SETUP_UPDATES_FILE;
    }

    public static String getBackupIndexFile() {
        return EDITED_THEME_FILE;
    }

    public static String getEditedFile() {
        return EDITED_THEME_FILE;
    }

}

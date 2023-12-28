package helper;

import config.SystemPath;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author staff
 */
public class URLManager {

    private static final String PREFIX = "https://bootstrapmade.com/demo/templates/";
    private static final String SUFFIX = "/index.html";
    private static final String PREFIX_LOCAL = SystemPath.getFolderWorks();

    private static String getURL(boolean localMode, String themeName, boolean clearCache) {
        String url = null;

        if (localMode) {
            try {
                url = PREFIX_LOCAL + themeName + SUFFIX;
                File file = new File(url);
                String filePath = file.toURI().toURL().toString();
                url = filePath;
            } catch (Exception ex) {
                System.err.println("URL locally is invalid!");
            }
        } else {
            url = PREFIX + themeName + SUFFIX;
        }

        String random = String.valueOf(Math.random() * 1000000);
        String urlWithCacheBuster = null;

        if (clearCache) {
            urlWithCacheBuster = url + "?cache=" + random;
        } else {
            urlWithCacheBuster = url;
        }

        return urlWithCacheBuster;
    }

    public static String getWhatsappWebURL() {
        return "https://wa.link/pmnveg";
    }

    public static String getCheckUpdatesURL() {
        return "https://fgibtools.api.fgroupindonesia.com/check";
    }

    public static String getDownloadUpdatesURL() {
        return "https://fgibtools.api.fgroupindonesia.com/download/stable-release";
    }

    public static String buildURLLocally(String themeName, boolean clearCache) {
        return getURL(true, themeName, clearCache);
    }

    public static String buildURL(String themeName, boolean clearCache) {
        return getURL(false, themeName, clearCache);
    }

    /* public static final String THEME_SIIMPLE = "https://bootstrapmade.com/demo/templates/Siimple/index.html";
    public static final String THEME_ESTARTUP = "https://bootstrapmade.com/demo/templates/eStartup/index.html";
    public static final String THEME_THEEVENT = "https://bootstrapmade.com/demo/templates/TheEvent/index.html";
    public static final String THEME_AVILION = "https://bootstrapmade.com/demo/templates/Avilon/index.html";
    public static final String THEME_APPLAND = "https://bootstrapmade.com/demo/templates/Appland/index.html";
    public static final String THEME_SOFTLAND = "https://bootstrapmade.com/demo/templates/SoftLand/index.html";
    public static final String THEME_SHUFFLE = "https://bootstrapmade.com/demo/templates/Shuffle/index.html";
    public static final String THEME_SCAFFOLD = "https://bootstrapmade.com/demo/templates/Scaffold/index.html";
    public static final String THEME_LUMIA = "https://bootstrapmade.com/demo/templates/Lumia/index.html";
    public static final String THEME_BOOTSLANDER = "https://bootstrapmade.com/demo/templates/Bootslander/index.html";
    public static final String THEME_DAY = "https://bootstrapmade.com/demo/templates/Day/index.html";
    public static final String THEME_ONEPAGE = "https://bootstrapmade.com/demo/templates/OnePage/index.html";
    public static final String THEME_BIZLAND = "https://bootstrapmade.com/demo/templates/BizLand/index.html";
    public static final String THEME_FLEXSTART = "https://bootstrapmade.com/demo/templates/FlexStart/index.html";
    public static final String THEME_ARSHA = "https://bootstrapmade.com/demo/templates/Arsha/index.html";
    public static final String THEME_APPEND = "https://bootstrapmade.com/demo/templates/Append/index.html";
    public static final String THEME_HEROBIZ = "https://bootstrapmade.com/demo/templates/HeroBiz/index.html";
     */
}

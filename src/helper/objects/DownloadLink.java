/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper.objects;

/**
 *
 * @author staff
 */
public class DownloadLink {

    private String direct_url;
    private String app_name;
    private String link_mode;
    private String last_download;
    private int total_overall;
    private String generated_js_code;

    /**
     * @return the direct_url
     */
    public String getDirect_url() {
        return direct_url;
    }

    /**
     * @param direct_url the direct_url to set
     */
    public void setDirect_url(String direct_url) {
        this.direct_url = direct_url;
    }

    /**
     * @return the app_name
     */
    public String getApp_name() {
        return app_name;
    }

    /**
     * @param app_name the app_name to set
     */
    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    /**
     * @return the link_mode
     */
    public String getLink_mode() {
        return link_mode;
    }

    /**
     * @param link_mode the link_mode to set
     */
    public void setLink_mode(String link_mode) {
        this.link_mode = link_mode;
    }

    /**
     * @return the last_download
     */
    public String getLast_download() {
        return last_download;
    }

    /**
     * @param last_download the last_download to set
     */
    public void setLast_download(String last_download) {
        this.last_download = last_download;
    }

    /**
     * @return the total_overall
     */
    public int getTotal_overall() {
        return total_overall;
    }

    /**
     * @param total_overall the total_overall to set
     */
    public void setTotal_overall(int total_overall) {
        this.total_overall = total_overall;
    }

    /**
     * @return the generated_js_code
     */
    public String getGenerated_js_code() {
        return generated_js_code;
    }

    /**
     * @param generated_js_code the generated_js_code to set
     */
    public void setGenerated_js_code(String generated_js_code) {
        this.generated_js_code = generated_js_code;
    }

}

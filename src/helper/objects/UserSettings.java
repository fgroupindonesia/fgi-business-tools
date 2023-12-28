
package helper.objects;

/**
 *
 * @author staff
 */
public class UserSettings {
    private int id;
    private String username;
    private String pass;
    private String contact;
    private String email;
    private String check_updates;
    private int remember_me;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the check_updates
     */
    public String getCheck_updates() {
        return check_updates;
    }

    /**
     * @param check_updates the check_updates to set
     */
    public void setCheck_updates(String check_updates) {
        this.check_updates = check_updates;
    }

    /**
     * @return the remember_me
     */
    public int getRemember_me() {
        return remember_me;
    }

    /**
     * @param remember_me the remember_me to set
     */
    public void setRemember_me(int remember_me) {
        this.remember_me = remember_me;
    }
}

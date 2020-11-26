package entity;

/**
 * @author Lu
 */
public class User {

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    private String cellphone;
    public String getUsername(){
        return username;
    }
}

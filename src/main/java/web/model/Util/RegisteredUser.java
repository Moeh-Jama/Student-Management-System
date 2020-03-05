package web.model.Util;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "registered_user")
public class RegisteredUser {

    @Id
    @NotBlank
    private int user_id;

    @NotBlank
    private String password;

    private boolean isStaff;

    public RegisteredUser(){
        super();
    }

    public RegisteredUser(int userID, String password, boolean isStaff){
        this.user_id = userID;
        this.password = password;
        this.isStaff = isStaff;
    }

    public int getUserID(){
        return this.user_id;
    }
    public void setUserID(int id){
        this.user_id = id;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public boolean isStaff(){
        return this.isStaff;
    }
    public void setStaff(boolean isStaff){
        this.isStaff = isStaff;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Person.Person;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author swarnadeekshitha
 */
public class UserAccountDirectory {
    private ArrayList<UserAccount> userAccountDirectory;
    
    public UserAccountDirectory(){
        userAccountDirectory = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(ArrayList<UserAccount> userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }
    
    public UserAccount addUserAccount(String username,String password,Person person,Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccountDirectory.add(userAccount);
        return userAccount;
    }
    
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountDirectory)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public boolean checkDuplicates(String username){
        for(UserAccount ua : userAccountDirectory){
            if(ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProfileDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import model.ProfileBean;

/**
 *
 * @author IT353S741
 */
@ManagedBean
@SessionScoped
public class ProfileController {
private ProfileBean theModel;
    private String results;
    private int failedlogin;
    private boolean loggintrue;
    private String loginname;
    private String authentic;

   
    /**
     * Creates a new instance of ProfileController
     */
    public ProfileController() {
        theModel = new ProfileBean();
        failedlogin=0;
        loggintrue=false;
        
        authentic="Bailey";
    }

    /**
     * @return the theModel
     */
    public ProfileBean getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(ProfileBean theModel) {
        this.theModel = theModel;
    }
    
     public String getInfo() {
        
    theModel.sendEmail();
    results= theModel.getInfo();
        return "echo.xhtml";
   
     }
         public String getResults() {
        return results;
    }

    
    public void setResults(String results) {
        this.results = results;
    }
    public String logincheck() {
        
        if (failedlogin == 3) {
            this.results = "You have tried a maximum number of tries, please wait 5 minutes to try again.";
            return "LoginBad.xhtml";
            
        }
      
        if (theModel.getUserid().equals("Bailey")){
            failedlogin=0;
            loggintrue=true;
            this.results = "Thank you for signing in " + theModel.getUserid();
            return "LoginGood.xhtml";
        }
        
        failedlogin++;
        this.results = "Please try again" ;
        return "LoginBad.xhtml";
       
         
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProfileDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.ProfileBean;

/**
 *
 * @author IT353S741
 */
@ManagedBean
@RequestScoped
public class ProfileController {
private ProfileBean theModel;
    private String results;
    /**
     * Creates a new instance of ProfileController
     */
    public ProfileController() {
        theModel = new ProfileBean();
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
}

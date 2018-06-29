/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendBeans;

import Persistencia.Campsite;
import Persistencia.JPAExample;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andreia Patrocínio
 * @author Carolina Albuquerque
 * @author Diogo Jorge
 * @author Pedro Pires
 * 
 */
@ManagedBean(name = "searchbean")
@SessionScoped
public class SearchBean implements Serializable{
    
    @ManagedProperty(value = "#{campsiteLocation}")
    private String campsiteLocation;
    @ManagedProperty(value = "#{listaCampsites}")
    private List<Campsite> listaCampsites; 
    
    @ManagedProperty(value = "#{checkin}")
    private Date checkin;
    
   @ManagedProperty(value = "#{checkout}")
    private Date checkout;
    
            
    JPAExample ex = new JPAExample();
    
    public String getCampsiteLocation() {
        return campsiteLocation;
    }

    public void setCampsiteLocation(String campsiteLocation) {
        this.campsiteLocation = campsiteLocation;
    }


    public List<Campsite> getListaCampsites() {
        return listaCampsites;
    }

    public void setListaCampsites(List<Campsite> listaCampsites) {
        this.listaCampsites = listaCampsites;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }
 
    public String showAll(){
        listaCampsites = ex.listarTodosCampsites();     
        return "results.xhtml";
    }
    
    public String search(){
        listaCampsites = ex.listarCampsite(campsiteLocation); 
        return "results.xhtml";
    }
    
   
}

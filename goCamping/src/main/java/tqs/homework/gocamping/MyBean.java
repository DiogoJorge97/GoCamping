/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs.homework.gocamping;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import net.bootsfaces.component.tabView.TabView;

/**
 *
 * @author carolina albuquerque
 */

@ManagedBean(name = "myBean") 
@ViewScoped
public class MyBean implements Serializable {

private int activeIndex = 0;

    public int getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(int activeIndex) {
        this.activeIndex = activeIndex;
    }

    public void nextTab() {
        activeIndex++;
    }
}
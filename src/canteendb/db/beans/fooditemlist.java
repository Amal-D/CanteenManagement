/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteendb.db.beans;

/**
 *
 * @author amald
 */
public class fooditemlist {
    private String id;
    private String NAME;
    private String RATE;

    public fooditemlist(String id, String NAME , String RATE) {
                this.id = id;
                this.NAME = NAME;
                this.RATE = RATE;
                
        
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the NAME
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * @param NAME the NAME to set
     */
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    /**
     * @return the RATE
     */
    public String getRATE() {
        return RATE;
    }

    /**
     * @param RATE the RATE to set
     */
    public void setRATE(String RATE) {
        this.RATE = RATE;
    }
        
        public String toString() {
                    return id;
        }
        
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canteendb.db.beans;

/**
 *
 * @author project
 */
public class PurchasedItemBean {
    
    private String mat;
    private String qty;
    private String prize;

    /**
     * @return the mat
     */
    public String getMat() {
        return mat;
    }

    /**
     * @param mat the mat to set
     */
    public void setMat(String mat) {
        this.mat = mat;
    }

    /**
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(String qty) {
        this.qty = qty;
    }

    /**
     * @return the prize
     */
    public String getPrize() {
        return prize;
    }

    /**
     * @param prize the prize to set
     */
    public void setPrize(String prize) {
        this.prize = prize;
    }
}

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
public class DailyIncomeBean {
    private float expence;
    private float income;
    private float profit;

    /**
     * @return the expence
     */
    public float getExpence() {
        return expence;
    }

    /**
     * @param expence the expence to set
     */
    public void setExpence(float expence) {
        this.expence = expence;
    }

    /**
     * @return the income
     */
    public float getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(float income) {
        this.income = income;
    }

    /**
     * @return the profit
     */
    public float getProfit() {
        return profit;
    }

    /**
     * @param profit the profit to set
     */
    public void setProfit(float profit) {
        this.profit = profit;
    }
    
}

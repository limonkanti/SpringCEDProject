
package com.limon.springproject;


public class Estimation 
{
    private int id;
    private String date;
    private String month;
    private String cost;
    private String costDetails;
    private String earn;
    private String earnDetails;
    private String deposit;
    private String depositDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCostDetails() {
        return costDetails;
    }

    public void setCostDetails(String costDetails) {
        this.costDetails = costDetails;
    }

    public String getEarn() {
        return earn;
    }

    public void setEarn(String earn) {
        this.earn = earn;
    }

    public String getEarnDetails() {
        return earnDetails;
    }

    public void setEarnDetails(String earnDetails) {
        this.earnDetails = earnDetails;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getDepositDetails() {
        return depositDetails;
    }

    public void setDepositDetails(String depositDetails) {
        this.depositDetails = depositDetails;
    }

    public Estimation( String date, String month, String cost, String costDetails, String earn, String earnDetails, String deposit, String depositDetails,int id) {
        this.id = id;
        this.date = date;
        this.month = month;
        this.cost = cost;
        this.costDetails = costDetails;
        this.earn = earn;
        this.earnDetails = earnDetails;
        this.deposit = deposit;
        this.depositDetails = depositDetails;
    }

    public Estimation(String date, String month, String cost, String costDetails, String earn, String earnDetails, String deposit, String depositDetails) {
        this.date = date;
        this.month = month;
        this.cost = cost;
        this.costDetails = costDetails;
        this.earn = earn;
        this.earnDetails = earnDetails;
        this.deposit = deposit;
        this.depositDetails = depositDetails;
    }

    public Estimation(int id, String month) {
        this.id = id;
        this.month = month;
    }

    public Estimation() {
    }
    
    
    
}

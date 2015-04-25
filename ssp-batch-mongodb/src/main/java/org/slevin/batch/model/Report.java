package org.slevin.batch.model;

import org.slevin.common.Account;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@XmlRootElement(name = "report-mongo")
public class Report {

    private int id;
    private Date date;
    private long impression;
    private int clicks;
    private BigDecimal earning;
    private List<Account> accounts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getImpression() {
        return impression;
    }

    public void setImpression(long impression) {
        this.impression = impression;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public BigDecimal getEarning() {
        return earning;
    }

    public void setEarning(BigDecimal earning) {
        this.earning = earning;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("M/d/yyyy");

        return "Report [id=" + id + ", date=" + dateFormatter.format(date) + ", impression=" + impression + ", clicks=" + clicks + ", earning="
                + earning + "]";
    }

}
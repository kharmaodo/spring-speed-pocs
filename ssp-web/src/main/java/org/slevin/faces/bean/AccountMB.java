package org.slevin.faces.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.ResourceDependencies;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.InjectService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.slevin.common.Account;
import org.slevin.common.Role;
import org.slevin.dao.AccountDao;
import org.slevin.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jacky on 02/01/15.
 */


@Component(value = "accountMB")
@ViewScoped
public class AccountMB implements Serializable {


    private Account bean;
    private Account beanSelected;
    private String passwordCheck;
    private String role;

    private List<Account> list;
    private List<Account> listSelected;



    @Autowired
    private AccountDao accountService;

    @Autowired
    private RoleDao roleService;


    @PostConstruct
    public void init(){
        refreshList();
    }


    
    public void refreshList(){
        this.bean = new Account();
        this.beanSelected = new Account();
        this.list = new ArrayList<Account>();
        this.listSelected = new ArrayList<Account>();
        try {
            this.list.addAll(accountService.findAll());
            this.listSelected.addAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void save() {
        try {


            if(bean.getPassword().equals(this.passwordCheck)){
                this.bean.setPassword(Account.md5(this.bean.getPassword()));
                accountService.persist(this.bean);
                Role roleTmp = new Role();
                roleTmp.setUsername(this.bean.getUsername());
                roleTmp.setName(this.role);
                roleService.persist(roleTmp);
                refreshList();
            }else{
                notificationError("Password don't match");
            }



            notificationSuccess("persist Account");
        } catch (Exception e) {
            notificationError(e,"persist Account");
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            accountService.merge(this.beanSelected);
            refreshList();
            notificationSuccess("update Account");
        } catch (Exception e) {
            notificationError(e,"update Account");
        }
    }

    public void delete() {
        try {
            accountService.remove(this.beanSelected.getId());
            refreshList();
            roleService.remove(roleService.findByProperty("username", this.beanSelected.getUsername()).get(0).getId());
            notificationSuccess("delete Account");
        } catch (Exception e) {
            notificationError(e,"delete Account");
        }
    }

    public void onCancel(RowEditEvent event) {
        refreshList();
    }


    public void reset() {
        refreshList();
        RequestContext.getCurrentInstance().reset("form1");
    }


    public void notificationSuccess(String operation) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation "+operation+" success");
        FacesMessage msg = null;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public void notificationError(Exception e, String operation) {
        Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation "+operation+" Error ",e);
        FacesMessage msg = null;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Error");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void notificationError(String message) {
        Logger.getLogger(this.getClass().getName()).log(Level.ERROR, message);
        FacesMessage msg = null;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Error");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public Account getBean() {
        return bean;
    }

    public void setBean(Account bean) {
        this.bean = bean;
    }

    public Account getBeanSelected() {
        return beanSelected;
    }

    public void setBeanSelected(Account beanSelected) {
        this.beanSelected = beanSelected;
    }

    public List<Account> getList() {
        if(list == null){
            list = new ArrayList<Account>();
        }
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    public List<Account> getListSelected() {
        return listSelected;
    }

    public void setListSelected(List<Account> listSelected) {
        this.listSelected = listSelected;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AccountDao getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountDao accountService) {
        this.accountService = accountService;
    }

    public RoleDao getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleDao roleService) {
        this.roleService = roleService;
    }
}

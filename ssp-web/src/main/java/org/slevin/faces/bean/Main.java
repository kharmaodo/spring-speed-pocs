package org.slevin.faces.bean;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import scala.annotation.meta.getter;


public class Main {

	
}



@Component 
class RolesList {
	
    @Autowired
    @Qualifier("rolesList")
    private List<String> roles= new ArrayList<String>();

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
    
    
}

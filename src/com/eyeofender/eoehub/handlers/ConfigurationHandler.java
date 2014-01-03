package com.eyeofender.eoehub.handlers;

import java.util.ArrayList;
import java.util.List;

import com.eyeofender.eoehub.EOEHub;

public class ConfigurationHandler {

	EOEHub plugin;
	
	/** Stats **/
	private List<String> staffNames = new ArrayList<String>();
	
	public ConfigurationHandler ( EOEHub plugin ){
		this.plugin = plugin;
	}
	
	public void init(){
		if(plugin.getConfig().contains("staffNames"))
			this.setStaffNames(plugin.getConfig().getStringList("staffNames"));
			
	}
	
	public List<String> getStaffNames() {
		return staffNames;
	}

	public void setStaffNames(List<String> staffNames) {
		this.staffNames = staffNames;
	}
}

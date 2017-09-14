
package com.my.Helper;

/**
 *
 * @author Vandens mc Maddens
 */

import java.util.ArrayList;
import java.util.Iterator;

public class SectionProperty {
    
	private String name;
	private ArrayList items;
	
	public SectionProperty()
	{
		items = new ArrayList();
	}
	
	public void setName(String newVal) {
		this.name = newVal;
	}

	public String getName() {
		return this.name;
	}

	public void addItem(String name,String value) {
		String s[] = new String[2];
		s[0]=name;
		s[1]=value;
		items.add(s);
	}

	public String getItem(String name) {
		String r="";
        Iterator it = items.iterator();
        while (it.hasNext()) {
        	String s[] = (String[])it.next();
        	if (s[0].equalsIgnoreCase(name))
        	{
        		r=s[1];
        		break;
        	}
        }
        return r;
	}
}


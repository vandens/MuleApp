
package com.my.Helper;

/**
 *
 * @author Vandens mc Maddens
 */

import ch.ubique.inieditor.IniEditor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GlobalProperty {
        private static GlobalProperty ref;
	private ArrayList arrprops;
	private IniEditor props = null;
	private String propertiesFile;
        private HashMap<String,String> globalMap = new HashMap<String,String>();

	private GlobalProperty(String pathToFile)
	{
            arrprops        = new ArrayList();
            propertiesFile  = pathToFile;
            LoadProperties();
	}

	private void LoadProperties()
	{ 
	    props = new IniEditor();
	    	  
	    try {
		    props.load(propertiesFile);
		} catch(IOException ex)	{
			return;
		}
		
		List l = props.sectionNames();
                Iterator it = l.iterator();
                while (it.hasNext()) {
                    String line = (String) it.next();
                    SectionProperty sec = new SectionProperty();
                    List l2 = props.optionNames(line);
                    Iterator it2 = l2.iterator();
                    sec.setName(line);
                    while (it2.hasNext()) {
                        String val  = (String) it2.next();
                        String val2 = props.get(line, val);
                        globalMap.put(val, val2);
                        sec.addItem(val, val2);
                        arrprops.add(sec);
                    }
                }
		
	}

	public SectionProperty getSections(String SectionName)
	{
		SectionProperty r = null;
        Iterator it = arrprops.iterator();
        while (it.hasNext()) {
        	SectionProperty sec = (SectionProperty)it.next();
        	if (sec.getName().equalsIgnoreCase(SectionName))
        	{
        		r = sec;
        		break;
        	}
        }
        return r;
	}

	public String getPropValue(String SectionName,String PropValue)
	{
		String r = null;
        Iterator it = arrprops.iterator();
        while (it.hasNext()) {
        	SectionProperty sec = (SectionProperty)it.next();
        	if (sec.getName().equalsIgnoreCase(SectionName))
        	{
        		r = sec.getItem(PropValue);
        		break;
        	}
        }
        return r;
	}

	public void setPropValue(String HeadName, String SectionName,String PropValue)
	{
		props.set(HeadName, SectionName, PropValue);
		try {
			props.save(propertiesFile);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
        public static synchronized GlobalProperty getGlobalProp(String param)
        {
                  if (ref == null)
                      ref = new GlobalProperty(param);
                  return ref;
        }

	@Override
	public Object clone() throws CloneNotSupportedException
	{
	    throw new CloneNotSupportedException(); 
	}
        
        public ArrayList getArrayConfig(){
            
            return arrprops;
        }
        
        public HashMap<String,String> getGlobalMap(){            
            return globalMap;            
        }
        
        public Map<String,String> getSpesificMap(String key){
            
            Map<String,String> partnerMap = new HashMap<String,String>();
            for(Map.Entry<String,String> x : globalMap.entrySet()){
                String[] keys = x.getKey().split("\\.");
                String vals = x.getValue();
                
                if(keys[0].equalsIgnoreCase(key)){                    
                    partnerMap.put(keys[1], vals);
                }
            }    
            return partnerMap;
            
        }
        
       
}

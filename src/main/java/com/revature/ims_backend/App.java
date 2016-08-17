package com.revature.ims_backend;

import com.revature.ims_backend.entities.Category;
import com.revature.persist.DataLayer;

public class App 
{
    public static void main( String[] args )
    {
    	
    	DataLayer dataLayer = new DataLayer();
    	Category input = new Category(1, "Packaging Supplies");// oom(1, 333, "Sprie");
    	dataLayer.insertObject(input);
    	Object output = dataLayer.getCategoryById(input.getId());//getClassroomById(1);
    	System.out.println(output);
    	dataLayer.close();
    }
}

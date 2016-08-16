package com.revature.ims_backend;

import com.revature.beans.Classroom;
import com.revature.persist.DataLayer;

public class App 
{
    public static void main( String[] args )
    {
    	DataLayer dataLayer = new DataLayer();
    	dataLayer.insertObject(new Classroom(1, 333, "Spire"));
    	Classroom output = dataLayer.getClassroomById(1);
    	System.out.println(output.getId() + " " + output.getRoomNumber() + " " + output.getBuilding());
    	dataLayer.close();
    }
}

package com.queue.BackendQueue.Client;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.queue.BackendQueue.server.OperationOnData;

@RestController
@RequestMapping(value = "/client")
public class ClientPushOperation 
{
	private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 200;
    private static final int CODE_FAILUE = 500;
    private static OperationOnData store = new OperationOnData();

    @RequestMapping(value = "/pollData", method = RequestMethod.GET)
    public BaseConditionForPoll pollData()
	{
    	BaseConditionForPoll baseCondition = new BaseConditionForPoll();
    	try
    	{
    		ArrayList<String> data = store.returnData();
    		baseCondition.setStatus(SUCCESS_STATUS);
    		baseCondition.setCode(CODE_SUCCESS);
    		baseCondition.setData(data);
    		
    	}
    	catch(Exception e)
    	{
    		baseCondition.setStatus(SUCCESS_STATUS);
    		baseCondition.setCode(CODE_SUCCESS);
    		baseCondition.setData(null);
    	}
    	
    	return baseCondition;
	}
    
    
    
    @RequestMapping(value = "/insertData", method = RequestMethod.GET)
    public BaseConditionForPush pushData(@RequestParam(value = "query") String query)
	{
    	System.out.println("Got the data");
    	System.out.println("data= "+query);
    	BaseConditionForPush baseCondition = new BaseConditionForPush();
    	try
    	{
    		System.out.println("Inside try");
    		store.insertData(query);
    		System.out.println("Data has been stored");
    		baseCondition.setStatus(SUCCESS_STATUS);
    		baseCondition.setCode(CODE_SUCCESS);
    	}
    	catch(Exception e)
    	{
    		baseCondition.setStatus(ERROR_STATUS);
    		baseCondition.setCode(CODE_FAILUE);
    	}
    	
    	return baseCondition;
	}
	
	
	
    
    
    
    
    
    
    
    
	
	
	
	
	/*
	 * interface OnGeekEventListener { 
  
    // this can be any type of method 
    void onGeekEvent(); 
} 
  
class B { 
  
    private OnGeekEventListener mListener; // listener field 
  
    // setting the listener 
    public void registerOnGeekEventListener(OnGeekEventListener mListener) 
    { 
        this.mListener = mListener; 
    } 
  
    // my synchronous task 
    public void doGeekStuff() 
    { 
  
        // perform any operation 
        System.out.println("Performing callback before synchronous Task"); 
  
        // check if listener is registered. 
        if (this.mListener != null) { 
  
            // invoke the callback method of class A 
            mListener.onGeekEvent(); 
        } 
    } 
  
    // Driver Function 
    public static void main(String[] args) 
    { 
        B obj = new B(); 
        OnGeekEventListener mListener = new A(); 
        obj.registerOnGeekEventListener(mListener); 
        obj.doGeekStuff(); 
    } 
} 
  
class A implements OnGeekEventListener { 
  
    @Override
    public void onGeekEvent() 
    { 
        System.out.println("Performing callback after synchronous Task"); 
        // perform some routine operation 
    } 
    // some class A methods 
} 
	 */
}

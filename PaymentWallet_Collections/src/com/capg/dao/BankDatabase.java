package com.capg.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.capg.bean.BankDetails;
import com.capg.bean.CustomerDetails;

public class BankDatabase implements BankDatabaseIntf{
	static Map<Integer,BankDetails> map= new HashMap<Integer,BankDetails>();
	static BankDetails b;
	
	@Override
	public void storeBankDetailsDb(BankDetails b){
		map.put(b.getAccNo(), b);
			
	}
	
	@Override
	public Map<Integer,BankDetails> getBankDetailsDb(int i){
		Set<Integer> key= map.keySet();
		boolean flag= false;
		for(Integer j:key ){
			if(i==j)
			{
				flag=true;
				break;
			}
			else 
				{
					continue;
				}
		}
		if(flag=true) {
			return map;
		}
		else {
			
		return null;
		}		
	
	}
	
	@Override
	public boolean checkAccount(int accNo) {
        return map.containsKey(accNo);
    }
}


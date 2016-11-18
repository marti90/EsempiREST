package it.alfasoft.martina.dao;

import it.alfasoft.martina.model.BustaPaga;

import java.util.Map;
import java.util.TreeMap;

public class BustaPagaDAO {
	
	private Map<Long,BustaPaga> buste;
	
	public BustaPagaDAO(){
		
		buste= new TreeMap<Long,BustaPaga>();
		
		BustaPaga b1= new BustaPaga(1,2000,"01");
		BustaPaga b2= new BustaPaga(2,1500,"01");
		BustaPaga b3= new BustaPaga(3,2200,"01");
		BustaPaga b4= new BustaPaga(4,1800,"01");
		
		buste.put(b1.getId_busta(), b1);
		buste.put(b2.getId_busta(), b2);
		buste.put(b3.getId_busta(), b3);
		buste.put(b4.getId_busta(), b4);
	}

	public Map<Long,BustaPaga> getBuste() {
		return buste;
	}

	public void setBuste(Map<Long,BustaPaga> buste) {
		this.buste = buste;
	}
	
	

}

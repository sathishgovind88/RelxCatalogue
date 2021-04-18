package com.mendeley.interview;


import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class testCatalogue {
		
	private String[][] arrval = {{"Love Story", "2020"},{"Story of Historical","2019"},{"Story of Happy", "2019"}};
	private static List<Document> testdoc;
	public Catalogue objcata = new Catalogue();
	
	@Test()	
	public void emptycatalogue() {
		Assert.assertEquals(0, objcata.size());		
	}
	
	@Test
	public void verifycatalogue(){			
		boolean check;
		
		for (int idx = 0;idx < arrval.length;idx++) {			
			objcata.addDocument(new Document(arrval[idx][0], Integer.parseInt(arrval[idx][1])));		
		}		
				
		if (objcata.size() > 0) {
			
			Assert.assertTrue(true);
		}
		else {			
			Assert.assertTrue(false);
		}
		
		testdoc = objcata.getSortedDocuments(new sortbytitle());		
		
		for (int i =0; i< testdoc.size();i++) {
			check = getcatalogue(testdoc.get(i).getTitle(),testdoc.get(i).getPublicationYear());
									
			if (check == true) {				
				Assert.assertTrue(true);
			}
			else {			
				Assert.assertTrue(false);
			}
		}
				
		testdoc = objcata.getDocumentsByYear(2019);
						
	}
	
	@Test
	public void verifycatalogueyear() {
				
		Assert.assertEquals(2, testdoc.size());		
						
	}
					
	public boolean getcatalogue(String title,int year) {
				
		for (int idx = 0;idx < arrval.length;idx++) {
			if (arrval[idx][0].equals(title) && Integer.parseInt(arrval[idx][1]) == year) {
				return true;				
			}
		}
		return false;
	}	

}

class sortbytitle implements Comparator<Document>{

	@Override
	public int compare(Document o1, Document o2) {
		// TODO Auto-generated method stub
				
		//return o1.getTitle().compareTo(o2.getTitle());
		return o1.getPublicationYear() - o2.getPublicationYear();
	}
	
	
}
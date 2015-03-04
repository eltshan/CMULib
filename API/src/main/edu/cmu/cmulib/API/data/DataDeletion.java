package edu.cmu.cmulib.API.data;

/**
 * 
 * @author shen
 * @version 0.1
 * @since 2/24/2015
 * 
 *        This class contains only one function: delete data items from the end.
 */
public class DataDeletion {

	static public boolean delete(int numOfItems) {
		return Master.deleteData(numOfItems);
	}
}

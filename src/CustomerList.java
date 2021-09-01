import java.util.ArrayList;

public class CustomerList implements MyIterator{
	private ArrayList<Customer> theList;
	int currentItem = 0;
	
	public CustomerList() {
		this.theList = new ArrayList<Customer>();
	}
	
	public ArrayList<Customer> getList() {
		return this.theList;
	}
	
	public Customer getCustomer(String id) {
		while(hasNext()){
			Customer temp = this.theList.get(currentItem);
			if (temp.getID().equals(id))
				return temp;
			else{
				next();
			}
		}
		System.out.println("Customer " + id + " not found");
		return null;
	}
	
	public boolean addCustomer(Customer cust) {
		for (int i = 0; i < this.theList.size(); i++) {
			Customer temp = this.theList.get(i);
			if (temp.getID().equals(cust.getID()))
				return false;
		}
		this.theList.add(cust);
		return true;
	}

	@Override
	public boolean hasNext() {
		if (currentItem >= theList.size()){
			return false;
		}
		return true;
	}

	@Override
	public Object next() {
		return theList.get(currentItem++);
	}
}

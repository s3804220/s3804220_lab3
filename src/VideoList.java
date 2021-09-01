import java.util.ArrayList;

public class VideoList implements MyIterator{
	private ArrayList<Video> theList;
	int currentItem = 0;

	public VideoList() {
		this.theList = new ArrayList<Video>();
	}

	public ArrayList<Video> getList() {
		return this.theList;
	}
	
	public Video getVideo(String id) {
		while(hasNext()){
			Video temp = this.theList.get(currentItem);
			if (temp.getID().equals(id))
				return temp;
			else{
				currentItem++;
			}
		}
		System.out.println("Video " + id + " not found");
		return null;
	}
	
	public boolean addVideo(Video vid) {
		for (int i = 0; i < this.theList.size(); i++) {
			Video temp = this.theList.get(i);
			if (temp.getID().equals(vid.getID()))
				return false;
		}
		theList.add(vid);
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

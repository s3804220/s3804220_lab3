public class SuperVIPCustomer extends Customer{
    private int reward_points;
    private static SuperVIPCustomer onlySuperVIPCustomer;

    public SuperVIPCustomer(String name, String address, String iD, String phone) {
        super(name, address, iD, phone);
    }

    public static SuperVIPCustomer getInstance(){
        if(onlySuperVIPCustomer==null){
            onlySuperVIPCustomer = new SuperVIPCustomer("SuperVIPName", "123 SuperVIP street", "SUPERVIP_ID", "123");
        }
        return onlySuperVIPCustomer;
    }

    public int getReward_points() {
        return reward_points;
    }
    public void setReward_points(int reward_points) {
        this.reward_points = reward_points;
    }

    @Override
    public boolean borrowVid(Video rental) {
        if (super.borrowVid(rental)) {
            if (reward_points>=100)
                reward_points = 0;
            else
                reward_points += 10;
            System.out.println("Customer "+this.getName()+" now has "+this.getReward_points()+" reward points");
            return true;
        }
        return false;
    }
}

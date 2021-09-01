public class CustomerFactory {

    public static Customer createCustomer(String type, String name, String address, String id, String phone){
        if(type.equals("guest")){
            return new GuestCustomer(name, address, id, phone);
        }
        else if (type.equals("vip")){
            return new VIPCustomer(name, address, id, phone);
        }
        else if(type.equals("supervip")){
            return SuperVIPCustomer.getInstance();
        }
        return null;
    }
}

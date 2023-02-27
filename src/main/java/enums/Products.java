package enums;

public enum Products {
    MIRENDINA("123","Mirendina",5),
    TANGO("234","Tango",3),
    KITKAT("345","Kitkat",5),
    SNICKERS("456","Snickers",15),
    MILKA("567","Milka",26);


    private String id;
    private String libel;
    private double price;


    Products(String id,String libel,double price) {
        this.id =id;
        this.libel=libel;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getLibel() {
        return libel;
    }
}

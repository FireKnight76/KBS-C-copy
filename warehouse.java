public class warehouse {
    int location;
    int productid;
    int amount;
    public warehouse(int location, int productid, int amount){
        this.location = location;
        this.productid = productid;
        this.amount = amount;
    }

    public int getlocation() {
        return this.location;
    }

    public void setlocation(int location) {
        this.location = location;
    }

    public int getproductid() {
        return this.productid;
    }

    public void setproductid(int productid) {
        this.productid = productid;
    }

    public int getamount() {
        return this.amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "{" +
            " location='" + getlocation() + "'" +
            ", productid='" + getproductid() + "'" +
            ", amount='" + getamount() + "'" +
            "}";
    }

}

public class packages {
    int packageid;
    String destination;
    String status;
    String location;
    public packages(int packageid, String destination, String status, String location){
        this.packageid = packageid;
        this.destination = destination;
        this.status = status;
        this.location = location;
    }

    public int getPackageid() {
        return this.packageid;
    }

    public void setPackageid(int packageid) {
        this.packageid = packageid;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "{" +
            " packageid='" + getPackageid() + "'" +
            ", destination='" + getDestination() + "'" +
            ", status='" + getStatus() + "'" +
            ", location='" + getLocation() + "'" +
            "}";
    }
 
 }



public class Customer {

    private String custName;
    private String mobNo;
    private String acc;
    private String addr;
    public Customer( String custName, String mobNo, String acc, String addr) {


        this.custName = custName;
        this.mobNo = mobNo;
        this.acc = acc;
        this.addr = addr;
    }

    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getMobNo() {
        return mobNo;
    }
    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
    public String getacc() {
        return acc;
    }
    public void setacc(String acc) {
        this.acc = acc;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
}
 
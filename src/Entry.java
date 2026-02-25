public class Entry {
    private String value;
    private long expiryTime;
    public Entry(String value,long ttl){
        this.value=value;
        if(ttl==-1) {
            this.expiryTime=-1;
        }
        else{
            this.expiryTime=System.currentTimeMillis()+ttl;
        }
    }
    public String getValue(){
        return value;
    }
    public boolean isExpired() {
        if (expiryTime == -1) return false;
        return System.currentTimeMillis() > expiryTime;//epoch time is more than expiry time
    }

}
import java.util.HashMap;
import java.util.Map;

public class DB {
    Map<Integer,Entry> storage=new HashMap<>();
    boolean running=true;
    public void start(){
        running = true;
        System.out.println("DB Started");
    }
    public void stop(){
        running = false;
        System.out.println("DB Stop");
    }
    public void checkRunning(){
        if(!running){
            throw new RuntimeException("Database is not running");
        }
    }
    public synchronized void put(int key,String value,long ttl){
        checkRunning();
        storage.put(key, new Entry(value,ttl));
        System.out.println("Inserted key " + key + " with value  " + value+" With ttl "+ttl/1000+" secs ");
    }
    public synchronized String get(int key){
        checkRunning();
        Entry e = storage.get(key);

        if (e == null || e.isExpired()) {
            storage.remove(key); // safe even if key not present
            return null;
        }

        return e.getValue();

    }
    public synchronized void delete(int key){
        checkRunning();
        storage.remove(key);
        System.out.println("Deleted value at key"+key);
    }
}

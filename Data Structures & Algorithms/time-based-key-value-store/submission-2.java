class TimeMap {
    HashMap<String, List<TimeStampedValue>> m;
    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TimeStampedValue t = new TimeStampedValue(timestamp, value);
        if(m.containsKey(key)) {
            m.get(key).add(t);
        } else {
            List<TimeStampedValue> l = new ArrayList<>();
            l.add(t);
            m.put(key, l);
        }
        System.out.println("after setting list for key "+key);
        int index=0;
        for(TimeStampedValue t1:m.get(key)) {
            System.out.println("index "+index+" timestamp "+t1.timestamp+" value "+t1.value);
            index++;
        }
    }
    
    public String get(String key, int timestamp) {
        System.out.println("get for key "+key+" timestamp "+timestamp);
        if(m.containsKey(key)) {
            List<TimeStampedValue> l = m.get(key);
            int index = search(l, timestamp);
            if(index==-1)
                return "";
                System.out.println("returning for index "+index+" value "+l.get(index).value);
            return l.get(index).value;
        } else {
            return "";
        }
    }

    public int search(List<TimeStampedValue> list, int timestamp) {
        // search the exact or nearest timestamp value index
        int l=0, r=list.size()-1;
        int m=-1;
        int match=-1;
        
        while(l<=r) {
            m=(l+r)/2;
            System.out.println("l "+l+" r "+r+" m "+m);
            if(list.get(m).timestamp==timestamp) {
                System.out.println("found exact match at index "+m);
                return m;
            }
            if(list.get(m).timestamp<=timestamp){
                match=m;
                l=m+1;
            } else {
                r=m-1;
            }
        }
        System.out.println("returning match "+match);
        return match;
    }
}

class TimeStampedValue{
    public int timestamp;
    public String value;

    public TimeStampedValue(int timestamp, String value) {
        this.timestamp=timestamp;
        this.value=value;
    }
}

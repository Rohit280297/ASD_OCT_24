import java.util.*;

// class HashMap{
//     class Entry{
//         int data;
//         int val;
//     }

//     int getKey()
//     {
//         return this.data;
//     }

//     int getValue(){
//         return this.val;
//     }




// }


public class HashMapDemo {
    public static void main(String[] args)
    {
        // // DataStructure<DataType> name = new DataStructure<>():

        // // HashMap<DataTypeOfKey, DataTypeOfValue> map = new HashMap<>();
        // HashMap<String, Integer> map = new HashMap<>(); // initializes an empty hashmap of capacity 16.
        // // HashMap<String, Integer> map2 = new HashMap<>(10);
        // // HashMap<String, Integer> map3 = new HashMap<>(10, 0.6f);

        // // methods of a hashmap.
        // // put()
        // map.put("abc", 1);// map.put(key, value)
        // map.put("bcdf", 2);
        // map.put("casdfkg", 3);
        // map.put("ddkfg", 4);
        // map.put("easdg", 5);
        // // keySet() : returns a set of all the keys in the hashmap.
        // for(String key : map.keySet())
        // {
        //     System.out.println(key+" "+map.get(key));
        // }
        // // get(key) : returns the value corresponding the key.
        // // System.out.println(map.get("casddvfkg"));
        // // containsKey(key) : returns true if the key is present in the hashmap else returns false.
        // // System.out.println(map.containsKey("absdc"));
        // // containsValue(value) : returns true if the value is present in the hashmap else returns false.
        // // System.out.println(map.containsValue(10));


        // System.out.println("Adding duplicate key");
        // map.put("abc", 10);
        // for(String key : map.keySet())
        // {
        //     System.out.println(key+" "+map.get(key));
        // }

        // for(Integer val : map.values())
        // {
        //    System.out.println("Value is : "+val); 
        // }

        // // entrySet() : entry (key, value)
        // System.out.println(map.entrySet());

        // // remove(key) : removes a particular key from the hashmap.
        // map.remove("abc");
        // System.out.println("After removing a key");
        // for(String key : map.keySet())
        // {
        //     System.out.println(key+" "+map.get(key));
        // }

        // // size() : returns you the number of key value pairs present.

        int[] arr = {5,1,2,6,5,3,7,3,8,4,5,6};
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(freq.containsKey(arr[i]))
            {
                // int getFreq = freq.get(arr[i]); // return the current freq of arr[i];
                freq.put(arr[i], 1 + freq.get(arr[i]));
            }
            else{
                freq.put(arr[i], 1);
            }
        }

        for(HashMap.Entry<Integer, Integer> entry : freq.entrySet())
        {
            System.out.println(entry.getKey() +" "+ entry.getValue());
        }
    }
}

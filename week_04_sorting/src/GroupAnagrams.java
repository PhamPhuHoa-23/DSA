import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    // https://leetcode.com/problems/group-anagrams/description/

    public static void main(String[] args) {

    }

    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> myHashMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            if (!myHashMap.containsKey(key)) {
                myHashMap.put(key, new ArrayList<>());
            }

            myHashMap.get(key).add(str);
        }
        return new ArrayList<>(myHashMap.values());
    }


}

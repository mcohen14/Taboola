import java.nio.file.*;
import java.util.*;

public class JSONParser {
    public static Map<String, Object> parse(String json) {
        json = json.replaceAll("\\s", "");
        json = json.replaceAll("\"", "");
        Map<String, Object> map = new HashMap<String, Object>();
        int i = 1;
        while(json.charAt(i) != '}') {
            String key = json.substring(i, json.indexOf(':', i));
            i += key.length()+1;
            String val = "";
            if(json.charAt(i) == '{'){
                val = json.substring(i, json.indexOf('}', i) + 1);
                map.put(key, parse(val));
                i += val.length();
            }else{
                while(json.charAt(i) != ',' && json.charAt(i) != '}') {
                    val += json.charAt(i);
                    i++;
                }
                map.put(key, val);
            }
            if(json.charAt(i) == ',') {
                i++;
            }
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("src/example.json")));
        System.out.println(parse(json));
    }
}

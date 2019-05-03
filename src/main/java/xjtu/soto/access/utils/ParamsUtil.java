package xjtu.soto.access.utils;

import java.util.HashMap;
import java.util.Map;

public class ParamsUtil {
    public static Map<String, String> parse(String params) {
        String[] param = params.split("&");
        Map<String, String> paramMap = new HashMap<>();
        for (String s : param
                ) {
            paramMap.put(s.split("=")[0], s.split("=")[1]);
        }
        return paramMap;
    }
}

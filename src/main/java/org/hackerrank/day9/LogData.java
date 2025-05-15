package org.hackerrank.day9;

import java.util.*;

public class LogData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> logs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                row.add(sc.next());
            }
            logs.add(row);
        }

        List<List<String>> res=extractErrorLogs(logs);

        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

    static List<List<String>> extractErrorLogs(List<List<String>> logs){
        List<List<String>> res=new ArrayList<>();
        for(List<String> l :logs){
            if(l.get(2).equals("ERROR") || l.get(2).equals("CRITICAL")){
                res.add(l);
            }
        }

        Collections.sort(res, new Comparator<List<String>>() {
            @Override
                public int compare(List<String> a, List<String> b) {
                    String s1=convertToString(a.get(0), a.get(1));
                    String s2=convertToString(b.get(0), b.get(1));
                    return s1.compareTo(s2);
                }
        });

        return res;
    }

    private static String convertToString(String date, String time) {
        String[] d = date.split("-");
        String[] t = time.split(":");

        return d[2]+d[1]+d[0]+t[0]+t[1];
    }
}

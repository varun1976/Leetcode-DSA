class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        for(List<String> list:knowledge){
            map.put(list.get(0),list.get(1));
        }

        StringBuilder res=new StringBuilder();
        int n=s.length();
        int i=0;
        while(i<n){
            char ch=s.charAt(i);
            if(ch=='('){
                i++;
                int start=i,end=-1;
                while(s.charAt(i)!=')') i++;
                end=i;
                String key=s.substring(start,end);
                if(map.containsKey(key)) res.append(map.get(key));
                else res.append("?");
            }
            else{
                res.append(s.charAt(i));
            }
            i++;
        }
        return res.toString();
    }
}
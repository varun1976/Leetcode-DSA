class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder res=new StringBuilder();
        int n=title.length();
        int ind=0,space=-1;
        while(ind<n){
            space=title.indexOf(' ',ind+1);
            if(space==-1) space=n;
            if(space-ind>2){
                res.append(Character.toUpperCase(title.charAt(ind)));
                ind++;
                while(ind<n && ind<=space){
                    res.append(Character.toLowerCase(title.charAt(ind)));
                    ind++;
                }
            }
            else{
                while(ind<n && ind<=space){
                    res.append(Character.toLowerCase(title.charAt(ind)));
                    ind++;
                }
            }
        }


        // res.append(Character.toUpperCase(title.charAt(ind)));
        // ind++;
        // while(ind<n){
        //     res.append(Character.toLowerCase(title.charAt(ind)));
        //     ind++;
        // }


        return res.toString();
    }
}
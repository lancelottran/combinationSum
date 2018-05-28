String combinationSum(int[] a, int sum) {
    Arrays.sort(a);
    HashSet<Integer> unique = new HashSet<>();
    
    for(int i = 0; i < a.length; i++)
        unique.add(a[i]);
    Integer[] array = unique.toArray(new Integer[0]);
    StringBuilder res = new StringBuilder();
    StringBuilder com = new StringBuilder();
    com.append("(");
    
    String re = sum(array, sum, 0, res, com).toString();
    
    if(re.length() == 0)
        re = "Empty";
    
    return re;
}

StringBuilder sum(Integer[] a, int curr, int start, StringBuilder res, StringBuilder com){
    if(curr == 0){
        StringBuilder temp = new StringBuilder(com);
        temp.setLength(temp.length()-1);
        res.append(temp.append(")").toString());
        return res;
    }
    
    if(curr < 0)
        return res;
    
    for(int i = start; i < a.length; i++){
        com.append(a[i] + " ");
        sum(a, curr-a[i], i, res, com);
        com.setLength(com.length()-2);
    }
    
    return res;
}

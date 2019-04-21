class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                int pos1 = log1.indexOf(' ');
                int pos2 = log2.indexOf(' ');
                
                char ch1 = log1.charAt(pos1 + 1);
                char ch2 = log2.charAt(pos2 + 1);
                
                boolean isDigit1 = Character.isDigit(ch1);
                boolean isDigit2 = Character.isDigit(ch2);
                
                if (!isDigit1 && !isDigit2) {
                    int preCompute = log1.substring(pos1 + 1).compareTo(log2.substring(pos2 + 1));
                    if (preCompute != 0) {
                        return preCompute;
                    }
                    return log1.substring(0, pos1).compareTo(log2.substring(0, pos2));
                }
                
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            }
        };
        
        Arrays.sort(logs, comp);
        return logs;
    }
}
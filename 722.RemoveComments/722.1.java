class Solution {
    public List<String> removeComments(String[] source) {
        if (source == null || source.length == 0) {
            return new ArrayList<>();
        }
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        // 主要是记录block
        boolean mode = false;
        
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (mode) {
                    if (line.charAt(i) == '*' && i < line.length() - 1 && line.charAt(i + 1) == '/') {
                        mode = false;
                        //skip '/' on next iteration of i
                        i++;
                    }
                } else {
                    if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i + 1) == '*') {
                        mode = true;
                        //skip '*' on next iteration of i
                        i++;
                    } else if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i + 1) == '/') {
                        //ignore remaining characters in this line
                        break;
                    } else {
                        // not a comment
                        sb.append(line.charAt(i));
                    }
                }
            }
            
            // not to insert empty lines in the result
            if (!mode && sb.length() > 0) {
                result.add(sb.toString());
                //reset for next line of source code
                sb = new StringBuilder();
            }
        }
        
        return result;
    }
}
class FileSystem {
    class File {
        public boolean isFile;
        public Map<String, File> children;
        public String content;
        
        public File() {
            children = new HashMap<>();
            content = "";
        }
    }
    
    private File root;
    
    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        
        if (path == null || path.length() == 0) {
            return result;
        }
        
        String[] dirs = path.split("/");
        File node = root;
        String name = "";
        
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            
            if (!node.children.containsKey(dir)) {
                return result;
            }
            
            node = node.children.get(dir);
            name = dir;
        }
        
        if (node.isFile) {
            result.add(name);
        } else {
            for (String n : node.children.keySet()) {
                result.add(n);
            }
        }
        
        Collections.sort(result);
        return result;
    }
    
    public void mkdir(String path) {
        if (path == null || path.length() == 0) {
            return;
        }
        
        String[] dirs = path.split("/");
        File node = root;
        
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }

            if (!node.children.containsKey(dir)) {
                node.children.put(dir, new File());
            }
            
            node = node.children.get(dir);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        if (filePath == null || filePath.length() == 0) {
            return;
        }
        
        String[] dirs = filePath.split("/");
        File node = root;
        
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }

            if (!node.children.containsKey(dir)) {
                node.children.put(dir, new File());
            }
            
            node = node.children.get(dir);
        }
        
        node.isFile = true;
        node.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        if (filePath == null || filePath.length() == 0) {
            return "";
        }
        
        String[] dirs = filePath.split("/");
        File node = root;
        
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }

            if (!node.children.containsKey(dir)) {
                node.children.put(dir, new File());
            }
            
            node = node.children.get(dir);
        }

        return node.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
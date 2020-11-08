class Logger {
    Set<String> set;
    Queue<Log> queue;

    /** Initialize your data structure here. */
    public Logger() {
        set = new HashSet<>();
        queue = new LinkedList<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && timestamp - queue.peek().timestamp >= 10) {
            Log log = queue.poll();
            set.remove(log.message);
        }
        
        if (set.contains(message)) {
            return false;
        }
        set.add(message);
        queue.offer(new Log(timestamp, message));
        return true;
    }
}

class Log {
    int timestamp;
    String message;
    public Log(int timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
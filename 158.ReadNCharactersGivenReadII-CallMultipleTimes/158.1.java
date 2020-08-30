/**
buffered reading:
buf[] is a user buffer where we strore result to. Basic idea is we create a internal buffer (buff) and every time we read from file, we read from this internal buffer first to avoid expensive system call( here you can imagine sys call is read4()).
**/

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private int buffPointer = 0;
    private int buffCount = 0;
    private char[] buff = new char[4];

    public int read(char[] buf, int n) {
        int pointer = 0;
        while (pointer < n) {
            if (buffPointer == 0) {
                buffCount = read4(buff);
            }
            
            while (pointer < n && buffPointer < buffCount) {
                buf[pointer++] = buff[buffPointer++];
            }
            
            // all chars in buff used up, set pointer to 0
            if (buffPointer == buffCount) {
                buffPointer = 0;
            }
            
            // read4 returns less than 4, end of remote file
            if (buffCount < 4) {
                break;
            }
        }
        
        return pointer;
    }
}
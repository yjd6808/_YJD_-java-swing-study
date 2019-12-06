package book_manager_server;

/**
*
* @author jungdo
*/
public enum OpCode {
       NONE(-1),
       LOGIN(8580000),
       REGISTER(8580001);
       
        private final int value;
        private OpCode(int value) {
           this.value = value;
       }

       public int getValue() {
           return value;
       }
 }
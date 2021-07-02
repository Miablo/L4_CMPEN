public class UDPClient {
    /** Host to ping */
    String remoteHost;

    /** Port number of remote host */
    int remotePort;

    /** How many pings to send */

    static final int NUM_PINGS = 10;

    /** How many reply pings have we received */

    int numReplies = 0;

    /** Array for holding replies and RTTs */

    static boolean[] replies = new boolean[NUM_PINGS];

    static long[] rtt = new long[NUM_PINGS];

    /* Send our own pings at least once per second. If no replies received

     within 5 seconds, assume ping was lost. */

    /** 1 second timeout for waiting replies */

    static final int TIMEOUT = 1000;

    /** 5 second timeout for collecting pings at the end */

    static final int REPLY_TIMEOUT = 5000;

    /** constructor **/

    public UDPClient(String host, int port) {

        host = this.remoteHost;
        port = this.remotePort;

    }
}


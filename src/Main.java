import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * CMPEN Lab 4 UDP Ping Server
 *
 * @author Mio Diaz
 * @version 1.0
 *
 */
public class Main {
    /**
     * Main method
     * @param args port number passed from user via command line
     *
     */
    public static void main(String[] args) throws Exception {
        int port = 0;

        // Parse port number from command line
        try {

            port = Integer.parseInt(args[0]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Need one argument: port number.");

            System.exit(-1);

        } catch (NumberFormatException e) {

            System.out.println("Please give port number as integer.");

            System.exit(-1);

        }

        // Next, we create a new socket using the DatagramSocket class.
        // Create a new datagram socket at the port **/
        DatagramSocket serverSocket = new DatagramSocket(port);
        byte[] receiveData = new byte[512];
        byte[] sendData = new byte[512];

        // Let the user know the server is running
        System.out.println("The UDP server is listening on port " + port);


        // Create a new datagram packet and let the socket receive it
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);

        // Print the message received
        String sentence = new String(receivePacket.getData());

        if (!sentence.equals("")) {

            System.out.println(sentence.trim());

        }

        // Get the IP Address of the Sender **/
        InetAddress IPAddress = receivePacket.getAddress();

        // Get the port of the Sender **/
        int senderPort = receivePacket.getPort();

        // Prepare the data to send back **/
        sendData = receiveData;

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, senderPort);

        // Send the packet **/
        serverSocket.send(sendPacket);

    }



}

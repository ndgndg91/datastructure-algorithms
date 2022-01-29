package systemcall;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InformationMaintenance {

    public static void main(String[] args) {
        printCurrentProcessId();
        printHostname();
    }

    private static void printCurrentProcessId() {
        long pid = ProcessHandle.current().pid();
        System.out.println("current pid is : " + pid);
    }

    private static void printHostname() {
        try {
            final var addr = InetAddress.getLocalHost();
            final var hostname = addr.getHostName();
            System.out.println(hostname);
        } catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }
    }
}

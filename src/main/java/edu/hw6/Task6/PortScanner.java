package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"MagicNumber", "RegexpSinglelineJava"})
public class PortScanner {

    private PortScanner() {
    }

    private final static int MAX_PORT = 49151;
    private final static int MIN_PORT = 0;
    private final static String HEADER = "%-10s %-8s %s\n";
    private static final Map<Integer, String> PORT_DICTIONARY = new HashMap<>();

    static {
        PORT_DICTIONARY.put(5432, "PostgreSQL Database");
        PORT_DICTIONARY.put(3389, "Remote Desktop Protocol (RDP)");
        PORT_DICTIONARY.put(27017, "MongoDB Database");
        PORT_DICTIONARY.put(53, "DNS (Domain Name System)");
        PORT_DICTIONARY.put(443, "HTTPS (HyperText Transfer Protocol Secure)");
        PORT_DICTIONARY.put(22, "SSH (Secure Shell)");
        PORT_DICTIONARY.put(25, "SMTP (Simple Mail Transfer Protocol)");
        PORT_DICTIONARY.put(21, "FTP (File Transfer Protocol)");
        PORT_DICTIONARY.put(80, "HTTP (HyperText Transfer Protocol)");
        PORT_DICTIONARY.put(
            23,
            "Telnet (Telnet protocol to ensure effective communication along with the remote server)"
        );
        PORT_DICTIONARY.put(110, "POP3 (Post Office Protocol version 3 for email retrieval)");
        PORT_DICTIONARY.put(143, "IMAP (Internet Message Access Protocol for email retrieval)");
        PORT_DICTIONARY.put(67, "DHCP (Dynamic Host Configuration Protocol for IP address allocation)");
        PORT_DICTIONARY.put(68, PORT_DICTIONARY.get(67));
        PORT_DICTIONARY.put(123, "NTP (Network Time Protocol for time synchronization)");
        PORT_DICTIONARY.put(
            161,
            "SNMP (Simple Network Management Protocol to verify the "
            + "functionality of the network and management of network)"
        );
        PORT_DICTIONARY.put(162, PORT_DICTIONARY.get(161));
        PORT_DICTIONARY.put(445, "SMB (Server Message Block protocol for file sharing and printer sharing)");
        PORT_DICTIONARY.put(548, "AFP (Apple Filing Protocol for file sharing between Macs)");
        PORT_DICTIONARY.put(137, "NetBIOS (NetBIOS protocol for network communication between Windows devices)");
        PORT_DICTIONARY.put(138, PORT_DICTIONARY.get(137));
        PORT_DICTIONARY.put(139, PORT_DICTIONARY.get(137));
        PORT_DICTIONARY.put(8080, "HTTP Proxy (HTTP proxy server)");
        PORT_DICTIONARY.put(1080, "SOCKS (SOCKS proxy server)");
        PORT_DICTIONARY.put(3306, "MySQL (MySQL database server)");
        PORT_DICTIONARY.put(1433, "MSSQL (Microsoft SQL Server database server)");
        PORT_DICTIONARY.put(1521, "Oracle (Oracle database server)");
        PORT_DICTIONARY.put(389, "LDAP (Lightweight Directory Access Protocol for directory services)");
        PORT_DICTIONARY.put(636, PORT_DICTIONARY.get(389));
        PORT_DICTIONARY.put(5722, "SMB2 (SMB version 2 protocol)");
        PORT_DICTIONARY.put(500, "IKE (Internet Key Exchange protocol for VPN connections)");
        PORT_DICTIONARY.put(1701, "L2TP (Layer 2 Tunneling Protocol for VPN connections)");
        PORT_DICTIONARY.put(1723, "PPTP (Point-to-Point Tunneling Protocol for VPN connections)");
        PORT_DICTIONARY.put(5060, "SIP (Session Initiation Protocol for VoIP communication)");
        PORT_DICTIONARY.put(5061, PORT_DICTIONARY.get(5060));
        PORT_DICTIONARY.put(3128, "HTTPS Proxy (HTTPS proxy server)");
        PORT_DICTIONARY.put(5900, "VNC (Virtual Network Computing for remote access)");
        PORT_DICTIONARY.put(6667, "IRC (Internet Relay Chat for real-time communication)");
        PORT_DICTIONARY.put(6697, PORT_DICTIONARY.get(6667));
        PORT_DICTIONARY.put(2049, "NFS (Network File System for file sharing)");
        PORT_DICTIONARY.put(6379, "Redis (Redis key-value store)");
        PORT_DICTIONARY.put(11211, "Memcached (Memcached distributed memory caching system)");
        PORT_DICTIONARY.put(873, "Rsync (Remote synchronization for file transfers)");
        PORT_DICTIONARY.put(5353, "Zeroconf (Zero Configuration Networking for automatic network configuration)");
        PORT_DICTIONARY.put(5222, "XMPP (Extensible Messaging and Presence Protocol for instant messaging)");
        PORT_DICTIONARY.put(5223, PORT_DICTIONARY.get(5222));
    }

    public static void scanPorts() {
        System.out.println("Запуск сканирования портов: " + MIN_PORT + "-" + MAX_PORT);
        System.out.printf(HEADER, "Протокол", "Порт", "Сервис");
        String portInfo;

        for (int port = MIN_PORT; port < MAX_PORT; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();
            } catch (IOException ignored) {
                if (PORT_DICTIONARY.containsKey(port)) {
                    portInfo = PORT_DICTIONARY.get((port));
                } else {
                    portInfo = "";
                }
                System.out.printf(HEADER.formatted("TCP", port, portInfo));
            }
            try {
                DatagramSocket datagramSocket = new DatagramSocket(port);
                datagramSocket.close();

            } catch (IOException ignored) {
                if (PORT_DICTIONARY.containsKey(port)) {
                    portInfo = PORT_DICTIONARY.get((port));
                } else {
                    portInfo = "";
                }
                System.out.printf(HEADER.formatted("UDP", port, portInfo));
            }
        }
        System.out.println("\n\nСканирование завершено");
    }
}

package ds.Temperature;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ds.Temperature.TemperatureGrpc.TemperatureBlockingStub;
import ds.Temperature.TemperatureGrpc.TemperatureStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

/* Unfinished GUI - I sadly didn't have enough time to finish the GUI files for the code, due to my own error.
This GUI files also includes the code for service discovery */

public class TemperatureGUI {

    private static TemperatureBlockingStub blockingStub;
    private static TemperatureStub asyncStub;

    private ServiceInfo temperatureServiceInfo;


    private JFrame frame;
    private JTextField textNumber1;
    private JTextField textNumber2;
    private JTextArea textResponse ;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TemperatureGUI window = new TemperatureGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TemperatureGUI() {

        String temperature_service_type = "_temperature._tcp.local.";
        discoverTemperatureService(temperature_service_type);



        String host = temperatureServiceInfo.getHostAddresses()[0];
        int port = temperatureServiceInfo.getPort();


        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();

        //stubs -- generate from proto
        blockingStub = TemperatureGrpc.newBlockingStub(channel);

        asyncStub = TemperatureGrpc.newStub(channel);

        initialize();
    }



    private void discoverTemperatureService(String service) {


        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());


            jmdns.addServiceListener(service, new ServiceListener() {

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Storage Service resolved: " + event.getInfo());

                    temperatureServiceInfo = event.getInfo();

                    int port = temperatureServiceInfo.getPort();

                    System.out.println("resolving " + "_storage._tcp.local." + " with properties ...");
                    System.out.println("\t port: " + port);
                    System.out.println("\t type:"+ event.getType());
                    System.out.println("\t name: " + event.getName());
                    System.out.println("\t description/properties: " + temperatureServiceInfo.getNiceTextString());
                    System.out.println("\t host: " + temperatureServiceInfo.getHostAddresses()[0]);


                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Storage Service removed: " + event.getInfo());


                }

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Storage Service added: " + event.getInfo());


                }
            });

            // Wait a bit
            Thread.sleep(2000);

            jmdns.close();

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }




    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Lighting - Service Controller");
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        frame.getContentPane().setLayout(bl);

        JPanel panel_service_1 = new JPanel();
        frame.getContentPane().add(panel_service_1);
        panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Room");
        panel_service_1.add(lblNewLabel_1);

        textNumber1 = new JTextField();
        panel_service_1.add(textNumber1);
        textNumber1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("On/Off");
        panel_service_1.add(lblNewLabel_2);

        boolean selectedValue;

        JComboBox comboOperation = new JComboBox();
        comboOperation.setModel(new DefaultComboBoxModel(new String[] {"ON", "OFF"}));
        panel_service_1.add(comboOperation);



        JButton btnCalculate = new JButton("SET");
        panel_service_1.add(btnCalculate);

        textResponse = new JTextArea(3, 20);
        textResponse .setLineWrap(true);
        textResponse.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textResponse);

        //textResponse.setSize(new Dimension(15, 30));
        panel_service_1.add(scrollPane);


        JPanel panel_service_2 = new JPanel();
        frame.getContentPane().add(panel_service_2);

        JPanel panel_service_3 = new JPanel();
        frame.getContentPane().add(panel_service_3);

    }

}

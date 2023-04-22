package ds.Lighting;


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

import ds.Lighting.LightingServiceGrpc.LightingServiceBlockingStub;
import ds.Lighting.LightingServiceGrpc.LightingServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class LightingGUI {

    private static LightingServiceBlockingStub blockingStub;
    private static LightingServiceStub asyncStub;

    private ServiceInfo lightingServiceInfo;


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
                    LightingGUI window = new LightingGUI();
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
    public LightingGUI() {

        String lighting_service_type = "_lighting._tcp.local.";
        discoverLightingService(lighting_service_type);


        /*
        String host = lightingServiceInfo.getHostAddresses()[0];
        int port = lightingServiceInfo.getPort();
         */

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        //stubs -- generate from proto
        blockingStub = LightingServiceGrpc.newBlockingStub(channel);

        asyncStub = LightingServiceGrpc.newStub(channel);

        initialize();
    }



    private void discoverLightingService(String service) {


        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());


            jmdns.addServiceListener(service, new ServiceListener() {

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Lighting Service resolved: " + event.getInfo());

                    lightingServiceInfo = event.getInfo();

                    int port = lightingServiceInfo.getPort();

                    System.out.println("resolving " + "_lighting._tcp.local." + " with properties ...");
                    System.out.println("\t port: " + port);
                    System.out.println("\t type:"+ event.getType());
                    System.out.println("\t name: " + event.getName());
                    System.out.println("\t description/properties: " + lightingServiceInfo.getNiceTextString());
                    System.out.println("\t host: " + lightingServiceInfo.getHostAddresses()[0]);


                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Lighting Service removed: " + event.getInfo());


                }

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Lighting Service added: " + event.getInfo());


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
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int num1 = Integer.parseInt(textNumber1.getText());
                boolean num2;

                if (comboOperation.getSelectedIndex()==0){
                    num2=true;
                } else {
                    num2 = false;
                }

                LightingClient.setRoomLighting(num1, num2);



            }
        });
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

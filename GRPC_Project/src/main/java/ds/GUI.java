package ds;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import ds.Lighting.LightingServiceGrpc;
import ds.Lighting.LightingServiceGrpc.LightingServiceBlockingStub;
import ds.Lighting.LightingServiceGrpc.LightingServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class GUI {

    private ServiceInfo lightingServiceInfo;
    private static LightingServiceBlockingStub blockingStub;
    private static LightingServiceStub asyncStub;


    private JFrame frame;
    private JTextField textNumber1;
    private JTextField textNumber2;
    private JTextArea textResponse ;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GUI() {

        String lighting_service_type = "_lighting._tcp.local.";
        discoverLightingService(lighting_service_type);

        String host = lightingServiceInfo.getHostAddresses()[0];
        int port = lightingServiceInfo.getPort();

       /* ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();

        //stubs -- generate from proto
        blockingStub = LightingServiceGrpc.newBlockingStub(channel);

        asyncStub = LightingServiceGrpc.newStub(channel);


       // initialize();*/
    }

    /*
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Client - Service Controller");
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        frame.getContentPane().setLayout(bl);

        JPanel panel_service_1 = new JPanel();
        frame.getContentPane().add(panel_service_1);
        panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Number 1");
        panel_service_1.add(lblNewLabel_1);

        textNumber1 = new JTextField();
        panel_service_1.add(textNumber1);
        textNumber1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Number 2");
        panel_service_1.add(lblNewLabel_2);

        textNumber2 = new JTextField();
        panel_service_1.add(textNumber2);
        textNumber2.setColumns(10);


        JComboBox comboOperation = new JComboBox();
        comboOperation.setModel(new DefaultComboBoxModel(new String[] {"ADDITION", "SUBTRACTION", "MULTIPLICATION", "DIVISION"}));
        panel_service_1.add(comboOperation);


        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int num1 = Integer.parseInt(textNumber1.getText());
                int num2 = Integer.parseInt(textNumber2.getText());

                int index = comboOperation.getSelectedIndex();
                Operation operation = Operation.forNumber(index);

                CalculateRequest req = CalculateRequest.newBuilder().setNumber1(num1).setNumber2(num2).setOperation(operation).build();

                CalculateResponse response = blockingStub.calculate(req);

                textResponse.append("reply:"+ response.getResult() + " mes:"+ response.getMessage() + "\n");

                System.out.println("res: " + response.getResult() + " mes: " + response.getMessage());

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



    } */




    private void discoverLightingService(String service_type) {


        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());


            jmdns.addServiceListener(service_type, new ServiceListener() {

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Lighting Service resolved: " + event.getInfo());

                    lightingServiceInfo = event.getInfo();

                    int port = lightingServiceInfo.getPort();

                    System.out.println("resolving " + service_type + " with properties ...");
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
}

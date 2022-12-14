import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;

public class Main extends JFrame {

    private JMenuBar jMenuBar;
    private Workspace workSpace;
    private JMenuItem New, save, load;
    private JMenu fileMenu;
    private JMenu connectionsMenu;
    private JMenu actionMenu;
    private JMenuItem TSP, TspPro, Clustering, UserConnect;
    private JMenuItem move, create, connect;
    private AbstractFactory cityFactory;
    private JLabel status;

    /**
     * <p>This is the constructor</p>
     */
    public Main() {
        jMenuBar = new JMenuBar();
        workSpace = new Workspace();
        cityFactory = new CityFactory();
        getContentPane().add(workSpace);
        
        status = new JLabel("status : idle");
        
        status.setHorizontalAlignment(SwingConstants.CENTER);
        status.setVerticalAlignment(SwingConstants.BOTTOM);
        workSpace.add(status);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fileMenu = new JMenu("File");
        connectionsMenu = new JMenu("Connections");
        actionMenu = new JMenu("Action");
        New = new JMenuItem("new");
        save = new JMenuItem("save");
        load = new JMenuItem("load");
        TSP = new JMenuItem("TSP");
        TspPro = new JMenuItem("TSP-Pro");
        Clustering = new JMenuItem("Cluster");
        UserConnect = new JMenuItem("User Connect");
        move = new JMenuItem("Move");
        create = new JMenuItem("create");
        connect = new JMenuItem("connect");
        jMenuBar.add(fileMenu);
        jMenuBar.add(connectionsMenu);
        jMenuBar.add(actionMenu);
        fileMenu.add(save);
        fileMenu.add(load);
        fileMenu.add(New);
        connectionsMenu.add(TSP);
        connectionsMenu.add(TspPro);
        connectionsMenu.add(Clustering);
        connectionsMenu.add(UserConnect);
        actionMenu.add(move);
        actionMenu.add(create);
        actionMenu.add(connect);
        this.setJMenuBar(jMenuBar);
        this.setVisible(true);
    }

    /**
     * <p>This function is the entrance to run the function</p>
     * @param args
     */
    public static void main(String args[]){
        new Main().init();
    }


    /**
     * This is the function to add the menulistener to delete, save and load.
     */
    public void init(){
        TSP.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
            	status.setText("TSP running");
                workSpace.setCanConnect(true);
                workSpace.setCanMove(true);
                workSpace.setCanCreate(true);
                workSpace.handleRequest(1);
                status.setText("TSP completed");
            }
        });

        TspPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	status.setText("TSP Pro running");
                workSpace.setCanConnect(true);
                workSpace.setCanMove(true);
                workSpace.setCanCreate(true);
                workSpace.handleRequest(2);
                status.setText("TSP Pro completed");
            }
        });

        Clustering.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	status.setText("Clustering running");
                workSpace.setCanConnect(true);
                workSpace.setCanMove(true);
                workSpace.setCanCreate(true);
                workSpace.handleRequest(3);
                status.setText("Clustering completed");
            }
        });

        UserConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	status.setText("User connect mode");
                workSpace.handleUserConnect();
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	status.setText("file saved");
                CitiesList.getInstance().saveFile();
            }
        });

        New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workSpace.newPanel();
                status.setText("screen cleared");
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader fileReader = new FileReader("testCities.txt");
                    BufferedReader br = new BufferedReader(fileReader);
                    String a;
                    int i = 0;
                    while((a=br.readLine())!=null){
                        String[] info = a.split(" ");
                        String name = info[0];
                        System.out.println(name);
                        int  x = Integer.parseInt(info[1]);
                        int  y = Integer.parseInt(info[2]);
                        City city = cityFactory.getCity(name,x,y);
                        CitiesList.getInstance().addNewCity(city);
                        i++;
                    }
                    if(i>0) {
                        workSpace.handleRequest(1);
                    }
                    br.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	status.setText("current mode: move");
                workSpace.moveAbled();
            }
        });

        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	status.setText("current mode: connect");
                workSpace.connectAbled();
            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	status.setText("current mode: create");
                workSpace.createAbled();
            }
        });


        }
}

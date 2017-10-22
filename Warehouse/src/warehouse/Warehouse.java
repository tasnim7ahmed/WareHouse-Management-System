/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Warehouse extends JFrame{

    public static Account account = new Account();
    public static Login login = new Login();
    public static Create create = new Create();
    public static AddItem add = new AddItem();
    public static View view = new View();
    public static Sales sales = new Sales();
    Warehouse()
    {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("WAREHOUSE MANAGEMENT SYSTEM");
        this.add(account, BorderLayout.CENTER);
        this.pack();
        this.validate();
        this.setVisible(true);

        setAction();
    }
    public void setAction()
    {
        account.jButton2.addActionListener(e->{
            login.jPasswordField1.setText("");
            login.jTextField1.setText("");
         this.remove(account);
            this.add(login, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            this.pack();
        });
        account.jButton1.addActionListener(e->{
            create.jTextField3.setText("");
            create.jTextField4.setText("");
            create.jTextField6.setText("");
         this.remove(account);
            this.add(create, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            this.pack();
        });
        login.jButton2.addActionListener(e->{

         this.remove(login);
            this.add(account, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            this.pack();
        });
        create.jButton2.addActionListener(e->{

         this.remove(create);
            this.add(account, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            this.pack();
        });
        add.jButton2.addActionListener(e->{
login.jPasswordField1.setText("");
            login.jTextField1.setText("");
         this.remove(add);
            this.add(login, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            this.pack();
        });
        sales.jButton2.addActionListener(e->{
login.jPasswordField1.setText("");
            login.jTextField1.setText("");
         this.remove(sales);
            this.add(login, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            this.pack();
        });
        view.jButton2.addActionListener(e->{

         this.remove(view);
            this.add(add, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            this.pack();
        });
        login.jButton4.addActionListener(e->{

         String username = login.jTextField1.getText();
         String password = login.jPasswordField1.getText();
         
         try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","warehouse","123");
            Statement st = con.createStatement();
            String query = "Select * from admin";
            ResultSet rs = st.executeQuery(query);
            int flag = 0;
            while(rs.next())
            {
               
                String usr = rs.getString(2);
                String pass = rs.getString(3);
                if(usr.equals(username) && pass.equals(password))
                { flag=1;
                    add.jLabel2.setText(rs.getString(1));
                    this.remove(login);
                    this.add(add, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
                    login.jTextField1.setText("");
                    login.jPasswordField1.setText("");
                    break;
                }
            }
            rs.close();
            st.close();
            con.close();
            if(flag==0)
            {
                JOptionPane.showMessageDialog(null,"Username or Password doesn't match, Try Again!" ,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        });
        
        login.jButton3.addActionListener(e->{

         String username = login.jTextField1.getText();
         String password = login.jPasswordField1.getText();
         
         try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","warehouse","123");
            Statement st = con.createStatement();
            String query = "Select * from sales";
            ResultSet rs = st.executeQuery(query);
            int flag = 0;
            while(rs.next())
            {
                String usr = rs.getString(2);
                String pass = rs.getString(3);
                if(usr.equals(username) && pass.equals(password))
                {flag=1;
                    sales.jLabel2.setText(rs.getString(1));
                    this.remove(login);
                    this.add(sales, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
                    login.jTextField1.setText("");
                    login.jPasswordField1.setText("");
                    break;
                }
            }
            rs.close();
            st.close();
            con.close();
            if(flag==0)
            {
                JOptionPane.showMessageDialog(null,"Username or Password doesn't match, Try Again!" ,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        });
        create.jButton3.addActionListener(e->{
            String name = create.jTextField3.getText();
            String username = create.jTextField4.getText();
            String password = create.jTextField6.getText();
            
            try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","warehouse","123");
            Statement st = con.createStatement();
            String query = "Insert into sales values ( '"+name+"','"+username+"','"+password+"')";
            ResultSet rs = st.executeQuery(query);
            query = "commit";
            rs = st.executeQuery(query);
            rs.close();
            st.close();
            con.close();
create.jTextField3.setText("");
  create.jTextField4.setText("");
   create.jTextField6.setText("");
            JOptionPane.showMessageDialog(null," Account Successfully Created!" ,"Done!",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        });
        
        
        create.jButton4.addActionListener(e->{
            String name = create.jTextField3.getText();
            String username = create.jTextField4.getText();
            String password = create.jTextField6.getText();
            
            try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","warehouse","123");
            Statement st = con.createStatement();
            String query = "Insert into admin values ( '"+name+"','"+username+"','"+password+"')";
            ResultSet rs = st.executeQuery(query);
            query = "commit";
            rs = st.executeQuery(query);
            rs.close();
            st.close();
            con.close();
create.jTextField3.setText("");
  create.jTextField4.setText("");
   create.jTextField6.setText("");
            JOptionPane.showMessageDialog(null,"Admin Account Successfully Created!" ,"Done!",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        });
        
        
        sales.jButton6.addActionListener(e->{
            String name = sales.jTextField4.getText();
            int qty  = Integer.parseInt(sales.jTextField6.getText());
            int avail = 0;
            int flag = 0;
            try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","warehouse","123");
            Statement st = con.createStatement();
            String query = "Select * from item where name = '"+name+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                flag=1;
                avail = rs.getInt(5);
                    break;
                
            }
            if(avail>=qty && flag==1){
            query = "update item set qty = "+(avail-qty)+" where name =  '"+name+"'";
            
            JOptionPane.showMessageDialog(null,"Item Successfully Sold!" ,"Done!",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(avail<qty && flag==1)
            {
                JOptionPane.showMessageDialog(null,"Not Enough Item!" ,"ERROR!",JOptionPane.ERROR_MESSAGE);
            }
            rs = st.executeQuery(query);
            query = "commit";
            rs = st.executeQuery(query);
            rs.close();
            st.close();
            con.close();

            
            if(flag==0)
            {
                 JOptionPane.showMessageDialog(null,"Item not Found!" ,"ERROR!",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         sales.jTextField4.setText("");
         sales.jTextField6.setText("");
        });
        
        
        sales.jButton7.addActionListener(e->{
            String name = sales.jTextField4.getText();
            int qty  = Integer.parseInt(sales.jTextField6.getText());
            int avail = 0;
            int flag = 0;
            try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","warehouse","123");
            Statement st = con.createStatement();
            String query = "Select * from item where name = '"+name+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                flag=1;
                avail = rs.getInt(5);
                    break;
                
            }
            if(flag==1){
            query = "update item set qty = "+(avail+qty)+" where name =  '"+name+"'";
            
            JOptionPane.showMessageDialog(null,"Item Successfully Bought!" ,"Done!",JOptionPane.INFORMATION_MESSAGE);
            }
            
            rs = st.executeQuery(query);
            query = "commit";
            rs = st.executeQuery(query);
            rs.close();
            st.close();
            con.close();

            
            if(flag==0)
            {
                 JOptionPane.showMessageDialog(null,"Item not Found!" ,"ERROR!",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         sales.jTextField4.setText("");
         sales.jTextField6.setText("");
        });
        
        
        
        
        add.jButton5.addActionListener(e->{
            String name = add.jTextField4.getText();
            String brand = add.jTextField6.getText();
            String type = add.jTextField5.getText();
            int id = (int)hash(name,brand);
            int qty = Integer.parseInt(add.jTextField7.getText());
            try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","warehouse","123");
            Statement st = con.createStatement();
            String query = "Insert into item values ( "+id+",'"+name+"','"+brand+"','"+type+"',"+qty+")";
            ResultSet rs = st.executeQuery(query);
            query = "commit";
            rs = st.executeQuery(query);
            rs.close();
            st.close();
            con.close();
add.jTextField4.setText("");
            add.jTextField6.setText("");
            add.jTextField5.setText("");
            add.jTextField7.setText("");
            JOptionPane.showMessageDialog(null,"Product Successfully Added!" ,"Done!",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        });
        add.jButton6.addActionListener(e->{
            String name = add.jTextField1.getText();

            try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","warehouse","123");
            Statement st = con.createStatement();
            String query = "Delete from item where name = '"+name+"'";
            ResultSet rs = st.executeQuery(query);
             query = "commit";
            rs = st.executeQuery(query);
            rs.close();
            st.close();
            con.close();

            JOptionPane.showMessageDialog(null,"Item Successfully Deleted!" ,"Done!",JOptionPane.INFORMATION_MESSAGE);
            add.jTextField1.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        });
        add.jButton7.addActionListener(e->{
DefaultTableModel model = (DefaultTableModel) view.jTable1.getModel();
            int row = model.getRowCount();
                while (row > 0) {
                    model.removeRow(model.getRowCount() - 1);
                    row = model.getRowCount();
                }

            try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","warehouse","123");
            Statement st = con.createStatement();
            String query = "Select * from item";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                        
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String brand = rs.getString(3);
                    String type = rs.getString(4);
                    int qty = rs.getInt(5);
                    
                        model.addRow(new Object[]{id,name,brand,type,qty});
                    }
            rs.close();
            st.close();
            con.close();
this.remove(add);
            this.add(view, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            this.pack();
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        });
        
        add.jButton8.addActionListener(e->{
            String name = add.jTextField2.getText();

            try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","warehouse","123");
            Statement st = con.createStatement();
            String query = "Delete from sales where name = '"+name+"'";
            ResultSet rs = st.executeQuery(query);
             query = "commit";
            rs = st.executeQuery(query);
            rs.close();
            st.close();
            con.close();

            JOptionPane.showMessageDialog(null,"Salesman Successfully Deleted!" ,"Done!",JOptionPane.INFORMATION_MESSAGE);
            add.jTextField2.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        });
        
    }
    public static long hash(String a, String b) {
        String str = a + b;
        long prime = 3797;
        long MOD = 1000000007;
        long Hash = 0;
        for (int i = 0; i < str.length(); i++) {
            Hash = (prime * Hash) % MOD + str.charAt(i);
            Hash = Hash % MOD;
        }
        return Hash;
    }
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
    }
    
}

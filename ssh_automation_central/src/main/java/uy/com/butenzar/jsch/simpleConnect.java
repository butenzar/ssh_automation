/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.jsch;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import java.io.FilterInputStream;
import java.io.IOException;
import static java.lang.System.in;


/**
 *
 * @author Bruno Szilagyi
 */
public class simpleConnect {
    
    
    
    public static void main(String[] arg){

    int lport;
    String rhost;
    int rport;

    try{
      
      JSch jsch=new JSch();

      //String host=null;
//      if(arg.length>0){
//        host=arg[0];
//      }
//      else{
//        host=JOptionPane.showInputDialog("Enter username@hostname",
//                                         System.getProperty("user.name")+
//                                         "@localhost"); 
//      }
      
      //SE Obtiene user y el host.
//      String user=host.substring(0, host.indexOf('@'));
//      host=host.substring(host.indexOf('@')+1);

      
      //Se pide una session al puerto de SSH.
      String user="root";
      String host="192.168.250.49";
      Integer port= 22;
      Session session = null;
      
      
  try {
        //Tratamos de iniciar una session.
        session = jsch.getSession(user, host , port);
        session.setPassword("geocom");
  }
  catch (JSchException e) {
    //throw new TransferException("Failed to open session - " + params, e);
  }
  
      // username and password will be given via UserInfo interface.
   

//  Create UserInfo instance in order to support SFTP connection to any machine 
//  without a key username and password will be given via UserInfo interface.
   UserInfo userInfo = new SftpUserInfo();
   session.setUserInfo(userInfo);


    session.connect(10000);

    boolean isSessionConnected = session.isConnected();
    
    Channel channel=session.openChannel("shell");

      // Enable agent-forwarding.
      //((ChannelShell)channel).setAgentForwarding(true);

     channel.setInputStream(System.in);
      
      // a hack for MS-DOS prompt on Windows.
//      channel.setInputStream(new FilterInputStream(System.in){
//          public int read(byte[] b, int off, int len)throws IOException{
//            return in.read(b, off, (len>1024?1024:len));
//          }
//        });
//       

      channel.setOutputStream(System.out);

      /*
      // Choose the pty-type "vt102".
      ((ChannelShell)channel).setPtyType("vt102");
      */

      /*
      // Set environment variable "LANG" as "ja_JP.eucJP".
      ((ChannelShell)channel).setEnv("LANG", "ja_JP.eucJP");
      */

      //channel.connect();
      channel.connect(3*1000);
      //Channel channel=session.openChannel("shell");
      //channel.connect();

//      int assinged_port=session.setPortForwardingL(lport, rhost, rport);
//      System.out.println("localhost:"+assinged_port+" -> "+rhost+":"+rport);
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}

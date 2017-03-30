/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserAuth;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DELL
 */
public class SSHCommand {
    @RequestMapping(value="/insert", method=RequestMethod.GET)
    public String doget(Model model){
      UserAuth user=new UserAuth(); 
      model.addAttribute("submitForm",user);
      return "index";
    }
     @RequestMapping(value="/resultat", method=RequestMethod.POST)
     public String dopost(@ModelAttribute("insertForm")UserAuth user,BindingResult result,Model model, HttpServletRequest req )
     {
         try{
	    	Session session=(Session) req.getSession().getAttribute("session");
	    	Channel channel=session.openChannel("exec");
	        ((ChannelExec)channel).setCommand(user.getCommand());
	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        
	        InputStream in=channel.getInputStream();
	        channel.connect();
                
	        byte[] tmp=new byte[1024];
	        while(true){
                    
	          while(in.available()>0){
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	           model.addAttribute("resultat",new String(tmp, 0, i));
	          }
                  
	          if(channel.isClosed()){
	          model.addAttribute("status",channel.getExitStatus());
	            break;
                    
	          }
	          try{Thread.sleep(1000);}catch(Exception e){}
	        }
	        //channel.disconnect();
	        //session.disconnect();
	        //model.addAttribute("done","DONE");
              
	    }
         catch(Exception e){
	    	e.printStackTrace();
               model.addAttribute("error","hello catch!");
               
            }
         return "insert";
     }   
    
}

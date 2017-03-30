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
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DELL
 */
@Controller
public class SSHConnect {
    
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String doget(Model model){
      UserAuth user=new UserAuth(); 
      model.addAttribute("submitForm",user);
      return "index";
    }
     @RequestMapping(value="/insert", method=RequestMethod.POST)
     public String dopost(@ModelAttribute("submitForm")UserAuth user,BindingResult result,Model model, HttpServletRequest req )
     {try
     {
        java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user.getUsername(), user.getHost(), 22);
	    	session.setPassword(user.getPassword());
	    	session.setConfig(config);
	    	session.connect();
	    	model.addAttribute("connexion","Welcome to command line web interface");
                req.getSession().setAttribute("session", session);
                return "insert";
     }
     catch(Exception e){
	    	e.printStackTrace();
                model.addAttribute("noconnexion","Connection Failed");
                return "index";
     }
         
         
     }   
    
}

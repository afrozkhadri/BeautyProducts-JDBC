package trg.talentsprint.sample;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView printHello2(ModelAndView model) throws ClassNotFoundException, SQLException {

		BeautyDao b1 = new BeautyDao();

		List<BeautyProdutcs> list = b1.getBeautyProductsList();
		model.addObject("bpList", list);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/addform")
	public String showform(Model m) {
		m.addAttribute("command", new BeautyProdutcs());
		return "addform";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)

	public String save(@ModelAttribute("bpList") BeautyProdutcs bp) {
		BeautyDao b1 = new BeautyDao();
		b1.save(bp);
		System.out.println("hello servlet");
		return "redirect:/home";

	}

	@RequestMapping("/home")
	public String viewemp(Model m) throws ClassNotFoundException, SQLException {
		BeautyDao b1 = new BeautyDao();
		List<BeautyProdutcs> list = b1.getBeautyProductsList();
		m.addAttribute("bpList", list);
		return "home";
	}
	
	@RequestMapping(value="/editform")
	public String showeditform(Model m) throws ClassNotFoundException, SQLException {
		BeautyDao b1 = new BeautyDao();
		List<BeautyProdutcs> list = b1.getBeautyProductsList();
		m.addAttribute("bpList", list);
		return "editform";
	}
	
	@RequestMapping(value="/update/{id}")    
    public String showupdateform(@PathVariable int id, Model m){  
	BeautyDao bp = new BeautyDao();
        BeautyProdutcs b=bp.getBeautyProductsId(id);    
        m.addAttribute("command",b);  
        return "updateform";    
    }  
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("bpList")  BeautyProdutcs b){    
    	BeautyDao bp = new BeautyDao();
		bp.update(b);
		return "redirect:/home";   
    }    

	 @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
			BeautyDao b1 = new BeautyDao();
	       b1.delete(id);    
	        return "redirect:/home";    
	    }     
	
}

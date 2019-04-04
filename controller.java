package trg.talentsprint.sample;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class controller {

	@RequestMapping(value = "/saveA", method = RequestMethod.POST)

	public void saveA() {
		
		System.out.println("Hello this is another Controller");
		
		

	}

}

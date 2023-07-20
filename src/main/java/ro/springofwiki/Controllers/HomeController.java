package ro.springofwiki.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.springofwiki.Models.Section;
import ro.springofwiki.Services.SectionService;

@Controller
public class HomeController {
	
	@Autowired
	SectionService sectionsService;
	
	@GetMapping("/Homepage")
	public String GetHomepage(@RequestParam(name="name", defaultValue="Explorer") String name, Model model) {
		model.addAttribute("name", name);
		List<Section> sections = sectionsService.getAllSections();
		model.addAttribute("sections", sections);
		return "Index.html";
	}
	
	@GetMapping("/Section")
	public String GetAddSection(@RequestParam(name="name", defaultValue="Explorer") String name, Model model) {
		model.addAttribute("section", new Section());
		model.addAttribute("name", name);
		return "SectionAdd.html";
	}
}

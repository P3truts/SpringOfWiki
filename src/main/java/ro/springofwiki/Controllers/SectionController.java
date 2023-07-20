package ro.springofwiki.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.springofwiki.Models.Section;
import ro.springofwiki.Services.SectionService;

@Controller
public class SectionController {

	@Autowired
	SectionService sectionsService;
	
//	@PostMapping("/SectionAdd")
//	public String addSection(@RequestParam(name="name", defaultValue="world") String name,
//			@RequestParam("title") String title, @RequestParam("description") String description,
//			@RequestParam("imageLink") String imageLink, Model model) {
//		Section section = new Section(title, description, imageLink);
//		model.addAttribute("name", name);
//		sectionsService.addSection(section);
//		return "Index.html";
//	}
	
	@PostMapping("/SectionAdd")
	public String addSection(@RequestParam(name="name", defaultValue="world") String name,
			Section section, Model model) {
		model.addAttribute("name", name);
		List<Section> sections = sectionsService.getAllSections();
		section.setId(sections.size()+1);
		sectionsService.addSection(section);
		model.addAttribute("sections", sections);
		return "Index.html";
	}
	
	@GetMapping("/SectionDel")
	public String delSection(@RequestParam(name="name", defaultValue="world") String name,
			Section section, Model model) {
		model.addAttribute("name", name);
		sectionsService.deleteSection(section.getId());
		List<Section> sections = sectionsService.getAllSections();
		model.addAttribute("sections", sections);
		return "Index.html";
	}
}

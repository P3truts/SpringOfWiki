package ro.springofwiki.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.springofwiki.Models.Section;
import ro.springofwiki.Repositories.SectionRepository;

@Service
public class SectionService {

	@Autowired
	private SectionRepository sectionRepo;

	public List<Section> getAllSections() {
		List<Section> sections = new ArrayList<>();
		sectionRepo.findAll().forEach(sections::add);
		return sections;
	}
	
	public void addSection(Section section) {
		sectionRepo.save(section);
	}
	
	public void updateSection(Integer id, Section section) {
		sectionRepo.save(section);
	}

	public void deleteSection(Integer id) {
		sectionRepo.deleteById(id);
	}
}

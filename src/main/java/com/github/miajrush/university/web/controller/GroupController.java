package com.github.miajrush.university.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.miajrush.university.model.Group;
import com.github.miajrush.university.model.Student;
import com.github.miajrush.university.service.GroupService;
import com.github.miajrush.university.service.StudentService;

import javax.validation.Valid;

import java.util.List;

/**
 * Controller used to manage {@link Group}s.
 */
@Controller
@RequestMapping("/groups")
public class GroupController {
	private static final String VIEW_CREATE_OR_UPDATE_GROUP_FORM = "groups/createOrUpdateForm";
	private final GroupService groupService;
	private final StudentService studentService;
	private Group oldGroup;
	
	@Autowired
	public GroupController(GroupService groupService, StudentService studentService) {
		this.groupService = groupService;
		this.studentService = studentService;
		
		oldGroup = null;
	}
	
	@ModelAttribute("students")
	public List<Student> findStudents() {
		return studentService.findAll();
	}
	
	@GetMapping
	public String showAll(Model model) {
		model.addAttribute("groups", groupService.findAll());
		return "groups/list";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 *
	 * @param id a {@link Group} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}")
	public String showById(@PathVariable Integer id, Model model) {
		model.addAttribute("group", groupService.findById(id));
		return "groups/details";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("group", new Group());
		return VIEW_CREATE_OR_UPDATE_GROUP_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update.
	 *
	 * @param group the {@link Group} to save
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/new")
	public String proceedCreationForm(@Valid Group group, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_GROUP_FORM;
		}
		
		groupService.save(group);
		return "redirect:/groups";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions and we need to keep the old group.
	 *
	 * @param id a {@link Group} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}/edit")
	public String initUpdateForm(@PathVariable Integer id, Model model) {
		oldGroup = groupService.findById(id);
		model.addAttribute("group", oldGroup);
		
		return VIEW_CREATE_OR_UPDATE_GROUP_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update. We need to set the name field for old group to avoid
	 * exceptions.
	 *
	 * @param group the {@link Group} to update
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}/edit")
	public String proceedUpdateForm(@Valid Group group, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_GROUP_FORM;
		}
		
		oldGroup.setName(group.getName());
		groupService.update(oldGroup);
		
		return "redirect:/groups";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions. If the list of students isn't empty, the model will add an
	 * "error" attribute and the page will update.
	 *
	 * @param id a {@link Group} id to delete
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		Group group = groupService.findById(id);
		if (group.getStudentsNumber() > 0) {
			model.addAttribute("group", group);
			model.addAttribute("error", "true");
			
			return "groups/details";
		}
		
		groupService.delete(group);
		return "redirect:/groups";
	}
}

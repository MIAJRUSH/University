package com.github.miajrush.university.web.controller;

import com.github.miajrush.university.model.Progress;
import com.github.miajrush.university.service.ProgressService;
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
import com.github.miajrush.university.model.Lesson;
import com.github.miajrush.university.model.Student;
import com.github.miajrush.university.service.GroupService;
import com.github.miajrush.university.service.StudentService;

import javax.validation.Valid;

import java.util.List;

/**
 * Controller used to manage {@link Student}s.
 */
@Controller
@RequestMapping("/students")
public class StudentController {
	private static final String VIEW_CREATE_OR_UPDATE_STUDENT_FORM = "students/createOrUpdateForm";
	private final StudentService studentService;
	private final GroupService groupService;
	private final ProgressService progressService;
	private Group oldGroup;
	
	@Autowired
	public StudentController(StudentService studentService, GroupService groupService,
	                         ProgressService progressService) {
		this.studentService = studentService;
		this.groupService = groupService;
		this.progressService = progressService;
		
		oldGroup = null;
	}
	
	@ModelAttribute("groups")
	public List<Group> findGroups() {
		return groupService.findAll();
	}
	
	@GetMapping
	public String showAll(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "students/list";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 *
	 * @param id a {@link Student} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}")
	public String showById(@PathVariable Integer id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		return "students/details";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("student", new Student());
		return VIEW_CREATE_OR_UPDATE_STUDENT_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update. We need to set the student field to avoid exceptions.
	 *
	 * @param student the {@link Student} to save
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/new")
	public String proceedCreationForm(@Valid Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_STUDENT_FORM;
		}
		
		student.setGroup(groupService.findById(student.getGroup().getId()));
		studentService.save(student);
		
		return "redirect:/students";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions and we need to keep the old student.
	 *
	 * @param id a {@link Student} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}/edit")
	public String initUpdateForm(@PathVariable Integer id, Model model) {
		Student student = studentService.findById(id);
		student.setGroup(groupService.findById(student.getGroup().getId()));
		
		oldGroup = student.getGroup();
		model.addAttribute("student", student);
		
		return VIEW_CREATE_OR_UPDATE_STUDENT_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update. We need to set the student field to avoid exceptions.
	 *
	 * @param student the {@link Student} to update
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}/edit")
	public String proceedUpdateForm(@Valid Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_STUDENT_FORM;
		}
		
		student.setGroup(groupService.findById(student.getGroup().getId()));
		studentService.update(student, oldGroup);
		
		return "redirect:/students";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 * <p>
	 * If the list of progress contains the subject, the progress will be deleted.
	 *
	 * @param student a {@link Student} to delete
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}")
	public String delete(@ModelAttribute Student student) {
		List<Progress> progress = progressService.findAll();
		for (Progress p : progress) {
			if (p.getStudent().equals(student)) {
				progressService.delete(p);
			}
		}
		
		student = studentService.findById(student.getId());
		studentService.delete(student);
		return "redirect:/students";
	}
}

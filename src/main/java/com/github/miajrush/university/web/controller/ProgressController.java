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
import com.github.miajrush.university.model.Progress;
import com.github.miajrush.university.model.Student;
import com.github.miajrush.university.model.Subject;
import com.github.miajrush.university.service.ProgressService;
import com.github.miajrush.university.service.StudentService;
import com.github.miajrush.university.service.SubjectService;

import javax.validation.Valid;

import java.util.List;

/**
 * Controller used to manage {@link Progress}.
 */
@Controller
@RequestMapping("/progress")
public class ProgressController {
	private static final String VIEW_CREATE_OR_UPDATE_PROGRESS_FORM = "progress/createOrUpdateForm";
	private final ProgressService progressService;
	private final StudentService studentService;
	private final SubjectService subjectService;
	
	@Autowired
	public ProgressController(ProgressService progressService, StudentService studentService,
	                          SubjectService subjectService) {
		this.progressService = progressService;
		this.studentService = studentService;
		this.subjectService = subjectService;
	}
	
	@ModelAttribute("students")
	public List<Student> findTeachers() {
		return studentService.findAll();
	}
	
	@ModelAttribute("subjects")
	public List<Subject> findSubjects() {
		return subjectService.findAll();
	}
	
	@GetMapping("")
	public String showAll(Model model) {
		model.addAttribute("progress", progressService.findAll());
		return "progress/list";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 *
	 * @param id a {@link Progress} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}")
	public String showById(@PathVariable Integer id, Model model) {
		model.addAttribute("progress", progressService.findById(id));
		return "progress/details";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("progress", new Progress());
		return VIEW_CREATE_OR_UPDATE_PROGRESS_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update. We need to set the fields to avoid exceptions.
	 *
	 * @param progress the {@link Progress} to save
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/new")
	public String proceedCreationForm(@Valid Progress progress, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_PROGRESS_FORM;
		}
		
		setFields(progress);
		progressService.save(progress);
		
		return "redirect:/progress";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 *
	 * @param id a {@link Progress} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}/edit")
	public String initUpdateForm(@PathVariable Integer id, Model model) {
		model.addAttribute("progress", progressService.findById(id));
		return VIEW_CREATE_OR_UPDATE_PROGRESS_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update. We need to set the fields to avoid exceptions.
	 *
	 * @param progress the {@link Progress} to update
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}/edit")
	public String proceedUpdateForm(@Valid Progress progress, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_PROGRESS_FORM;
		}
		
		setFields(progress);
		progressService.update(progress);
		
		return "redirect:/progress";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 *
	 * @param id a {@link Progress} id to delete
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		progressService.delete(progressService.findById(id));
		return "redirect:/progress";
	}
	
	/*
	 * We need to find objects by ID and set them to avoid exceptions.
	 */
	private void setFields(Progress progress) {
		progress.setStudent(studentService.findById(progress.getStudent().getId()));
		progress.setSubject(subjectService.findById(progress.getSubject().getId()));
	}
}

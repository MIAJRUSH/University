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
import com.github.miajrush.university.model.Lesson;
import com.github.miajrush.university.model.Progress;
import com.github.miajrush.university.model.Subject;
import com.github.miajrush.university.service.LessonService;
import com.github.miajrush.university.service.ProgressService;
import com.github.miajrush.university.service.SubjectService;

import javax.validation.Valid;

import java.util.List;

/**
 * Controller used to manage {@link Subject}s.
 */
@Controller
@RequestMapping("/subjects")
public class SubjectController {
	private static final String VIEW_CREATE_OR_UPDATE_SUBJECT_FORM = "subjects/createOrUpdateForm";
	private final SubjectService subjectService;
	private final LessonService lessonService;
	private final ProgressService progressService;
	
	@Autowired
	public SubjectController(SubjectService subjectService, LessonService lessonService,
	                         ProgressService progressService) {
		this.subjectService = subjectService;
		this.lessonService = lessonService;
		this.progressService = progressService;
	}
	
	@GetMapping
	public String showAll(Model model) {
		model.addAttribute("subjects", subjectService.findAll());
		return "subjects/list";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 *
	 * @param id a {@link Subject} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}")
	public String showById(@PathVariable Integer id, Model model) {
		model.addAttribute("subject", subjectService.findById(id));
		return "subjects/details";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("subject", new Subject());
		return VIEW_CREATE_OR_UPDATE_SUBJECT_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update.
	 *
	 * @param subject the {@link Subject} to save
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/new")
	public String proceedCreationForm(@Valid Subject subject, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_SUBJECT_FORM;
		}
		
		subjectService.save(subject);
		return "redirect:/subjects";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 *
	 * @param id a {@link Subject} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}/edit")
	public String initUpdateForm(@PathVariable Integer id, Model model) {
		model.addAttribute("subject", subjectService.findById(id));
		return VIEW_CREATE_OR_UPDATE_SUBJECT_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update.
	 *
	 * @param subject the {@link Subject} to update
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}/edit")
	public String proceedUpdateForm(@Valid Subject subject, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_SUBJECT_FORM;
		}
		
		subjectService.update(subject);
		return "redirect:/subjects";
	}
	
	/**
	 * If the list of lessons contains the subject, the model will add an "error" attribute and the page will update.
	 * <p>
	 * If the list of progress contains the subject, the progress will be deleted.
	 *
	 * @param subject the {@link Subject} to delete
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}")
	public String delete(@ModelAttribute Subject subject, Model model) {
		List<Lesson> lessons = lessonService.findAll();
		for (Lesson lesson : lessons) {
			if (lesson.getSubject().equals(subject)) {
				model.addAttribute("subject", subject);
				model.addAttribute("error", "true");
				return "subjects/details";
			}
		}
		
		List<Progress> progresses = progressService.findAll();
		for (Progress progress : progresses) {
			if (progress.getSubject().equals(subject)) {
				progressService.delete(progress);
				break;
			}
		}
		
		subjectService.delete(subject);
		return "redirect:/subjects";
	}
}

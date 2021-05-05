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
import com.github.miajrush.university.model.Teacher;
import com.github.miajrush.university.model.TeacherPosition;
import com.github.miajrush.university.service.LessonService;
import com.github.miajrush.university.service.TeacherPositionService;
import com.github.miajrush.university.service.TeacherService;

import javax.validation.Valid;

import java.util.List;

/**
 * Controller used to manage {@link Teacher}s.
 */
@Controller
@RequestMapping("/teachers")
public class TeacherController {
	private static final String VIEW_CREATE_OR_UPDATE_TEACHER_FORM = "teachers/createOrUpdateForm";
	private final TeacherService teacherService;
	private final TeacherPositionService teacherPositionService;
	private final LessonService lessonService;
	
	@Autowired
	public TeacherController(TeacherService teacherService, TeacherPositionService teacherPositionService,
	                         LessonService lessonService) {
		this.teacherService = teacherService;
		this.teacherPositionService = teacherPositionService;
		this.lessonService = lessonService;
	}
	
	@ModelAttribute("positions")
	public List<TeacherPosition> findTeacherPositions() {
		return teacherPositionService.findAll();
	}
	
	@GetMapping("")
	public String showAll(Model model) {
		model.addAttribute("teachers", teacherService.findAll());
		return "teachers/list";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 *
	 * @param id a {@link Teacher} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}")
	public String showById(@PathVariable Integer id, Model model) {
		model.addAttribute("teacher", teacherService.findById(id));
		return "teachers/details";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("teacher", new Teacher());
		return VIEW_CREATE_OR_UPDATE_TEACHER_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update. We need to set the position field to avoid exceptions.
	 *
	 * @param teacher the {@link Teacher} to save
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/new")
	public String proceedCreationForm(@Valid Teacher teacher, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_TEACHER_FORM;
		}
		
		teacher.setPosition(teacherPositionService.findById(teacher.getPosition().getId()));
		teacherService.save(teacher);
		
		return "redirect:/teachers";
	}
	
	/**
	 * We need to find an object by ID and to set the position field to avoid exceptions.
	 *
	 * @param id a {@link Teacher} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}/edit")
	public String initUpdateForm(@PathVariable Integer id, Model model) {
		Teacher teacher = teacherService.findById(id);
		teacher.setPosition(teacherPositionService.findById(teacher.getPosition().getId()));
		model.addAttribute("teacher", teacherService.findById(id));
		
		return VIEW_CREATE_OR_UPDATE_TEACHER_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update. We need to set the position field to avoid exceptions.
	 *
	 * @param teacher the {@link Teacher} to update
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}/edit")
	public String proceedUpdateForm(@Valid Teacher teacher, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_TEACHER_FORM;
		}
		
		teacher.setPosition(teacherPositionService.findById(teacher.getPosition().getId()));
		teacherService.update(teacher);
		
		return "redirect:/teachers";
	}
	
	/**
	 * If the list of lessons contains the teacher, the model will add an "error" attribute and the page will update.
	 *
	 * @param teacher the {@link Teacher} to delete
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}")
	public String delete(@ModelAttribute Teacher teacher, Model model) {
		List<Lesson> lessons = lessonService.findAll();
		for (Lesson lesson : lessons) {
			if (lesson.getTeacher().equals(teacher)) {
				model.addAttribute("teacher", teacherService.findById(teacher.getId()));
				model.addAttribute("error", "true");
				return "teachers/details";
			}
		}
		
		teacherService.delete(teacher);
		return "redirect:/teachers";
	}
}

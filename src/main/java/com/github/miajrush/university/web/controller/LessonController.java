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
import com.github.miajrush.university.model.LessonType;
import com.github.miajrush.university.model.Subject;
import com.github.miajrush.university.model.Teacher;
import com.github.miajrush.university.service.LessonService;
import com.github.miajrush.university.service.LessonTypeService;
import com.github.miajrush.university.service.SubjectService;
import com.github.miajrush.university.service.TeacherService;

import javax.validation.Valid;

import java.util.List;

/**
 * Controller used to manage {@link Lesson}s.
 */
@Controller
@RequestMapping("/lessons")
public class LessonController {
	private static final String VIEW_CREATE_OR_UPDATE_LESSON_FORM = "lessons/createOrUpdateForm";
	private final LessonService lessonService;
	private final SubjectService subjectService;
	private final TeacherService teacherService;
	private final LessonTypeService lessonTypeService;
	
	@Autowired
	public LessonController(LessonService lessonService, SubjectService subjectService, TeacherService teacherService,
	                        LessonTypeService lessonTypeService) {
		this.lessonService = lessonService;
		this.subjectService = subjectService;
		this.teacherService = teacherService;
		this.lessonTypeService = lessonTypeService;
	}
	
	@ModelAttribute("subjects")
	public List<Subject> findSubjects() {
		return subjectService.findAll();
	}
	
	@ModelAttribute("teachers")
	public List<Teacher> findTeachers() {
		return teacherService.findAll();
	}
	
	@ModelAttribute("lessonTypes")
	public List<LessonType> findLessonTypes() {
		return lessonTypeService.findAll();
	}
	
	@GetMapping("")
	public String showAll(Model model) {
		model.addAttribute("lessons", lessonService.findAll());
		return "lessons/list";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 *
	 * @param id a {@link Lesson} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}")
	public String showById(@PathVariable Integer id, Model model) {
		model.addAttribute("lesson", lessonService.findById(id));
		return "lessons/details";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("lesson", new Lesson());
		return VIEW_CREATE_OR_UPDATE_LESSON_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update. We need to set the fields to avoid exceptions.
	 *
	 * @param lesson the {@link Lesson} to save
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/new")
	public String proceedCreationForm(@Valid Lesson lesson, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_LESSON_FORM;
		}

		setFields(lesson);
		lessonService.save(lesson);
		
		return "redirect:/lessons";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 *
	 * @param id a {@link Lesson} id
	 * @param model an object to add attributes
	 * @return the name of the HTML page
	 */
	@GetMapping("/{id}/edit")
	public String initUpdateForm(@PathVariable Integer id, Model model) {
		model.addAttribute("lesson", lessonService.findById(id));
		return VIEW_CREATE_OR_UPDATE_LESSON_FORM;
	}
	
	/**
	 * If binding results has errors then the page will update. We need to set the fields to avoid exceptions.
	 *
	 * @param lesson the {@link Lesson} to update
	 * @param bindingResult an object to represents binding results
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}/edit")
	public String proceedUpdateForm(@Valid Lesson lesson, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VIEW_CREATE_OR_UPDATE_LESSON_FORM;
		}
		
		setFields(lesson);
		lessonService.update(lesson);
		
		return "redirect:/lessons";
	}
	
	/**
	 * We need to find an object by ID to avoid exceptions.
	 *
	 * @param id a {@link Lesson} id to delete
	 * @return the name of the HTML page
	 */
	@PostMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		lessonService.delete(lessonService.findById(id));
		return "redirect:/lessons";
	}
	
	/*
	 * We need to find objects by ID and set them to avoid exceptions.
	 */
	private void setFields(Lesson lesson) {
		lesson.setSubject(subjectService.findById(lesson.getSubject().getId()));
		lesson.setTeacher(teacherService.findById(lesson.getTeacher().getId()));
		lesson.setLessonType(lessonTypeService.findById(lesson.getLessonType().getId()));
	}
}

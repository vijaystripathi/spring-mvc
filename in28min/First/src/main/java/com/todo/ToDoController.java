package com.todo;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class ToDoController {
	
	@Autowired
	ToDoService service;
	@Autowired
	UserValidation ud;
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showtodos(String name, ModelMap model) {
		String user = (String) model.get("name");
		model.addAttribute("todos", service.retrieveTodos(user));		
		return "list-todos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("ToDo", new ToDo(0, "vijay", "default", new Date(),false));
	
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {

		if (result.hasErrors())
			return "todo";

		service.addTodo((String) model.get("name"), todo.getDesc(), new Date(),
				false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/del-todo", method = RequestMethod.GET)
	public String delTodo(ModelMap model, @RequestParam int id) {
		service.deleteTodo(id);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String name, @RequestParam String password) {
		if (!ud.isUserValid(name, password)) {
			model.put("error", "Invalid username/password");
			return "login";
		}

		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}

}

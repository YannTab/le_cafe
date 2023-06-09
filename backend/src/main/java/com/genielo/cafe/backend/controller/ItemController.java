package com.genielo.cafe.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.genielo.cafe.backend.model.*;
import com.genielo.cafe.backend.repository.*;

@Controller

public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	    
	
	/*public String addItemIngredients(Model model, @PathVariable("item_id") Long item_id) {
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	
	@GetMapping("/items/all")
	public String getItems(Model model) {
		
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "adminItems" ;
				
	
	}
	
	@GetMapping("/items/new")
	public String addItems(Model model) {
		
		Item item = new Item();
		
		model.addAttribute("item", item);
		return "itemForm";
	}
	
	@PostMapping("/items/save")
	public String saveItem(Item item, RedirectAttributes redirectAttributes) {
		
		try {
			itemRepository.save(item);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		
		return "redirect:/items/all";
	}
	
	
	
	
		
}

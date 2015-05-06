package org.gestion.cr.controllers;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class AccuielAdminController 
{
	// index
		@RequestMapping(value = "/index")
		public String test() {
			
			return "accueilAdmin";

		}


}

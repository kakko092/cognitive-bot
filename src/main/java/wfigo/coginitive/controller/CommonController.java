package wfigo.coginitive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import wfigo.coginitive.service.OpenWeatherMapService;
import wfigo.coginitive.service.SlackWebhookService;

@Controller
public class CommonController {
	
	@Autowired
	SlackWebhookService slackService;
	
	@Autowired
	OpenWeatherMapService weatherService;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "This service is responsible for the back end processing of the line bot";
	}
	
	@RequestMapping("/Hello")
	@ResponseBody
	String hello() {
		
		String message = "Hello World!";
		slackService.sendTextMessage(message);
		
		return message;
	}
	
	@RequestMapping("/Weather")
	@ResponseBody
	String weather(@RequestParam String city) {
		
		return weatherService.getWeather(city);
	}
	
}

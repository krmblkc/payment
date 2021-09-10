package com.example.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.payment.model.ChargeRequest;

@Controller
public class CheckoutController {

	@Value("${STRIPE_PUBLIC_KEY}")
	private String stripePublicKey;

	@RequestMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("amount", 50 * 100);
		model.addAttribute("stripePublicKey", stripePublicKey);
		model.addAttribute("currency", ChargeRequest.Currency.EUR);
		return "checkout";
	}

}

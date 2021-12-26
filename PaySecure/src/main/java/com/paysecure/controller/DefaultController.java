package com.paysecure.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paysecure.utils.ObjMapper;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.param.AccountCreateParams;

@RestController
public class DefaultController {

	@GetMapping
	public String test() {
		return "App starts correctly!!!!";
	}

	@GetMapping("/account")
	public ResponseEntity<Object> createAccoount(@RequestHeader HttpHeaders httpHeaders) {

		Stripe.apiKey = "sk_test_51K8LpZHAyPAsNJoGVmyFQPooYJ8CchkMcBvDnkCZelv6ZUyGbAo7xinqZGP3vsrHncEZO3MpSV9CdNp8ufPs08U100qnOAzIfy";

		AccountCreateParams params = AccountCreateParams.builder().setType(AccountCreateParams.Type.EXPRESS).build();
		Account account = null;
		try {
			account = Account.create(params);

			return new ResponseEntity<>(ObjMapper.getInstance().writeValueAsString(account),
					HttpStatus.OK);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}

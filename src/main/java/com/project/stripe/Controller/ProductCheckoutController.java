package com.project.stripe.Controller;

import com.project.stripe.Dto.Productrequest;
import com.project.stripe.Dto.StripeResponse;
import com.project.stripe.Service.StripeService;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/v1")
public class ProductCheckoutController {

    private final StripeService stripeService;

    public ProductCheckoutController(StripeService stripeService) {
        this.stripeService = stripeService;
    }
    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> checkoutProduct(@RequestBody Productrequest productrequest) throws StripeException {
        StripeResponse stripeResponse=stripeService.checkoutProducts(productrequest);
        return ResponseEntity.status(HttpStatus.OK).body(stripeResponse);
    }


}



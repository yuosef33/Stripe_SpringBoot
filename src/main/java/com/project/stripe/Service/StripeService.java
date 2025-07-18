package com.project.stripe.Service;

import com.project.stripe.Dto.Productrequest;
import com.project.stripe.Dto.StripeResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {
    @Value("${app.stripe.key}")
    private String theKey;
    public StripeResponse checkoutProducts(Productrequest productrequest) throws StripeException {
        Stripe.apiKey=theKey;


        SessionCreateParams.LineItem.PriceData.ProductData productData =
                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                        .setName(productrequest.getName())
                        .build();


        SessionCreateParams.LineItem.PriceData priceData = SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency(productrequest.getCurrency() == null ? "USD" : productrequest.getCurrency())
                .setUnitAmount(productrequest.getAmount())
                .setProductData(productData)
                .build();


        SessionCreateParams.LineItem lineitem = SessionCreateParams.LineItem.builder().
                setQuantity(productrequest.getQuantity())
                .setPriceData(priceData).build();


        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:8080/success")
                .setCancelUrl("http://localhost:8080/cancel")
                .addLineItem(lineitem)
                .build();

        Session session= Session.create(params);


        return new StripeResponse("Success","Payment session created",
                session.getId(),session.getUrl());


    }
}

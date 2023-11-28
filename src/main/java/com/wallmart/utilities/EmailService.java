package com.wallmart.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.wallmart.entities.Orders;

import java.util.Date;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendOrderDetailsToCustomer(String customerEmail, String orderNumber, Orders order) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(customerEmail);
            helper.setSubject("Order Confirmation - Order #" + orderNumber);

            // You can customize the email content based on your requirements
            String emailContent = "<html><body>" +
                    "<p>Thank you for your order. Here are the order details:</p>" +
                    "<ul>" +
                    "<li><strong>Order Number:</strong> " + orderNumber + "</li>" +
                    "<li><strong>Product Name:</strong> " + order.getProduct().getTitle() + "</li>" +
                    "<li><strong>Customer Address:</strong> " + order.getCustomerAddress() + "</li>" +
                    "<li><strong>Customer Mobile:</strong> " + order.getCustomerMobile() + "</li>" +
                    "</ul>" +
                    "<p>Order Date: " + order.getOrderDate() + "</p>" +
                    "</body></html>";

            helper.setText(emailContent, true);

            javaMailSender.send(message);
        } catch (Exception e) {
            // Handle exceptions, log errors, or throw custom exceptions as needed
            e.printStackTrace();
        }
    }
}

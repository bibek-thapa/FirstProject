package com.example.DAOImpl;

import com.example.DAOService.MailService;
import com.example.data.Order;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;
    
    Logger logger = Logger.getLogger(MailServiceImpl.class);

    public void sendEmail(Object object) {

        Order order =(Order) object;
        MimeMessagePreparator messagePreparator = preparator(order);
        try{
        mailSender.send(messagePreparator);
        logger.info("Message Successfully sent");
        }catch(MailException mx)
        {
            logger.info(mx.getMessage());
            System.err.println(mx.getMessage());
        }

        }

    public MimeMessagePreparator preparator(final Order order) {
        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom(new InternetAddress("service@onlinestore.com"));
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(order.getUser().getEmailAddress()));
                mimeMessage.setText("Dear, "+ order.getUser().getFirstName()+"!! Thank you, for placing an order" + " Your order id is #"+order.getId());
                mimeMessage.setSubject("PRODUCT ORDER CONFIRMATION");
            }
        };

        return mimeMessagePreparator;
    }

}

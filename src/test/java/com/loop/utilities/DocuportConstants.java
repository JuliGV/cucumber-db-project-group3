package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DocuportConstants {
    public static final String USERNAME_CLIENT = "b1g3_client@gmail.com";
    public static final String USERNAME_ADVISOR = "b1g3_advisor@gmail.com";
    public static final String USERNAME_SUPERVISOR = "b1g3_supervisor@gmail.com";
    public static final String USERNAME_EMPLOYEE = "b1g3_employee@gmail.com";

    public static final String PASSWORD_DOCUPORT = "Group3";

    public static final String CLIENT_ROLE = "client";
    public static final String ADVISOR_ROLE = "advisor";
    public static final String EMPLOYEE_ROLE = "employee";
    public static final String SUPERVISOR_ROLE = "supervisor";






    public static final String ERROR_MESSAGE_FOR_EMPTY_PASSWORD = "Please enter your password";
    public static final String ADRESS_DOCUPORT = "https://beta.docuport.app";
    public static final String LOGO_DOCUPORT = "Docuport";
    public static final String USERNAME_PLACEHOLDER = "Username or email";

    public static final String PASSWORD_PLACEHOLDER = "Password";

    public static final String USERNAME_ERROR_MSG = "Please enter your username or email address";
    public static final String PASSWORD_ERROR_MSG = "Please enter your password";
    public static final String RESET_PASSWORD_URL = "reset-password";

    public static final String RESET_PASSWORD_MSG = "Enter the email address associated with your account";
    public static final String RESET_EMAIL = "forgotpasswordg1@gmail.com";
    public static final String CONFIRMATION_MSG_RESET_PASSWORD = "We've sent you an email with a link to reset your password. Please check your email";

    public static final String HOME_ICONE_TEXT = "Home";
    public static final String RECIVEDOCS_ICONE_TEXT = "Received docs";
    public static final String MY_UPLOADS_ICONE_TEXT = "My uploads";
    public static final String INVITATION_ICONE_TEXT = "Invitations";


    public static final List<String> ALL_LINK_NAME_ADVISOT_LEFT_MENU = new ArrayList<>(Arrays.asList("My uploads,Received docs,Home,Clients, Invitations, Users, Leads, Bookkeeping, 1099 form, Reconciliation"));


    // users UserName, phoneNumber,fullName, role,advisor
    public static final String ADVISOR_FULLNAME = "Batch1 Group1";
    public static final String SUPERVISOR_FULLNAME = "Batch1 Group1";
    public static final String ALEXDESOUZA_FULLNAME = "Alex De Souza";
    public static final String ALEXDESOUZA_EMAIL = "alex.de.souza@gmail.com";
    public static final String SUPERVISOR_EMAIL = "b1g1_supervisor@gmail.com";
    public static final String ADVISOR_EMAIL = "b1g1_advisor@gmail.com";
    public static final String ADVISOR_USERNAME = "b1g1_advisor@gmail.com";
    public static final String SUPERVISOR_USERNAME = "b1g1_supervisor@gmail.com";
    public static final String ALEXDESOUZA_USERNAME = "alexdesouze";
    public static final String ALEXDESOUZA_PHONENUMBER = "+994512060042";
    public static final String SUPERVISOR_PHONENUMBER = "0000000000";
    public static final String ADVISOR_PHONENUMBER = "0000000000";
    public static final String ADVISOR_ROLE_TABLE = "Advisor";
    public static final String SUPERVISOR_ROLE_TABLE = "Supervisor";
    public static final String ALEXDESOUZA_ROLE_TABLE = "Client";

    public static final String INVITER_FOR_ALL = "";


    // NAME OF COLONS IN USER'S TABLE

    public static final String ROLE_COLUMN = "role";
    public static final String USERNAME_COLUMN = "username";
    public static final String FULL_NAME_COLUMN = "full name";
    public static final String PHONE_NUMBER_COLUMN = "phone number";
    public static final String ADVISOR_COLUMN = "advisor";
    public static final String INVITER_COLUMN = "inviter";





    public static void loginDocuport (String role,WebDriver driver) {

        driver.get(DocuportConstants.ADRESS_DOCUPORT);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userName = driver.findElement(By.cssSelector("input[type='text']"));

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));

        WebElement loginButton = driver.findElement(By.cssSelector("span[class='v-btn__content']"));

        switch (role) {
            case "client":
                userName.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
                loginButton.click();

                break;
            case "advisor":
                userName.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
                loginButton.click();

                break;

        }




    }


}






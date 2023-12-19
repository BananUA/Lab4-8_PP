package EventLog;

import Toy.Toy;
import util.EmailUtil;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class EventLog {

    public void ClearSessionLog() {
        try (FileWriter writer = new FileWriter("./src/main/resources/log.txt", false)) {
            String text = "";
            writer.write(text);

            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*public String GetSessionLog() {
        String result = "";
        try (FileReader reader = new FileReader("./src/main/resources/log.txt")) {
            Scanner scan = new Scanner(reader);

            while (scan.hasNextLine()) {
                result += scan.nextLine() + "\n";
            }

            if (result.equals("")) {
                result = "No logs in this session";
            }

        } catch (Exception ex) {

            result = ex.getMessage();
        }
        return result;
    }*/

    public void AddActionLog(Toy toy, String comment) {
        try (FileWriter writer = new FileWriter("./src/main/resources/log.txt", true)) {
            Date date = new Date();
            String text = date.toString() + " - " + comment + toy.toString();
            writer.write(text);

            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AddLog(String message) {
        try (FileWriter writer = new FileWriter("./src/main/resources/log.txt", true)) {
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss");
            Date date = new Date();
            String text = date.toString() + " - " + message + "\n";
            writer.write(text);

            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void EmailLog(String message) {
        String fromEmail = ""; //requires valid gmail id
        String password = ""; // correct password for gmail id
        String toEmail = ""; // can be any email id

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();
        String text = date.toString() + " - " + message + "\n";
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, toEmail, "ErrorLog",text);
    }
}

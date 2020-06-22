/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popadic.lazar.fon.fisweb.action.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import popadic.lazar.fon.fisweb.action.AbstractAction;
import popadic.lazar.fon.fisweb.constants.PageConstants;
import popadic.lazar.fon.fisweb.model.User;

/**
 * Akcija za prikaz stranice za logovanje korisnika na sistem, nasledjuje apstraktnu klasu AbstractAction
 * 
 * @author Lazar Popadic
 */
@Component
public class LoginAction extends AbstractAction {

    /**
     * Ukoliko korisnik postoji vraca izgled pocetne stranice, u suportnom vraca izgled stranice za logovanje
     * @param request http zahtev
     * @return izgled stranice, za logovanje ili pocetne stranice, kao string
     */
    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("====================================================");
        System.out.println("====================LoginAction=====================");
        System.out.println(email + "\t" + password);
        System.out.println("====================================================");

        //proveri da li postoji
        User user = findUser(request, email, password);
        if (user == null) {
            request.setAttribute("message", "User does not exist!");
            return PageConstants.VIEW_LOGIN;
        } else if(!(user.getPassword().equals(password))) {
            request.setAttribute("message", "Password you entered does not exist!");
            return PageConstants.VIEW_LOGIN;
        }else{
            request.getSession(true).setAttribute("loginUser", user);
            return PageConstants.VIEW_HOME;
        }
    }

    /**
     * Vraca korisnika ako se pronadje korisnik sa prosledjenim email-om i sifrom
     * @param request http zahtev
     * @param email email korisnika koga trazimo
     * @param password sifra korisnika koga trazimo 
     * @return user ako mu odgovaraju email i password, u suprotnom vraca null
     */
    private User findUser(HttpServletRequest request, String email, String password) {
        List<User> users = (List<User>) request.getServletContext().getAttribute("users");
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}

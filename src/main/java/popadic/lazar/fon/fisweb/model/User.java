/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popadic.lazar.fon.fisweb.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Korisnik koji se loguje na sistem i upravlja istim
 * 
 * @author Lazar Popadic
 */
public class User implements Serializable{

    /**
     * Ime korisnika
     */
    private String firstname;
     /**
     * Prezime korisnika
     */
    private String lastname;
     /**
     * Email korisnika
     */
    private String email;
     /**
     * Sifra korisnika
     */
    private String password;

     /**
     * Neparametrizovani konstruktor, dodelice atributima default vrednosti
     */
    public User() {
    }
    /**
     * Parametrizovan konstruktor, dodeljuje atributima vrednosti koje su prosledjene kao parametri
     * @param firstname ime koje treba postaviti
     * @param lastname prezime koje treba postaviti
     * @param email email koji treba postaviti
     * @param password sifra koju treba postaviti
     */
    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

     /**
     * Vraca ime korisnika
     * @return ime korisnika kao string
     */
    public String getFirstname() {
        return firstname;
    }

     /**
     * Postavlja novo ime korisnika
     * @param firstname novo ime koje treba postaviti
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
 /**
     * Vraca prezime korisnika
     * @return prezime korisnika kao string
     */
    public String getLastname() {
        return lastname;
    }

     /**
     * Postavlja novo prezime korisnika
     * @param lastname novo prezime koje treba postaviti
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

     /**
     * Vraca emial korisnika
     * @return email korisnika kao string
     */
    public String getEmail() {
        return email;
    }

     /**
     * Postavlja novi email korisnika
     * @param email novi email koji treba postaviti
     */
    public void setEmail(String email) {
        this.email = email;
    }

     /**
     * Vraca sifru korisnika
     * @return sifru korisnika kao string
     */
    public String getPassword() {
        return password;
    }
    /**
     * Postavlja novu sifru korisnika
     * @param password nova sifra koju treba postaviti
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.firstname);
        hash = 97 * hash + Objects.hashCode(this.lastname);
        hash = 97 * hash + Objects.hashCode(this.email);
        return hash;
    }

     /**
     * Proverava da li su dva korisnika ista i
     * vraca true ako jesu, u suprotnom vraca false
     * 
     * @return true ako je uneti objekat klase User sa
     * istim email-om i password-om, u suprotnom vratiti false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

     /**
     * Vraca string sa svim podacima o korisniku
     * @return String koji sadrzi ime, prezime, email i sifru korisnika
     */
    @Override
    public String toString() {
        return "User{" + "firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password + '}';
    }

}

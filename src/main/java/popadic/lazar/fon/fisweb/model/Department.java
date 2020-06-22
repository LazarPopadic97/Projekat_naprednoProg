/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popadic.lazar.fon.fisweb.model;

import java.util.Objects;

/**
 * Informacije o katedri koja se prati u sistemu
 * 
 * @author Lazar Popadic
 */
public class Department {
     /**
     * ID katedre
     */
    private long id;
     /**
     * Skraceni naziv katedre
     */
    private String shortname;
     /**
     * Naziv katedre
     */
    private String name;

     /**
     * Neparametrizovani konstruktor, postavlja vrednosti atributa na default vrednosti
     */
    public Department() {
    }
    /**
     * Parametrizovani konstruktor, postavlja vrednosti atributa na vrednosti prosledjene kao parametre
     * @param shortName novi skraceni naziv katedre koji treba postaviti
     * @param name novi naziv katedre koji treba postaviti
     */
     public Department(String shortName, String name) {
        this.shortname = shortName;
        this.name = name;
    }
      /**
     * Parametrizovani konstruktor, postavlja vrednosti atributa na vrednosti prosledjene kao parametre
     * @param id novi id katedre koji treba postaviti
     * @param shortname novi skraceni naziv katedre koji treba postaviti
     * @param name novi naziv katedre koji treba postaviti
     */
    public Department(long id, String shortname, String name) {
        this.id = id;
        this.shortname = shortname;
        this.name = name;
    }

    /**
     * Vraca id katedre
     * @return id katedre kao long
     */
    public long getId() {
        return id;
    }
     /**
     * Postavlja novi id katedre
     * @param id novi id koji treba postaviti
     */

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Vraca kratki naziv katedre
     * @return shortname katedre kao string
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * Postavlja novi kratki naziv katedre
     * @param shortname novi kratki naziv koji treba postaviti
     */
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    /**
     * Vraca naziv katedre
     * @return name katedre kao string
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlja novi naziv katedre
     * @param name novi naziv koji treba postaviti
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.shortname);
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
     * Proverava da li su dve katedre iste i
     * vraca true ako jesu, u suprotnom vraca false
     * 
     * @return true ako je uneti objekat klase Department sa
     * istim id-om, u suprotnom vratiti false
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
        final Department other = (Department) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    /**
     * Vraca string sa podacima o katedri
     * @return String koji sadrzi id, kratki naziv i naziv katedre 
     */
    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", shortname=" + shortname + ", name=" + name + '}';
    }

   
    
    
            }

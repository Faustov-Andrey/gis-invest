package ru.itr.giskv.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="giskv_user")
public class GiskvUser implements Serializable {

    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "id")
    private Long id;

    /**
     * Фамилия пользователя
     */
    @Column(name = "last_name", nullable = true, length = 128)
    private String lastName;

    /**
     * Имя пользователя
     */
    @Column(name = "first_name", nullable = true, length = 128)
    private String firstName;

    /**
     * Отчество пользователя
     */
    @Column(name = "father_name", nullable = true, length = 128)
    private String fathersName;

    /**
     * Отчество пользователя
     */
    @Column(name = "personal_number", nullable = true, length = 32)
    private String personalNumber;

    /**
     * Логин пользователя
     */
    @Column(name = "login", nullable = true, length = 32)
    private String login;

       /**
     * Пароль пользователя
     */
    @Column(name = "pwd", nullable = true, length = 32)
    private String pwd;

    /**
     * комментарий
     */
    @Column(name = "comment", nullable = true, length = 1024)
    private String comment;


    public Long getId() {
        return id;
    }
    public void setId(final Long id) {
        this.id = id;
    }

    public String getLastName(){ return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName(){ return firstName; }
    public void setFirstName(String firstName) {
        this.firstName= firstName;
    }

    public String getFathersName(){ return fathersName; }
    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getPersonalNumber(){ return personalNumber; }
    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getLogin(){ return login; }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd(){ return pwd; }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getComment(){ return comment; }
    public void setComment(String comment) {
        this.comment = comment;
    }

}

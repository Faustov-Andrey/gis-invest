package ru.itr.giskv.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="role")
public class Role  implements Serializable {

    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    @Column(name = "id")
    private Long id;

    /**
     * Фамилия пользователя
     */
    @Column(name = "name", columnDefinition = "Varchar(128) default 'new'", nullable = false, length = 128)
    private String name;

    /**
     * комментарий
     */
    @Column(name = "description", nullable = true, length = 1024)
    private String description;

    /**
     * комментарий
     */
    @Column(name = "comment", nullable = true, length = 32)
    private String comment;

    public Long getId() {
        return id;
    }
    public void setId(final Long id) {
        this.id = id;
    }

    public String getName(){ return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){ return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDComment(){ return comment; }
    public void setComment(String comment) {
        this.comment = comment;
    }
}

package com.example.registration.registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;



    private enum Role {
        TEACHER, STUDENT,CURATOR
    }

    public enum State {
        ACTIVE, BANNED
    }

    public boolean isActive() {

        return this.state == State.ACTIVE;
    }

    public boolean isBanned() {

        return !isActive();
    }

    public boolean isStudent() {

        return this.role == Role.STUDENT;
    }
    public boolean isTeacher() {

        return this.role == Role.TEACHER;
    }
    public boolean isCurator() {

        return this.role == Role.CURATOR;
    }
}

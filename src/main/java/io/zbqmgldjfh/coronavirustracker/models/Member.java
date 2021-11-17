package io.zbqmgldjfh.coronavirustracker.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String name;

    private boolean enabled;
}

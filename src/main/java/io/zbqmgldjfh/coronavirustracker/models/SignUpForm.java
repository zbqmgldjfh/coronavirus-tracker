package io.zbqmgldjfh.coronavirustracker.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class SignUpForm {

    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmpassword;
    @NotEmpty
    private String name;
}

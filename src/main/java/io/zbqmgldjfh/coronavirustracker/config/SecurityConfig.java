package io.zbqmgldjfh.coronavirustracker.config;

import io.zbqmgldjfh.coronavirustracker.security.MyLoginSuccessHandler;
import io.zbqmgldjfh.coronavirustracker.security.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityUserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(SecurityUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.userDetailsService(userDetailsService);

        security.authorizeRequests().antMatchers("/", "/system/**", "/members/**").permitAll();
        security.authorizeRequests().antMatchers("/board/**").authenticated();
        security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

        security.csrf().disable();

        //security.formLogin().loginPage("/system/login").defaultSuccessUrl("/", true).usernameParameter("username");
        security.formLogin().defaultSuccessUrl("/", true);
        security.exceptionHandling().accessDeniedPage("/system/accessDenied");
        security.logout().invalidateHttpSession(true).logoutSuccessUrl("/");

    }
}

package com.manushd.app.autenticacion;

import com.manushd.app.autenticacion.repository.UserRepository;
import com.manushd.app.autenticacion.repository.RoleRepository;
import com.manushd.app.autenticacion.models.User;
import com.manushd.app.autenticacion.models.Role;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class AutenticacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutenticacionApplication.class, args);
    }
}

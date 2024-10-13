package com.example.CRUD.security.controller;

import com.example.CRUD.security.dto.LoginRequestDTO;
import com.example.CRUD.security.dto.RegisterRequestDTO;
import com.example.CRUD.security.dto.ResponseDTO;
import com.example.CRUD.entity.UserEntity;
import com.example.CRUD.repository.UserRepository;
import com.example.CRUD.security.securityToken.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        UserEntity user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário invalido"));
        if(passwordEncoder.matches(body.password(),user.getSenha())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<UserEntity> user = this.userRepository.findByEmail(body.email());

        if (user.isEmpty()) {
            UserEntity newUser = new UserEntity();
            newUser.setSenha(passwordEncoder.encode(body.password()));
            newUser.setId(null);
            newUser.setEmail(body.email());
            newUser.setNome(body.name());
            newUser.setCpfCnpj(body.cpfCnpj());
            newUser.setEndereco(body.email());
            newUser.setRole(body.role());
            newUser.setTelefone(body.telefone());
            newUser.setDataCadastro(LocalDate.now());

            System.out.println("AQUIII -------> " + newUser);

            this.userRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }


}

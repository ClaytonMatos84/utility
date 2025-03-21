package com.example.utility.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PassDto(@NotNull(message = "A senha é obrigatório")
        @Size(min = 8, message = "A senha deve conter no mínimo 08 caracteres.")
        @Pattern(regexp = ".*[A-Z].*", message = "A senha deve conter pelo menos uma letra maiúscula.")
        @Pattern(regexp = ".*[a-z].*", message = "A senha deve conter pelo menos uma letra minúscula.")
        @Pattern(regexp = ".*[0-9].*", message = "A senha deve conter pelo menos um dígito numérico.")
        @Pattern(regexp = ".*\\W.*", message = "A senha deve conter pelo menos um caractere especial.")
                      String password) {
}

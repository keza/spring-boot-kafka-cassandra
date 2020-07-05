package com.farukkaya.producer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserRegisterRequest {

    @NotBlank(message = "Ad alanı boş olamaz.")
    @Size(max = 99, message = "Ad alanı uzunluğu 99 karakter sınırından fazladır.")
    private String name;

    @NotBlank(message = "Soyad alanı boş olamaz.")
    @Size(max = 99, message = "Soyadı alanı uzunluğu 99 karakter sınırından fazladır.")
    private String surname;

    @Email(message = "E-posta geçerli değildir.")
    @NotBlank(message = "E-posta alanı boş olamaz.")
    @Size(max = 255, message = "E-posta alanı uzunluğu 255 karakter sınırından fazladır.")
    private String email;

    @NotBlank(message = "Cep telefonu alanı boş olamaz.")
    @Pattern(regexp = "(5[0-9]{9})", message = "Cep telefonu geçerli değildir. Cep telefonu numarasınızı kontrol ediniz.")
    private String phoneNumber;

    private List<UUID> followerList;
}

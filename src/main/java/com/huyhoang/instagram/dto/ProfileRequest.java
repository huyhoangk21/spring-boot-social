package com.huyhoang.instagram.dto;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ProfileRequest {

    @NotBlank(message = "Bio must not be empty")
    private String bio;

    private String profileImageUrl;

    private Date birthday;

    @NotBlank(message = "Website url must not be empty")
    private String websiteUrl;

}

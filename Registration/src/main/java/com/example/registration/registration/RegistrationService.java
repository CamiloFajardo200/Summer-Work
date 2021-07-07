package com.example.registration.registration;

import com.example.registration.appuser.AppUser;
import com.example.registration.appuser.AppUserRole;
import com.example.registration.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;

    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return appUserService.singUpUser(
                new AppUser(
                        request.getUsername(),
                        request.getGroup(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getDateofbirth(),
                        AppUserRole.request.getRole()

                )
        );
    }
}

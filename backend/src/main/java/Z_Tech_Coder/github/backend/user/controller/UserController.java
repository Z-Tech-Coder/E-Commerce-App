package Z_Tech_Coder.github.backend.user.controller;

import Z_Tech_Coder.github.backend.user.Service.UserService;
import Z_Tech_Coder.github.backend.user.Service.serviceObj.LoginRequest;
import Z_Tech_Coder.github.backend.user.Service.serviceObj.LoginResponse;
import Z_Tech_Coder.github.backend.user.Service.serviceObj.SignupRequest;
import Z_Tech_Coder.github.backend.user.Service.serviceObj.SignupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
       LoginResponse loginResponseLocal = userService.login(loginRequest);
       return ResponseEntity.ok(loginResponseLocal);
    }

    @PostMapping("/signup")
    ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest signupRequest){
        SignupResponse signupResponse = userService.signup(signupRequest);
        return ResponseEntity.ok(signupResponse);
    }


}

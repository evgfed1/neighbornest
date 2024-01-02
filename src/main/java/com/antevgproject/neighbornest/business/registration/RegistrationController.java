//package com.antevgproject.neighbornest.business.registration;
//
//
//import com.antevgproject.neighbornest.business.login.dto.UserDto;
//import com.antevgproject.neighbornest.business.registration.dto.AssociationDto;
//import com.antevgproject.neighbornest.infrastructure.validation.ApiError;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import jakarta.annotation.Resource;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RegistrationController {
//
//    @Resource
//    private RegistrationService registrationService;
//
//
//    @RequestMapping("/registration/association")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "OK"),
//            @ApiResponse(responseCode = "403", description = "Association has already registered.", content = @Content(schema = @Schema(implementation = ApiError.class)))})
//public void registerNewAssociation(@RequestBody AssociationDto associationDto) {
//        registrationService.registerNewAssociation(associationDto);
//    }
//}

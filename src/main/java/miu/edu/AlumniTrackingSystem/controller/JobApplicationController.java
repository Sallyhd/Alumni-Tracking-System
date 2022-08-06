package miu.edu.AlumniTrackingSystem.controller;

import lombok.AllArgsConstructor;
import miu.edu.AlumniTrackingSystem.dto.JobApplicationDTO;
import miu.edu.AlumniTrackingSystem.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.keycloak.KeycloakPrincipal;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/job-applications")
@AllArgsConstructor
@CrossOrigin("*")
public class JobApplicationController {
    private final JobService jobService;

    //    -------------------- get applicants -------------------

    @GetMapping("/applicants")
    public List<JobApplicationDTO> getApplicants(@RequestBody int jobId){
        return null;//jobService.getApplicants(jobId);
    }


    //    -------------------- apply for a job -------------------
    @PostMapping("/apply")
    public ResponseEntity applyToJob(@RequestParam Integer jobId, Principal principal){

        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username=user.getKeycloakSecurityContext().getToken().getPreferredUsername();
        //jobService.applyToJob(jobId,username);
        return ResponseEntity.ok().build();
    }

    //    -----------------------  get list of advertisements ---------

    @GetMapping("")
    public ResponseEntity<JobApplicationDTO> getJob(@RequestParam Integer jobId, Principal principal){
        KeycloakPrincipal user=(KeycloakPrincipal)principal;
        String username=user.getKeycloakSecurityContext().getToken().getPreferredUsername();
        return null;
    }

}

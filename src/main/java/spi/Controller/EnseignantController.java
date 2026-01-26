package spi.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spi.Service.Interface.EnseignantService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/Enseignant")
public class EnseignantController {

    private final EnseignantService enseignantService;


}

package spi.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spi.Service.Interface.EtudiantService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/Etudiant")
public class EtudiantController {
    private final EtudiantService etudiantService;
}

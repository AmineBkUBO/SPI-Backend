package spi.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spi.Service.Interface.FormationService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/Formation")
public class FormationController {
    private final FormationService formationService;
}

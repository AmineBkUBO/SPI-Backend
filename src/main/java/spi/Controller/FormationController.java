package spi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spi.Entity.Formation;
import spi.Service.Interface.FormationService;
import org.springframework.data.domain.Page;

import java.util.Optional;

@RestController
@RequestMapping("/api/formations")
@RequiredArgsConstructor
public class FormationController {

    private final FormationService formationService;

    @PostMapping
    public ResponseEntity<Formation> create(@RequestBody Formation formation) {
        return ResponseEntity.ok(formationService.createFormation(formation));
    }

    @GetMapping
    public ResponseEntity<Page<Formation>> getAll(@RequestParam(defaultValue = "1") int page) {
        return ResponseEntity.ok(formationService.getAllFormations(page));
    }

    @GetMapping("/{code}")
    public ResponseEntity<Formation> getById(@PathVariable String code) {
        Optional<Formation> formation = formationService.getFormationById(code);
        return formation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{code}")
    public ResponseEntity<Formation> update(@PathVariable String code,
                                            @RequestBody Formation formation) {
        formation.setCodeFormation(code);
        return ResponseEntity.ok(formationService.updateFormation(formation));
    }
}

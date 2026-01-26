package spi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spi.Entity.Enseignant;
import spi.Service.Interface.EnseignantService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enseignants")
@RequiredArgsConstructor
public class EnseignantController {

    private final EnseignantService enseignantService;

    @PostMapping
    public ResponseEntity<Enseignant> create(@RequestBody Enseignant enseignant) {
        return ResponseEntity.ok(enseignantService.createEnseignant(enseignant));
    }

    @GetMapping
    public ResponseEntity<List<Enseignant>> getAll() {
        return ResponseEntity.ok(enseignantService.getAllEnseignants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getById(@PathVariable Integer id) {
        Optional<Enseignant> enseignant = enseignantService.getEnseignantById(id);
        return enseignant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Enseignant> update(@PathVariable Integer id,
                                             @RequestBody Enseignant enseignant) {
        enseignant.setId(id);
        return ResponseEntity.ok(enseignantService.updateEnseignant(enseignant));
    }
}

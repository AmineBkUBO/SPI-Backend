package spi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spi.Entity.Etudiant;
import spi.Service.Interface.EtudiantService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiants")
@RequiredArgsConstructor
public class EtudiantController {

    private final EtudiantService etudiantService;

    @PostMapping
    public ResponseEntity<Etudiant> create(@RequestBody Etudiant etudiant) {
        return ResponseEntity.ok(etudiantService.createEtudiant(etudiant));
    }

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAll() {
        return ResponseEntity.ok(etudiantService.getEtudiants());
    }

    @GetMapping("/{noEtudNat}")
    public ResponseEntity<Etudiant> getById(@PathVariable String noEtudNat) {
        Optional<Etudiant> etudiant = etudiantService.getEtudiantById(noEtudNat);
        return etudiant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{noEtudNat}")
    public ResponseEntity<Etudiant> update(@PathVariable String noEtudNat,
                                           @RequestBody Etudiant etudiant) {
        etudiant.setNoEtudiantNat(noEtudNat);
        return ResponseEntity.ok(etudiantService.updateEtudiant(etudiant));
    }
}

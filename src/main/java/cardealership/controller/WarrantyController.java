package cardealership.controller;

import cardealership.dto.WarrantyDto;
import cardealership.mapper.WarrantyMapper;
import cardealership.model.Warranty;
import cardealership.repository.WarrantyRepository;
import cardealership.service.WarrantyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor
public class WarrantyController implements WarrantyControllerResource {

    private final WarrantyService warrantyService;
    private final WarrantyRepository warrantyRepository;
    private final WarrantyMapper warrantyMapper;

    @Override
    public ResponseEntity<Warranty> getById(Long id) {
        Warranty warranty = warrantyService.getById(id);

        return ResponseEntity.ok(warranty);
    }

    @Override
    public ResponseEntity<String> add(WarrantyDto warrantyDto) {
        Warranty warranty = warrantyMapper.withWarrantyDto(warrantyDto).toEntity();

        try {
            warrantyService.add(warranty);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.ok("Warranty added successfully");
    }

    @Override
    public ResponseEntity<String> update(WarrantyDto warrantyDto, Long id) {
        try {
            warrantyService.update(warrantyDto, id);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.ok("Warranty updated successfully");
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        try {
            warrantyService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.ok("Warranty deleted successfully");
    }
}

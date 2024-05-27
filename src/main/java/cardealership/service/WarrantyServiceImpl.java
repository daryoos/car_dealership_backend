package cardealership.service;

import cardealership.dto.WarrantyDto;
import cardealership.model.Warranty;
import cardealership.repository.WarrantyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepository;

    @Override
    public Warranty getById(Long id) {
        Warranty warranty = warrantyRepository.findById(id);
        System.out.println(warranty);
        return warranty;
    }

    @Override
    public void add(Warranty warranty) throws Exception {
        try {
            warrantyRepository.save(warranty);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void update(WarrantyDto warrantyDto, Long id) throws Exception {
        Warranty warranty = warrantyRepository.findById(id);
        if (warranty != null) {
            warranty.setPrice(warrantyDto.getPrice());
            warranty.setEndDate(warrantyDto.getEndDate());
            warrantyRepository.save(warranty);
        }
        else {
            throw new Exception("Warranty not found");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Warranty warranty = warrantyRepository.findById(id);
        if (warranty != null) {
            warrantyRepository.delete(warranty);
        }
        else {
            throw new Exception("Warranty not found");
        }
    }
}

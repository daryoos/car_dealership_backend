package cardealership.service;

import cardealership.dto.BillDto;
import cardealership.mapper.BillMapper;
import cardealership.model.Bill;
import cardealership.model.User;
import cardealership.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public Bill getById(Long id) {
        Bill bill = billRepository.findById(id);
        System.out.println(bill);
        return bill;
    }

    @Override
    public void add(Bill bill) throws Exception {
        try {
            billRepository.save(bill);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void update(BillDto billDto, Long id) throws Exception {
        Bill bill = billRepository.findById(id);
        if (bill != null) {
            bill.setPrice(billDto.getPrice());
            bill.setDate(billDto.getDate());
            bill.setCart(billDto.getCart());
            billRepository.save(bill);
        }
        else {
            throw new Exception("Bill not found");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Bill bill = billRepository.findById(id);
        try {
            billRepository.delete(bill);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    @Override
    public List<BillDto> getAllDto() {
        List<Bill> bills = billRepository.findAll();
        List<BillDto> billDtos = new ArrayList<>();
        for (Bill bill : bills) {
            billDtos.add(billMapper.withBill(bill).toDto());
        }
        return billDtos;
    }

    @Override
    public List<Bill> getByUserId(Long id) {
        List<Bill> bills = billRepository.findByUserId(id);
        System.out.println(bills);
        return bills;
    }

    @Override
    public Bill getCart(Long id) {
        Bill bill = billRepository.findCart(id);
        System.out.println(bill);
        return bill;
    }


}

package com.example.demo.business.service;

import com.example.demo.business.domain.StoreDTO;
import com.example.demo.business.exceptions.ResourceNotFoundException;
import com.example.demo.data.entity.Store;
import com.example.demo.data.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreService {

    private StoreRepository storeRepository;

    public List<StoreDTO> getAllStores() {
        Iterable<Store> stores = storeRepository.findAll();
        List<StoreDTO> dtoList = new ArrayList<>();

        for(Store store : stores) {
            StoreDTO storeDTO = createDTO(store);
            dtoList.add(storeDTO);
        }

        dtoList.sort(Comparator.comparing(StoreDTO::getId));

        return dtoList;
    }

    public StoreDTO getStoreById(Long id){
        Optional<Store> store = storeRepository.findById(id);
        if (store.isPresent()){
            return createDTO(store.get());
        }
        else{
            throw new ResourceNotFoundException("Store id not found","Enter a valid Store id");
        }
    }

    private StoreDTO createDTO(Store store) {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(store.getId());
        storeDTO.setName(store.getName());
        storeDTO.setPostCode(store.getPostCode());
        return storeDTO;
    }
}

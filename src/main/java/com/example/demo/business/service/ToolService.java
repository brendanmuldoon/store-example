package com.example.demo.business.service;

import com.example.demo.business.domain.ToolDTO;
import com.example.demo.business.exceptions.ResourceNotFoundException;
import com.example.demo.data.entity.Tool;
import com.example.demo.data.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToolService {
    private final ToolRepository toolRepository;

    public List<ToolDTO> getAllTools() {
        Iterable<Tool> tools = toolRepository.findAll();
        List<ToolDTO> dtoList = new ArrayList<>();

        for(Tool tool : tools) {
            ToolDTO toolDTO = createDTO(tool);
            dtoList.add(toolDTO);
        }

        dtoList.sort(Comparator.comparing(ToolDTO::getDescription));

        return dtoList;
    }

    public ToolDTO getToolById(Long id){
        Optional<Tool> tool = toolRepository.findById(id);
        if (tool.isPresent()){
            return createDTO(tool.get());
        }
        else{
            throw new ResourceNotFoundException("Tool id not found","Enter a valid tool id");
        }
    }

    private ToolDTO createDTO(Tool tool) {
        ToolDTO toolDTO = new ToolDTO();
        toolDTO.setId(tool.getId());
        toolDTO.setDescription(tool.getDescription());
        toolDTO.setHirePrice(tool.getHirePrice());
        return toolDTO;
    }
}
